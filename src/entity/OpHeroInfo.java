package entity;

import java.util.List;
import java.util.Map;

public class OpHeroInfo {

    private List<Double> distances;
    private Map<Double, GameInfo.StateEntity.HerosEntity> heros;
    private double attackMeHealth;

    public List<Double> getDistances() {
        return distances;
    }

    public void setDistances(List<Double> distances) {
        this.distances = distances;
    }

    public Map<Double, GameInfo.StateEntity.HerosEntity> getHeros() {
        return heros;
    }

    public void setHeros(Map<Double, GameInfo.StateEntity.HerosEntity> heros) {
        this.heros = heros;
    }

    public double getAttackMeHealth() {
        return attackMeHealth;
    }

    public void setAttackMeHealth(double attackMeHealth) {
        this.attackMeHealth = attackMeHealth;
    }
}
