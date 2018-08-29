package tactics;


import entity.GameInfo;
import server.WsServer;
import util.InstructionsUtils;
import util.Utils;

public class One {

    /**
     * ai策略一
     *
     * @param myCamp
     * @param state
     */
    public static void realTimeAttack(WsServer wsServer, String myCamp, GameInfo.StateEntity state) {
        // 优先攻击靠近的英雄
        for (GameInfo.StateEntity.HerosEntity hero : state.getHeros()) {
            if (!hero.getCamp().equals(myCamp)) {
                continue;
            }
            // 计算离每个英雄最近的英雄
            GameInfo.StateEntity.HerosEntity closeHero = null;
            double minDistance = 0;
            for (GameInfo.StateEntity.HerosEntity opHero : state.getHeros()) {
                if (opHero.getCamp().equals(myCamp)) {
                    continue;
                }

                double distance = Utils.getDistance(hero.getPosition(), opHero.getPosition());
                if (distance < 400 && !opHero.getStatus().equals("dead")
                        && (closeHero == null || distance < minDistance)) {
                    closeHero = opHero;
                    minDistance = distance;
                }
            }
            // 攻击英雄
            if (closeHero != null) {
                InstructionsUtils.attackHero(wsServer, hero, closeHero);
            }
        }

        //其次占塔
        for (GameInfo.StateEntity.HerosEntity hero : state.getHeros()) {
            if (!hero.getCamp().equals(myCamp)) {
                continue;
            }
            // 计算离每个英雄最近的英雄
            GameInfo.StateEntity.TowersEntity closeTower = null;
            double minDistance = 0;
            for (GameInfo.StateEntity.TowersEntity tower : state.getTowers()) {
                if (tower.getCamp().equals(myCamp)) {
                    continue;
                }
                double distance = Utils.getDistance(hero.getPosition(), tower.getPosition());
                if (closeTower == null || distance < minDistance) {
                    closeTower = tower;
                    minDistance = distance;
                }
            }
            // 攻击塔
            if (closeTower != null) {
                InstructionsUtils.attackTower(wsServer, hero, closeTower.getId());
            }
        }

        // 传递命令给服务器
        for (GameInfo.StateEntity.HerosEntity hero : state.getHeros()) {
            if (!hero.getCamp().equals(myCamp)) {
                continue;
            }
            // 如果没有可执行的命令，则攻击敌方未死的英雄
            for (GameInfo.StateEntity.HerosEntity opHero : state.getHeros()) {
                if (!opHero.getCamp().equals(myCamp) && !opHero.getStatus().equals("dead")) {
                    InstructionsUtils.attackHero(wsServer, hero, opHero);
                }
            }
        }
        wsServer = null;
        state = null;
    }
}
