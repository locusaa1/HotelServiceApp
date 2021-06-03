package hotelServiceApp.view.adminMainMenu;

import hotelServiceApp.backEndCode.Admin;
import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Payment;
import hotelServiceApp.backEndCode.Receptionist;
import hotelServiceApp.view.alerts.Alerts;
import hotelServiceApp.view.modifyReceptionistPanel.ModifyReceptionistPanelController;
import hotelServiceApp.view.newReceptionistPanel.NewReceptionistPanelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminMainMenuController implements Initializable {

    public static Admin admin;
    public static Receptionist receptionist;

    @FXML
    private Button registerReceptionistButton;

    @FXML
    private Button removeButton;

    @FXML
    private TextField accountCashField;

    @FXML
    private TextField dniTextField;

    @FXML
    private TextField totalPaymentField;

    @FXML
    private Button logOutButton;

    @FXML
    private TextField descPaymentField;

    @FXML
    private DatePicker paymentDateField;

    @FXML
    private Button backUpButton;

    @FXML
    private ListView<Payment> paymentListView = new ListView<Payment>();

    @FXML
    private Button showPaymentButton;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField receptionistSalaryField;

    @FXML
    private Button editReceptionistButton;

    /**
     * void logOut(ActionEvent event)
     * This method is an event handler used when the logOut button is pressed.
     * It sets back the logInView.
     */
    @FXML
    void logOut(ActionEvent event) {

        if (Alerts.confirmationAlert("logOut", "Stay", "LogOut", "Are you sure you want to logOut?")) {
            Main.mainStage.setScene(Main.logInScene);
        }
    }

    /**
     * void setNewBackUp(ActionEvent event)
     * This method is an event handler used when the backUp button is pressed.
     * It saves all the info at the moment into the backUp file.
     */
    @FXML
    void setNewBackUp(ActionEvent event) {

        if (Alerts.confirmationAlert("Yes", "No", "BackUp", "Are you sure you want to save a backUp of the Hotel Information?")) {
            //Se haría el backUp dentro del archivo alternativo
        }
    }

    /**
     * void registerNewReceptionist(ActionEvent event)
     * This method is an event handler used when the registerReceptionist button is pressed.
     * It opens a new Stage with the fields to complete to generate a new receptionist.
     * The admin can discard the info and go back o confirm an save the ino into a new receptionist into the hotel data.
     */
    @FXML
    void registerNewReceptionist(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../newReceptionistPanel/NewReceptionistPanel.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("New Receptionist");
        stage.setScene(new Scene(root, 800, 600));
        NewReceptionistPanelController.receptionistStage = stage;
        NewReceptionistPanelController.receptionistStage.showAndWait();
    }

    /**
     * void showPayments(ActionEvent event)
     * This method is an event handler used when the showPayments button is pressed.
     * It shows all the payments into the receptionist paymentList.
     */
    @FXML
    void showPayments(ActionEvent event) {

        if (Main.hotelData.receptionistExists(this.dniTextField.getText())) {

            Receptionist receptionist = Main.hotelData.receptionistDniExists(this.dniTextField.getText());
            AdminMainMenuController.receptionist = receptionist;
            this.receptionistSalaryField.setText(Double.toString(receptionist.getSalary()));
            if (AdminMainMenuController.receptionist.getPaymentList().size() > 0) {

                this.paymentListView.setItems(receptionist.getPaymentsObservableList());
                this.paymentListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {

                Alerts.infoAlert("Error", "The receptionist does not have payments to show.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "The dni field is empty or incorrect!", "close");
        }
    }

    /**
     * void confirmPayment(ActionEvent event)
     * This method is an event handler used when the confirm button is pressed.
     * It sets a new payment into the receptionist list.
     */
    @FXML
    void confirmPayment(ActionEvent event) {

        if (this.everyFieldCompleted()) {

            if (AdminMainMenuController.receptionist != null) {

                try {

                    Payment payment = new Payment(this.paymentDateField.getValue(), Double.parseDouble(this.totalPaymentField.getText()), this.descPaymentField.getText());

                    if ((AdminMainMenuController.admin.getHotelTotalCash() - Double.parseDouble(this.totalPaymentField.getText())) > 0) {

                        AdminMainMenuController.receptionist.setPaymentList(payment);
                        AdminMainMenuController.admin.setHotelTotalCash(AdminMainMenuController.admin.getHotelTotalCash() - payment.getPayment());
                        this.accountCashField.setText(Double.toString(AdminMainMenuController.admin.getHotelTotalCash()));
                        Alerts.infoAlert("Congrats", "The payment were done successfully!", "close");
                    } else {

                        Alerts.errorAlert("Error", "There is not enough money into the account", "close");
                    }
                } catch (NumberFormatException exception) {

                    Alerts.errorAlert("Error", "The total field is a number field.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "You have to show and search the receptionist by dni first.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "Theres is an empty field to complete!", "close");
        }
    }

    /**
     * public Boolean everyFieldCompleted()
     * This method checks if every field into the scene is completed.
     */
    public Boolean everyFieldCompleted() {

        Boolean confirm = false;

        if (this.totalPaymentField.getText() != null && this.paymentDateField.getValue() != null && this.descPaymentField != null) {

            confirm = true;
        }

        return confirm;
    }

    /**
     * void removePayment(ActionEvent event)
     * This method is an event handler used when the remove button is pressed.
     * This sets back the amount of the selected payment into the admin account and deletes the payment from the receptionist payments list and listView.
     */
    @FXML
    void removePayment(ActionEvent event) {

        if (this.paymentListView.getItems().size() > 0) {

            if (this.paymentListView.getSelectionModel().getSelectedItems().size() > 0) {

                if (Alerts.confirmationAlert("Confirm", "Cancel", "Remove Payment", "Are you sure you want to delete te payment?")) {

                    this.paymentListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    Payment payment = this.paymentListView.getSelectionModel().getSelectedItem();
                    this.paymentListView.getItems().remove(payment);
                    AdminMainMenuController.admin.setHotelTotalCash(AdminMainMenuController.admin.getHotelTotalCash() + payment.getPayment());
                    this.accountCashField.setText(Double.toString(AdminMainMenuController.admin.getHotelTotalCash()));
                    Alerts.infoAlert("Congrats", "The payment were successfully done.", "close");
                } else {

                    Alerts.infoAlert("Payment", "The payment remove were canceled.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "There is nothing selected.", "close");
            }
        } else {
            Alerts.errorAlert("Error", "There is nothing in the list to be removed.", "close");
        }
    }

    /**
     * void editReceptionist(ActionEvent event)
     * This method is an event handler used when the editReceptionist button is pressed.
     * It checks if the dni is a number, and if the dni is from a real receptionist into HotelData.
     * It cast launchReceptionistEdit() to launch the new window.
     */
    @FXML
    void editReceptionist(ActionEvent event) {

        try {

            int dni = Integer.parseInt(this.dniTextField.getText());
            Receptionist receptionist = Main.hotelData.receptionistDniExists(this.dniTextField.getText());

            if (receptionist != null) {

                ModifyReceptionistPanelController.receptionist = receptionist;
                this.launchReceptionistEdit();
            } else {

                Alerts.errorAlert("Error", "The receptionist does not exists.", "close");
            }
        } catch (NumberFormatException | IOException exception) {

            Alerts.errorAlert("Error", "The dni must be a number.", "close");
        }
    }

    /**
     * public void initialize(URL location, ResourceBundle resources)
     * This method is used when the scene is loaded into the stage initializing the variables inside the method
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String cash = Double.toString(AdminMainMenuController.admin.getHotelTotalCash());
        this.accountCashField.setText(cash);
    }

    /**
     * public void launchReceptionistEdit()
     * This method creates and launch the receptionist edit windows.
     */
    public void launchReceptionistEdit() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../modifyReceptionistPanel/ModifyReceptionistPanel.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Editing Receptionist");
        stage.setScene(new Scene(root, 600, 400));
        ModifyReceptionistPanelController.stage = stage;
        ModifyReceptionistPanelController.stage.showAndWait();
    }
}
