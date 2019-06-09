package controls;

import entities.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;



import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Login implements Initializable {
    @FXML
    private MethodController methodController = new MethodController();
    private List<Users> users;
    @FXML
    public TextField tfUser;

    @FXML
    public PasswordField pfPassword;

    boolean b=false;

    String stanowisko = "";
    String magazyn = "[magazyn]";
    String zlecenia = "[zlecenia]";
    String admin = "[admin]";
    String ksiegowa = "[ksiegowa]";
    String upr = "";


    public void login(ActionEvent event) throws IOException {

        Users userAuth = new Users(tfUser.getText(), pfPassword.getText()) ;

        List<Users> serAuth = users.stream()
                .filter(u -> u.getNazwisko().equals(userAuth.getNazwisko()))
                .filter(u -> u.getHaslo().equals(userAuth.getHaslo()))

                .collect(Collectors.toList());


        if (!serAuth.isEmpty()) {
            b = true;
            stanowisko = methodController.getStanowisko(tfUser.getText(), pfPassword.getText());
            System.out.println(stanowisko);
            log(b, event);
        }

    }


    public void log(boolean b, ActionEvent event ) {
        if (b) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource(uprawnienia(stanowisko).toString()));
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else alert();
    }



    public String uprawnienia(String stanowisko) {

        if (stanowisko.equals(magazyn)) upr = "../fxml/storage.fxml";
        else if (stanowisko.equals(zlecenia)) upr = "../fxml/orders.fxml";
        else if (stanowisko.equals(admin)) upr = "../fxml/dashboard.fxml";
        else if (stanowisko.equals(ksiegowa)) upr = "../fxml/fVat.fxml";
        else upr = "../MavenHibernate/Main.fxml";

        return upr;
    }

    public void alert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Zobacz co źle zrobiłeś");
        alert.setContentText("Złe dane logowania");
        alert.showAndWait();
    }

    public void register(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/registration.fxml"));
        Scene scene = new Scene(pane);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        users = methodController.getUsers();
    }
}

