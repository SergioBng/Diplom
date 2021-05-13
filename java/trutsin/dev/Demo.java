package trutsin.dev;

public class Demo {
    public static void main(String[] args) {
        WorkWithFile workWithFile = new WorkWithFile();

        Element element = workWithFile.setParametersFromFile();
        System.out.printf("\n\nOld: " + element.toString() + "\n\n");

        OperationWithElement operationWithElement = new OperationWithElement();
        Element newElement = operationWithElement.denormirovanie(element, 3);
        System.out.printf("New: " + newElement.toString());

//        Element newElement2 = operationWithElement.transformation_AChH_In_FNCh(element);
//        System.out.printf("New: " + newElement2.toString());
    }
}
