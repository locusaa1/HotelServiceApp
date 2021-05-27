package hotelServiceApp.view.userBookingView;

import hotelServiceApp.backEndCode.Booking;
import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Passenger;
import hotelServiceApp.backEndCode.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.jws.soap.SOAPBinding;
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

    @FXML
    void deleteBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

            Main.hotelData.deleteExistingBooking(UserBookingViewController.passenger, UserBookingViewController.passenger.getBooking().getRoom(), UserBookingViewController.passenger.getBooking());
            System.out.println("Borrado exitosamente");
        } else {

            System.out.println("No tiene reservas para borrar");
        }

    }

    @FXML
    void showBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

            this.bookingList.getItems().add(0,UserBookingViewController.passenger.getBooking().getToString());
            this.bookingList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        } else {

            System.out.println("El cliente no tiene reservas"); //alerta

        }
    }

    @FXML
    void generateBooking(ActionEvent event) {

        if (UserBookingViewController.passenger.getBooking() != null) {

            System.out.println("Tiene una reserva"); //alerta
        } else {

            LocalDate firstDate = this.firstDatePicker.getValue();
            LocalDate secondDate = this.secondDatePicker.getValue();

            if (firstDate == null || secondDate == null) {

                System.out.println("Tiene que seleccionar ambos campos de fechas"); //alerta
            } else {

                if (secondDate.isAfter(firstDate)) {

                    if (firstDate.isBefore(LocalDate.now())) {

                        System.out.println("La fecha de inicio debe ser como mínimo hoy."); //alerta
                    } else {

                        if (this.oneBedroomCheckBox.isSelected()) {

                            Room room = Main.hotelData.searchAvailableRoom(firstDate, secondDate, 1);
                            if (room != null) {

                                Booking booking = new Booking(LocalDate.now(), UserBookingViewController.passenger, room, firstDate, secondDate);
                                Main.hotelData.setNewBooking(UserBookingViewController.passenger, room, booking);
                            } else {

                                System.out.println("No hay habitaciones disponibles en esa fecha"); //Alerta
                            }
                        } else if (this.twoBedroomsCheckBox.isSelected()) {

                            Room room = Main.hotelData.searchAvailableRoom(firstDate, secondDate, 2);
                            if (room != null) {

                                Booking booking = new Booking(LocalDate.now(), UserBookingViewController.passenger, room, firstDate, secondDate);
                                Main.hotelData.setNewBooking(UserBookingViewController.passenger, room, booking);
                            } else {

                                System.out.println("No hay habitaciones disponibles en esa fecha"); //Alerta
                            }

                        } else {

                            System.out.println("Tiene que seleccionar al menos una cantidad de habitaciones"); //alerta
                        }
                    }
                } else {

                    System.out.println("La fecha de inicio debe ser anteiror a la de salida"); //alerta
                }
            }
        }
    }

    @FXML
    void refreshListView(ActionEvent event) {

        ObservableList<String>refresh= FXCollections.observableArrayList("");
        this.bookingList.getItems().setAll(refresh);
        this.bookingList.refresh();
    }

    @FXML
    void logOut(ActionEvent event) {

        ButtonType confirm = new ButtonType("Go back", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType("Stay", ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alertDiscardChanges = new Alert(Alert.AlertType.CONFIRMATION,"",confirm,cancel);
        alertDiscardChanges.setHeaderText(null);
        alertDiscardChanges.setTitle("Confirmation");
        alertDiscardChanges.setContentText("Are you sure you want to discard the info and go back?");
        alertDiscardChanges.showAndWait();

        if (alertDiscardChanges.getResult().equals(confirm)){

            UserBookingViewController.passenger=null;
            Main.mainStage.setScene(Main.logInScene);
        }
    }

}
