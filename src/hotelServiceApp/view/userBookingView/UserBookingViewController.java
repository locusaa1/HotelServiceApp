package hotelServiceApp.view.userBookingView;

import hotelServiceApp.backEndCode.Booking;
import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.backEndCode.Room;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class UserBookingViewController {

    public static Passenger passenger;

    @FXML
    private Button refreshListButton;

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
    private Button logOutButton;

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

    /**
     * void deleteBooking(ActionEvent event)
     * This method is an event handler used when the deleteBooking button is pressed by the user.
     * It checks if the passenger already has a booking.
     * It checks if there are items in the list to delete too, and if the items were selected.
     */
    @FXML
    void deleteBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

            if (this.bookingList.getItems().size() > 0) {

                if (this.bookingList.getSelectionModel().getSelectedItems().size() > 0) {

                    Main.hotelData.deleteExistingBooking(UserBookingViewController.passenger, UserBookingViewController.passenger.getBooking().getRoom(), UserBookingViewController.passenger.getBooking());
                    Alerts.infoAlert("Congrats", "Successfully deleted." + "\n Close this window and refresh the list.", "close");
                } else {

                    Alerts.errorAlert("Error", "No items selected.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "There is nothing in the list to delete.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "You do not have booking to delete.", "close");
        }

    }

    /**
     * void showBooking(ActionEvent event)
     * This method is an event handler used when the showBooking button is pressed by the user.
     * It checks if the passenger has a booking to show.
     */
    @FXML
    void showBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

            this.bookingList.getItems().add(0, UserBookingViewController.passenger.getBooking().getToString());
            this.bookingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        } else {

            Alerts.errorAlert("Error", "You do not have bookings to show.", "close");
        }
    }

    /**
     * void generateBooking(ActionEvent event)
     * This method is an event handler used when the generateBooking button is pressed.
     * This method contains all the alerts needed to check if the fields were picked correctly.
     * It generates a new booking for the passenger.
     */
    @FXML
    void generateBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

            Alerts.errorAlert("Error", "You already have a booking", "close");
        } else {

            LocalDate firstDate = this.firstDatePicker.getValue();
            LocalDate secondDate = this.secondDatePicker.getValue();
            if (firstDate == null || secondDate == null) {

                Alerts.errorAlert("Error", "You have to pick to dates" + "\n (Check-In) & (Check-Out)", "close");
            } else {

                if (secondDate.isAfter(firstDate)) {

                    if (firstDate.isBefore(LocalDate.now())) {

                        Alerts.errorAlert("Error", "The chek-In minimu value is today", "close");
                    } else {

                        if (this.oneBedroomCheckBox.isSelected()) {

                            Room room = Main.hotelData.searchAvailableRoom(firstDate, secondDate, 1);
                            if (room != null) {

                                Booking booking = new Booking(LocalDate.now(), UserBookingViewController.passenger, room, firstDate, secondDate);
                                Main.hotelData.setNewBooking(UserBookingViewController.passenger, room, booking);
                            } else {

                                Alerts.errorAlert("Error", "There is no rooms available in the date range selected", "close");
                            }
                        } else if (this.twoBedroomsCheckBox.isSelected()) {

                            Room room = Main.hotelData.searchAvailableRoom(firstDate, secondDate, 2);
                            if (room != null) {

                                Booking booking = new Booking(LocalDate.now(), UserBookingViewController.passenger, room, firstDate, secondDate);
                                Main.hotelData.setNewBooking(UserBookingViewController.passenger, room, booking);
                            } else {

                                Alerts.errorAlert("Error", "There is no rooms available in the date range selected", "close");
                            }
                        } else {

                            Alerts.errorAlert("Error", "You have to use at least one check-box for the bedrooms.", "close");
                        }
                    }
                } else {

                    Alerts.errorAlert("Error", "The check-In date goes before the check-Out date", "close");
                }
            }
        }
    }

    /**
     * void refreshListView(ActionEvent event)
     * This method is an event handler used when the refreshListView button is pressed by the user.
     * It checks if there are items in the list to be refreshed.
     */
    @FXML
    void refreshListView(ActionEvent event) {

        if (this.bookingList.getItems().size() > 0) {

            this.bookingList.getItems().remove(0);
            this.bookingList.refresh();
        } else {

            Alerts.errorAlert("Error", "There is nothing in the list to refresh.", "close");
        }
    }

    /**
     * void logOut(ActionEvent event)
     * This method is an event handler used when the logOut button is pressed by the user.
     * It confirms the logOut of the client.
     */
    @FXML
    void logOut(ActionEvent event) {

        if (Alerts.confirmationAlert("log-Out", "Stay", "Confirmation", "Are you sure you want to log-Out?")) {

            Main.mainStage.setScene(Main.logInScene);
        }
    }

}
