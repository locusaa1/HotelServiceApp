package hotelServiceApp.view.userBookingView;

import hotelServiceApp.backEndCode.Booking;
import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Passenger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class UserBookingViewController {

    public static Passenger passenger;

    @FXML
    private Button generateButton;

    @FXML
    private Button deleteBookingButton;

    @FXML
    private Label showBookingLabel;

    @FXML
    private Label listFirstLabel;

    @FXML
    private Label listSecondLabel;

    @FXML
    private CheckBox oneBedroomCheckBox;

    @FXML
    private Label deleteBookingLabel;

    @FXML
    private ListView<String> bookingList = new ListView<String>();

    @FXML
    private Button showBookingButton;

    @FXML
    private CheckBox twoBedroomsCheckBox;

    @FXML
    private DatePicker firstDatePicker;

    @FXML
    private DatePicker secondDatePicker;

    @FXML
    void deleteBooking(ActionEvent event) {

    }

    @FXML
    void showBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

            this.bookingList.getItems().addAll(UserBookingViewController.passenger.getBooking().toString());
            this.bookingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        } else {

            //Alerta el cliente no tiene reservas

        }
    }

    @FXML
    void generateBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

        } else {

            Main.hotelData.
        }
    }

}
