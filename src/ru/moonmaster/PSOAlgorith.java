package ru.moonmaster;

import ru.moonmaster.Interface.ConstantParticle;
import ru.moonmaster.PSOUtility.PSOUtility;
import ru.moonmaster.Particle.LocationParticle;
import ru.moonmaster.Particle.Particle;
import ru.moonmaster.Particle.SpeedParticle;
import ru.moonmaster.ProbleSol.ProblemLimit;
import ru.moonmaster.ProbleSol.ProblemSet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class PSOAlgorith implements ConstantParticle{

    private ArrayList<Particle> swarm = new ArrayList<Particle>();
    private double[] pBest = new double[MAX_PARTICLE];
    private Vector<LocationParticle> pBestLocation = new Vector<LocationParticle>();
    private double gBest;
    private LocationParticle gBestLocation;
    private double[] fitnessValueList = new double[MAX_PARTICLE];

    Random generator = new Random();

    public void execute() {
        initializeSwarm();
        updateFitnessList();

        for(int i=0; i<MAX_PARTICLE; i++) {
            pBest[i] = fitnessValueList[i];
            pBestLocation.add(swarm.get(i).getLocationParticle());
        }

        int t = 0;
        double w;
        double err = 9999;

        while(t < MAX_ITERATION & err > ERR_TOLERANCE) {
            // step 1 - update pBest
            for(int i=0; i<MAX_PARTICLE; i++) {
                if(fitnessValueList[i] > pBest[i]) {
                    pBest[i] = fitnessValueList[i];
                    pBestLocation.set(i, swarm.get(i).getLocationParticle());
                }
            }

            // step 2 - update gBest
            int bestParticleIndex = PSOUtility.getMinPos(fitnessValueList);

            if(t == 0 || fitnessValueList[bestParticleIndex] < gBest) {
                gBest = fitnessValueList[bestParticleIndex];
                gBestLocation = swarm.get(bestParticleIndex).getLocationParticle();
            }

            w = W_UPPERBOUND - (((double) t) / MAX_ITERATION) * (W_UPPERBOUND - W_LOWERBOUND);

            for(int i=0; i<MAX_PARTICLE; i++) {
                double r1 = generator.nextDouble();
                double r2 = generator.nextDouble();

                Particle p = swarm.get(i);

                // step 3 - update velocity
                double[] newVel = new double[2];
                newVel[0] = (w * p.getSpeedParticle().getSpeedParticle()[0]) +
                        (r1 * C1) * (pBestLocation.get(i).getLocationParticle()[0] - p.getLocationParticle().getLocationParticle()[0]) +
                        (r2 * C2) * (gBestLocation.getLocationParticle()[0] - p.getLocationParticle().getLocationParticle()[0]);
                newVel[1] = (w * p.getSpeedParticle().getSpeedParticle()[1]) +
                        (r1 * C1) * (pBestLocation.get(i).getLocationParticle()[1] - p.getLocationParticle().getLocationParticle()[1]) +
                        (r2 * C2) * (gBestLocation.getLocationParticle()[1] - p.getLocationParticle().getLocationParticle()[1]);
                SpeedParticle vel = new SpeedParticle(newVel);
                p.setSpeedParticle(vel);

                // step 4 - update location
                double[] newLoc = new double[2];
                newLoc[0] = p.getLocationParticle().getLocationParticle()[0] + newVel[0];
                newLoc[1] = p.getLocationParticle().getLocationParticle()[1] + newVel[1];
                LocationParticle loc = new LocationParticle(newLoc);
                p.setLocationParticle(loc);
            }

            err = ProblemSet.evaluate(gBestLocation) - 0; // error


            System.out.println("ITERATION " + t + ": ");
            System.out.println("     Best X: " + gBestLocation.getLocationParticle()[0]);
            System.out.println("     Best Y: " + gBestLocation.getLocationParticle()[1]);
            System.out.println("     Value: " + ProblemSet.evaluate(gBestLocation));

            t++;
            updateFitnessList();
        }

        System.out.println("\nSolution found at iteration " + (t - 1) + ", the solutions is:");
        System.out.println("     Best X: " + gBestLocation.getLocationParticle()[0]);
        System.out.println("     Best Y: " + gBestLocation.getLocationParticle()[1]);
    }

    public void initializeSwarm() {
        Particle p;
        for(int i=0; i<MAX_PARTICLE; i++) {
            p = new Particle();

            // randomize location inside a space defined in Problem Set
            double[] loc = ProblemLimit.trueLocationParticle();

            LocationParticle location = new LocationParticle(loc);

            // randomize velocity in the range defined in Problem Set
            double[] vel = new double[2];
            vel[0] = VEL_LOW + generator.nextDouble() * (VEL_HIGH - VEL_LOW);
            vel[1] = VEL_LOW + generator.nextDouble() * (VEL_HIGH - VEL_LOW);
            SpeedParticle velocity = new SpeedParticle(vel);

            p.setLocationParticle(location);
            p.setSpeedParticle(velocity);
            swarm.add(p);
        }
    }

    public void updateFitnessList() {
        for(int i=0; i<MAX_PARTICLE; i++) {
            fitnessValueList[i] = swarm.get(i).getFintesFunction();
        }
    }


}
