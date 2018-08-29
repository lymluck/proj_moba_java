package entity;

import java.util.List;
import java.util.Map;

public class OpTowerInfo {
    private List<Double> distances;
    private Map<Double, GameInfo.StateEntity.TowersEntity> towers;

    public List<Double> getDistances() {
        return distances;
    }

    public void setDistances(List<Double> distances) {
        this.distances = distances;
    }

    public Map<Double, GameInfo.StateEntity.TowersEntity> getTowers() {
        return towers;
    }

    public void setTowers(Map<Double, GameInfo.StateEntity.TowersEntity> towers) {
        this.towers = towers;
    }
}
