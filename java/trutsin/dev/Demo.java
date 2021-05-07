package trutsin.dev;

public class Demo {
    public static void main(String[] args) {
        WorkWithFile workWithFile = new WorkWithFile();
        Element element = workWithFile.setParametersFromFile();
        System.out.println();
        System.out.printf("\n\nOld: " + element.toString() + "\n\n");
        OperationWithElement operationWithElement = new OperationWithElement();
        Element newElement = operationWithElement.denormirovanie(element, 3);
        System.out.printf("New: " + newElement.toString());
    }
}
