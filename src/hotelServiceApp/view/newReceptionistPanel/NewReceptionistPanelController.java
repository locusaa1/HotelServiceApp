package hotelServiceApp.view.newReceptionistPanel;

import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Receptionist;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewReceptionistPanelController {

    public static Stage receptionistStage;
    public static Scene receptionistScene;

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
    private TextField salaryTextField;

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
     * This method is an event handler used when the confirm button is pressed.
     * It sets a new receptionist into the HotelData taking all the information from the fields on the windows.
     * It checks for every possible failure.
     */
    @FXML
    void saveUserInfo(ActionEvent event) {

        Receptionist receptionist = new Receptionist(this.nameTextField.getText(),
                this.surnameLabel.getText(),
                this.dniLabel.getText(),
                this.countryTextField.getText(),
                this.addressTextField.getText(),
                this.phoneTextField.getText(),
                this.usernameTextField.getText(),
                this.passwordTextField.getText(),
                Double.parseDouble(this.salaryTextField.getText()));

        try {

            int firstTry = Integer.parseInt(this.dniTextFIeld.getText());
            int secondTry = Integer.parseInt(this.phoneTextField.getText());

            if (Main.hotelData.receptionistExists(receptionist.getDni()).equals(false)) {

                if (Main.hotelData.receptionistUsernameExists(receptionist.getUsername()).equals(false)) {

                    if (this.passwordTextField.getText().equals(this.passwordTextFieldConfirm.getText())) {

                        Main.hotelData.setReceptionistList(receptionist);
                        Alerts.infoAlert("Congrats", "Your new receptionist were registered successfully", "close");
                        NewReceptionistPanelController.receptionistStage.close();
                    } else {

                        Alerts.errorAlert("Error", "The password does not match the confirm password field", "close");
                    }
                } else {

                    Alerts.errorAlert("Error", "The username is already used.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "The receptionist is already registered", "close");
            }
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The dni & phone are number fields only.", "close");
        }
    }

    /**
     * void discardInfo(ActionEvent event)
     * This method is an event handler used when the discard info button is pressed.
     * It closes the window and discard the info not saving a new receptionist.
     */
    @FXML
    void discardInfo(ActionEvent event) {

        if (Alerts.confirmationAlert("Go back", "Stay", "Confirmation", "You will discard all the info in this windows and go back.")) {

            NewReceptionistPanelController.receptionistStage.close();
        }
    }


}

