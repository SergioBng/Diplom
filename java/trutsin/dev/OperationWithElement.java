package trutsin.dev;

public class OperationWithElement {
    private double normalizingFrequency;

    public OperationWithElement() {
    }

    public Element denormirovanie(Element element, double normalizingFrequency) {
        for (int i = 0; i < element.getCoefficientFirst().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientFirst().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientFirst().set(i, newCoefficient);
        }

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

        for (int i = 0; i < element.getCoefficientThird().size(); i += 2) {
            Double oldCoefficient = element.getCoefficientThird().get(i);
            double newCoefficient = oldCoefficient * normalizingFrequency;
            element.getCoefficientThird().set(i, newCoefficient);
        }

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
}
