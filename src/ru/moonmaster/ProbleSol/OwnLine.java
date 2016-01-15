package ru.moonmaster.ProbleSol;

public class OwnLine {

    private Line line1;
    private Line line2;
    private String result;

    public OwnLine(Line line1, Line line2) {
        this.line1 = line1;
        this.line2 = line2;
    }

    protected double coordX;
    protected double coordY;

    private double det(double param1, double param2, double param3, double param4) {
        double calcDet = 0.0;
        calcDet = (param1 * param2) - (param3 * param4);
        return calcDet;
    }

    public void coordinate () {
        double detRes = det(line1.getParamA(), line2.getParamB(), line1.getParamB(), line2.getParamA());
        if (detRes == 0.0) {
            result = "Test";
        }
        else {
            double numericX = det(-line1.getParamC(), line2.getParamB(), -line2.getParamC(), line1.getParamB());
            coordX = -(numericX / detRes);
            double numericY = det(line1.getParamA(), -line2.getParamC(), line2.getParamA(), -line1.getParamC());
            coordY = -(numericY / detRes);
        }
    }
}
