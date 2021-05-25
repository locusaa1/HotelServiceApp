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

    /**This method is used when the confirm button is pressed by the user.
     *It checks if the passenger dni is already in the database, it it is true then throws an alert.
     *It also checks if the username is already taken, if it is true then trows another alert to the user.
     *If everything is ok, when the user press the confirm button it will save all the info into a passenger and will add it to the hotelData in the Main.*/

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

            Alert alertPassengerExists = new Alert(Alert.AlertType.ERROR,"",ButtonType.YES,ButtonType.NO);
            alertPassengerExists.setHeaderText(null);
            alertPassengerExists.setTitle("Error");
            alertPassengerExists.setContentText("The passenger is already registered.");
            alertPassengerExists.showAndWait();
        }
    }

    /**This method is used when the discard button is pressed by the user.
     *It always throws and alert to confirm if the user is sure about leaving the windows with all the information wrote.
     *If the result of the alert is the confirm button, then it will go back to the logIn scene.
     *If the result is the cancel button, then it will close the alert and stay in the same scene.*/

    @FXML
    void discardInfo(ActionEvent event) {

        ButtonType confirm = new ButtonType("Go back", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Stay", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alertDiscardChanges = new Alert(Alert.AlertType.CONFIRMATION,"",confirm,cancel);
        alertDiscardChanges.setHeaderText(null);
        alertDiscardChanges.setTitle("Confirmation");
        alertDiscardChanges.setContentText("Are you sure you want to discard the info and go back?");
        alertDiscardChanges.showAndWait();

        if (alertDiscardChanges.getResult().equals(confirm)){

            Main.mainStage.setScene(Main.logInScene);
        }
    }
}
