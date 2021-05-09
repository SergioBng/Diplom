package trutsin.dev;

import java.util.ArrayList;

public class OperationWithElement {
    private double normalizingFrequency;

    public OperationWithElement() {
    }

    public Element denormirovanie(Element element, double normalizingFrequency) {
        //        First coefficient
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientFirst().set(i, newCoefficient);
        }

        //        Second coefficient
        for (int i = 0; i < element.getCoefficientSecond().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientSecond().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientSecond().set(i, newCoefficient);
        }
        for (int i = 1; i < element.getCoefficientSecond().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientSecond().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientSecond().set(i, newCoefficient);
        }

        //        Third coefficient
        for (int i = 0; i < element.getCoefficientThird().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientThird().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientThird().set(i, newCoefficient);
        }

        //        Fourth coefficient
        for (int i = 0; i < element.getCoefficientFourth().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientFourth().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientFourth().set(i, newCoefficient);
        }
        for (int i = 1; i < element.getCoefficientFourth().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientFourth().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientFourth().set(i, newCoefficient);
        }

        return element;
    }

    public Element transformation_AChH_In_FNCh(Element element) {
        Element newElement = new Element();

        double newLargeCoefficientFirst =
                Math.pow(element.getCoefficientFirst().get(0), element.getCoefficientFirst().get(1));

        int newCountOfMultiplierFirst = element.getCoefficientFirst().size() / 2;

        //        First coefficient
        ArrayList<Double> intermediateArray = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            double newCoefficient = Math.pow(oldCoefficient, -1);
            intermediateArray.add(newCoefficient);
            intermediateArray.add(element.getCoefficientFirst().get(i+1));
        }
        newElement.setCoefficientFirst(intermediateArray);
        intermediateArray.clear();

        //        Second coefficient
        for (int i = 0; i < element.getCoefficientSecond().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientSecond().get(i);
            double newCoefficient = oldCoefficient *
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientSecond().get(i+1), 2), -1);
            element.getCoefficientSecond().set(i, newCoefficient);
        }


        return newElement;
    }
}
