package ru.moonmaster.ProbleSol;

public class Line {

    private double paramA;
    private double paramB;
    private double paramC;
    private String name;

    public Line(double paramA, double paramB, double paramC, String name) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
        this.name = name;
    }

    public double getParamA() {
        return paramA;
    }

    public double getParamB() {
        return paramB;
    }

    public double getParamC() {
        return paramC;
    }

    public double calculate(double x, double y) {
        double result = paramA * x + paramB * y;
        return result;
    }
}
