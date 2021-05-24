package hotelServiceApp.view.userRegisterView;

import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.backEndCode.Main;
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

        if (Main.hotelData.passengerExists(passenger.getDni()).equals(false)) {

            if(Main.hotelData.usernameExists(passenger.getUsername()).equals(false)){

                Main.hotelData.setPassengerList(passenger);
                System.out.println(Main.hotelData.getPassenger(0).toString());
                System.out.println(Main.hotelData.getPassenger(1).toString());
            }else {

                Alert alertUsernameExists = new Alert(Alert.AlertType.ERROR);
                alertUsernameExists.setHeaderText(null);
                alertUsernameExists.setTitle("Error");
                alertUsernameExists.setContentText("The username is already used.");
                alertUsernameExists.showAndWait();
            }
        } else {

            Alert alertPassengerExists = new Alert(Alert.AlertType.ERROR);
            alertPassengerExists.setHeaderText(null);
            alertPassengerExists.setTitle("Error");
            alertPassengerExists.setContentText("The passenger is already registered.");
            alertPassengerExists.showAndWait();
        }
    }

    @FXML
    void discardInfo(ActionEvent event) {

    }

}
