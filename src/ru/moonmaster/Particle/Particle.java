package ru.moonmaster.Particle;

public class Particle {

    private LocationParticle locationParticle;
    private SpeedParticle speedParticle;
    private double fintesFunction;

    public LocationParticle getLocationParticle() {
        return locationParticle;
    }

    public void setLocationParticle(LocationParticle locationParticle) {
        this.locationParticle = locationParticle;
    }

    public SpeedParticle getSpeedParticle() {
        return speedParticle;
    }

    public void setSpeedParticle(SpeedParticle speedParticle) {
        this.speedParticle = speedParticle;
    }

    public double getFintesFunction() {
        return fintesFunction;
    }

    public void setFintesFunction(double fintesFunction) {
        this.fintesFunction = fintesFunction;
    }
}
