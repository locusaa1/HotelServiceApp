package hotelServiceApp.view.newUserPanel;

import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.view.alerts.Alerts;
import hotelServiceApp.view.receptionistMenu.ReceptionistMenuController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewUserPanelController {

    public static Stage stage;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField dniTextFIeld;

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
    private Button addButton;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private TextField surnameTextField;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label dniLabel;

    @FXML
    private Button allPassengersLoadedButton;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField usernameTextField;

    /**
     * void allPassengersReady(ActionEvent event)
     * This method is an event handler used when the allPassengersLoaded button is pressed.
     * It allows the user to leave the loop of load windows if he failed typing the amount of passengers before.
     */
    @FXML
    void allPassengersReady(ActionEvent event) {

        if (Alerts.confirmationAlert("Yes", "No", "Passengers group ready?", "Are you sure you want to stop the passengers load?")) {

            if (ReceptionistMenuController.passengerList.size() > 0) {

                ReceptionistMenuController.check = ReceptionistMenuController.passengerList.size();
                NewUserPanelController.stage.close();
            } else {

                Alerts.errorAlert("Error", "You have to load at least one passenger.", "close");
            }
        }
    }

    /**
     * void addPassenger(ActionEvent event)
     * This method is an event handler used when the add button is pressed.
     * It sets a new passenger into the HotelData and into the list of passengers to be checked in.
     */
    @FXML
    void addPassenger(ActionEvent event) {

        Passenger passenger = new Passenger(this.nameTextField.getText(),
                this.surnameTextField.getText(),
                this.dniTextFIeld.getText(),
                this.countryTextField.getText(),
                this.addressTextField.getText(),
                this.phoneTextField.getText(),
                this.usernameTextField.getText(),
                this.dniTextFIeld.getText());

        try {

            int firstTry = Integer.parseInt(this.dniTextFIeld.getText());
            int secondTry = Integer.parseInt(this.phoneTextField.getText());

            if (Main.hotelData.passengerExists(passenger.getDni()).equals(false)) {

                if (Main.hotelData.usernameExists(this.usernameTextField.getText()).equals(false)) {

                    Main.hotelData.setPassengerList(passenger);
                    ReceptionistMenuController.passengerList.add(passenger);
                    Alerts.infoAlert("Congrats", "The passenger was successfully added to the grup.", "close");
                    NewUserPanelController.stage.close();
                } else {

                    Alerts.errorAlert("Error", "The username is already used.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "The passenger already exists", "close");
                if (Alerts.confirmationAlert("Yes", "No", "Set passenger", "Do you want to set the existing passenger to the group?")) {

                    passenger = Main.hotelData.dniSearchPassenger(this.dniTextFIeld.getText());
                    ReceptionistMenuController.passengerList.add(passenger);
                    Alerts.infoAlert("Congrats", "The passenger was added successfully", "close");
                    NewUserPanelController.stage.close();
                }
            }

        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "Dni & Phone are number fields!", "close");
        }
    }
}
