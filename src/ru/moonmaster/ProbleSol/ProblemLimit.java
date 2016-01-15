package ru.moonmaster.ProbleSol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemLimit {

    protected static double[] trueLocation;

    public static double[] trueLocationParticle () {
        trueLocation = new double[2];
        Line paramLineOne = new Line(5.45, 4.3, 4.4, "lim1");
        Line paramLineTwo = new Line(4.55, 3.7, 5.6, "lim2");
        Line paramLineThree = new Line(4.25, -2.25, 6.0, "lim3");
        Line paramLineThow = new Line(3.75, -3.75, 8.0, "lim4");

        OwnLine lim1 = new OwnLine(paramLineOne, paramLineTwo);
        OwnLine lim2 = new OwnLine(paramLineOne, paramLineThree);
        OwnLine lim3 = new OwnLine(paramLineOne, paramLineThow);
        OwnLine lim4 = new OwnLine(paramLineTwo, paramLineThree);
        OwnLine lim5 = new OwnLine(paramLineTwo, paramLineThow);
        OwnLine lim6 = new OwnLine(paramLineThree, paramLineThow);

        List<OwnLine> listAllLimits = new ArrayList<OwnLine>();
        List<Double> listCoordinateX = new ArrayList<Double>();
        List<Double> listCoordinateY = new ArrayList<Double>();

        listAllLimits.add(lim1);
        listAllLimits.add(lim2);
        listAllLimits.add(lim3);
        listAllLimits.add(lim4);
        listAllLimits.add(lim5);
        listAllLimits.add(lim6);

        getAllCoordinate(listAllLimits);
        for (OwnLine itemListAllCoordinate : listAllLimits) {
            listCoordinateX.add(itemListAllCoordinate.coordX);
            listCoordinateY.add(itemListAllCoordinate.coordY);
        }

        int indexMinElX = listCoordinateX.indexOf(Collections.min(listCoordinateX));
        int indexMaxElX = listCoordinateX.indexOf(Collections.max(listCoordinateX));
        int indexMinElY = listCoordinateY.indexOf(Collections.min(listCoordinateY));
        int indexMaxElY = listCoordinateY.indexOf(Collections.max(listCoordinateY));

        double minCoordinateX = listCoordinateX.get(indexMinElX);
        double maxCoordinateX = listCoordinateX.get(indexMaxElX);
        double minCoordinateY = listCoordinateY.get(indexMinElY);
        double maxCoordinateY = listCoordinateY.get(indexMaxElY);

        double x = minCoordinateX + (double)(Math.random() * (maxCoordinateX - minCoordinateX));
        double y = minCoordinateY + (double)(Math.random() * (maxCoordinateY - minCoordinateY));

        trueLocation[0] = x;
        trueLocation[1] = y;

        /*boolean countIter = false;
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
        */
        return trueLocation;
    }


    private static void getAllCoordinate(List<OwnLine> listAllLimits) {
        for (OwnLine itemListAllLimits : listAllLimits) {
            itemListAllLimits.coordinate();
        }
    }

}
