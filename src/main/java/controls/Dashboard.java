package controls;

import entities.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Dashboard implements Initializable {

    @FXML  javafx.scene.control.Button btnWyloguj = new Button();
    @FXML  javafx.scene.control.Button btnZlecenia = new Button();
    @FXML  javafx.scene.control.Button btnFaktury = new Button();
    @FXML  javafx.scene.control.Button btnAdministracja = new Button();
    @FXML  javafx.scene.control.Button btnMagazyn = new Button();
    @FXML  javafx.scene.control.Button btnSerwis = new Button();
    @FXML javafx.scene.text.Text lbZalogowany = new Text();
    @FXML
    private Label labelZalogowany;

    @FXML
    private Login login;

//    @FXML
//    private String strstanowisko ="";
//    @FXML
//    private String strzalogowany ;

    @FXML
    private MethodController methodController = new MethodController();
    private List<Users> users;

    public BorderPane borderPane;
    private Object Users;




//    @FXML
//    public void  uprawnienia(String Stanowisko, String lbZalogowany) {
//
//
//        btnSerwis.setText("test");
//        strstanowisko = Stanowisko;
//        strzalogowany = lbZalogowany;
//        System.out.println("stanowiskoupr:  "+strstanowisko+",   lblzalogowany: "+strzalogowany);
//
//
//    }
    @FXML
    private void uprawnienia(){
        btnSerwis.setDisable(true);
        btnZlecenia.setDisable(true);
        btnAdministracja.setDisable(true);
        btnMagazyn.setDisable(true);
        btnFaktury.setDisable(true);
//        Login.lbzalogowany;
       // lbZalogowany.setText("zalogowany: "+Login.lbzalogowany.toString());
    //    System.out.println(strstanowisko);
        labelZalogowany.setText(Login.lbzalogowany);
        if (Login.stanowisko.equals("serwis"))btnSerwis.setDisable(false);
        else if (Login.stanowisko.equals("ksiegowa"))btnFaktury.setDisable(false);
        else if (Login.stanowisko.equals("magazyn"))btnMagazyn.setDisable(false);
        else if (Login.stanowisko.equals("admin")){
            btnSerwis.setDisable(false);
            btnZlecenia.setDisable(false);
            btnAdministracja.setDisable(false);
            btnMagazyn.setDisable(false);
            btnFaktury.setDisable(false);
        }
        else btnZlecenia.setDisable(false);



       // System.out.println(Login.stanowisko);
       // btnSerwis.setText("test");
       // System.out.println(login.stanowisko);
    }

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



    /**
     * Otwiera okno panuelu administracyjnego
     * @param event
     * @throws IOException
     */
    public void openAdministracja(ActionEvent event) throws IOException {
            TextInputDialog dialog = new TextInputDialog("");
            dialog.setTitle("Alert");
            dialog.setHeaderText("Dodatkowe zabezpieczenie");
            dialog.setContentText("Wpisz haslo:");

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
                } else {
                    Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/info.fxml"));
                    borderPane.setCenter(noweOkno);
                }

            }

    }
    /**
     * Otwieranie panelu magazyn
     */
        public void openMagazyn (ActionEvent event) throws IOException {
                Parent noweOkno = FXMLLoader.load(getClass().getResource("/fxml/storage.fxml"));
                borderPane.setCenter(noweOkno);

        }


        @Override
        public void initialize (URL location, ResourceBundle resources){
            methodController.initDb();
            users = methodController.getUsers();

            uprawnienia();

        }
    }
