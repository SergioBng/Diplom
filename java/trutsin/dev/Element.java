package trutsin.dev;

import java.util.ArrayList;

public class Element {

    private ArrayList<Double> coefficientFirst;
    private ArrayList<Double> coefficientSecond;
    private ArrayList<Double> coefficientThird;
    private ArrayList<Double> coefficientFourth;
    private double largeMultiplier;
    private int degreeV;
    private int degreeG;

    public Element() {
    }

    public ArrayList<Double> getCoefficientFirst() {
        return coefficientFirst;
    }

    public void setCoefficientFirst(ArrayList<Double> coefficientFirst) {
        this.coefficientFirst = coefficientFirst;
    }

    public ArrayList<Double> getCoefficientSecond() {
        return coefficientSecond;
    }

    public void setCoefficientSecond(ArrayList<Double> coefficientSecond) {
        this.coefficientSecond = coefficientSecond;
    }

    public ArrayList<Double> getCoefficientThird() {
        return coefficientThird;
    }

    public void setCoefficientThird(ArrayList<Double> coefficientThird) {
        this.coefficientThird = coefficientThird;
    }

    public ArrayList<Double> getCoefficientFourth() {
        return coefficientFourth;
    }

    public void setCoefficientFourth(ArrayList<Double> coefficientFourth) {
        this.coefficientFourth = coefficientFourth;
    }

    public double getLargeMultiplier() {
        return largeMultiplier;
    }

    public void setLargeMultiplier(double largeMultiplier) {
        this.largeMultiplier = largeMultiplier;
    }

    public int getDegreeV() {
        return degreeV;
    }

    public void setDegreeV(int degreeV) {
        this.degreeV = degreeV;
    }

    public int getDegreeG() {
        return degreeG;
    }

    public void setDegreeG(int degreeG) {
        this.degreeG = degreeG;
    }

    @Override
    public String toString() {
        return "Element{" +
                "coefficientFirst=" + coefficientFirst +
                ", coefficientSecond=" + coefficientSecond +
                ", coefficientThird=" + coefficientThird +
                ", coefficientFourth=" + coefficientFourth +
                ", largeMultiplier=" + largeMultiplier +
                '}';
    }
}
