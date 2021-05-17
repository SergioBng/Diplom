package trutsin.dev.fx.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;

public class Graphic {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
        createButton.setOnAction(e -> {
                    //creating the chart
                    //defining a series
                    XYChart.Series series = new XYChart.Series();
                    series.setName("АЧХ");
                    //populating the series with data
                    series.getData().add(new XYChart.Data("1", 23));
                    series.getData().add(new XYChart.Data("2", 14));
                    series.getData().add(new XYChart.Data("3", 15));
                    series.getData().add(new XYChart.Data("4", 24));

                    chart.getData().addAll(series);
        });

    }
}

