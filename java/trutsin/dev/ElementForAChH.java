package trutsin.dev;

import java.util.ArrayList;

public class ElementForAChH {
    private double coefficientFirst;
    private double coefficientSecond;
    private double coefficientThird;
    private double coefficientFourth;
    private double largeMultiplier;

    public ElementForAChH() {
    }

    public double getCoefficientFirst() {
        return coefficientFirst;
    }

    public void setCoefficientFirst(double coefficientFirst) {
        this.coefficientFirst = coefficientFirst;
    }

    public double getCoefficientSecond() {
        return coefficientSecond;
    }

    public void setCoefficientSecond(double coefficientSecond) {
        this.coefficientSecond = coefficientSecond;
    }

    public double getCoefficientThird() {
        return coefficientThird;
    }

    public void setCoefficientThird(double coefficientThird) {
        this.coefficientThird = coefficientThird;
    }

    public double getCoefficientFourth() {
        return coefficientFourth;
    }

    public void setCoefficientFourth(double coefficientFourth) {
        this.coefficientFourth = coefficientFourth;
    }

    public double getLargeMultiplier() {
        return largeMultiplier;
    }

    public void setLargeMultiplier(double largeMultiplier) {
        this.largeMultiplier = largeMultiplier;
    }

    @Override
    public String toString() {
        return "ElementForAChH{" +
                "coefficientFirst=" + coefficientFirst +
                ", coefficientSecond=" + coefficientSecond +
                ", coefficientThird=" + coefficientThird +
                ", coefficientFourth=" + coefficientFourth +
                ", largeMultiplier=" + largeMultiplier +
                '}';
    }
}
