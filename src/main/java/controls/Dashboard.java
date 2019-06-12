package controls;

import MavenHibernate.Main;
import entities.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Dashboard implements Initializable {
    @FXML
    Label lblZalogowany;
    @FXML private javafx.scene.control.Button btnWyloguj;

    @FXML
    private MethodController methodController = new MethodController();
    private List<Users> users;

    public BorderPane borderPane;
    private Object Users;

    public void openZlecenia(ActionEvent event) throws IOException {
        Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/orders.fxml"));
        borderPane.setCenter(noweOkno);
    }

    public void openSerwis(ActionEvent event) throws IOException {
        Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/serwis.fxml"));
        borderPane.setCenter(noweOkno);
    }

    public void wyloguj (ActionEvent event) throws IOException {
        Stage stage = (Stage) btnWyloguj.getScene().getWindow();
        // do what you have to do
        stage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../MavenHibernate/main.fxml"));


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("System");
        stage.show();
    }

    public void openFaktury(ActionEvent event) {
    }
    public void openAdministracja(ActionEvent event) throws IOException {

        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter your name:");

// Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            Users userAuth = new Users(result.get());

            List<Users> serAuth = users.stream()
                    .filter(u -> u.getStanowisko().equals(userAuth.getStanowisko()))
                    .collect(Collectors.toList());
            if (!serAuth.isEmpty()) {
                Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/administration.fxml"));
                borderPane.setCenter(noweOkno);
            }else {
                Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/info.fxml"));
                borderPane.setCenter(noweOkno);
            }

        }
    }

        public void openMagazyn (ActionEvent event) throws IOException {
            Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/storage.fxml"));
            borderPane.setCenter(noweOkno);
        }


        @Override
        public void initialize (URL location, ResourceBundle resources){
            methodController.initDb();
            users = methodController.getUsers();
        }
    }
