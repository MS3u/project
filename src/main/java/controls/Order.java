package controls;

import entities.Orders;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import java.net.URL;
import java.util.ResourceBundle;

public class Order<field> implements Initializable {

    private MethodController methodController = new MethodController();

@FXML

public TextField dataPrzyjecia;

    @FXML
    public TextField tfImie;

    @FXML
    public TextField tfNip;

    @FXML
    public TextField tfNazwisko;

    @FXML
    public TextField tfNrLokalu;

    @FXML
    public TextField tfMiasto;

    @FXML
    public TextArea tfOpis;

    @FXML
    public TextField tfNrZlecenia;

    @FXML
    public TextField tfNrDomu;

    @FXML
    public TextField tfUlica;
    @FXML
    public Button addOrder;


    public void addOrder() {

        Orders order = new Orders(
                dataPrzyjecia.getText(),
                tfImie.getText(),
                tfNazwisko.getText(),
                tfMiasto.getText(),
                tfNrDomu.getText(),
                tfNrLokalu.getText(),
                tfOpis.getText(),
                tfNrZlecenia.getText(),
                tfUlica.getText(),
                tfNip.getText());
        if (dataPrzyjecia.getText().trim().isEmpty()
        ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Prosze wypełnic wszystkie okna");

            alert.showAndWait();


    }else {
            methodController.saveData(order);
            clearData();
        }
    }







public void clearData(){
    dataPrzyjecia.clear();
            tfImie.clear();
            tfNazwisko.clear();
            tfMiasto.clear();
            tfNrDomu.clear();
            tfNrLokalu.clear();
            tfOpis.clear();
            tfNrZlecenia.clear();
            tfUlica.clear();
            tfNip.clear();
}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();

    }
}
