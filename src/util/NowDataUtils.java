package util;


import entity.*;

import java.util.*;

public class NowDataUtils {

    /**
     * 获取英雄信息
     *
     * @param myCamp
     * @param heros
     * @return
     */
    public static HeroInfo getHeros(String myCamp, List<GameInfo.StateEntity.HerosEntity> heros) {
        HeroInfo heroInfo = new HeroInfo();
        List<GameInfo.StateEntity.HerosEntity> myHeros = new ArrayList<>();
        List<GameInfo.StateEntity.HerosEntity> opHeros = new ArrayList<>();
        double myHealths = 0;
        double opHealths = 0;
        for (GameInfo.StateEntity.HerosEntity hero : heros) {
            if (!hero.getStatus().equals("dead")) {
                if (!hero.getCamp().equals(myCamp)) {
                    //敌方英雄
                    opHeros.add(hero);
                    opHealths += hero.getHealthPoint();
                } else {
                    myHeros.add(hero);
                    myHealths += hero.getHealthPoint();
                }
            }
        }
        heroInfo.setMyHeros(myHeros);
        heroInfo.setMyHeroHealths(myHealths);
        heroInfo.setOpHeros(opHeros);
        heroInfo.setOpHersoHealths(opHealths);
        heros = null;
        myHeros = null;
        opHeros = null;
        return heroInfo;
    }

    /**
     * 获取塔信息
     *
     * @param myCamp
     * @param towers
     * @return
     */
    public static TowerInfo getTowers(String myCamp, List<GameInfo.StateEntity.TowersEntity> towers) {
        TowerInfo towerInfo = new TowerInfo();
        List<GameInfo.StateEntity.TowersEntity> myTowers = new ArrayList<>();
        List<GameInfo.StateEntity.TowersEntity> opTowers = new ArrayList<>();
        double myHealths = 0;
        double opHealths = 0;
        double leastHealth = Integer.MAX_VALUE;
        double maxHealth = Utils.TowerHealth;
        int opTowerSize = 0;
        GameInfo.StateEntity.TowersEntity leastHealthTower = null;
        GameInfo.StateEntity.TowersEntity maxHealthTower = null;
        for (GameInfo.StateEntity.TowersEntity tower : towers) {
            double towerHealth = tower.getHealthPoint();
            if (tower.getCamp() != null && !"".equals(tower.getCamp())) {
                //排除中立塔
                if (!tower.getCamp().equals(myCamp)) {
                    //敌方塔
                    opTowerSize++;
                    opTowers.add(tower);
                    opHealths += tower.getHealthPoint();
                    if (towerHealth < leastHealth) {
                        leastHealth = towerHealth;
                        leastHealthTower = tower;
                    }
                    //控塔，排除中立塔
                    if (towerHealth > maxHealth) {
                        maxHealth = towerHealth;
                        maxHealthTower = tower;
                    }
                } else {
                    myTowers.add(tower);
                    myHealths += tower.getHealthPoint();
                }
            } else {
                if (!opTowers.contains(tower)) {
                    opTowers.add(tower);
                }
            }
        }
        towerInfo.setMyTowers(myTowers);
        towerInfo.setMyTowerHealths(myHealths);
        towerInfo.setOpTowers(opTowers);
        towerInfo.setOpTowerSize(opTowerSize);
        towerInfo.setMaxHealthTower(maxHealthTower);
        towerInfo.setLeastHealthTower(leastHealthTower);
        towerInfo.setOpTowerHealths(opHealths);
        towers = null;
        myTowers = null;
        opTowers = null;
        leastHealthTower = null;
        maxHealthTower = null;
        return towerInfo;
    }

    /**
     * 获取最近的敌方英雄
     *
     * @param self
     * @param opHeros
     * @return
     */
    public static OpHeroInfo getCloseOpHero(GameInfo.StateEntity.HerosEntity self, List<GameInfo.StateEntity.HerosEntity> opHeros) {
        //距离最近的敌方英雄
        OpHeroInfo heroInfo = new OpHeroInfo();
        ArrayList<Double> distances = new ArrayList<>();
        Map<Double, GameInfo.StateEntity.HerosEntity> heros = new HashMap<>();
        List<GameInfo.StateEntity.HerosEntity> rangHeros = new ArrayList<>();
        double opHealths = 0;
        for (GameInfo.StateEntity.HerosEntity opHero : opHeros) {
            if (!opHero.getStatus().equals("dead")) {
                ExcCmdInfo exeCmdInfo = opHero.getExecutingCmd();
                ExcCmdInfo cmdInfo = opHero.getCmd();
                //我与敌方英雄的距离
                double distance = Utils.getDistance(opHero.getPosition(), self.getPosition());
                if (cmdInfo != null) {
                    if (self.getId() == cmdInfo.getTargetId() && self.getType().equals(cmdInfo.getTargetType())
                            && distance <= Utils.getHeroRange(opHero)) {
                        if (!rangHeros.contains(opHero)) {
                            opHealths += opHero.getHealthPoint();
                            rangHeros.add(opHero);
                        }
                    }
                }
                if (exeCmdInfo != null) {
                    if (self.getId() == exeCmdInfo.getTargetId() && self.getType().equals(exeCmdInfo.getTargetType())
                            && distance <= Utils.getHeroRange(opHero)) {
                        if (!rangHeros.contains(opHero)) {
                            opHealths += opHero.getHealthPoint();
                            rangHeros.add(opHero);
                        }
                    }
                }
                distances.add(distance);
                heros.put(distance, opHero);
                cmdInfo = null;
                exeCmdInfo = null;
            }
        }
        Collections.sort(distances);
        heroInfo.setHeros(heros);
        heroInfo.setAttackMeHealth(opHealths);
        heroInfo.setDistances(distances);
        distances = null;
        rangHeros = null;
        heros = null;
        return heroInfo;
    }

    /**
     * 攻击范围内血量最少的英雄
     *
     * @param opHeroInfo
     * @param range
     * @return
     */
    public static GameInfo.StateEntity.HerosEntity getRangeleastHealth(OpHeroInfo opHeroInfo, double range) {
        //攻击范围内血量最少的英雄
        Map<Double, GameInfo.StateEntity.HerosEntity> opHeros = opHeroInfo.getHeros();
        double minHealth = Integer.MAX_VALUE;
        GameInfo.StateEntity.HerosEntity leastHero = null;
        for (Double distance : opHeros.keySet()) {
            if (range >= distance) {
                double heroHealth = opHeros.get(distance).getHealthPoint();
                if (heroHealth < minHealth) {
                    minHealth = heroHealth;
                    leastHero = opHeros.get(distance);
                }
            }
        }
        return leastHero;
    }

    /**
     * 获取最近的敌方塔
     *
     * @param self
     * @param opTowers
     * @return
     */
    public static OpTowerInfo getCloseOpTower(GameInfo.StateEntity.HerosEntity self, List<GameInfo.StateEntity.TowersEntity> opTowers) {
        //距离最近的敌方塔
        OpTowerInfo opTowerInfo = null;
        if (opTowers != null && opTowers.size() > 0) {
            opTowerInfo = new OpTowerInfo();
            ArrayList<Double> distances = new ArrayList<>();
            Map<Double, GameInfo.StateEntity.TowersEntity> towers = new HashMap<>();
            for (GameInfo.StateEntity.TowersEntity tower : opTowers) {
                //我与敌方塔的距离
                double distance = Utils.getDistance(tower.getPosition(), self.getPosition());
                distances.add(distance);
                towers.put(distance, tower);
            }
            Collections.sort(distances);
            opTowerInfo.setTowers(towers);
            opTowerInfo.setDistances(distances);
            distances = null;
            towers = null;
        }
        return opTowerInfo;
    }

    /**
     * 判断友方一起能否打过正在攻击的敌方
     *
     * @param self
     * @param opHero
     * @param myHeros
     * @return
     */
    public static MyColseHero closeHerosInfo(GameInfo.StateEntity.HerosEntity self, GameInfo.StateEntity.HerosEntity opHero, List<GameInfo.StateEntity.HerosEntity> myHeros) {
        MyColseHero myColseHero = new MyColseHero();
        double ourHealth = self.getHealthPoint();
        double closeDis = Integer.MAX_VALUE;
        GameInfo.StateEntity.HerosEntity closeHero = null;
        List<GameInfo.StateEntity.HerosEntity> rangHeros = new ArrayList<>();
        for (GameInfo.StateEntity.HerosEntity myHero : myHeros) {
            if (myHero.getId() != self.getId() && !myHero.getStatus().equals("dead")) {
                if (myHero.getName().equals("shooter")) {
                    myColseHero.setHasShooter(true);
                }
                ExcCmdInfo exeCmdInfo = myHero.getExecutingCmd();
                ExcCmdInfo cmdInfo = myHero.getCmd();
                //攻击目标相同，且在攻击范围内
                double myDis = Utils.getDistance(myHero.getPosition(), opHero.getPosition());
                if (cmdInfo != null) {
                    if (opHero.getId() == cmdInfo.getTargetId() && opHero.getType().equals(cmdInfo.getTargetType())
                            && myDis <= Utils.getHeroRange(myHero)) {
                        if (!rangHeros.contains(myHero)) {
                            ourHealth += myHero.getHealthPoint();
                            rangHeros.add(myHero);
                        }
                    }
                }
                if (exeCmdInfo != null) {
                    if (opHero.getId() == exeCmdInfo.getTargetId() && opHero.getType().equals(exeCmdInfo.getTargetType())
                            && myDis <= Utils.getHeroRange(myHero)) {
                        if (!rangHeros.contains(myHero)) {
                            ourHealth += myHero.getHealthPoint();
                            rangHeros.add(myHero);
                        }
                    }
                }
                //我与友方的距离
                double distance = Utils.getDistance(myHero.getPosition(), self.getPosition());
                //最近的没有参与此次攻击的满血英雄
                if (distance < closeDis && myHero.getHealthPoint() == myHero.getInitHealthPoint()) {
                    closeDis = distance;
                    if (!rangHeros.contains(myHero)) {
                        closeHero = myHero;
                    }
                }
                cmdInfo = null;
                exeCmdInfo = null;
            }
        }
        myColseHero.setCloseHealthHero(closeHero);
        myColseHero.setOurHealth(ourHealth);
        closeHero = null;
        self = null;
        opHero = null;
        myHeros = null;
        return myColseHero;
    }

}
