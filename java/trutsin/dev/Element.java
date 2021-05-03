package trutsin.dev;

public class Element {

    private int[][] coefficientFirst;
    private int[][] coefficientSecond;
    private int[][] coefficientThird;
    private int[][] coefficientFourth;
    private int countOfMultiplier;
    private int largeMultiplier;

    public Element() {
    }

    public int[][] getCoefficientFirst() {
        return coefficientFirst;
    }

    public void setCoefficientFirst(int[][] coefficientFirst) {
        this.coefficientFirst = coefficientFirst;
    }

    public int[][] getCoefficientSecond() {
        return coefficientSecond;
    }

    public void setCoefficientSecond(int[][] coefficientSecond) {
        this.coefficientSecond = coefficientSecond;
    }

    public int[][] getCoefficientThird() {
        return coefficientThird;
    }

    public void setCoefficientThird(int[][] coefficientThird) {
        this.coefficientThird = coefficientThird;
    }

    public int[][] getCoefficientFourth() {
        return coefficientFourth;
    }

    public void setCoefficientFourth(int[][] coefficientFourth) {
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
}
