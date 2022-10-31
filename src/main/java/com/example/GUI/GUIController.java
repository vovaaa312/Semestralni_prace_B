package com.example.GUI;

import java.net.URL;
import java.util.ResourceBundle;

import Zamek.Zamek;
import Enum.enumTypKey;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

public class GUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button importDatBTN;

    @FXML
    private ListView<Zamek> mainListView;

    @FXML
    private Button najdiNejblizBTN;

    @FXML
    private Button najdiZamekBTN;

    @FXML
    private ChoiceBox<enumTypKey> nastavKlicChBox;

    @FXML
    private Button odeberZamekBTN;

    @FXML
    private Button prebudujBTN;

    @FXML
    private Button vlozZamekBTN;

    @FXML
    private Button zrusBTN;

    @FXML
    void OnActionImportDatBTN(ActionEvent event) {

    }

    @FXML
    void OnActionNajdiNejblizBTN(ActionEvent event) {

    }

    @FXML
    void OnActionNajdiZamekBTN(ActionEvent event) {

    }

    @FXML
    void OnActionOdeberZamekBTN(ActionEvent event) {

    }

    @FXML
    void OnActionPrebudujBTN(ActionEvent event) {

    }

    @FXML
    void OnActionVlozZamekBTN(ActionEvent event) {

    }

    @FXML
    void OnActionZrusBTN(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert importDatBTN != null : "fx:id=\"importDatBTN\" was not injected: check your FXML file 'Main.fxml'.";
        assert mainListView != null : "fx:id=\"mainListView\" was not injected: check your FXML file 'Main.fxml'.";
        assert najdiNejblizBTN != null : "fx:id=\"najdiNejblizBTN\" was not injected: check your FXML file 'Main.fxml'.";
        assert najdiZamekBTN != null : "fx:id=\"najdiZamekBTN\" was not injected: check your FXML file 'Main.fxml'.";
        assert nastavKlicChBox != null : "fx:id=\"nastavKlicChBox\" was not injected: check your FXML file 'Main.fxml'.";
        assert odeberZamekBTN != null : "fx:id=\"odeberZamekBTN\" was not injected: check your FXML file 'Main.fxml'.";
        assert prebudujBTN != null : "fx:id=\"prebudujBTN\" was not injected: check your FXML file 'Main.fxml'.";
        assert vlozZamekBTN != null : "fx:id=\"vlozZamekBTN\" was not injected: check your FXML file 'Main.fxml'.";
        assert zrusBTN != null : "fx:id=\"zrusBTN\" was not injected: check your FXML file 'Main.fxml'.";

    }

}
