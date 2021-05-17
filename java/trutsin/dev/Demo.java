package trutsin.dev;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo extends Application {
    public static void main(String[] args) {
        WorkWithFile workWithFile = new WorkWithFile();

        Element element = workWithFile.setParametersFromFile();
        System.out.printf("\n\nOld: " + element.toString() + "\n\n");

        OperationWithElement operationWithElement = new OperationWithElement();
//        Element newElement = operationWithElement.denormirovanie(element, 3);
//        System.out.printf("New: " + newElement.toString());

        Element newElement2 = operationWithElement.transformation_AChH_In_FNCh(element);
        System.out.printf("New: " + newElement2.toString());


        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Map<Double, Double> mapWithAChH = workWithMenu();

        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Frequency");

        LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("АЧХ");

        XYChart.Series series = new XYChart.Series();
        series.setName("АЧХ");


        for (Map.Entry entry : mapWithAChH.entrySet()) {

            series.getData().add(new XYChart.Data(entry.getKey(), entry.getValue()));
        }


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void menu() {
        System.out.printf("\n\nChoose operation with element:\n" +
                "1.Find AChH of element.\n" +
                "2.Denormirovanie.\n" +
                "3.FNCh to FChH.\n" +
                "4.Exit.");
    }

    public static Map<Double, Double> workWithMenu() {
        WorkWithFile workWithFile = new WorkWithFile();
        Element element = workWithFile.setParametersFromFile();
        OperationWithElement operationWithElement = new OperationWithElement();
        ArrayList<Double> frequencies = new ArrayList<>();
        frequencies.add(1.0);
        frequencies.add(2.0);
        frequencies.add(3.0);
        frequencies.add(4.0);
        frequencies.add(5.0);
        menu();
        Scanner scanner = new Scanner(System.in);
        System.out.printf("\n\nInput number:\n");
        int input = scanner.nextInt();
        Map<Double, Double> mapWithAChH = new HashMap<>();
        if (input == 1) {
            mapWithAChH = operationWithElement.getAChHOfElementByAllFrequencies(element, frequencies);
        } else if (input == 3) {
            Element newElement = operationWithElement.transformation_AChH_In_FNCh(element);
            mapWithAChH = operationWithElement.getAChHOfElementByAllFrequencies(newElement, frequencies);
        } else {
            workWithMenu();
        }
        return mapWithAChH;
    }
}
