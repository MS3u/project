package controls;

import entities.Storage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class cStorage implements Initializable {


    @FXML
    public TableColumn<Storage, String> colCeN;

    @FXML
    public TableColumn<Storage, String> colCenB;

    @FXML
    public TableColumn<Storage, String> colStan;

    @FXML
    public TableColumn<Storage, String> colId;

    @FXML
    public TableColumn<Storage, String> colNazwa;

    @FXML
    private TextField tfNazwa;

    @FXML
    private TextField tfStan;

    @FXML
    private TextField tfCenaN;

    @FXML
    private TextField tfCenaB;


    @FXML
    private TableView<Storage> table;


    public MethodController methodController = new MethodController();
    public ObservableList<Storage> ObservableListItems;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        loadDataToTable(null);
        refreshItemsList();

    }


    @FXML
    private void loadDataToTable(ActionEvent event) {
        Transaction transaction = methodController.session.beginTransaction();
        List items = methodController.session.createCriteria(Storage.class).list();
        transaction.commit();
        colId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNazwa.setCellValueFactory(new PropertyValueFactory<>("Nazwa"));
        colCeN.setCellValueFactory(new PropertyValueFactory<>("CenaNetto"));
        colCenB.setCellValueFactory(new PropertyValueFactory<>("CenaBrutto"));
        colStan.setCellValueFactory(new PropertyValueFactory<>("Stan"));
        table.setItems(ObservableListItems);
        ObservableList itemlist = FXCollections.observableArrayList(items);
        table.setItems(itemlist);


    }

    @FXML
    private void refreshItemsList() {
        Transaction transaction = methodController.session.beginTransaction();
        List items = methodController.session.createCriteria(Storage.class).list();
        transaction.commit();
        ObservableList itemlist = FXCollections.observableArrayList(items);
        table.setItems(itemlist);
        table.refresh();
    }


    /**
     * @param event
     */
    public void addItem(javafx.event.ActionEvent event) {



        try{
            String nazwa = tfNazwa.getText();
            float cenN = Float.parseFloat(tfCenaN.getText());
            float cenaB = Float.parseFloat(tfCenaB.getText());
            int stan = Integer.parseInt(tfStan.getText());
            Storage storage = new Storage(nazwa, cenN, cenaB, stan);
            methodController.saveData(storage);
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Look, an Information Dialog");
            alert.setContentText("I have a great message for you!");

            alert.showAndWait();
        }



        clearItemForm();
        refreshItemsList();

    }

    public void clearItemForm() {
        tfNazwa.clear();
        tfCenaN.clear();
        tfCenaB.clear();
        tfStan.clear();
    }

//    public void tableClick(MouseEvent mouseEvent) {
//       Storage clicked = table.getSelectionModel().getSelectedItem();
//            String cenaB = String.valueOf(clicked.getCenaBrutto());
//        String cenaN = String.valueOf(clicked.getCenaNetto());
//        String stan = String.valueOf(clicked.getStan());
//
//            tfNazwa.setText(clicked.getNazwa());
//            tfCenaB.setText(cenaB);
//            tfCenaN.setText(cenaN);
//            tfStan.setText(stan);
//
//    }


    public void changeItem(javafx.event.ActionEvent event) {


        String nazwa = tfNazwa.getText();
        float cenaN = Float.parseFloat(tfCenaN.getText());
        float cenaB = Float.parseFloat(tfCenaB.getText());
        int stan = Integer.parseInt(tfStan.getText());
        int id = table.getSelectionModel().getSelectedItem().getId();

        Storage updateStorage = new Storage(id, nazwa, cenaN, cenaB, stan);
        methodController.update(updateStorage);
        refreshItemsList();
        clearItemForm();


    }

    public void deleteItem(javafx.event.ActionEvent event) {
        Storage storage = table.getSelectionModel().getSelectedItem();
        methodController.deleteFromDb(storage);
        clearItemForm();
        refreshItemsList();
    }
}
