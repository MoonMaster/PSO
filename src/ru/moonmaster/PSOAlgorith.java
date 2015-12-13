package ru.moonmaster;

import ru.moonmaster.Interface.ConstantParticle;
import ru.moonmaster.Particle.Particle;
import ru.moonmaster.ProbleSol.ProblemLimit;

import java.util.ArrayList;

public class PSOAlgorith implements ConstantParticle{

    private static ArrayList<Particle> arrayParticle = new ArrayList<Particle>();

    public static void main(String[] args) {
        initParticle();
    }

    private static void initParticle() {
        Particle particle;
        for (int indexPop = 0; indexPop < MAX_PARTICLE; indexPop++) {
            particle = new Particle();
            double[] locationParticle = new double[MAX_PARTICLE];
            double[] trueLocation = new double[2];
            trueLocation = ProblemLimit.trueLocationParticle();
            locationParticle[0] = trueLocation[0];
            locationParticle[1] = trueLocation[1];
        }
    }
}
