package entity;

import java.util.List;

public class HeroInfo {
    private List<GameInfo.StateEntity.HerosEntity> myHeros;
    private List<GameInfo.StateEntity.HerosEntity> opHeros;
    private double myHeroHealths;
    private double opHersoHealths;

    public List<GameInfo.StateEntity.HerosEntity> getMyHeros() {
        return myHeros;
    }

    public void setMyHeros(List<GameInfo.StateEntity.HerosEntity> myHeros) {
        this.myHeros = myHeros;
    }

    public List<GameInfo.StateEntity.HerosEntity> getOpHeros() {
        return opHeros;
    }

    public void setOpHeros(List<GameInfo.StateEntity.HerosEntity> opHeros) {
        this.opHeros = opHeros;
    }

    public double getMyHeroHealths() {
        return myHeroHealths;
    }

    public void setMyHeroHealths(double myHeroHealths) {
        this.myHeroHealths = myHeroHealths;
    }

    public double getOpHersoHealths() {
        return opHersoHealths;
    }

    public void setOpHersoHealths(double opHersoHealths) {
        this.opHersoHealths = opHersoHealths;
    }
}
