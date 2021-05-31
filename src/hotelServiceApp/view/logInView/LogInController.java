package hotelServiceApp.view.logInView;

import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.view.alerts.Alerts;
import hotelServiceApp.view.userBookingView.UserBookingViewController;
import hotelServiceApp.view.userMainMenu.UserMainMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.IOException;

public class LogInController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private Label logInTitle;

    @FXML
    private Label adminLogInLabel;

    @FXML
    private Button registrationButton;

    @FXML
    private Button adminLogInButton;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Button logInButton;

    /**
     * setUserMainMenuView(ActionEvent event)
     * This method is an event handler used when the LogIn button is pressed by the user.
     * It checks if the username exists, if it doesn't then throws an alert to the user.
     * It checks if the password matched the username, if it doesn't then throws another type of alert.
     * And it also checks in case that the user LogIn successfully, if he is hosted or not, then sets the appropriated scene.
     */

    @FXML
    void setUserMainMenuView(ActionEvent event) throws IOException {

        if (Main.hotelData.usernameExists(this.usernameTextField.getText()).equals(true)) {

            Passenger passenger = new Passenger();
            passenger = Main.hotelData.usernameSearchPassenger(this.usernameTextField.getText());
            if (Main.hotelData.confirmPassword(this.passwordTextField.getText(), passenger).equals(true)) {

                if (passenger.getHosted().equals(true)) {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../userMainMenu/UserMainMenu.fxml"));
                    UserMainMenuController.passenger = passenger;
                    Parent root = loader.load();
                    Main.mainStage.setScene(new Scene(root, 800, 600));
                } else {

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../userBookingView/UserBookingView.fxml"));
                    UserBookingViewController.passenger = passenger;
                    Parent root = loader.load();
                    Main.mainStage.setScene(new Scene(root, 800, 600));
                }
            } else {

                Alerts.errorAlert("Error", "The password is incorrect", "close");
            }
        } else {

            Alerts.errorAlert("Error", "The username does not exists!", "close");
        }
    }

    /**
     * changeLogInView(ActionEvent event)
     * This method is an event handler used when the adminLogIn button is pressed by the user.
     * It sets the admin log in scene.
     */

    @FXML
    void changeLogInView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../adminLogInView/AdminLogIn.fxml"));
        Parent root = loader.load();
        Main.mainStage.setScene(new Scene(root, 800, 600));
    }

    /**
     * setRegisterView(ActionEvent event)
     * This method is an event handler used when the registration button is pressed by the user.
     * It sets the registration scene
     */

    @FXML
    void setRegisterView(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../userRegisterView/UserRegisterView.fxml"));
        Parent root = loader.load();
        Main.mainStage.setScene(new Scene(root, 800, 600));
    }

}
