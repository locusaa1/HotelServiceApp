package hotelServiceApp.view.itemsMenu;

import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.SupplyItem;
import hotelServiceApp.backEndCode.SupplySections;
import hotelServiceApp.view.alerts.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ItemsMenuController {

    @FXML
    private MenuItem sodaMenu;

    @FXML
    private MenuItem specialRoomsMenu;

    @FXML
    private Button modifyButton;

    @FXML
    private MenuItem foodMenu;

    @FXML
    private MenuItem drinksMenu;

    @FXML
    private Button removeButton;

    @FXML
    private Button confirmButton;

    @FXML
    private MenuItem extraServicesMenu;

    @FXML
    private ListView<SupplyItem> itemsList;

    @FXML
    private TextField nameField;

    @FXML
    private TextField stockField;

    @FXML
    private TextField descField;

    @FXML
    private TextField priceField;

    @FXML
    private SplitMenuButton sectionMenu;

    /**
     * void setOnFood(ActionEvent event)
     * This method is an event handler used when the foodMenu button is pressed.
     * It sets all the food items into the listView
     */
    @FXML
    void setOnFood(ActionEvent event) {

        this.itemsList.setItems(Main.hotelData.returnAllSectionItems(SupplySections.FOOD));
        this.itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.sectionMenu.setText(SupplySections.FOOD.name());
    }

    /**
     * void setOnSoda(ActionEvent event)
     * This method is an event handler used when the sodaMenu button is pressed.
     * It sets all the soda items into the listView.
     */
    @FXML
    void setOnSoda(ActionEvent event) {

        this.itemsList.setItems(Main.hotelData.returnAllSectionItems(SupplySections.SODA));
        this.itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.sectionMenu.setText(SupplySections.SODA.name());
    }

    /**
     * void setOnDrinks(ActionEvent event)
     * This method is an event handler used when the drinksMenu button is pressed.
     * It sets all the drinks items into the listView.
     */
    @FXML
    void setOnDrinks(ActionEvent event) {

        this.itemsList.setItems(Main.hotelData.returnAllSectionItems(SupplySections.DRINKS));
        this.itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.sectionMenu.setText(SupplySections.DRINKS.name());
    }

    /**
     * void setOnExtraServices(ActionEvent event)
     * This method is an event handler used when the extraServicesMenu button is pressed.
     * It sets all the extraServices items into the listView.
     */
    @FXML
    void setOnExtraServices(ActionEvent event) {

        this.itemsList.setItems(Main.hotelData.returnAllSectionItems(SupplySections.EXTRASERVICES));
        this.itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.sectionMenu.setText(SupplySections.EXTRASERVICES.name());
    }

    /**
     * void setOnSpecialRooms(ActionEvent event)
     * This method is an event handler used when the specialRoomsMenu button is pressed.
     * It sets all the specialRooms items into the listView.
     */
    @FXML
    void setOnSpecialRooms(ActionEvent event) {

        this.itemsList.setItems(Main.hotelData.returnAllSectionItems(SupplySections.SPECIALROOMS));
        this.itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        this.sectionMenu.setText(SupplySections.SPECIALROOMS.name());
    }

    /**
     * void confirmItem(ActionEvent event)
     * This method is an event handler used then the confirm button is pressed.
     * It sets a new item into the current section selected.
     */
    @FXML
    void confirmItem(ActionEvent event) {

        try {

            double firstTry = Double.parseDouble(this.priceField.getText());
            int secondTry = Integer.parseInt(this.stockField.getText());

            SupplyItem item = new SupplyItem(SupplySections.convertString(this.sectionMenu.getText()),
                    this.nameField.getText(),
                    firstTry,
                    secondTry,
                    this.descField.getText());

            Main.hotelData.setSupplyItemList(item);
            Alerts.infoAlert("Congrats", "The item was added successfully", "close");
        } catch (NumberFormatException exception) {

            Alerts.errorAlert("Error", "The price and stock must be a number.", "close");
        }
    }

    /**
     * void removeItem(ActionEvent event)
     * This method is an event handler used when the remove button is pressed.
     * It removes permanently an item from the list into the HotelData.
     */
    @FXML
    void removeItem(ActionEvent event) {

        if (this.itemsList.getItems().size() > 0) {

            if (this.itemsList.getSelectionModel().getSelectedItems() != null) {

                this.itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                Main.hotelData.getSupplyItemList().remove(this.itemsList.getSelectionModel().getSelectedItem());
                this.itemsList.getItems().removeAll(this.itemsList.getSelectionModel().getSelectedItem());
                Alerts.infoAlert("Congrats", "The item was successfully removed", "close");
            } else {

                Alerts.errorAlert("Error", "There is nothing selected.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "There is nothing in the list to remove", "close");
        }
    }

    /**
     * void modifyItem(ActionEvent event)
     * This method is an event handler used when the modify button is pressed.
     * It allows the user to change every field of the item, even the section by selecting another one.
     */
    @FXML
    void modifyItem(ActionEvent event) {

        if (this.itemsList.getItems().size() > 0) {

            if (this.itemsList.getSelectionModel().getSelectedItems() != null) {
                SupplyItem item = this.itemsList.getSelectionModel().getSelectedItem();
                this.itemsList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                this.nameField.setText(item.getName());
                this.priceField.setText(Double.toString(item.getPrice()));
                this.stockField.setText(Integer.toString(item.getStock()));
                this.descField.setText(item.getDesc());
                Main.hotelData.getSupplyItemList().remove(this.itemsList.getSelectionModel().getSelectedItem());
                this.itemsList.getItems().removeAll(this.itemsList.getSelectionModel().getSelectedItem());
            } else {

                Alerts.errorAlert("Error", "There is nothing selected.", "close");
            }
        } else {

            Alerts.errorAlert("Error", "There is nothing in the list to remove", "close");
        }
    }

}
