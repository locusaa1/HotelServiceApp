package hotelServiceApp.view.modifyReceptionistPanel;

import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Receptionist;
import hotelServiceApp.view.alerts.Alerts;
import hotelServiceApp.view.modifyUserPanel.ModifyUserPanelController;
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

public class ModifyReceptionistPanelController implements Initializable {

    public static Receptionist receptionist;
    public static Stage stage;

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField dniTextField;

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
    private TextField salaryTextField;

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
     * This method is used to set up all the fields required at the launch of the window with the receptionist information.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.nameTextField.setText(ModifyReceptionistPanelController.receptionist.getName());
        this.surnameTextField.setText(ModifyReceptionistPanelController.receptionist.getSurname());
        this.dniTextField.setText(ModifyReceptionistPanelController.receptionist.getDni());
        this.countryTextField.setText(ModifyReceptionistPanelController.receptionist.getCountry());
        this.addressTextField.setText(ModifyReceptionistPanelController.receptionist.getAdress());
        this.phoneTextField.setText(ModifyReceptionistPanelController.receptionist.getPhone());
        this.salaryTextField.setText(Double.toString(ModifyReceptionistPanelController.receptionist.getSalary()));
        this.usernameTextField.setText(ModifyReceptionistPanelController.receptionist.getUsername());
        this.passwordTextField.setText(ModifyReceptionistPanelController.receptionist.getPassword());
    }

    /**
     * void confirmChanges(ActionEvent event)
     * This method is an event handler used when the confirm button is pressed.
     * It checks for every possible failure and if everything is ok, then it changes the information of the receptionist in the HotelData.
     */
    @FXML
    void confirmChanges(ActionEvent event) {

        Receptionist receptionist = new Receptionist(this.nameTextField.getText(),
                this.surnameTextField.getText(),
                this.dniTextField.getText(),
                this.countryTextField.getText(),
                this.addressTextField.getText(),
                this.phoneTextField.getText(),
                this.usernameTextField.getText(),
                this.passwordTextField.getText(),
                Double.parseDouble(this.salaryTextField.getText()));
        try {

            int firstTry = Integer.parseInt(this.dniTextField.getText());
            int secondTry = Integer.parseInt(this.phoneTextField.getText());
            double thirdTry = Double.parseDouble(this.salaryTextField.getText());

            if (Main.hotelData.receptionistExists(this.dniTextField.getText()).equals(false)) {

                Main.hotelData.getReceptionistList().remove(this.receptionist);
                Main.hotelData.setReceptionistList(receptionist);
                Alerts.infoAlert("Congrats", "The receptionist data was successfully changed.", "close");
                ModifyReceptionistPanelController.stage.close();
            } else {

                Alerts.errorAlert("Error", "The new dni still exists.", "close");
            }


        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The dni, phone and salary must be numbers.", "close");
        }
    }
}
