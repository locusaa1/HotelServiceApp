package hotelServiceApp.view.modifyUserPanel;

import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifyUserPanelController implements Initializable {

    public static Passenger passenger;
    public static Stage stage;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField dniTextFIeld;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Label countryLabel;

    @FXML
    private Label titleLabel;

    @FXML
    private Label surnameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label dniLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField usernameTextField;

    /**
     * public void initialize(URL location, ResourceBundle resources)
     * This method is used to set up all the fields required at the launch of the window with the passenger information.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.nameTextField.setText(ModifyUserPanelController.passenger.getName());
        this.surnameTextField.setText(ModifyUserPanelController.passenger.getSurname());
        this.dniTextFIeld.setText(ModifyUserPanelController.passenger.getDni());
        this.countryTextField.setText(ModifyUserPanelController.passenger.getCountry());
        this.addressTextField.setText(ModifyUserPanelController.passenger.getAdress());
        this.phoneTextField.setText(ModifyUserPanelController.passenger.getPhone());
        this.usernameTextField.setText(ModifyUserPanelController.passenger.getUsername());
        this.passwordTextField.setText(ModifyUserPanelController.passenger.getPassword());
    }

    /**
     * void confirmChanges(ActionEvent event)
     * This method is an event handler used when the confirm button is pressed.
     * It checks for every possible failure and if everything is ok, then it changes the information of the passenger in the HotelData.
     */
    @FXML
    void confirmChanges(ActionEvent event) {

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

            if (Main.hotelData.passengerExists(this.dniTextFIeld.getText()).equals(false)) {

                Main.hotelData.getPassengerList().remove(this.passenger);
                Main.hotelData.setPassengerList(passenger);
                Alerts.infoAlert("Congrats", "The passenger data was successfully changed.", "close");
                ModifyUserPanelController.stage.close();
            } else {

                Alerts.errorAlert("Error", "The new dni still exists.", "close");
            }


        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The dni and phone must be numbers.", "close");
        }
    }
}
