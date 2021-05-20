package hotelServiceApp.backEndCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    public static Stage mainStage;
    public static Scene logInScene;

    public static List <Persona> persona = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/logInview/LogIn.fxml"));
        this.mainStage = primaryStage;
        this.logInScene = new Scene(root,800,600);
        primaryStage.setTitle("Hotel Service App");
        primaryStage.setScene(this.logInScene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

}
