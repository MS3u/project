package controls;

import entities.Magazyn;
import entities.Serwis;
import entities.Users;
import entities.Zlecenie;
import javafx.beans.property.SimpleStringProperty;
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
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class cSerwis implements Initializable {
    @FXML
    public Label lblOpis;
    @FXML
    public ComboBox<Magazyn> cBox1;
    @FXML
    public TextField tfNr;
    @FXML
    public TextField tfStatus;
    @FXML
    public ComboBox statusBox;
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
    @FXML
    public TableView<Zlecenie> tableOrders;
    public ObservableList<Zlecenie> ObservableListItems;
    MethodController methodController = new MethodController();
    @FXML
    private TableColumn<Serwis, String> tSerwisant;
    @FXML
    private TableColumn<Serwis, String> tNrZlecenia;
    @FXML
    private TableColumn<Serwis, String> tStatus;
    @FXML
    private TableColumn<Serwis, String> tPodzespoly;
    @FXML
    private TableView<Serwis> serwisTable;
    @FXML
    private ComboBox<String> edytujStatus;
    private Object magazyn;
    private Object zlecenie;
    private int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        zaladujDaneDoTabeliSerwisu();
        refreshMagazyn();
        loadDataToTable();
        edytujStatus.getItems().addAll("W realizacji" , "Zakończone");
    }

    private void refreshMagazyn() {
        List<Magazyn> magazyn = methodController.getAllMagazyn();
        ObservableList<Magazyn> magazynObservableList = FXCollections.observableArrayList(magazyn);
        cBox1.setItems(magazynObservableList);
    }

    public void editStatus(ActionEvent event) {
    }

    public void tableSerwisClicked(MouseEvent mouseEvent) {
    }

    public void zaladujDaneDoTabeliSerwisu() {
        Transaction transaction = methodController.session.beginTransaction();
        List<Serwis> serwis = methodController.getAllSerwis();
        transaction.commit();


        tSerwisant.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Serwis, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Serwis, String> param) {
                String readerLogin = param.getValue().getUsers().getNazwisko();
                return new SimpleStringProperty(readerLogin);
            }
        });

        tNrZlecenia.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Serwis, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Serwis, String> param) {
                String readerLogin = String.valueOf(param.getValue().getZlecenie_id());
                return new SimpleStringProperty(readerLogin);
            }
        });

        tStatus.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Serwis, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Serwis, String> param) {
                String readerLogin = param.getValue().getStatus();
                return new SimpleStringProperty(readerLogin);
            }
        });

        tPodzespoly.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Serwis, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Serwis, String> param) {
                String readerLogin = param.getValue().getMagazyn().getNazwa();
                return new SimpleStringProperty(readerLogin);
            }
        });

        ObservableList serwisList = FXCollections.observableArrayList(serwis);
        serwisTable.setItems(serwisList);
    }

    /**
     * @param event
     */
    public void addStatus(ActionEvent event) {
        Magazyn magazyn = cBox1.getSelectionModel().getSelectedItem();

        int id = tableOrders.getSelectionModel().getSelectedItem().getId();

        Users users1 = zalogowanyUzytkownik();


        Serwis serwis = new Serwis(magazyn, "Nie rozpoczęte", id, users1);

        int stan = magazyn.getStan();
        methodController.saveData(serwis);
        int result = stan - 1;
        magazyn.setStan(result);
        Transaction transaction = methodController.session.beginTransaction();
        methodController.session.merge(magazyn);
        transaction.commit();

    }

    private Users zalogowanyUzytkownik() {
        List<Users> users = methodController.getUsers();

        List<Users> collect = users.stream()
                .filter(users1 -> users1.getId() == Login.id)
                .collect(Collectors.toList());

        return collect.get(0);
    }

    @FXML
    private void loadDataToTable() {
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

    @FXML
    private void edytujSerwis(ActionEvent event){
        Serwis serwis = serwisTable.getSelectionModel().getSelectedItem();
        String selectedItem = edytujStatus.getSelectionModel().getSelectedItem();
        Magazyn magazyn = cBox1.getSelectionModel().getSelectedItem();
        serwis.setStatus(selectedItem);
        serwis.setMagazyn(magazyn);
        Transaction transaction = methodController.session.beginTransaction();
        methodController.session.merge(serwis);
        transaction.commit();

    }
}

