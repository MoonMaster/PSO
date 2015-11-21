package ru.moonmaster.ProbleSol;

import ru.moonmaster.Particle.LocationParticle;

public class ProblemSet {

    private static final double paramA = 5.4;
    private static final double paramB = 2.6;

    public static double evalFunc(LocationParticle locationParticle) {
        double resultEvalFunc = 0;
        double positionX1 = locationParticle.getPositionX1();
        double positionX2 = locationParticle.getGetPositionX2();
        resultEvalFunc = paramA * positionX1 - paramB * positionX2;
        return resultEvalFunc;
    }
}
