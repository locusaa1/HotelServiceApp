package hotelServiceApp.view.receptionistMenu;

import hotelServiceApp.backEndCode.*;
import hotelServiceApp.view.alerts.Alerts;
import hotelServiceApp.view.modifyUserPanel.ModifyUserPanelController;
import hotelServiceApp.view.newUserPanel.NewUserPanelController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReceptionistMenuController {

    public static Receptionist receptionist;
    public static List<Passenger> passengerList = new ArrayList<>();
    public static Integer check;

    @FXML
    private Button checkOutButton;

    @FXML
    private TextField amountOfPassengersToCheck;

    @FXML
    private TextField dniGeneralPassengerField;

    @FXML
    private Button checkInButton;

    @FXML
    private TextField roomNumberField;

    @FXML
    private Button generateOccupationButton;

    @FXML
    private TextField amountOfPassengersField;

    @FXML
    private Button showPassengerInfoButton;

    @FXML
    private Button showRoomInfoButton;

    @FXML
    private TextField amountOfRoomsField;

    @FXML
    private Button showPassengerReviewsButton;

    @FXML
    private Button isAvailableButton;

    @FXML
    private Button showAllRoomsInfoButton;

    @FXML
    private Button logOutButton;

    @FXML
    private DatePicker datePickerField;

    @FXML
    private Button editPassengerInfoButton;

    @FXML
    private TextField dniHostedPassengerField;

    @FXML
    private ListView<String> passengerInfoListView = new ListView<>();

    @FXML
    private ListView<Room> roomListView = new ListView<>();

    @FXML
    private ListView<PassengerReview> passengerReviewsListView = new ListView<>();

    @FXML
    private Button itemsMenuButton;

    /**
     * void checkIn(ActionEvent event)
     * This method is an event handler used when the checkIn button is pressed.
     * It lets confirm a checkIn and add all the passengers of the group into the HotelData.
     * It checks for every possible failure.
     */
    @FXML
    void checkIn(ActionEvent event) {

        if (Main.hotelData.passengerExists(this.dniHostedPassengerField.getText()).equals(true)) {

            Passenger passenger = Main.hotelData.dniSearchPassenger(this.dniHostedPassengerField.getText());

            try {

                this.check = Integer.parseInt(this.amountOfPassengersToCheck.getText());

                if (passenger.getBooking() != null) {

                    if (this.check < passenger.getBooking().getRoom().getMaxCapacity()) {

                        if (passenger.getBooking().getCheckin().equals(LocalDate.now())) {

                            ReceptionistMenuController.passengerList.removeAll(ReceptionistMenuController.passengerList);
                            ReceptionistMenuController.passengerList.add(passenger);

                            this.launchPassengersLoad(this.check);

                            double total = passenger.getBooking().getRoom().getPrice() * (passenger.getBooking().getCheckout().getDayOfYear() - passenger.getBooking().getCheckin().getDayOfYear());

                            if (Alerts.confirmationAlert("Yes", "No", "CheckIn", "The total amount of the occupation is: " + total +
                                    "\n Are you sure you want to save the Occupation?.")) {

                                Occupation occupation = new Occupation(passenger.getBooking(), ReceptionistMenuController.passengerList, total);
                                Main.hotelData.setCheckIn(passenger, occupation, ReceptionistMenuController.passengerList);
                                Alerts.infoAlert("Congrats", "The occupation was successfully created", "close");
                            }
                        } else {

                            Alerts.errorAlert("Error", "The check in date is: " + passenger.getBooking().getCheckin(), "close");
                        }
                    } else {

                        Alerts.errorAlert("Error", "The amount of passengers exceed the max capacity room", "close");
                    }
                } else {

                    Alerts.errorAlert("Error", "The passenger does not have a booking to check in.", "close");
                }
            } catch (NumberFormatException | IOException exception) {

                Alerts.errorAlert("Error", "The amount must be a number!", "close");
            }
        } else {

            Alerts.errorAlert("Error", "The dni does not exists or the field is empty!", "close");
        }
    }

    /**
     * void checkOut(ActionEvent event)
     * This method is an event handler used when the checkOut button is pressed.
     * It confirms a checkOut an sets all the passengers out of the room and modify all the needed info.
     * It checks for every possible failure.
     */
    @FXML
    void checkOut(ActionEvent event) {

        if (Main.hotelData.passengerExists(this.dniHostedPassengerField.getText()).equals(true)) {

            Passenger passenger = Main.hotelData.dniSearchPassenger(this.dniHostedPassengerField.getText());

            if (passenger.getHosted().equals(true)) {

                if (passenger.getBooking() != null) {

                    if (Alerts.confirmationAlert("Yes", "No", "ChekOut", "Are you sure to check-out the group")) {

                        double total = passenger.getRoom().getTotalPurchases();
                        Main.hotelData.setCheckOut(passenger, total);
                        Alerts.infoAlert("Congrats", "The check-out was successfully done" +
                                "\n You got a total of: $" + total + " from the group purchases!", "close");
                    }
                } else {

                    Alerts.errorAlert("Error", "The passenger is not the responsible of the check-out", "close");
                }
            } else {

                Alerts.errorAlert("Error", "The passenger is not hosted in the hotel yet.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "The dni does not exist or the field is empty", "close");
        }
    }

    /**
     * void generateOccupation(ActionEvent event)
     * This method is an event handler used when the generateOccupation is pressed.
     * It lets the receptionist sets a new Occupation at the moment.
     * Also it lets the receptionist adds every passenger with all the info into the HotelData.
     */
    @FXML
    void generateOccupation(ActionEvent event) {

        if (this.datePickerField.getValue() != null) {

            if (LocalDate.now().isBefore(this.datePickerField.getValue())) {

                try {

                    int amountOfRooms = Integer.parseInt(this.amountOfRoomsField.getText());
                    int amountOfPassengers = Integer.parseInt(this.amountOfPassengersField.getText());

                    Room room = Main.hotelData.searchAvailableRoom(LocalDate.now(), this.datePickerField.getValue(), amountOfRooms, amountOfPassengers);
                    ReceptionistMenuController.passengerList.removeAll(ReceptionistMenuController.passengerList);
                    if (room != null) {

                        this.check = amountOfPassengers;
                        this.launchPassengersLoad(this.check);

                        Booking booking = new Booking(LocalDate.now(), ReceptionistMenuController.passengerList.get(0), room, LocalDate.now(), this.datePickerField.getValue());
                        double total = booking.getRoom().getPrice() * (booking.getCheckout().getDayOfYear() - booking.getCheckin().getDayOfYear());

                        if (Alerts.confirmationAlert("Yes", "No", "New Occupation", "The total amount of the occupation is: " + total +
                                "\n Are you sure you want to save the Occupation?.")) {

                            Occupation occupation = new Occupation(booking, ReceptionistMenuController.passengerList, total);
                            Main.hotelData.setNewBooking(ReceptionistMenuController.passengerList.get(0), room, booking);
                            Main.hotelData.setCheckIn(booking.getPassenger(), occupation, ReceptionistMenuController.passengerList);
                            Alerts.infoAlert("Congrats", "The occupation was successfully created", "close");
                        }
                    } else {

                        Alerts.errorAlert("Error", "There is not an available room in the date range selected.", "close");
                    }
                } catch (NumberFormatException | IOException exception) {

                    Alerts.errorAlert("Error", "The amount of passengers and rooms are numbers!", "close");
                }
            } else {

                Alerts.errorAlert("Error", "The selected must be after today", "close");
            }
        } else {

            Alerts.errorAlert("Error", "You have to select a date.", "close");
        }
    }

    /**
     * void isAvailable(ActionEvent event)
     * This method is an event handler used when the is available button is pressed.
     * It shows an alert if the room is available or if there was a problem searching for it.
     */
    @FXML
    void isAvailable(ActionEvent event) {

        try {

            int roomNumber = Integer.parseInt(this.roomNumberField.getText());
            Room room = Main.hotelData.searchRoomNumber(roomNumber);

            if (room != null) {

                if (room.isAvailable()) {

                    Alerts.infoAlert("Congrats", "The room found is available.", "close");
                } else {

                    Alerts.errorAlert("Not available", "The room found is not available.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "The room does not exists.", "close");
            }
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The room number is empty or incorrect.", "close");
        }
    }

    /**
     * void showRoomInfo(ActionEvent event)
     * This method is an event handler user when the showRoomInfo button is pressed.
     * It shows all the info of the room found into the list view.
     */
    @FXML
    void showRoomInfo(ActionEvent event) {

        try {

            int roomNumber = Integer.parseInt(this.roomNumberField.getText());
            Room room = Main.hotelData.searchRoomNumber(roomNumber);

            if (room != null) {

                this.roomListView.getItems().setAll(room);
                this.roomListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            } else {

                Alerts.errorAlert("Error", "The room does not exists.", "close");
            }
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The room number is empty or incorrect.", "close");
        }
    }

    /**
     * void showAllRoomsInfo(ActionEvent event)
     * This method is an event handler used when the showAllRoomsInfo button is pressed.
     * It shows all the info from all the rooms into the list view.
     */
    @FXML
    void showAllRoomsInfo(ActionEvent event) {

        this.roomListView.getItems().setAll(Main.hotelData.returnAllTheRooms());
        this.roomListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /**
     * void showPassengerInfo(ActionEvent event)
     * This method is an event handler used when the showPassengerInfo button is pressed.
     * It shows all the info of the passenger found into the list view.
     */
    @FXML
    void showPassengerInfo(ActionEvent event) {

        try {

            int dni = Integer.parseInt(this.dniGeneralPassengerField.getText());
            Passenger passenger = Main.hotelData.dniSearchPassenger(this.dniGeneralPassengerField.getText());

            if (passenger != null) {

                this.passengerInfoListView.getItems().setAll(passenger.toString());
            } else {

                Alerts.errorAlert("Error", "The passenger does not exists.", "close");
            }
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The dni must be a number.", "close");
        }
    }

    /**
     * void showPassengerReviews(ActionEvent event)
     * This method is an event handler used when the showPassengerReviews button is pressed.
     * It shows all the passengerRevies into the list view.
     */
    @FXML
    void showPassengerReviews(ActionEvent event) {

        try {

            int dni = Integer.parseInt(this.dniGeneralPassengerField.getText());
            Passenger passenger = Main.hotelData.dniSearchPassenger(this.dniGeneralPassengerField.getText());

            if (passenger != null) {

                if (passenger.getPassengerReviews().size() > 0) {

                    this.passengerReviewsListView.getItems().setAll(passenger.getPassengerReviews());
                } else {

                    Alerts.errorAlert("Error", "The passenger does not have reviews to show.", "close");
                }
            } else {

                Alerts.errorAlert("Error", "The passenger does not exists.", "close");
            }
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The dni must be a number.", "close");
        }
    }

    /**
     * void editPassengerInfo(ActionEvent event)
     * This method is an event handler used when the editPassengerInfo button is pressed.
     * It allows the receptionist to change every field of the passenger information.
     */
    @FXML
    void editPassengerInfo(ActionEvent event) {

        try {

            int dni = Integer.parseInt(this.dniGeneralPassengerField.getText());
            Passenger passenger = Main.hotelData.dniSearchPassenger(this.dniGeneralPassengerField.getText());

            if (passenger != null) {

                ModifyUserPanelController.passenger = passenger;
                this.launchPassengerEdit();
            } else {

                Alerts.errorAlert("Error", "The passenger does not exists.", "close");
            }
        } catch (NumberFormatException | IOException exception) {

            Alerts.errorAlert("Error", "The dni must be a number.", "close");
        }
    }

    /**
     * void logOut(ActionEvent event)
     * This method is an event handler used when the logOut button is pressed.
     * It allows the user to logOut his account.
     */
    @FXML
    void logOut(ActionEvent event) {

        if (Alerts.confirmationAlert("Yes", "No", "logOut", "Are you sure you want to log out?")) {

            Main.mainStage.setScene(Main.logInScene);
        }
    }

    /**
     * void showItemsMenu(ActionEvent event)
     * This method is an event handler used when the itemsMenu button is pressed.
     * It opens the items menu for the receptionist calling the launchItemsMenu method
     */
    @FXML
    void showItemsMenu(ActionEvent event) throws IOException {

        this.launchItemsMenu();
    }

    /**
     * public void launchPassengersLoad(int amountOfPassengers)
     * This method creates and makes a loop launching the window to load new passengers into the HotelData.
     */
    public void launchPassengersLoad(int amountOfPassengers) throws IOException {

        while (ReceptionistMenuController.passengerList.size() < amountOfPassengers) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../newUserPanel/NewUserPanel.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("New Passenger");
            stage.setScene(new Scene(root, 600, 400));
            NewUserPanelController.stage = stage;
            NewUserPanelController.stage.showAndWait();
        }
    }

    /**
     * public void launchItemsMenu()
     * This method creates and launch the itemsMenu in a new window.
     */
    public void launchItemsMenu() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../itemsMenu/ItemsMenu.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Items Menu");
        stage.setScene(new Scene(root, 800, 600));
        stage.showAndWait();
    }

    /**
     * public void launchPassengerEdit()
     * This method creates and launch the passengerEdit window.
     */
    public void launchPassengerEdit() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../modifyUserPanel/ModifyUserPanel.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Editing Passenger");
        stage.setScene(new Scene(root, 600, 400));
        ModifyUserPanelController.stage = stage;
        ModifyUserPanelController.stage.showAndWait();
    }
}