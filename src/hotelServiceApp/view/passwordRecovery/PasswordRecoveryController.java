package hotelServiceApp.view.passwordRecovery;

import hotelServiceApp.backEndCode.Admin;
import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PasswordRecoveryController {

    public static Stage stage;

    @FXML
    private TextField dniField;

    @FXML
    private TextField usernameField;

    @FXML
    private Button recoverButton;

    @FXML
    private TextField addressField;

    /**
     * void recoverPassword(ActionEvent event)
     * This method is an event handler used when the recover button is pressed.
     * It allows the user to recover his password if he completes with the correct information all the fields.
     */
    @FXML
    void recoverPassword(ActionEvent event) {

        try {

            int firstTry = Integer.parseInt(this.dniField.getText());
            Passenger passenger = Main.hotelData.dniSearchPassenger(this.dniField.getText());
            if (passenger != null) {

                if (passenger.getAdress().equals(this.addressField.getText()) && passenger.getUsername().equals(this.usernameField.getText())) {

                    Alerts.infoAlert("Congrats", "Your password is: " + passenger.getPassword(), "close");
                    PasswordRecoveryController.stage.close();
                }
            } else {

                Alerts.errorAlert("Error", "The dni is not registered in the hotel.", "close");
            }
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The dni must be a number.", "close");
        }
    }
}
