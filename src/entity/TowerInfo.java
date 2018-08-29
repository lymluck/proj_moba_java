package entity;

import java.util.List;

public class TowerInfo {
    private List<GameInfo.StateEntity.TowersEntity> myTowers;
    private List<GameInfo.StateEntity.TowersEntity> opTowers;
    private double myTowerHealths;
    private double opTowerHealths;
    private GameInfo.StateEntity.TowersEntity leastHealthTower;
    private GameInfo.StateEntity.TowersEntity maxHealthTower;
    private int opTowerSize;

    public List<GameInfo.StateEntity.TowersEntity> getMyTowers() {
        return myTowers;
    }

    public void setMyTowers(List<GameInfo.StateEntity.TowersEntity> myTowers) {
        this.myTowers = myTowers;
    }

    public List<GameInfo.StateEntity.TowersEntity> getOpTowers() {
        return opTowers;
    }

    public void setOpTowers(List<GameInfo.StateEntity.TowersEntity> opTowers) {
        this.opTowers = opTowers;
    }

    public double getMyTowerHealths() {
        return myTowerHealths;
    }

    public void setMyTowerHealths(double myTowerHealths) {
        this.myTowerHealths = myTowerHealths;
    }

    public double getOpTowerHealths() {
        return opTowerHealths;
    }

    public void setOpTowerHealths(double opTowerHealths) {
        this.opTowerHealths = opTowerHealths;
    }

    public GameInfo.StateEntity.TowersEntity getLeastHealthTower() {
        return leastHealthTower;
    }

    public void setLeastHealthTower(GameInfo.StateEntity.TowersEntity leastHealthTower) {
        this.leastHealthTower = leastHealthTower;
    }

    public GameInfo.StateEntity.TowersEntity getMaxHealthTower() {
        return maxHealthTower;
    }

    public void setMaxHealthTower(GameInfo.StateEntity.TowersEntity maxHealthTower) {
        this.maxHealthTower = maxHealthTower;
    }

    public int getOpTowerSize() {
        return opTowerSize;
    }

    public void setOpTowerSize(int opTowerSize) {
        this.opTowerSize = opTowerSize;
    }
}
