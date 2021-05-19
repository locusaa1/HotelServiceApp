package hotelServiceApp.view.logInView;

import hotelServiceApp.backEndCode.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

public class LogInController{

    @FXML
    private TextField usernameField;

    @FXML
    private Label logInTitle;

    @FXML
    private Label adminLogInLabel;

    @FXML
    private Button adminMenuButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button logInButton;

    @FXML
    void logInUser(ActionEvent event) {

        System.out.println("User Loged In");
    }

    @FXML
    void changeLogInView(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../adminLogInView/AdminLogIn.fxml"));
        Parent root = loader.load();
        Main.mainStage.setScene(new Scene(root,800,600));
    }

}
