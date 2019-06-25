package controls;

import entities.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


/**
 * Panel do administracji uzytkownikami
 */
public class AdminPanel implements Initializable {
    @FXML
    private TextField tfNazwisko;
    @FXML
    private TextField tfStanowisko;
    @FXML
    private TextField tfHaslo;
    @FXML
    private TextField tfImie;

    @FXML
    private TableColumn<Users, String> tImie;

    @FXML
    private TableColumn<Users, String> tStanowisko;

    @FXML
    private TableColumn<Users, String> tNazwisko;

    @FXML
    private TableView<Users> tableUsers;

    @FXML
    private TableColumn<Users, String> tId;

    @FXML
    private TableColumn<Users, String> tHaslo;

    public MethodController methodController = new MethodController();

    /**
     * Metoda wyslwietla dane z bazy w tabeli
     * @param event
     */
    private void loadDataToTable(ActionEvent event) {
        Transaction transaction = methodController.session.beginTransaction();
        List items = methodController.session.createCriteria(Users.class).list();
        transaction.commit();
        tImie.setCellValueFactory(new PropertyValueFactory<>("Imie"));
        tId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tNazwisko.setCellValueFactory(new PropertyValueFactory<>("Nazwisko"));
        tStanowisko.setCellValueFactory(new PropertyValueFactory<>("Stanowisko"));
        tHaslo.setCellValueFactory(new PropertyValueFactory<>("Haslo"));
        ObservableList itemlist = FXCollections.observableArrayList(items);
        tableUsers.setItems(itemlist);
    }

    /**
     * Dodawanie nowego uzytkownika
     */
    public void addUser(javafx.event.ActionEvent event) {
        Users user = new Users(
                tfImie.getText(),
               methodController.get_SHA_512_SecurePassword(  tfNazwisko.getText(),"zakodowane"),
                tfHaslo.getText(),
                tfStanowisko.getText());

        methodController.saveData(user);
        refreshItemsList();
        clear();

    }
    /**
     * Usuwanie uzytkownika
     */
    public void deleteUser(ActionEvent event) {
        Users storage = tableUsers.getSelectionModel().getSelectedItem();
        methodController.deleteFromDb(storage);
        refreshItemsList();
        clear();
    }
    /**
     *  Edycja uzytkownika
     */
    public void editUser(ActionEvent event) {
        int id = tableUsers.getSelectionModel().getSelectedItem().getId();
        String imie = tfImie.getText();
        String nazwisko = tfNazwisko.getText();
        String stanowisko = tfStanowisko.getText();
        String haslo = methodController.get_SHA_512_SecurePassword(tfHaslo.getText(),"zakodowane");
        Users updateUser = new Users(id, imie, nazwisko, stanowisko, haslo);
        methodController.update(updateUser);
        refreshItemsList();
    }
    /**
     * Czyszczenie pol textowych formularza
     */
    public void clear() {
        tfStanowisko.clear();
        tfNazwisko.clear();
        tfImie.clear();
        tfHaslo.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        loadDataToTable(null);

    }
    /**
     *  Wyswietlenie konkretnego wiersza tabeli po kliknieciu muszki
     */
    public void tableClick(MouseEvent mouseEvent) {

        Users clicked = tableUsers.getSelectionModel().getSelectedItem();
        tfImie.setText(clicked.getImie());
        tfNazwisko.setText(clicked.getNazwisko());
        tfStanowisko.setText(clicked.getStanowisko());
      tfHaslo.setText(clicked.getHaslo());
    }

    /**
     *  Odswiezenie zawartosci tabeli po wykonaniu konretnej czynnosci
     */
    private void refreshItemsList() {
        Transaction transaction = methodController.session.beginTransaction();
        List userList = methodController.session.createCriteria(Users.class).list();
        transaction.commit();
        ObservableList itemlistUsers = FXCollections.observableArrayList(userList);
        tableUsers.setItems(itemlistUsers);
        tableUsers.refresh();
        clear();
    }

}
