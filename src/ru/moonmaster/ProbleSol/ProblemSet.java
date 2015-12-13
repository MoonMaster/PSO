package ru.moonmaster.ProbleSol;


import ru.moonmaster.Particle.LocationParticle;

public class ProblemSet implements ConstantProblem {

    public static double evaluate(LocationParticle locationParticle) {
        double result = 0;
        double x = locationParticle.getLocationParticle()[0];
        double y = locationParticle.getLocationParticle()[1];

        result = constProblemSol1 * x + constProblemSol2 * y;
        return result;
    }

}
