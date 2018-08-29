package tactics;

import entity.*;
import server.WsServer;
import util.InstructionsUtils;
import util.NowDataUtils;
import util.Utils;

import java.util.List;

import static util.NowDataUtils.getCloseOpHero;
import static util.NowDataUtils.getCloseOpTower;

public class Three {

    /**
     * ai策略三
     *
     * @param wsServer
     * @param heroInfo
     */
    public static void realTimeAttack(WsServer wsServer, HeroInfo heroInfo, TowerInfo towerInfo, GameInfo.StateEntity state) {
        for (GameInfo.StateEntity.HerosEntity self : heroInfo.getMyHeros()) {
            //最近的敌方英雄
            OpHeroInfo opHeroInfo = getCloseOpHero(self, heroInfo.getOpHeros());
            double attachMeHealth = opHeroInfo.getAttackMeHealth();
            double closeOpHeroDistance = opHeroInfo.getDistances().size() > 0 ? opHeroInfo.getDistances().get(0) : 0;
            GameInfo.StateEntity.HerosEntity closeOpHero = opHeroInfo.getHeros().get(closeOpHeroDistance);
            GameInfo.StateEntity.HerosEntity leastHelthOpHero = NowDataUtils.getRangeleastHealth(opHeroInfo, Utils.getHeroRange(self));
            //敌方塔
            List<GameInfo.StateEntity.TowersEntity> opTowers = towerInfo.getOpTowers();
            int opTowerSize = towerInfo.getOpTowerSize();
            if (opTowers.size() == 0) {
                //都是我的塔，直接攻击敌方英雄
                attackOpHero(wsServer, self, closeOpHero, heroInfo.getMyHeros(), null, closeOpHeroDistance, attachMeHealth, 0);
            } else {
                //控时间，前往血量最少的塔，打塔
                OpTowerInfo opTowerInfo = getCloseOpTower(self, opTowers);
                double closeTowerDistance = opTowerInfo != null && opTowerInfo.getDistances().size() > 0 ? opTowerInfo.getDistances().get(0) : 0;
                GameInfo.StateEntity.TowersEntity closeTower = opTowerInfo != null ? opTowerInfo.getTowers().get(closeTowerDistance) : null;
                judgeTime(wsServer, opTowerSize, heroInfo, towerInfo, state.getTime(), self, closeOpHero, closeOpHeroDistance, closeTowerDistance, closeTower, opTowers, attachMeHealth, leastHelthOpHero);
                opTowerInfo = null;
                closeTower = null;
            }
            opHeroInfo = null;
            closeOpHero = null;
            leastHelthOpHero = null;
            opTowers = null;
            self = null;
        }
        wsServer = null;
        heroInfo = null;
        state = null;
        towerInfo = null;
    }

    /**
     * 攻击范围内敌方英雄策略
     *
     * @param wsServer
     * @param self
     * @param opHero
     * @param myHeros
     */
    private static void attackOpHero(WsServer wsServer, GameInfo.StateEntity.HerosEntity self, GameInfo.StateEntity.HerosEntity opHero,
                                     List<GameInfo.StateEntity.HerosEntity> myHeros, GameInfo.StateEntity.TowersEntity closeTower,
                                     double closeOpHeroDistance, double attachMeHealth, int opTowerSize) {
        MyColseHero myCloseHero = NowDataUtils.closeHerosInfo(self, opHero, myHeros);
        if (self.getName().equals(opHero.getName())) {
            //英雄同类型
            if (Utils.getHeroRange(self) >= closeOpHeroDistance) {
                if (myCloseHero.getOurHealth() >= attachMeHealth) {
                    //打得过
                    if (self.getHealthPoint() > opHero.getHealthPoint()) {
                        //直接攻击
                        InstructionsUtils.attackHero(wsServer, self, opHero);
                    } else {
                        RunCloseHero(wsServer, self, opHero, myCloseHero.getCloseHealthHero());
                    }
                } else {
                    RunCloseHero(wsServer, self, opHero, myCloseHero.getCloseHealthHero());
                }
            } else {
                //直接攻击
                InstructionsUtils.attackHero(wsServer, self, opHero);
            }
        } else {
            if (self.getName().equals("shooter") && !opHero.getName().equals("shooter")) {
                //远程打近战
                if (Utils.getHeroRange(self) >= closeOpHeroDistance) {
                    //打得着
                    GameInfo.StateEntity.HerosEntity closeHealth = myCloseHero.getCloseHealthHero();
                    if (closeHealth != null) {
                        if (self.getAttackCD() != 0 && self.getFireCD() != 0) {
                            //技能攻击都未CD，走位
                            RunCloseHero(wsServer, self, opHero, closeHealth);
                        } else {
                            //直接攻击
                            InstructionsUtils.attackHero(wsServer, self, opHero);
                        }
                    } else {
                        RunCloseHero(wsServer, self, opHero, closeHealth);
                    }
                } else {
                    //不在攻击范围内,攻击最近的
                    InstructionsUtils.attackHero(wsServer, self, opHero);
                }
            } else {
                //近战打远程
                if (Utils.getHeroRange(self) >= closeOpHeroDistance) {
                    if (myCloseHero.getOurHealth() >= attachMeHealth) {
                        //团队整体打得过对方
                        double myAttack = Math.ceil((self.getAttackDamageMax() + self.getAttackDamageMin()) / 2);
                        double opAttack = Math.ceil((opHero.getAttackDamageMax() + opHero.getAttackDamageMin()) / 2);
                        if ((opHero.getAttackGap() + opHero.getAttackAnimation()) * Math.ceil(self.getHealthPoint() / opAttack)
                                >= (self.getAttackGap() + self.getAttackAnimation()) * Math.ceil(opHero.getHealthPoint() / myAttack)) {
                            //打得过跟我单挑的
                            InstructionsUtils.attackHero(wsServer, self, opHero);
                        } else {
                            //走位，如果我是近战友方是远程，顶上去，否则
                            if (!"shooter".equals(self.getName()) && myCloseHero.isHasShooter()) {
                                InstructionsUtils.attackHero(wsServer, self, opHero);
                            } else {
                                RunCloseHero(wsServer, self, opHero, myCloseHero.getCloseHealthHero());
                            }
                        }
                    } else {
                        RunCloseHero(wsServer, self, opHero, myCloseHero.getCloseHealthHero());
                    }
                } else {
                    attackTower(wsServer, self, opHero, closeTower, opTowerSize);
                }
            }
        }
        wsServer = null;
        closeTower = null;
        self = null;
        opHero = null;
        myHeros = null;
    }

    /**
     * 逃跑策略
     *
     * @param wsServer
     * @param self
     * @param opHero
     */
    private static void RunCloseHero(WsServer wsServer, GameInfo.StateEntity.HerosEntity self,
                                     GameInfo.StateEntity.HerosEntity opHero, GameInfo.StateEntity.HerosEntity closeHealth) {
        //逃往最近的满血友方
        if (closeHealth != null) {
            if (self.getHealthPoint() <= opHero.getAttackDamageMax()) {
                //血量低，直接攻击
                InstructionsUtils.attackHero(wsServer, self, opHero);
            } else {
                if (!"move".equals(self.getExecutingCmd().getType()) && !"move".equals(self.getCmd().getType())) {
                    InstructionsUtils.moveHero(wsServer, self, Utils.getMovePos(self.getCamp()));
                }
            }
        } else {
            //直接攻击
            InstructionsUtils.attackHero(wsServer, self, opHero);
        }
        closeHealth = null;
        wsServer = null;
        self = null;
        opHero = null;
    }

    /**
     * 攻击塔策略
     *
     * @param wsServer
     * @param self
     * @param closeOpHero
     * @param tower
     */
    private static void attackTower(WsServer wsServer, GameInfo.StateEntity.HerosEntity self, GameInfo.StateEntity.HerosEntity closeOpHero,
                                    GameInfo.StateEntity.TowersEntity tower, int opTowerSize) {
        //做血量控制
        if (opTowerSize > 5) {
            //未占三个塔前占塔
            InstructionsUtils.attackTower(wsServer, self, tower.getId());
        } else {
            if (tower.getCamp() != null && !"".equals(tower.getCamp())) {
                if (tower.getHealthPoint() > Utils.TowerHealth) {
                    //攻击塔
                    InstructionsUtils.attackTower(wsServer, self, tower.getId());
                } else {
                    //塔血少于我方一个英雄攻击值,攻击英雄
                    InstructionsUtils.attackHero(wsServer, self, closeOpHero);
                }
            } else {
                //攻击英雄
                InstructionsUtils.attackHero(wsServer, self, closeOpHero);
            }
        }
        wsServer = null;
        self = null;
        closeOpHero = null;
        tower = null;
    }


    /**
     * 时间根据团队英雄个数和血量情况定
     *
     * @param wsServer
     * @param heroInfo
     * @param time
     * @param self
     * @param closeOpHero
     * @param closeOpHeroDistance
     * @param closeTowerDistance
     * @param closeTower
     * @param opTowers
     * @param attachMeHealth
     * @param leastHelthOpHero
     */

    public static void judgeTime(WsServer wsServer, int opTowerSize, HeroInfo heroInfo, TowerInfo towerInfo, int time, GameInfo.StateEntity.HerosEntity self, GameInfo.StateEntity.HerosEntity closeOpHero,
                                 double closeOpHeroDistance, double closeTowerDistance, GameInfo.StateEntity.TowersEntity closeTower, List<GameInfo.StateEntity.TowersEntity> opTowers,
                                 double attachMeHealth, GameInfo.StateEntity.HerosEntity leastHelthOpHero) {
        //已占塔至少三个且血量都高于一半
        GameInfo.StateEntity.TowersEntity maxHealthTower = towerInfo.getMaxHealthTower();
        //我的塔数占优
        //我的人数占优,塔不占优,25s
        double myRang = self.getAttackRange();
        if (time < 60000) {
            //普通对战
            normalAttack(wsServer, opTowerSize, self, closeOpHero, closeOpHeroDistance, closeTowerDistance, closeTower, maxHealthTower, opTowers,
                    attachMeHealth, leastHelthOpHero, heroInfo);
        } else if (time < 145000) {
            //开始优先控塔血
            if (maxHealthTower != null) {
                if (myRang < closeTowerDistance) {
                    if (closeTower.getHealthPoint() > Utils.TowerHealth) {
                        attackTower(wsServer, self, closeOpHero, closeTower, opTowerSize);
                    } else {
                        attackTower(wsServer, self, closeOpHero, maxHealthTower, opTowerSize);
                    }
                } else {
                    if (self.getFireCD() != 0) {
                        if (closeTower.getHealthPoint() > Utils.TowerHealth) {
                            attackTower(wsServer, self, closeOpHero, closeTower, opTowerSize);
                        } else {
                            attackTower(wsServer, self, closeOpHero, maxHealthTower, opTowerSize);
                        }
                    } else {
                        attackOpHero(wsServer, self, closeOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                    }
                }
            } else {
                attackOpHero(wsServer, self, closeOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
            }
        } else {
            if (time < 150000) {
                //跑向塔
                runToTower(wsServer, self, towerInfo.getLeastHealthTower(), opTowers);
            } else {
                //攻击攻击最近的塔
                if (self.getFireCD() != 0) {
                    InstructionsUtils.attackTower(wsServer, self, closeTower.getId());
                } else {
                    if (self.getFireRange() < closeOpHeroDistance) {
                        InstructionsUtils.attackTower(wsServer, self, closeTower.getId());
                    } else {
                        InstructionsUtils.attackHero(wsServer, self, closeOpHero);
                    }
                }
            }
        }
        wsServer = null;
        self = null;
        closeOpHero = null;
        closeTower = null;
        opTowers = null;
        leastHelthOpHero = null;
        maxHealthTower = null;
        heroInfo = null;
    }

    private static void normalAttack(WsServer wsServer, int opTowerSize, GameInfo.StateEntity.HerosEntity self, GameInfo.StateEntity.HerosEntity closeOpHero, double closeOpHeroDistance,
                                     double closeTowerDistance, GameInfo.StateEntity.TowersEntity closeTower, GameInfo.StateEntity.TowersEntity maxHealthTower,
                                     List<GameInfo.StateEntity.TowersEntity> opTowers, double attachMeHealth, GameInfo.StateEntity.HerosEntity leastHelthOpHero, HeroInfo heroInfo) {
        double maxHealthDis = maxHealthTower != null ? Utils.getDistance(self.getPosition(), maxHealthTower.getPosition()) : Integer.MAX_VALUE;
        //都不在我的可攻击范围内
        if (Utils.getHeroRange(self) < closeOpHeroDistance && Utils.getHeroRange(self) < closeTowerDistance) {
            //都不在我的可攻击范围内,优先攻击敌方满血，之后看谁距离更近，优先攻击谁
            if (maxHealthDis <= closeTowerDistance) {
                if (maxHealthTower != null) {
                    attackTower(wsServer, self, closeOpHero, maxHealthTower, opTowerSize);
                } else {
                    attackTower(wsServer, self, closeOpHero, closeTower, opTowerSize);
                }
            } else {
                if (closeTowerDistance < closeOpHeroDistance) {
                    //攻击塔
                    if (closeTower != null) {
                        attackTower(wsServer, self, closeOpHero, closeTower, opTowerSize);
                    } else {
                        //攻击最近的英雄
                        attackOpHero(wsServer, self, closeOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                    }
                } else {
                    //攻击最近的英雄
                    attackOpHero(wsServer, self, closeOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                }
            }
        } else {
            if (Utils.getHeroRange(self) < closeOpHeroDistance && Utils.getHeroRange(self) >= closeTowerDistance) {
                //塔在可攻击范围内，英雄不在可攻击范围内
                if (maxHealthDis <= closeTowerDistance) {
                    attackTower(wsServer, self, closeOpHero, maxHealthTower, opTowerSize);
                } else {
                    attackTower(wsServer, self, closeOpHero, closeTower, opTowerSize);
                }
            } else {
                //塔和英雄都在攻击范围内
                if (Utils.getHeroRange(self) >= closeOpHeroDistance && Utils.getHeroRange(self) >= closeTowerDistance) {
                    //谁近优先攻击谁
                    if (closeTowerDistance < closeOpHeroDistance) {
                        //攻击塔
                        if (closeTower != null) {
                            if (maxHealthDis <= closeTowerDistance) {
                                attackTower(wsServer, self, closeOpHero, maxHealthTower, opTowerSize);
                            } else {
                                attackTower(wsServer, self, closeOpHero, closeTower, opTowerSize);
                            }
                        } else {
                            //优先攻击最近的血量最少的英雄
                            if (leastHelthOpHero != null) {
                                attackOpHero(wsServer, self, leastHelthOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                            } else {
                                //攻击最近的英雄
                                attackOpHero(wsServer, self, leastHelthOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                            }
                        }
                    } else {
                        //优先攻击最近的血量最少的英雄
                        if (leastHelthOpHero != null) {
                            attackOpHero(wsServer, self, leastHelthOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                        } else {
                            //攻击最近的英雄
                            attackOpHero(wsServer, self, leastHelthOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                        }
                    }
                } else {
                    //优先攻击最近的血量最少的英雄
                    if (leastHelthOpHero != null) {
                        attackOpHero(wsServer, self, leastHelthOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                    } else {
                        //攻击最近的英雄
                        attackOpHero(wsServer, self, leastHelthOpHero, heroInfo.getMyHeros(), closeTower, closeOpHeroDistance, attachMeHealth, opTowerSize);
                    }
                }
            }
        }
        wsServer = null;
        self = null;
        closeOpHero = null;
        closeTower = null;
        leastHelthOpHero = null;
        maxHealthTower = null;
        heroInfo = null;
    }

    private static void runToTower(WsServer wsServer, GameInfo.StateEntity.HerosEntity self, GameInfo.StateEntity.TowersEntity leastHealthTower, List<GameInfo.StateEntity.TowersEntity> opTowers) {
        int opTowerSize = opTowers.size();
        int index = (int) (Math.random() * opTowerSize);
        if (index >= 0 && index < opTowerSize) {
            if (!"move".equals(self.getExecutingCmd().getType()) && !"move".equals(self.getCmd().getType())) {
                InstructionsUtils.moveHero(wsServer, self, opTowers.get(index).getPosition());
            }
        } else {
            if (!"move".equals(self.getExecutingCmd().getType()) && !"move".equals(self.getCmd().getType())) {
                InstructionsUtils.moveHero(wsServer, self, leastHealthTower.getPosition());
            }
        }
        wsServer = null;
        self = null;
        leastHealthTower = null;
        opTowers = null;
    }

}
