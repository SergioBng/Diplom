package trutsin.dev;

public class Demo{
    public static void main(String[] args) {
        WorkWithFile workWithFile = new WorkWithFile();

        Element element = workWithFile.setParametersFromFile();
        System.out.printf("\n\nOld: " + element.toString() + "\n\n");

        OperationWithElement operationWithElement = new OperationWithElement();
//        Element newElement = operationWithElement.denormirovanie(element, 3);
//        System.out.printf("New: " + newElement.toString());

        Element newElement2 = operationWithElement.transformation_FNCh_In_FVCh(element);
        System.out.printf("New: " + newElement2.toString());

//        Element newElement3 = operationWithElement.transformation_FNCh_In_PF(element, 1);
//        System.out.printf("New: " + newElement3.toString());

    }
}
