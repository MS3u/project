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
import javafx.stage.Stage;
import org.hibernate.Transaction;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import entities.Orders;

/**
 * Klasa obslugjaca zlecenia
 */


public class Order implements Initializable {

    @FXML
    public TableColumn<Zlecenie, String> tNr;
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
   // @FXML
   // public TableColumn<Orders, String> tSerwisant;
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
    public TextField tfNrZlecenia;
    @FXML
    public Button addOrder;
    @FXML
    public Button btnClear;
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
        tNr.setCellValueFactory(new PropertyValueFactory<>("nr"));
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

    private MethodController methodController = new MethodController();
    public ObservableList<Zlecenie> ObservableListItems;

    /**
     * Dodawanie zlecenia
     */
    public void addOrder() {
        String dataPrzyjeciaText = dataPrzyjecia.getText();
        String nrZleceniaText = tfNrZlecenia.getText();
        String imieText = tfImie.getText();
        String nazwiskoTextskoT = tfNazwisko.getText();
        String peselText = tfPesel.getText();
        String telefonText = tfTelefon.getText();
        String opisText = tfOpis.getText();

Zlecenie user= new Zlecenie(nrZleceniaText, imieText, nazwiskoTextskoT, peselText, telefonText, opisText, dataPrzyjeciaText);

        methodController.saveData(user);
        clearData();
        refreshItemsList();

    }
    @FXML
    private void clearData() {
        dataPrzyjecia.clear();
        tfImie.clear();
        tfNazwisko.clear();
        tfOpis.clear();
        tfNrZlecenia.clear();
        tfPesel.clear();
        tfTelefon.clear();
       // tfSerwisant.clear();
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


//    public void clearData(javafx.event.ActionEvent event) {
//        dataPrzyjecia.clear();
//        tfImie.clear();
//        tfNazwisko.clear();
//        tfMiasto.clear();
//        tfNrDomu.clear();
//        tfNrLokalu.clear();
//        tfOpis.clear();
//        tfNrZlecenia.clear();
//        tfUlica.clear();
//        tfNip.clear();
//        tfSerwisant.clear();
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        loadDataToTable(null);
        refreshItemsList();


    }


  @FXML
   public void tableClick(MouseEvent mouseEvent) {
   //    Orders clicked = tableOrders.getSelectionModel().getSelectedItem();
   //   tfNrZlecenia.setText(clicked.getNrZlecenia());
    //  dataPrzyjecia.setText(clicked.getDataPrzyjecia());
//        tfImie.setText(clicked.getImie());
//        tfNazwisko.setText(clicked.getNazwisko());
//        tfNip.setText(clicked.getNip());
//        tfMiasto.setText(clicked.getMiasto());
//        tfUlica.setText(clicked.getUlica());
//        tfNrDomu.setText(clicked.getNrDomu());
//        tfNrLokalu.setText(clicked.getNrLokalu());
//        tfOpis.setText(clicked.getOpis());
//        tfSerwisant.setText(clicked.getSerwisant());
//    }
//    @FXML
//    public void tableClick(javafx.event.ActionEvent event) {
//        editOrder(event);
   }

    /**
     * usuwanie zlecenia
     * @param event
     */
    public void deleteOrder(javafx.event.ActionEvent event) {
        Zlecenie user = tableOrders.getSelectionModel().getSelectedItem();
        //methodController.deleteFromDb(orders);
        clearData();
        refreshItemsList();
    }


    /**
     * edycja zlecenia
     * @param event
     */
  /**  public void editOrder(javafx.event.ActionEvent event) {

        if(btnEdit.getText().equals("Edycja Zlecenia")) {

            btnEdit.setText("Zapisz");

            User orders = tableOrders.getSelectionModel().getSelectedItem();
            tfNrZlecenia.setText(orders.());
            dataPrzyjecia.setText(orders.ge());
            tfImie.setText(orders.getImie());
            tfNazwisko.setText(orders.getNazwisko());
            tfNip.setText(orders.getNip());
            tfMiasto.setText(orders.getMiasto());
            tfUlica.setText(orders.getUlica());
            tfNrDomu.setText(orders.getNrDomu());
            tfNrLokalu.setText(orders.getNrLokalu());
            tfOpis.setText(orders.getOpis());
            refreshItemsList();
//            tfSerwisant.setText(orders.getSerwisant());
        }else {
            btnEdit.setText("Edycja Zlecenia");

            String dataPrzyjeciaText = dataPrzyjecia.getText();
            String nrZleceniaText = tfNrZlecenia.getText();
            String imieText = tfImie.getText();
            String nazwiskoTextskoT = tfNazwisko.getText();
            String nipText = tfNip.getText();
            String miastoTexttoT = tfMiasto.getText();
            String ulicaTextcaT = tfUlica.getText();
            String nrDomuText = tfNrDomu.getText();
            String nrLokauText = tfNrLokalu.getText();
            String opiStext = tfOpis.getText();
            String serwisantText = "";
            int id = tableOrders.getSelectionModel().getSelectedItem().getId();
            methodController.updateOder(id, dataPrzyjeciaText, nrZleceniaText,
                    imieText, nazwiskoTextskoT, miastoTexttoT, ulicaTextcaT, nrDomuText, nrLokauText, nipText, serwisantText, opiStext);

           // methodController.update(updateOrders);
            refreshItemsList();
        }
    }*/

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

    public void clear(javafx.event.ActionEvent event) {
        clearData();
    }

    public void editOrder(javafx.event.ActionEvent event) {
    }
}

