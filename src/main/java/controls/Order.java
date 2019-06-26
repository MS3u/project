package controls;

import PDF.GeneratePdf;
import com.itextpdf.text.DocumentException;
import entities.Zlecenie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.hibernate.Transaction;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Klasa obslugjaca zlecenia
 */


public class Order implements Initializable {

    @FXML
    public TableColumn<Zlecenie, String> tImie;
    @FXML
    public TableColumn<Zlecenie, String> tNazwisko;
    @FXML
    public TableColumn<Zlecenie, String> tPesel;
    @FXML
    public TableColumn<Zlecenie, String> tTelefon;
    @FXML
    public TableColumn<Zlecenie, String> tOpis;
    @FXML
    public TableColumn<Zlecenie, String> tData;
    @FXML
    public TableColumn<Zlecenie, String> tId;
    @FXML
    public TableView<Zlecenie> tableOrders;
    @FXML
    public TextField dataPrzyjecia;
    @FXML
    public TextField tfImie;
    @FXML
    public TextField tfNazwisko;
    @FXML
    public TextField tfPesel;
    @FXML
    public TextField tfTelefon;
    @FXML
    public TextField tfOpis;
    @FXML
    public Button addOrder;
    @FXML
    public Button btnEdit;
    public Button btnDeleteOrder;
    private Stage stage;

    /**
     * Ladownie danych do tabeli
     * @param event
     */
    @FXML
    private void loadDataToTable(ActionEvent event) {
        Transaction transaction = methodController.session.beginTransaction();
        List user = methodController.session.createCriteria(Zlecenie.class).list();
        transaction.commit();

      tId.setCellValueFactory(new PropertyValueFactory<>("id"));

        tImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        tNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        tPesel.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        tTelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        tOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableOrders.setItems(ObservableListItems);
        ObservableList orderList = FXCollections.observableArrayList(user);
        tableOrders.setItems(orderList);


    }

    /**
     * methodController obsluguje czynnosci zwiazaen z obsluga bazy danych
     */
    private MethodController methodController = new MethodController();
    public ObservableList<Zlecenie> ObservableListItems;

    /**
     * Dodawanie zlecenia
     */
    public void addOrder() {
        String dataPrzyjeciaText = dataPrzyjecia.getText();
        String imieText = tfImie.getText();
        String nazwiskoTextskoT = tfNazwisko.getText();
        String peselText = tfPesel.getText();
        String telefonText = tfTelefon.getText();
        String opisText = tfOpis.getText();

Zlecenie user= new Zlecenie(dataPrzyjeciaText, imieText, nazwiskoTextskoT, peselText, telefonText, opisText);

        methodController.saveData(user);
        clearData();
        refreshItemsList();

    }

    /**
     * metoda do usuwania warosci z pol tekstowych
     */
    @FXML
    private void clearData() {
        dataPrzyjecia.clear();
        tfImie.clear();
        tfNazwisko.clear();
        tfOpis.clear();
        tfPesel.clear();
        tfTelefon.clear();
    }

    /**
     * odswiezanie tabeli
     */
    @FXML
    private void refreshItemsList() {
        Transaction transaction = methodController.session.beginTransaction();
        List orders = methodController.session.createCriteria(Zlecenie.class).list();
        transaction.commit();

        ObservableList orderList = FXCollections.observableArrayList(orders);
        tableOrders.setItems(orderList);
        tableOrders.refresh();

    }


    /**
     * Inicjalizacja bazy danych oraz metod obslugujacych zawarosci tabel - odświeżanie danych
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        loadDataToTable(null);
        refreshItemsList();



    }

    /**
     * zwraca wartosci z tabeli do pol teksotywch
     * @param event
     */
   public void addToTextField(javafx.event.ActionEvent event) {
        Zlecenie clicked = tableOrders.getSelectionModel().getSelectedItem();
        dataPrzyjecia.setText(clicked.getData());
        tfImie.setText(clicked.getImie());
        tfNazwisko.setText(clicked.getNazwisko());
        tfOpis.setText(clicked.getOpis());
        tfTelefon.setText(clicked.getTelefon());
        tfPesel.setText(clicked.getPesel());
    }

    /**
     * usuwanie zlecenia
     */
    public void deleteOrder() {
        Zlecenie zlecenie = tableOrders.getSelectionModel().getSelectedItem();
        methodController.deleteFromDb(zlecenie);
        clearData();
        refreshItemsList();
    }


    /**
     * edycja zlecenia
     * @param event
     */
  /**  public void editOrder(javafx.event.ActionEvent event) {


    /**
     * generowaenie pdf zlecen
     * @param event
     * @throws FileNotFoundException
     * @throws DocumentException
     * @throws SQLException
     */
    public void generateRaport(javafx.event.ActionEvent event) throws FileNotFoundException, DocumentException, SQLException {

        GeneratePdf generatePdf = new GeneratePdf();
        generatePdf.generateRaport(event, stage);

    }

    /**
     * Edycja zlecenia
     * @param event
     */

    public void editOrder(javafx.event.ActionEvent event) {

        String data = dataPrzyjecia.getText();
        String imie = tfImie.getText();
        String nazwisko = tfNazwisko.getText();
        String pesel = tfPesel.getText();
        String telefon = tfTelefon.getText();
        String opis = tfOpis.getText();
        int id = tableOrders.getSelectionModel().getSelectedItem().getId();

        Zlecenie edycjaZlecenia = new Zlecenie(id,imie,nazwisko,pesel,telefon,opis,data);
        methodController.update(edycjaZlecenia);
        clearData();
        refreshItemsList();

    }


    public void tableClick(MouseEvent mouseEvent) {
    }
}

