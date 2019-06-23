package controls;

import entities.Magazyn;
import entities.Orders;
import entities.Zlecenie;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class Serwis implements Initializable {


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
    private void loadToSerwis(javafx.event.ActionEvent event) {
        Transaction transaction = methodController.session.beginTransaction();
        List allOrders = methodController.session.createCriteria(Orders.class).list();
        transaction.commit();

        tNrZlecenia.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Orders, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Orders, String> param) {
                String readerLogin = param.getValue().setSerwisant("Mirek");
                return new SimpleStringProperty(readerLogin);
            }
        });
    }

    private MethodController methodController = new MethodController();


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
        if (!allBookIds.contains(book.getId())) {

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

