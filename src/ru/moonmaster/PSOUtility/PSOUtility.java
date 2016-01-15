package ru.moonmaster.PSOUtility;

public class PSOUtility {
    public static int getMinPos(double[] list) {
        int pos = 0;
        double minValue = list[0];

        for (int indexPos = 0; indexPos < list.length; indexPos++) {
            if (list[indexPos] < minValue) {
                pos = indexPos;
                minValue = list[indexPos];
            }
        }
        return pos;
    }
}
