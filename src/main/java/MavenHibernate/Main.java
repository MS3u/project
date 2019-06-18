package MavenHibernate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("System");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }


















    }











