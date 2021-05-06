package trutsin.dev;

import java.util.ArrayList;

public class Element {

    private ArrayList<Integer> coefficientFirst;
    private ArrayList<Integer> coefficientSecond;
    private ArrayList<Integer> coefficientThird;
    private ArrayList<Integer> coefficientFourth;
    private int countOfMultiplier;
    private int largeMultiplier;

    public Element() {
    }

    public ArrayList<Integer> getCoefficientFirst() {
        return coefficientFirst;
    }

    public void setCoefficientFirst(ArrayList<Integer> coefficientFirst) {
        this.coefficientFirst = coefficientFirst;
    }

    public ArrayList<Integer> getCoefficientSecond() {
        return coefficientSecond;
    }

    public void setCoefficientSecond(ArrayList<Integer> coefficientSecond) {
        this.coefficientSecond = coefficientSecond;
    }

    public ArrayList<Integer> getCoefficientThird() {
        return coefficientThird;
    }

    public void setCoefficientThird(ArrayList<Integer> coefficientThird) {
        this.coefficientThird = coefficientThird;
    }

    public ArrayList<Integer> getCoefficientFourth() {
        return coefficientFourth;
    }

    public void setCoefficientFourth(ArrayList<Integer> coefficientFourth) {
        this.coefficientFourth = coefficientFourth;
    }

    public int getCountOfMultiplier() {
        return countOfMultiplier;
    }

    public void setCountOfMultiplier(int countOfMultiplier) {
        this.countOfMultiplier = countOfMultiplier;
    }

    public int getLargeMultiplier() {
        return largeMultiplier;
    }

    public void setLargeMultiplier(int largeMultiplier) {
        this.largeMultiplier = largeMultiplier;
    }

    @Override
    public String toString() {
        return "Element{" +
                "coefficientFirst=" + coefficientFirst +
                ", coefficientSecond=" + coefficientSecond +
                ", coefficientThird=" + coefficientThird +
                ", coefficientFourth=" + coefficientFourth +
                ", countOfMultiplier=" + countOfMultiplier +
                ", largeMultiplier=" + largeMultiplier +
                '}';
    }
}
