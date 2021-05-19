package trutsin.dev.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import trutsin.dev.Element;
import trutsin.dev.OperationWithElement;
import trutsin.dev.WorkWithFile;

import java.util.Map;

public class GraphicPf {
    @FXML
    private Button createButton;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    void createGraphic(ActionEvent event) {
        XYChart.Series series = new XYChart.Series();
        series.setName("АЧХ");

        WorkWithFile workWithFile = new WorkWithFile();
        Element element = workWithFile.setParametersFromFile();
        OperationWithElement operation = new OperationWithElement();
        Element newElement = operation.transformation_FNCh_In_PF(element, 1);
        Map<Double, Double> findAChH =
                operation.getAChHOfElementByAllFrequencies(newElement, operation.getFrequencies());
        for (Map.Entry entry : findAChH.entrySet()) {
            String finalX = String.format("%.2f" ,entry.getKey());
            series.getData().add(new XYChart.Data(finalX, entry.getValue()));
        }

        chart.getData().addAll(series);
    }
}
