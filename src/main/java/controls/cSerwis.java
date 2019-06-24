package controls;

import entities.Magazyn;
import entities.Zlecenie;
import entities.Serwis;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;


public class cSerwis implements Initializable {
MethodController methodController = new MethodController();

    @FXML
    public Label lblOpis;

    public ComboBox cBox;
    @FXML
    public ComboBox cBox1;
    @FXML
    public TextField tfNr;
    @FXML
    public TextField tfStatus;
    @FXML
    public ComboBox statusBox;
    private Object magazyn;
    private Object zlecenie;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        refreshMagazyn();
        refreshZlecenia();
    }
    private void refreshMagazyn() {
        List<Magazyn> magazyn = methodController.getAllMagazyn();
        ObservableList<Magazyn> magazynObservableList = FXCollections.observableArrayList(magazyn);
        cBox1.setItems(magazynObservableList);
    }

    private void refreshZlecenia() {
        List<Zlecenie> zlecenieList = methodController.getZlecenie();
        ObservableList<Zlecenie> zlecenieObservableList= FXCollections.observableArrayList(zlecenieList);
        cBox.setItems(zlecenieObservableList);
    }



    public void editStatus(ActionEvent event) {
    }

    public void tableSerwisClicked(MouseEvent mouseEvent) {
    }

    /**
     *
     * @param event
     */
    public void addStatus(ActionEvent event) {
        magazyn =cBox.getSelectionModel().getSelectedItem();
        zlecenie = cBox1.getSelectionModel().getSelectedItem();




    }
}

