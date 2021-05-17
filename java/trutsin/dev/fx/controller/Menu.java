package trutsin.dev.fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Menu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button makeDenormirovanieButton;

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private Button findAChHButton;

    @FXML
    private Button transformFNChInFVChButton;

    @FXML
    private Button transformFNChInPfButton;

    @FXML
    private Button transformFNChInZfButton;

    @FXML
    void findAChH(javafx.event.ActionEvent actionEvent) {
        findAChHButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../view/graphicFNCh.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
    }


    public void transformFNChInFVCh(ActionEvent actionEvent) {

    }


    public void transformFNChInPf(ActionEvent actionEvent) {

    }

    public void transformFNChInZf(ActionEvent actionEvent) {

    }
}
