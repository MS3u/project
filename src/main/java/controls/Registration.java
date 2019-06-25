package controls;

import entities.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Klasa obslugujaca rejestracje nowych uzytkownikow
 */

public class Registration implements Initializable {


    private MethodController methodController = new MethodController();


    @FXML
    public TextField tfimie;
    @FXML
    public TextField tfnazwisko;
    @FXML
    public TextField tfstanowisko;
    @FXML
    public PasswordField tfhaslo;
    @FXML
    public Button btnRegistration;
    @FXML
    public Button btnBack;


    /**
     * rejestracja nowego uzytkownika
     *
     * @param event
     */
    public void registerUser(ActionEvent event) {

        String imie = tfimie.getText();
        String nazwisko = tfnazwisko.getText();
        String stanowisko = tfstanowisko.getText();
        String haslo = methodController.get_SHA_512_SecurePassword(tfhaslo.getText(), "zakodowane");
        Users users = new Users(imie, nazwisko, stanowisko, haslo);
        methodController.saveData(users);
        //clearData();
        System.out.println("zapisano" + tfhaslo + tfstanowisko);
    }

    public void clearData() {
        tfimie.clear();
        tfnazwisko.clear();
        tfstanowisko.clear();
        tfhaslo.clear();

    }

    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        clearData();
    }

    /**
     * powrot do okna logowania
     *
     * @param event
     * @throws IOException
     */
    public void backToLogin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../MavenHibernate/main.fxml"));
        Scene scene = new Scene(pane);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
