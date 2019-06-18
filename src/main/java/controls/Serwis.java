package controls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Transaction;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import entities.Orders;


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
    public Button btnClear;
    @FXML
    public Button btnEdit;
    @FXML
    public Label lblOpis;


    @FXML
    private void loadDataToTable(ActionEvent event) {
        PropertyValueFactory temp ;
        Transaction transaction = methodController.session.beginTransaction();
        List orders = methodController.session.createCriteria(Orders.class).list();

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

        tSerwisant.setCellValueFactory(new PropertyValueFactory<>("Serwisant"));

        tableOrders.setItems(ObservableListItems);
        ObservableList orderList = FXCollections.observableArrayList(orders);
        tableOrders.setItems(orderList);

        transaction.commit();
    }



    public void setLblOpis(javafx.scene.input.MouseEvent mouseEvent){
       Orders orders = tableOrders.getSelectionModel().getSelectedItem();
       lblOpis.setText(orders.getOpis());

    }

    private MethodController methodController = new MethodController();
    public ObservableList<Orders> ObservableListItems;



    @FXML
    private void refreshItemsList() {
        Transaction transaction = methodController.session.beginTransaction();
        List orders = methodController.session.createCriteria(Orders.class).list();
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






    public void update(javafx.event.ActionEvent event){
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

        //methodController.update(updateOrders);
        refreshItemsList();
    }

    public void editOrder(javafx.event.ActionEvent event) {

        if(btnEdit.getText().equals("Edycja Zlecenia")) {

            btnEdit.setText("Zapisz");

            Orders orders = tableOrders.getSelectionModel().getSelectedItem();
            tfNrZlecenia.setText(orders.getNrZlecenia());
            dataPrzyjecia.setText(orders.getDataPrzyjecia());
            tfImie.setText(orders.getImie());
            tfNazwisko.setText(orders.getNazwisko());
            tfNip.setText(orders.getNip());
            tfMiasto.setText(orders.getMiasto());
            tfUlica.setText(orders.getUlica());
            tfNrDomu.setText(orders.getNrDomu());
            tfNrLokalu.setText(orders.getNrLokalu());
            tfOpis.setText(orders.getOpis());
            tfSerwisant.setText(orders.getSerwisant());
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
            String serwisantText = "aaa";
            int id = tableOrders.getSelectionModel().getSelectedItem().getId();
            methodController.updateOder(id, dataPrzyjeciaText, nrZleceniaText,
                    imieText, nazwiskoTextskoT, miastoTexttoT, ulicaTextcaT, nrDomuText, nrLokauText, nipText, serwisantText, opiStext);

            // methodController.update(updateOrders);
            refreshItemsList();
        }
    }


    public void tableClick(javafx.scene.input.MouseEvent mouseEvent) {

            Orders clicked = tableOrders.getSelectionModel().getSelectedItem();
            setLblOpis(mouseEvent);

    }
}

