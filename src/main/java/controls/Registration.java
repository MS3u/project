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
import java.util.List;
import java.util.ResourceBundle;

public class Registration<field> implements Initializable {


private MethodController methodController = new MethodController();


    @FXML
    public  TextField tfimie;
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



    public void registerUser(ActionEvent event) {
        Users user = new Users(
       tfimie.getText(),
       tfnazwisko.getText(),
       tfstanowisko.getText(),
       tfhaslo.getText());
        methodController.saveData(user);
       clearData();
    }




public void clearData(){
        tfimie.clear();
        tfnazwisko.clear();
        tfstanowisko.clear();
        tfhaslo.clear();

}

    public void initialize(URL location, ResourceBundle resources) {
    methodController.initDb();
    }


    public void backToLogin(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../MavenHibernate/main.fxml"));
        Scene scene = new Scene(pane);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
