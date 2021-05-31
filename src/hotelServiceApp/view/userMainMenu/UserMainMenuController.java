package hotelServiceApp.view.userMainMenu;

import hotelServiceApp.backEndCode.*;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserMainMenuController {

    public static Passenger passenger;

    @FXML
    private ListView<SupplyItem> hotelItemsList = new ListView<>();

    @FXML
    private Button logOutButton;

    @FXML
    private Button foodButton;

    @FXML
    private Button sodaButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button drinksButton;

    @FXML
    private Button specialRoomsButton;

    @FXML
    private ListView<SupplyItem> cartItemsList = new ListView<>();

    @FXML
    private Label label;

    @FXML
    private Button extraServicesButton;

    @FXML
    private Button purchaseButton;

    @FXML
    private Button addItemsButton;

    /**
     * void logOut(ActionEvent event)
     * This method is an event handler used when the logOut button is pressed by the user.
     * It confirms the logOut.
     */
    @FXML
    void logOut(ActionEvent event) {

        if (Alerts.confirmationAlert("logOut", "Stay", "Confirmation", "Are you sure you want to logOut?")) {
            Main.mainStage.setScene(Main.logInScene);
        }
    }

    /**
     * void setFoodInListView(ActionEvent event)
     * This method is an event handler used when the food button is pressed by the user.
     * It sets all the items that were checked in the getItemsInStock method and returned.
     */
    @FXML
    void setFoodInListView(ActionEvent event) {

        this.hotelItemsList.setItems(Main.hotelData.getItemsInStock(SupplySections.FOOD));
        this.hotelItemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * void setSodaInListView(ActionEvent event)
     * This method is an event handler used when the soda button is pressed by the user.
     * It sets all the items that were checked in the getItemsInStock method and returned.
     */
    @FXML
    void setSodaInListView(ActionEvent event) {

        this.hotelItemsList.setItems(Main.hotelData.getItemsInStock(SupplySections.SODA));
        this.hotelItemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * void setDrinksInListView(ActionEvent event)
     * This method is an event handler used when the drinks button is pressed by the user.
     * It sets all the items that were checked in the getItemsInStock method and returned.
     */
    @FXML
    void setDrinksInListView(ActionEvent event) {

        this.hotelItemsList.setItems(Main.hotelData.getItemsInStock(SupplySections.DRINKS));
        this.hotelItemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * void addItemsToCartList(ActionEvent event)
     * This method is an event handler used when the addItems button is pressed by the user.
     * It sets in the cart list all the items selected in the hotel list.
     */
    @FXML
    void addItemsToCartList(ActionEvent event) {

        if (this.hotelItemsList.getItems().size() > 0) {

            if (this.hotelItemsList.getSelectionModel().getSelectedItems().size() > 0) {

                this.cartItemsList.getItems().addAll(this.hotelItemsList.getSelectionModel().getSelectedItems());
            } else {

                Alerts.errorAlert("Error", "There is nothing selected.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "There is nothing in the list to add.", "close");
        }
    }

    /**
     * void setExtraServicesInListView(ActionEvent event)
     * This method is an event handler used when the extraServices button is pressed by the user.
     * It sets all the items that were checked in the getItemsInStock method and returned.
     */
    @FXML
    void setExtraServicesInListView(ActionEvent event) {

        this.hotelItemsList.setItems(Main.hotelData.getItemsInStock(SupplySections.EXTRASERVICES));
        this.hotelItemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * void setSpecialRoomsInListView(ActionEvent event)
     * This method is an event handler used when the specialRooms button is pressed by the user.
     * It sets all the items that were checked in the getItemsInStock method and returned.
     */
    @FXML
    void setSpecialRoomsInListView(ActionEvent event) {

        this.hotelItemsList.setItems(Main.hotelData.getItemsInStock(SupplySections.SPECIALROOMS));
        this.hotelItemsList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * void removeFromCartList(ActionEvent event)
     * This method is an event handler used when the remove button is pressed by the user.
     * It removes the first item of the cart list based on the selected one.
     */
    @FXML
    void removeFromCartList(ActionEvent event) {

        if (this.cartItemsList.getItems().size() > 0) {

            if (this.cartItemsList.getSelectionModel().getSelectedItems().size() > 0) {

                this.cartItemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                this.cartItemsList.getItems().remove(this.cartItemsList.getSelectionModel().getSelectedItem());
            } else {

                Alerts.errorAlert("Error", "Theres is nothing selected.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "There is nothing in the list to be removed.", "close");
        }
    }

    /**
     * void confirmPurchase(ActionEvent event)
     * This method is an event handler used when the purchase button is pressed by the user.
     * It throws a confirmation alert to the user to set the purchase or stay and change items.
     */
    @FXML
    void confirmPurchase(ActionEvent event) {

        if (this.cartItemsList.getItems().size() > 0) {

            Purchase purchase = new Purchase(LocalDate.now(), UserMainMenuController.passenger.getRoom(), UserMainMenuController.passenger, this.getSupplyItemsArrayList());
            if (Alerts.confirmationAlert("Buy", "Change items", "Confirmaiton", "Date: " + LocalDate.now() + "\n" +
                    "Purchase total: " + purchase.totalPrice() + "\n" + "Do you want to confirm the purchase?")) {

                Main.hotelData.setNewPurchase(UserMainMenuController.passenger, purchase);
                Alerts.infoAlert("Congrats", "Wait for the room service to deliver your order!", "close");

            }
        } else {

            Alerts.errorAlert("Error", "There is nothing in the list to buy.", "close");
        }
    }

    /**
     * public ArrayList<SupplyItem> getSupplyItemsArrayList()
     * This method returns an ArrayList of the cart items to be added in the purchase of the passenger.
     * This method is required because we prefer use arrayList after the collector returning a list.
     */
    public ArrayList<SupplyItem> getSupplyItemsArrayList() {

        return (ArrayList<SupplyItem>) this.cartItemsList.getItems().stream().collect(Collectors.toList());
    }

}
