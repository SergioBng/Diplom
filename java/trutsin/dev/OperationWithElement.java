package trutsin.dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OperationWithElement {

    public OperationWithElement() {
    }

    public Element denormirovanie(Element element, double normalizingFrequency) {
        double degree1 = 0;
        double degree2 = 0;
        double degree3 = 0;
        double degree4 = 0;

        //        First coefficient
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientFirst().set(i, newCoefficient);

            degree1 += element.getCoefficientFirst().get(i + 1);
        }

        //        Second coefficient
        for (int i = 0; i < element.getCoefficientSecond().size(); i += 3) {
            Double oldCoefficient1 = element.getCoefficientSecond().get(i);
            double newCoefficient1 = oldCoefficient1 * normalizingFrequency;
            element.getCoefficientSecond().set(i, newCoefficient1);

            Double oldCoefficient2 = element.getCoefficientSecond().get(i + 1);
            double newCoefficient2 = oldCoefficient2 * normalizingFrequency;
            element.getCoefficientSecond().set(i + 1, newCoefficient2);

            degree2 += element.getCoefficientSecond().get(i + 2);
        }

        //        Third coefficient
        for (int i = 0; i < element.getCoefficientThird().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientThird().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientThird().set(i, newCoefficient);

            degree3 += element.getCoefficientThird().get(i + 1);
        }

        //        Fourth coefficient
        for (int i = 0; i < element.getCoefficientFourth().size(); i += 3) {
            Double oldCoefficient1 = element.getCoefficientFourth().get(i);
            double newCoefficient1 = oldCoefficient1 * normalizingFrequency;
            element.getCoefficientFourth().set(i, newCoefficient1);

            Double oldCoefficient2 = element.getCoefficientFourth().get(i + 1);
            double newCoefficient2 = oldCoefficient2 * normalizingFrequency;
            element.getCoefficientFourth().set(i + 1, newCoefficient2);

            degree4 += element.getCoefficientFourth().get(i + 2);
        }

        element.setLargeMultiplier(Math.pow(element.getLargeMultiplier(),
                (degree3 + (2 * degree4)) - (degree1 + (2 * degree2))));

        return element;
    }

    public Element transformation_FNCh_In_FVCh(Element element) {
        Element newElement = new Element();
        double multipliedLargeMultiplier1 = 1;
        double multipliedLargeMultiplier2 = 1;
        double multipliedLargeMultiplier3 = 1;
        double multipliedLargeMultiplier4 = 1;
        double sumOfDegree1 = 0;
        double sumOfDegree2 = 0;
        double sumOfDegree3 = 0;
        double sumOfDegree4 = 0;

//        -----------------------------First part---------------------------------------------

        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            multipliedLargeMultiplier1 *= Math.pow(oldCoefficient, element.getCoefficientFirst().get(i + 1));
            sumOfDegree1 += element.getCoefficientFirst().get(i + 1);
        }

//              First coefficient
        ArrayList<Double> intermediateArray1 = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            double newCoefficient = Math.pow(oldCoefficient, -1);
            intermediateArray1.add(newCoefficient);
            intermediateArray1.add(element.getCoefficientFirst().get(i + 1));
        }
        newElement.setCoefficientFirst(intermediateArray1);

//        --------------------------------Second part-------------------------------------------

        for (int i = 0; i < element.getCoefficientFirst().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            multipliedLargeMultiplier2 *= Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientSecond().get(i + 1), 2),
                    element.getCoefficientSecond().get(i + 2));
            sumOfDegree2 += element.getCoefficientSecond().get(i + 2);
        }



//                Second coefficient
        ArrayList<Double> intermediateArray2 = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientSecond().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientSecond().get(i);
            double newCoefficientFirst = oldCoefficient *
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientSecond().get(i + 1), 2), -1);
            intermediateArray2.add(newCoefficientFirst);
            double newCoefficientSecond = element.getCoefficientSecond().get(i+1) *
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientSecond().get(i + 1), 2), -1);
            intermediateArray2.add(newCoefficientSecond);
            intermediateArray2.add(element.getCoefficientSecond().get(i + 2));
        }
        newElement.setCoefficientSecond(intermediateArray2);

//        ---------------------------Fourth part---------------------------------------------------------

        for (int i = 0; i < element.getCoefficientFourth().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientFourth().get(i);
            multipliedLargeMultiplier4 *= Math.pow(Math.pow(oldCoefficient, 2) +
                    Math.pow(element.getCoefficientFourth().get(i + 1), 2), -element.getCoefficientFourth().get(i + 2));
            sumOfDegree4 += element.getCoefficientFourth().get(i + 2);
        }

//                Fourth coefficient
        ArrayList<Double> intermediateArray4 = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientFourth().size(); i += 3) {
            Double oldCoefficient = element.getCoefficientFourth().get(i);
            double newCoefficientFirst = oldCoefficient *
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientFourth().get(i+1), 2), -1);
            intermediateArray4.add(newCoefficientFirst);
            double newCoefficientSecond = element.getCoefficientFourth().get(i+1) *
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(element.getCoefficientFourth().get(i+1), 2), -1);
            intermediateArray4.add(newCoefficientSecond);
            intermediateArray4.add(element.getCoefficientFourth().get(i+2));
        }
        newElement.setCoefficientFourth(intermediateArray4);


//      ---------------------------Third part----------------------------------------------------------

        int countOfMultipliers = element.getCoefficientThird().size() / 2;
        int notNull = 0;

//        Check on zero in coefficient a
        for (int i = 0; i < element.getCoefficientThird().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientThird().get(i);
            sumOfDegree3 += element.getCoefficientThird().get(i + 1);
            if (oldCoefficient != 0) {
                notNull += 1;
            }
        }
        if (notNull == countOfMultipliers) {
            countOfMultipliers += 1;
            sumOfDegree3 +=1;
        }
        double commonSumOfDegree = (sumOfDegree1 + (2 * sumOfDegree2)) - (sumOfDegree3 + (2 * sumOfDegree4));

//        Multiplying Large Multiplier
        for (int i = 0; i < element.getCoefficientThird().size(); i += 2) {
            int numberOfLargeMultiplier = 1;
            Double oldCoefficient = element.getCoefficientThird().get(i);
            if (oldCoefficient != 0 & numberOfLargeMultiplier < countOfMultipliers) {
                multipliedLargeMultiplier3 *= Math.pow(oldCoefficient, -element.getCoefficientThird().get(i + 1));
            } else {
                multipliedLargeMultiplier3 *= 1;
            }
        }

//        Third coefficient
        ArrayList<Double> intermediateArray3 = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientThird().size(); i += 2) {
            int numberOfLargeMultiplier = 1;
            Double oldCoefficientFirst = element.getCoefficientThird().get(i);
            double newCoefficientFirst;
            double newCoefficientSecond;
            if (oldCoefficientFirst != 0 & numberOfLargeMultiplier < countOfMultipliers) {
                newCoefficientFirst = Math.pow(oldCoefficientFirst, -1);
                newCoefficientSecond = element.getCoefficientThird().get(i + 1);
            } else {
                newCoefficientFirst = 0;
                newCoefficientSecond = commonSumOfDegree;
            }
            intermediateArray3.add(newCoefficientFirst);
            intermediateArray3.add(newCoefficientSecond);
            numberOfLargeMultiplier++;
        }
        newElement.setCoefficientThird(intermediateArray3);
        newElement.setLargeMultiplier(element.getLargeMultiplier() * multipliedLargeMultiplier1
                * multipliedLargeMultiplier2 * multipliedLargeMultiplier3 * multipliedLargeMultiplier4);

        return newElement;
    }

    private double getAChHOfElementByCurrentFrequency(Element element, double frequency) {
        double newCoefficientFirst = 1;
        double newCoefficientSecond = 1;
        double newCoefficientThird = 1;
        double newCoefficientFourth = 1;


//          First coefficient
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            double oldCoefficient = element.getCoefficientFirst().get(i);
            double intermediateCoefficient = Math.sqrt(Math.pow(oldCoefficient, 2) + Math.pow(frequency, 2));
            newCoefficientFirst *= Math.pow(intermediateCoefficient, element.getCoefficientFirst().get(i + 1));
        }

//        Second coefficient
        for (int i = 0; i < element.getCoefficientSecond().size(); i += 3) {
            double oldCoefficient = element.getCoefficientSecond().get(i);
            double oldFrequency = element.getCoefficientSecond().get(i + 1);
            double intermediateCoefficient = Math.sqrt(
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(oldFrequency, 2) + Math.pow(frequency, 2), 2) +
                    Math.pow(2 * oldCoefficient * frequency, 2));
            newCoefficientSecond *= Math.pow(intermediateCoefficient, element.getCoefficientSecond().get(i + 2));
        }

//        Third coefficient
        for (int i = 0; i < element.getCoefficientThird().size(); i += 2) {
            double oldCoefficient = element.getCoefficientThird().get(i);
            double intermediateCoefficient = Math.sqrt(Math.pow(oldCoefficient, 2) + Math.pow(frequency, 2));
            newCoefficientThird *= Math.pow(intermediateCoefficient, element.getCoefficientThird().get(i + 1));
        }

//        Fourth coefficient
        for (int i = 0; i < element.getCoefficientFourth().size(); i += 3) {
            double oldCoefficient = element.getCoefficientFourth().get(i);
            double oldFrequency = element.getCoefficientFourth().get(i + 1);
            double intermediateCoefficient = Math.sqrt(
                    Math.pow(Math.pow(oldCoefficient, 2) + Math.pow(oldFrequency, 2) - Math.pow(frequency, 2), 2) +
                            Math.pow(2 * oldCoefficient * frequency, 2));
            newCoefficientFourth *= Math.pow(intermediateCoefficient, element.getCoefficientFourth().get(i + 2));
        }

//        Large multiplier
        double newLargeMultiplier = Math.abs(element.getLargeMultiplier());

//        Multiplication of final coefficients
        double finalAChH = (newCoefficientThird * newCoefficientFourth) /
                (newLargeMultiplier * newCoefficientFirst * newCoefficientSecond);

        return finalAChH;
    }

    public Map<Double, Double> getAChHOfElementByAllFrequencies(Element element, ArrayList<Double> allFrequencies) {
        Map<Double, Double> mapWithFrequencyAndAChH = new HashMap<>();

        for (double frequency : allFrequencies) {
            mapWithFrequencyAndAChH.put(frequency, getAChHOfElementByCurrentFrequency(element, frequency));
        }
        return mapWithFrequencyAndAChH;
    }

    public ArrayList<Double> getFrequencies() {
        ArrayList<Double> frequencies = new ArrayList<>();
        frequencies.add(1.0);
        frequencies.add(2.0);
        frequencies.add(3.0);
        frequencies.add(4.0);
        frequencies.add(5.0);
        return frequencies;
    }

    public void transformation_FNCh_In_PF(Element element, double parameterOfTransform) {
        Element newElement = new Element();

//        First coefficient

        ArrayList<Double> intermediateArray1 = new ArrayList<>();
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            double oldCoefficient = element.getCoefficientFirst().get(i);
            double oldDegree = element.getCoefficientFirst().get(i + 1);
            double parameterD1 = Math.sqrt(Math.pow(oldCoefficient, 2) - (4 * Math.pow(parameterOfTransform, 2)));
            double newCoefficient = 0;
            double newDegree = 0;
            if (parameterD1 > 0 & ((i + 1) % 2) != 0) {
                newCoefficient = (oldCoefficient - Math.sqrt(parameterD1)) / (2 * parameterOfTransform);
                newDegree = oldDegree;
            } else if (parameterD1 > 0 & ((i + 1) % 2) == 0) {
                newCoefficient = (oldCoefficient + Math.sqrt(parameterD1)) / (2 * parameterOfTransform);
                newDegree = oldDegree;
            } else if (parameterD1 == 0) {
                newCoefficient = oldCoefficient / (2 * parameterOfTransform);
                newDegree = 2 * oldDegree;
            }
            intermediateArray1.add(newCoefficient);
            intermediateArray1.add(newDegree);
        }

    }
}
