package controls;

import entities.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Dashboard implements Initializable {
    @FXML
    private MethodController methodController = new MethodController();
    private List<Users> users;

    public BorderPane borderPane;
    private Object Users;

    public void openZlecenia(ActionEvent event) throws IOException {
                    Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/orders.fxml"));
            borderPane.setCenter(noweOkno);
    }

    public void openFaktury(ActionEvent event) {
    }

    public void openAdministracja(ActionEvent event) throws IOException {

            Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/administration.fxml"));
            borderPane.setCenter(noweOkno);



        }







    public void openMagazyn(ActionEvent event) throws IOException{
        Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/storage.fxml"));
        borderPane.setCenter(noweOkno);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        users = methodController.getUsers();
    }
}
