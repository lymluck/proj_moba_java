package util;

import com.alibaba.fastjson.JSONObject;
import entity.GameInfo;
import entity.PositionInfo;
import server.WsServer;

/**
 * 游戏指令封装
 */
public class InstructionsUtils {

    /**
     * 加入房间
     *
     * @param wsServer
     */
    public static void joinRoom(WsServer wsServer) {
        JSONObject params = new JSONObject();
        params.put("type", "join");
        params.put("gameId", "13v24");
        params.put("token", "pY0Rpfpou67Tg2S5");
        wsServer.send(params.toString());
        wsServer = null;
    }

    /**
     * 选择英雄
     *
     * @param wsServer
     */
    public static void chooseHero(WsServer wsServer) {
        JSONObject params = new JSONObject();
        String[] myHeros = new String[]{"shooter", "shooter", "warrior", "warrior", "warrior"};
        params.put("type", "pickHero");
        params.put("heros", myHeros);
        wsServer.send(params.toString());
        wsServer = null;
    }

    /**
     * 攻击英雄
     *
     * @param wsServer
     * @param hero
     * @param opHero
     */
    public static void attackHero(WsServer wsServer, GameInfo.StateEntity.HerosEntity hero, GameInfo.StateEntity.HerosEntity opHero) {
        JSONObject params = new JSONObject();
        if (opHero.getHealthPoint() < hero.getAttackDamageMin() + hero.getAttackDamageMax()) {
            //两次攻击可以kill敌方
            params.put("type", "attack");
        } else {
            params.put("type", hero.getFireCD() != 0 ? "attack" : "fire");
        }
        params.put("heroId", hero.getId());
        params.put("targetId", opHero.getId());
        params.put("targetType", "hero");
        wsServer.send(params.toString());
        hero = null;
        opHero = null;
        wsServer = null;
    }

    /**
     * 攻击塔
     *
     * @param wsServer
     * @param hero
     * @param closeTowerId
     */
    public static void attackTower(WsServer wsServer, GameInfo.StateEntity.HerosEntity hero, int closeTowerId) {
        JSONObject params = new JSONObject();
        params.put("type", "attack");
        params.put("heroId", hero.getId());
        params.put("targetId", closeTowerId);
        params.put("targetType", "tower");
        wsServer.send(params.toString());
        wsServer = null;
        hero = null;
    }

    /**
     * 移动英雄
     *
     * @param wsServer
     * @param hero
     * @param positionInfo
     */
    public static void moveHero(WsServer wsServer, GameInfo.StateEntity.HerosEntity hero, PositionInfo positionInfo) {
        JSONObject params = new JSONObject();
        params.put("type", "move");
        params.put("heroId", hero.getId());
        params.put("x", positionInfo.getX());
        params.put("y", positionInfo.getY());
        wsServer.send(params.toString());
        wsServer = null;
        hero = null;
        positionInfo = null;
    }

    public static void stopHero(WsServer wsServer, GameInfo.StateEntity.HerosEntity hero, PositionInfo positionInfo) {

    }
}
