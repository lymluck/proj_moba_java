package entity;

public class MyColseHero {
    private double ourHealth;
    private GameInfo.StateEntity.HerosEntity closeHealthHero;
    private boolean hasShooter;

    public double getOurHealth() {
        return ourHealth;
    }

    public void setOurHealth(double ourHealth) {
        this.ourHealth = ourHealth;
    }

    public GameInfo.StateEntity.HerosEntity getCloseHealthHero() {
        return closeHealthHero;
    }

    public void setCloseHealthHero(GameInfo.StateEntity.HerosEntity closeHealthHero) {
        this.closeHealthHero = closeHealthHero;
    }

    public boolean isHasShooter() {
        return hasShooter;
    }

    public void setHasShooter(boolean hasShooter) {
        this.hasShooter = hasShooter;
    }
}
