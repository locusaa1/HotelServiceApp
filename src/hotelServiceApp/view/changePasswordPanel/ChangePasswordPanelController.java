package hotelServiceApp.view.changePasswordPanel;

import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class ChangePasswordPanelController {

    public static Passenger passenger;
    public static Stage stage;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private PasswordField newPasswordConfirmField;

    @FXML
    private Button confirmButton;

    @FXML
    private PasswordField oldPasswordField;

    /**
     * void changePassword(ActionEvent event)
     * This method is an event handler used when the confirmButton is pressed by the user.
     * It checks if the oldPassword matches the real one, and if both of the new do the same thing.
     * If everything is ok then it changes the user password.
     */
    @FXML
    void changePassword(ActionEvent event) {

        if (this.passenger.getPassword().equals(this.oldPasswordField.getText())) {

            if (this.newPasswordField.getText().equals(this.newPasswordConfirmField.getText())) {

                this.passenger.setPassword(this.newPasswordField.getText());
                Alerts.infoAlert("Congrats", "The password was successfully changed.", "close");
                this.stage.close();
            } else {

                Alerts.errorAlert("Error", "The new password does not match the confirm field.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "The old password does not match.", "close");
        }
    }

}