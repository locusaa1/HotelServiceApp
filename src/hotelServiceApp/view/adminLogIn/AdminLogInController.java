package hotelServiceApp.view.adminLogIn;

import hotelServiceApp.backEndCode.Receptionist;
import hotelServiceApp.view.adminMainMenu.AdminMainMenuController;
import hotelServiceApp.view.alerts.Alerts;
import hotelServiceApp.view.receptionistMenu.ReceptionistMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    /**
     * void logInAdmin(ActionEvent event)
     * This method is an event handler used when the LogIn button is pressed by the administrator or receptionist.
     * It checks if the username exists, if it doesn't then throws an alert.
     * It checks if the password matched the username, if it doesn't then throws another type of alert.
     */
    @FXML
    void logInAdmin(ActionEvent event) throws IOException {

        if (Main.hotelData.getAdmin().confirmAdminAccess(this.adminUsernameField.getText(), this.adminPasswordField.getText())) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../adminMainMenu/AdminMainMenu.fxml"));
            AdminMainMenuController.admin = Main.hotelData.getAdmin();
            Parent root = loader.load();
            Main.mainStage.setScene(new Scene(root, 800, 600));

        } else if (Main.hotelData.receptionistUsernameExists(this.adminUsernameField.getText())) {

            Receptionist receptionist = Main.hotelData.usernameSearchReceptionist(this.adminUsernameField.getText());
            if (receptionist.confirmReceptionistAccess(this.adminUsernameField.getText(), this.adminPasswordField.getText())) {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../receptionistMenu/ReceptionistMenu.fxml"));
                ReceptionistMenuController.receptionist = receptionist;
                Parent root = loader.load();
                Main.mainStage.setScene(new Scene(root, 800, 600));
            } else {

                Alerts.errorAlert("Error", "The password is incorrect.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "The username or password are incorrect.", "close");
        }
    }

    /**
     * void changeLogInView(ActionEvent event)
     * This method is an event handler used when the userMenu button is pressed.
     * It changes the logIn view.
     */
    @FXML
    void changeLogInView(ActionEvent event) throws IOException {
        Main.mainStage.setScene(Main.logInScene);
    }

}
