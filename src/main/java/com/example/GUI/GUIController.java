package com.example.GUI;

import java.net.URL;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

import AbstrTable.AbstrTable;
import Pamatky.Pamatky;
import Zamek.Zamek;
import Enum.enumTypKey;
import Enum.enumTypProhlidky;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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

    static int num = 1;

    Pamatky pamatky = new Pamatky();

    @FXML
    void OnActionImportDatBTN(ActionEvent event) {
        try {
            pamatky.importDatTXT();
            draw();
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(ex.getClass().getName());
            alert.setHeaderText(ex.getLocalizedMessage());

            alert.showAndWait();
        }
    }


    @FXML
    void OnActionNajdiNejblizBTN(ActionEvent event) {

    }

    @FXML
    void OnActionNajdiZamekBTN(ActionEvent event) {

        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setHeaderText("Zadejte klic: ");
        switch (nastavKlicChBox.getValue()) {
            case NAZEV -> {
                Optional<String> result = textInputDialog.showAndWait();
                try {
                    if (pamatky.najdiZamek(result.get())!=null) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Information Dialog");
                        alert.setHeaderText("Prvek dle klice" + result.get());
                        alert.setContentText(pamatky.najdiZamek(result.get()).toString());

                        alert.showAndWait();
                    }
                }catch (Exception ex){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(ex.getClass().getName());
                    alert.setHeaderText(ex.getLocalizedMessage());

                    alert.showAndWait();
                }
            }
        }
        TextField field1 = new TextField();


    }

    @FXML
    void OnActionOdeberZamekBTN(ActionEvent event) {

    }

    @FXML
    void OnActionPrebudujBTN(ActionEvent event) {

    }

    @FXML
    void OnActionVlozZamekBTN(ActionEvent event) {
        pamatky.vlozZamek(new Zamek("1", "zamek1", "123.0, 321.0",123,321));
        draw();
    }

    @FXML
    void OnActionZrusBTN(ActionEvent event) {
        if (pamatky.jePrazdny()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Seznam je prazdny");

            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Opravdu chcete smazat vsechna data?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                pamatky.zrus();
                num = 1;
                draw();
            }
        }
    }

    public void draw() {

        try {

            mainListView.getItems().clear();
            Iterator iterator = pamatky.vytvorIterator(enumTypProhlidky.DEFAULT);

            while (iterator.hasNext()) {
                mainListView.getItems().add((Zamek) iterator.next());
                System.out.println(iterator.next().toString());
            }
        } catch (NullPointerException ex) {
            if (pamatky.jePrazdny()) {
                ex.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle(ex.getClass().getName());
                alert.setHeaderText(ex.getLocalizedMessage());

                alert.showAndWait();
        }}


    }

    @FXML
    void initialize() {
        nastavKlicChBox.getItems().addAll(enumTypKey.values());
    }

}
