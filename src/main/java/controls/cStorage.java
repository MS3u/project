package controls;

import entities.Magazyn;
import entities.Zlecenie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Klasa odpowiedzialna za magazyn
 */

public class cStorage implements Initializable {

    @FXML
    public TableColumn<Magazyn, String> colId;
    @FXML
    public TableColumn<Magazyn, String> colNazwa;

    @FXML
    public TableColumn<Magazyn, String> colCena;

    @FXML
    public TableColumn<Magazyn, String> colStan;
    @FXML
    private TextField tfNazwa;

    @FXML
    private TextField tfStan;

    @FXML
    private TextField tfCena;


    @FXML
    private TableView<Magazyn> table;


    public MethodController methodController = new MethodController();
    public ObservableList<Magazyn> ObservableListItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
       loadDataToTable(null);
        refreshItemsList();

    }

    /**
     * Metoda wyslwietla dane z bazy w tabeli
     */
   @FXML
    private void loadDataToTable(ActionEvent event) {
        Transaction transaction = methodController.session.beginTransaction();
        List items = methodController.session.createCriteria(Magazyn.class).list();
        transaction.commit();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        colCena.setCellValueFactory(new PropertyValueFactory<>("cena"));
        colStan.setCellValueFactory(new PropertyValueFactory<>("stan"));
        table.setItems(ObservableListItems);
        ObservableList itemlist = FXCollections.observableArrayList(items);
        table.setItems(itemlist);
    }
    /**
     * odwieze liste z bazy danych
     */
    @FXML
    private void refreshItemsList() {
        Transaction transaction = methodController.session.beginTransaction();
        List items = methodController.session.createCriteria(Magazyn.class).list();
        transaction.commit();
        ObservableList itemlist = FXCollections.observableArrayList(items);
        table.setItems(itemlist);
        table.refresh();
    }


    /**
     * Dodawnie nowego towaru do magazynu
     * @param event
     *
     */
    public void addItem(javafx.event.ActionEvent event) {
        try{
            String nazwa = tfNazwa.getText();
            String stan = tfStan.getText();
            int intStan = Integer.parseInt(stan);

          Magazyn storage = new Magazyn(nazwa, intStan);
           methodController.saveData(storage);
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Zobacz co źle zrobileś");
            alert.setContentText("Nieprawidłowy format wprowadzonych wartości");

            alert.showAndWait();
        }



        clearItemForm();
        refreshItemsList();

    }

    /**
     * Czyszczenie pol tekstowych formularza
     */
    public void clearItemForm() {
        tfNazwa.clear();
        tfCena.clear();
        tfStan.clear();
    }

    /**
     * Modifikacja zawartosci magazyny
     * @param event
     */
    public void changeItem(javafx.event.ActionEvent event) {


        String nazwa = tfNazwa.getText();
      //  float cenaN = Float.parseFloat(tfCena.getText());
        int stan = Integer.parseInt(tfStan.getText());
      int id = table.getSelectionModel().getSelectedItem().getId();

       Magazyn updateStorage = new Magazyn(id, nazwa,stan);
        methodController.update(updateStorage);
        refreshItemsList();
        clearItemForm();


    }

    /* *
     * Usuwanie przedmiotu z bazy
     */


    
    public void deleteItem(javafx.event.ActionEvent event) {
       Magazyn magazyn = table.getSelectionModel().getSelectedItem();
      methodController.deleteFromDb(magazyn);
        clearItemForm();
        refreshItemsList();
    }

public void editMagazin(){
    Magazyn clicked = table.getSelectionModel().getSelectedItem();
    tfNazwa.setText(clicked.getNazwa());
    tfStan.setText((Integer.toString( clicked.getStan())));
}
    public void tableClick(MouseEvent mouseEvent) {
    }
}
