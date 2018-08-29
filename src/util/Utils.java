package util;


import entity.GameInfo;
import entity.PositionInfo;

public class Utils {
    //控塔的血量
    public static int TowerHealth = 110;

    public static double getDistance(PositionInfo p1, PositionInfo p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    public static double getHeroRange(GameInfo.StateEntity.HerosEntity hero) {
        return hero.getFireCD() != 0 ? hero.getAttackRange() : hero.getFireRange();
    }

    public static PositionInfo getMovePos(String myCamp) {
        PositionInfo positionInfo = new PositionInfo();
        //注意比赛时的红蓝位置情况
        if (myCamp.equals("red")) {
            positionInfo.setX(3700);
            positionInfo.setY(1100);
        } else {
            positionInfo.setX(600);
            positionInfo.setY(1300);
        }
        return positionInfo;
    }
}
