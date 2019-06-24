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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Okno glowne logownia
 */
public class Login implements Initializable {
    @FXML
    private MethodController methodController = new MethodController();

    @FXML
    private Dashboard dashboard;

    @FXML
    public TextField tfUser;

    @FXML
    public PasswordField pfPassword;

    boolean b = false;

    public static String stanowisko;
    public static String lbzalogowany;
    private List<Users> users;


    /**
     * Weryfikcja wprowadzonych danych i logowanie do systemu z uwzglednieniem roli uzytkownika
     *
     * @param event
     * @throws IOException
     */
    public void login(ActionEvent event) throws IOException {

        Users userAuth = new Users(tfUser.getText(), methodController.get_SHA_512_SecurePassword(pfPassword.getText().toString(), "zakodowane"));

        List<Users> serAuth = users.stream()
                .filter(u -> u.getNazwisko().equals(userAuth.getNazwisko()))
                .filter(u -> u.getHaslo().equals(userAuth.getHaslo()))
                .collect(Collectors.toList());


        if (!serAuth.isEmpty() && !tfUser.getText().isEmpty() && !pfPassword.getText().isEmpty()) {
            b = true;
            stanowisko = methodController.getStanowisko(tfUser.getText(),
                    methodController.get_SHA_512_SecurePassword(pfPassword.getText().toString(), "zakodowane"));
            String imie = "";
            System.out.println(stanowisko);
            imie = methodController.getRodo(tfUser.getText(), methodController.get_SHA_512_SecurePassword(pfPassword.getText().toString(), "zakodowane"));
            System.out.println("imie: " + imie);
            System.out.println("login: " + tfUser.getText());
            lbzalogowany = (imie + " " + tfUser.getText());
            System.out.println("lblzalogowany: " + lbzalogowany);

            //dashboard.uprawnienia(stanowisko,lbZalogowany);

            System.out.println(stanowisko + "   " + lbzalogowany);
            log(b, event, lbzalogowany);

        } else {
            alert();
        }


    }


    public void log(boolean b, ActionEvent event, String lbZalogowany) {
        if (b) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxml/dashboard.fxml"));
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(new Scene(root));

                //  dashboard.uprawnienia(stanowisko, lbZalogowany);


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else alert();
    }


    public void alert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Zobacz co źle zrobiłeś");
        alert.setContentText("Złe dane logowania");
        alert.showAndWait();
    }

    /**
     * Otwieranie okna rejestracji uzytkownikow
     *
     * @param event
     * @throws IOException
     */
    public void register(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../fxml/registration.fxml"));
        Scene scene = new Scene(pane);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();


    }

    /**
     * Iniciowanie bazy danych, pobieranie uzytkownikow
     *
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        methodController.initDb();
        users = methodController.getUsers();
    }
}

