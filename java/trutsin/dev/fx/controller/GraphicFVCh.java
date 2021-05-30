package trutsin.dev.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import trutsin.dev.Element;
import trutsin.dev.OperationWithElement;
import trutsin.dev.WorkWithFile;

import java.util.ArrayList;
import java.util.Map;

public class GraphicFVCh {

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
//            Element newElement = operation.transformation_FNCh_In_FVCh(element);
//            Map<Double, Double> findAChH =
//                    operation.getAChHOfElementByAllFrequencies(newElement, operation.getFrequencies());
//            for (Map.Entry entry : findAChH.entrySet()) {
//                String finalX = String.format("%.2f" ,entry.getKey());
//                series.getData().add(new XYChart.Data(finalX, entry.getValue()));
//            }

            String path = "C:/Users/user/Desktop/Mathcad diplom/FVCH.txt";
            ArrayList<Double> list = workWithFile.getReadyValues(path);
            for (int i = 0; i < list.size(); i += 2) {
                String finalX = String.format("%.2f" , list.get(i));
                series.getData().add(new XYChart.Data(finalX, list.get(i + 1)));
            }

            chart.getData().addAll(series);
        });
    }

}
