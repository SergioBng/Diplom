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
//        -----------------------------First part---------------------------------------------
        int newCountOfMultiplierFirst = element.getCoefficientFirst().size() / 2;

        ArrayList<Double> arrayOfLargeMultiplierFirst = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            arrayOfLargeMultiplierFirst.add(Math.pow(oldCoefficient, element.getCoefficientFirst().get(i+1)));
        }

//              First coefficient
        ArrayList<Double> intermediateArray = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            double newCoefficient = Math.pow(oldCoefficient, -1);
            intermediateArray.add(newCoefficient);
            intermediateArray.add(element.getCoefficientFirst().get(i+1));
        }
        newElement.setCoefficientFirst(intermediateArray);
        intermediateArray.clear();

//        --------------------------------Second part-------------------------------------------
        ArrayList<Double> arrayOfLargeMultiplierSecond = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            arrayOfLargeMultiplierSecond.add(Math.pow(Math.pow(oldCoefficient, 2) +
                    Math.pow(element.getCoefficientSecond().get(i+1), 2), element.getCoefficientSecond().get(i+2)));
        }



//                Second coefficient
        for (int i = 0; i < element.getCoefficientSecond().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientSecond().get(i);
            double newCoefficientFirst = oldCoefficient *
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientSecond().get(i+1), 2), -1);
            intermediateArray.add(newCoefficientFirst);
            double newCoefficientSecond = element.getCoefficientSecond().get(i+1) *
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientSecond().get(i+1), 2), -1);
            intermediateArray.add(newCoefficientSecond);
            intermediateArray.add(element.getCoefficientSecond().get(i+3));
        }
        newElement.setCoefficientSecond(intermediateArray);
        intermediateArray.clear();





        return newElement;
    }
}
