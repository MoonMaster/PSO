package ru.moonmaster.ProbleSol;

import java.util.Random;

public class ProblemLimit {

    protected static double[] trueLocation;

    public static double[] trueLocationParticle () {
        trueLocation = new double[2];
        Line paramLineOne = new Line(5.45, 4.3, 4.4);
        Line paramLineTwo = new Line(4.55, 3.7, 5.6);
        Line paramLineThree = new Line(4.25, -2.25, 6.0);
        Line paramLineThow = new Line(3.75, -3.75, 8.0);
        boolean countIter = false;
        while (!countIter) {
            Random generateRandom = new Random();
            double x = generateRandom.nextDouble();
            double y = generateRandom.nextDouble();
            if ((x > 0) & (y > 0)) {
                double tmpResLim1 = (5.45 * x) + (4.3 * y);
                double tmpResLim2 = (4.55 * x) + (3.7 * y);
                double tmpResLim3 = (4.25 * x) + (-2.25 * y);
                double tmpResLim4 = (3.75 * x) + (-3.75 * y);
                if (tmpResLim1 >= 4.4 && tmpResLim2 <= 5.6 && tmpResLim3 >= 6.0 && tmpResLim4 <=8.0) {
                    countIter = true;
                    trueLocation[0] = x;
                    trueLocation[1] = y;
                }
            }
        }
        return trueLocation;
    }

}
