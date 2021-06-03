package hotelServiceApp.view.userRegisterView;

import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UserRegisterViewController {

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Label titleLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label goBackLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label saveLabel;

    @FXML
    private Label passwordConfirmLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField dniTextFIeld;

    @FXML
    private Label adviceLabel;

    @FXML
    private PasswordField passwordTextFieldConfirm;

    @FXML
    private Label surnameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Button discardButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label confirmLabel;

    @FXML
    private Label dniLabel;

    @FXML
    private TextField usernameTextField;

    /**
     * void saveUserInfo(ActionEvent event)
     * This method is an event handler used when the confirm button is pressed by the user.
     * It checks if the passenger dni is already in the database, it it is true then throws an alert.
     * It also checks if the username is already taken, if it is true then trows another alert to the user.
     * If everything is ok, when the user press the confirm button it will save all the info into a passenger and will add it to the hotelData in the Main.
     */
    @FXML
    void saveUserInfo(ActionEvent event) {

        Passenger passenger = new Passenger(this.nameTextField.getText(),
                this.surnameTextField.getText(),
                this.dniTextFIeld.getText(),
                this.countryTextField.getText(),
                this.addressTextField.getText(),
                this.phoneTextField.getText(),
                this.usernameTextField.getText(),
                this.passwordTextField.getText());
        try {

            int firstTry = Integer.parseInt(this.dniTextFIeld.getText());
            int secondTry = Integer.parseInt(this.phoneTextField.getText());

            if (Main.hotelData.passengerExists(passenger.getDni()).equals(false)) {

                if (Main.hotelData.usernameExists(passenger.getUsername()).equals(false)) {

                    if (this.passwordTextField.getText().equals(this.passwordTextFieldConfirm.getText())) {

                        Main.hotelData.setPassengerList(passenger);
                        Alerts.infoAlert("Congrats", "You were successfully registered.", "close");
                        Main.mainStage.setScene(Main.logInScene);
                    } else {

                        Alerts.errorAlert("Error", "The password does not match the confirm password field.", "close");
                    }
                } else {

                    Alerts.errorAlert("Error", "The username is already used.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "The passenger is already registered.", "close");
            }
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "DNI & Phone are number text fields", "close");
        }
    }

    /**
     * void discardInfo(ActionEvent event)
     * This method is an event handler used when the discard button is pressed by the user.
     * It always throws and alert to confirm if the user is sure about leaving the windows with all the information wrote.
     * If the result of the alert is the confirm button, then it will go back to the logIn scene.
     * If the result is the cancel button, then it will close the alert and stay in the same scene.
     */
    @FXML
    void discardInfo(ActionEvent event) {

        if (Alerts.confirmationAlert("Go back", "Stay", "Confirmation", "Are you sure you want to discard the info and go back?")) {

            Main.mainStage.setScene(Main.logInScene);
        }
    }
}
