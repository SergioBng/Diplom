package trutsin.dev.swing;

import trutsin.dev.Element;
import trutsin.dev.OperationWithElement;
import trutsin.dev.WorkWithFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        workWithMenu();
    }

    public static Map<Double, Double> workWithMenu() {
        menu();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n\nInput number:\n");
        int input = scanner.nextInt();
        Map<Double, Double> mapWithAChH = new HashMap<>();
        if (input == 1) {
            WorkWithFile getFile = new WorkWithFile();
            Element element = getFile.setParametersFromFile();
            SwingUi ui = new SwingUi(element);
            workWithMenu();
        } else if (input == 2) {
            WorkWithFile getFile = new WorkWithFile();
            Element element = getFile.setParametersFromFile();
            OperationWithElement operationWithElement = new OperationWithElement();
            Element newElement = operationWithElement.denormirovanie(element, 3);
            SwingUi ui = new SwingUi(newElement);
            workWithMenu();
        } else {
            workWithMenu();
        }
        return mapWithAChH;
    }

    public static void menu() {
        System.out.printf("\n\nChoose operation with element:\n" +
                "1.Find AChH of element.\n" +
                "2.Denormirovanie.\n" +
                "3.FNCh to FChH.\n" +
                "4.Exit.");
    }
}
