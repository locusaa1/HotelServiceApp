package hotelServiceApp.view.adminLogInView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import hotelServiceApp.backEndCode.Main;

import java.io.IOException;

public class AdminLogInController {

    @FXML
    private Button adminLogInButton;

    @FXML
    private Button userMenuButton;

    @FXML
    private Label userLogInLabel;

    @FXML
    private PasswordField adminPasswordField;

    @FXML
    private TextField adminUsernameField;

    @FXML
    private Label adminLogInTitle;

    @FXML
    void logInAdmin(ActionEvent event) {
        System.out.println("Admin Loged In");
    }

    @FXML
    void changeLogInView(ActionEvent event) throws IOException {
        Main.mainStage.setScene(Main.logInScene);
    }

}
