package controls;

import entities.Magazyn;
import entities.Orders;
import entities.Zlecenie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Serwis implements Initializable {
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
    public TableColumn<Orders, String> tOpis;

    @FXML
    public TableView<Orders> tableOrders;
    @FXML
    public Label lblOpis;
    @FXML
    public TableView<Orders> serwisTable;
    @FXML
    public TableColumn<Orders, String> tNrZlecenia;
    @FXML
    public TableColumn<Orders, String> tStatus;
    @FXML
    public TableColumn<Orders, String> serwisant;
    @FXML
    public TableColumn<Orders, String> tPodzespoly;
    @FXML
    public ComboBox cBox;
    @FXML
    public ComboBox cBox1;
    @FXML
    public TextField tfNr;
    @FXML
    public TextField tfStatus;
    @FXML
    public ComboBox statusBox;


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
        tMiasto.setCellValueFactory(new PropertyValueFactory<>("miasto"));
        tUlica.setCellValueFactory(new PropertyValueFactory<>("ulica"));
        tnDomu.setCellValueFactory(new PropertyValueFactory<>("nrDomu"));
        tNLokalu.setCellValueFactory(new PropertyValueFactory<>("nrLokalu"));
        tNip.setCellValueFactory(new PropertyValueFactory<>("nip"));
        tOpis.setCellValueFactory(new PropertyValueFactory<>("opis"));
        // tSerwisant.setCellValueFactory(new PropertyValueFactory<>("Serwisant"));


        tableOrders.setItems(ObservableListItems);
        ObservableList orderList = FXCollections.observableArrayList(orders);
        tableOrders.setItems(orderList);


    }

    @FXML
    private void loadToSerwis(ActionEvent event) {


    }




    private MethodController methodController = new MethodController();
    public ObservableList<Orders> ObservableListItems;
    public ObservableList<Orders> serwisObservableList;


    @FXML
    private void refreshItemsList() {
        Transaction transaction = methodController.session.beginTransaction();
        List orders = methodController.session.createCriteria(Orders.class).list();
        List status = methodController.session.createCriteria(Orders.class).list();

        transaction.commit();
        ObservableList serwisList = FXCollections.observableArrayList(status);
        ObservableList orderList = FXCollections.observableArrayList(orders);
        serwisTable.setItems(serwisList);
        serwisTable.refresh();
        tableOrders.setItems(orderList);

        tableOrders.refresh();

    }



      private void clearData() {
        tfStatus.clear();
        tfNr.clear();
      }

    private void refreshUsersComboBox() {
        List<Zlecenie> allUsers = methodController.getAllUsers();
        ObservableList<Zlecenie> users = FXCollections.observableArrayList(allUsers);
        cBox.setItems(users);
    }
    private void refreshBooksComboBox() {
        List<Magazyn> allBooks = methodController.getAllMagazyn();
        ObservableList<Magazyn> books = FXCollections.observableArrayList(allBooks);
        cBox1.setItems(books);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        loadDataToTable(null);
        loadToSerwis(null);
        refreshItemsList();
        refreshUsersComboBox();
        refreshBooksComboBox();
        statusBox.getItems().addAll("Przyjeto", "W trakcie realizcji", "Skończone");
    }


    public void addStatus(javafx.event.ActionEvent event) {
        Zlecenie user = (Zlecenie) cBox.getSelectionModel().getSelectedItem();
        Magazyn book = (Magazyn) cBox1.getSelectionModel().getSelectedItem();
                String z = String.valueOf(statusBox.getSelectionModel().getSelectedItem());

        List<Integer> allBookIds = methodController.getAllBookIds();
        if (allBookIds.contains(book.getId())) {

                Orders orders = new Orders(user, book, z);
                methodController.saveData(orders);
            }

        refreshItemsList();
        clearData();


    }

    public void editStatus(javafx.event.ActionEvent event) {
        String newStatus = tfStatus.getText();
        String newNr = tfNr.getText();
        int id = serwisTable.getSelectionModel().getSelectedItem().getId();
       // eSerwis updateSerwis = new eSerwis(id, newNr, newStatus, newSerwisant);


    //    methodController.update(updateSerwis);
        refreshItemsList();
        clearData();

    }

    public void tableSerwisClicked(MouseEvent mouseEvent) {
       // eSerwis clicked = serwisTable.getSelectionModel().getSelectedItem();
      //  tfNr.setText(clicked.getNrZlecenia());
       // tfStatus.setText(clicked.getStatus());
        //tfSerwisant.setText(clicked.getSerwisant());
    }

    public void tableClick(MouseEvent mouseEvent) {
    }
}

