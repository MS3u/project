package controls;

import entities.Storage;
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
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import entities.Orders;
import javafx.scene.control.*;


public class Order implements Initializable {
    @FXML
    public TableColumn<Orders, String> id;
    @FXML

    public TableColumn<Orders, String> tNr;
    @FXML
    public TableColumn<Orders, String> tData;
    @FXML
    public TableColumn<Orders, String> tImie;
    @FXML
    public TableColumn<Orders, String> tNazwisko;
    @FXML
    public TableColumn<Orders, String> tNip;
    @FXML
    public TableColumn<Orders, String> tMiasto;
    @FXML
    public TableColumn<Orders, String> tUlica;
    @FXML
    public TableColumn<Orders, String> tnDomu;
    @FXML
    public TableColumn<Orders, String> tNLokalu;
    @FXML
    public TableColumn<Orders, String> tOpis;
    @FXML
    public TableColumn<Orders, String> tSerwisant;
    @FXML
    public TableView<Orders> tableOrders;
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
    public TextField tfOpis;
    @FXML
    public TextField tfNrZlecenia;
    @FXML
    public TextField tfNrDomu;
    @FXML
    public TextField tfUlica;
    @FXML
    public Button addOrder;
    @FXML
    public TextField tfSerwisant;


    @FXML
    private void loadDataToTable(ActionEvent event) {
        Transaction transaction = methodController.session.beginTransaction();
        List orders = methodController.session.createCriteria(Orders.class).list();
        transaction.commit();

        id.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tNr.setCellValueFactory(new PropertyValueFactory<>("nrZlecenia"));
        tData.setCellValueFactory(new PropertyValueFactory<>("dataPrzyjecia"));
        tImie.setCellValueFactory(new PropertyValueFactory<>("imie"));
        tNazwisko.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        tNip.setCellValueFactory(new PropertyValueFactory<>("nip"));
        tMiasto.setCellValueFactory(new PropertyValueFactory<>("miasto"));
        tUlica.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        tnDomu.setCellValueFactory(new PropertyValueFactory<>("nrDomu"));
        tNLokalu.setCellValueFactory(new PropertyValueFactory<>("nrLokalu"));
        tOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        tSerwisant.setCellValueFactory(new PropertyValueFactory<>("Serwisant"));


        tableOrders.setItems(ObservableListItems);
        ObservableList orderList = FXCollections.observableArrayList(orders);
        tableOrders.setItems(orderList);


    }

    private MethodController methodController = new MethodController();
    public ObservableList<Orders> ObservableListItems;

    public void addOrder() {
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
        String serwisantText = tfSerwisant.getText();
        Orders order = new Orders(dataPrzyjeciaText, nrZleceniaText,
                imieText, nazwiskoTextskoT, miastoTexttoT, ulicaTextcaT, nrDomuText, nrLokauText, nipText, serwisantText, opiStext);


        methodController.saveData(order);
        clearData();
        refreshItemsList();

    }

    @FXML
    private void refreshItemsList() {
        Transaction transaction = methodController.session.beginTransaction();
        List orders = methodController.session.createCriteria(Orders.class).list();
        transaction.commit();

        ObservableList orderList = FXCollections.observableArrayList(orders);
        tableOrders.setItems(orderList);
        tableOrders.refresh();

    }


    public void clearData() {
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
        tfSerwisant.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        loadDataToTable(null);
        refreshItemsList();


    }


    @FXML
    public void tableClick(MouseEvent mouseEvent) {
        Orders clicked = tableOrders.getSelectionModel().getSelectedItem();
        tfNrZlecenia.setText(clicked.getNrZlecenia());
        dataPrzyjecia.setText(clicked.getDataPrzyjecia());
        tfImie.setText(clicked.getImie());
        tfNazwisko.setText(clicked.getNazwisko());
        tfNip.setText(clicked.getNip());
        tfMiasto.setText(clicked.getMiasto());
        tfUlica.setText(clicked.getUlica());
        tfNrDomu.setText(clicked.getNrDomu());
        tfNrLokalu.setText(clicked.getNrLokalu());
        tfOpis.setText(clicked.getOpis());
        tfSerwisant.setText(clicked.getSerwisant());
    }


    public void deleteOrder(javafx.event.ActionEvent event) {
        Orders orders = tableOrders.getSelectionModel().getSelectedItem();
        methodController.deleteFromDb(orders);
        clearData();
        refreshItemsList();
    }

    public void editOrder(javafx.event.ActionEvent event) {

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
        String serwisantText = tfSerwisant.getText();
        int id = tableOrders.getSelectionModel().getSelectedItem().getId();
        Orders updateOrders = new Orders(id,dataPrzyjeciaText, nrZleceniaText,
                imieText, nazwiskoTextskoT, miastoTexttoT, ulicaTextcaT, nrDomuText, nrLokauText, nipText, opiStext, serwisantText);

        methodController.update(updateOrders);
        refreshItemsList();
    }


}

