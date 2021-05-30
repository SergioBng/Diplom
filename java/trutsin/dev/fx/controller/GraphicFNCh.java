package trutsin.dev.fx.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import trutsin.dev.*;

public class GraphicFNCh {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button createButton;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private ImageView image;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;


    @FXML
    void createGraphic(ActionEvent event) {
        createButton.setOnAction(e -> {

            XYChart.Series series = new XYChart.Series();
            series.setName("АЧХ");
//            add data

            WorkWithFile workWithFile = new WorkWithFile();
//            Element element = workWithFile.setParametersFromFile();
//            OperationWithElement operation = new OperationWithElement();
//            Map<Double, Double> findAChH =
//                    operation.getAChHOfElementByAllFrequencies(element, operation.getFrequencies());
//            for (Map.Entry entry : findAChH.entrySet()) {
//                System.out.println("X: " + entry.getKey() + "Y: " + entry.getValue());
//                String finalX = String.format("%.2f" ,entry.getKey());
//                series.getData().add(new XYChart.Data(finalX, entry.getValue()));
//            }
            String path = "C:/Users/user/Desktop/Mathcad diplom/FNCH.txt";
            ArrayList<Double> list = workWithFile.getReadyValues(path);
            for (int i = 0; i < list.size(); i += 2) {
                String finalX = String.format("%.2f" , list.get(i));
                series.getData().add(new XYChart.Data(finalX, list.get(i + 1)));
            }

            chart.getData().addAll(series);
        });

    }
}

