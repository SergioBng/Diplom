package trutsin.dev.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import trutsin.dev.WorkWithFile;

import java.util.ArrayList;

public class GraphicZF {

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

            WorkWithFile workWithFile = new WorkWithFile();
            String path = "C:/Users/user/Desktop/Mathcad diplom/ZF.txt";
            ArrayList<Double> list = workWithFile.getReadyValues(path);
            for (int i = 0; i < list.size(); i += 2) {
                String finalX = String.format("%.2f" , list.get(i));
                series.getData().add(new XYChart.Data(finalX, list.get(i + 1)));
            }

            chart.getData().addAll(series);
        });
    }
}

