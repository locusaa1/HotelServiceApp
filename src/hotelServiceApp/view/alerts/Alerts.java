package hotelServiceApp.view.alerts;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

public class Alerts {

    /**
     * public static void errorAlert(String title, String content, String closeButton)
     * This static method lets the developer to throw an error alert and prevent the app to crash or get corrupted data
     */
    public static void errorAlert(String title, String content, String closeButton) {

        ButtonType close = new ButtonType(closeButton, ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.ERROR, content, close);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.showAndWait();
    }

    /**
     * public static void infoAlert(String title, String content, String closeButton)
     * This method lets the developer throw an instructive alert and informs the user.
     */
    public static void infoAlert(String title, String content, String closeButton) {

        ButtonType close = new ButtonType(closeButton, ButtonBar.ButtonData.OK_DONE);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, content, close);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.showAndWait();
    }

    /**
     * public static Boolean confirmationAlert(String confirmButton, String cancelButton, String title, String content)
     * This method lets the developer throw a confirmation alert to the user to use in conditionals.
     * We thought that returning a Boolean could be easier to manipulate.
     */
    public static Boolean confirmationAlert(String confirmButton, String cancelButton, String title, String content) {

        Boolean confirmation = false;
        ButtonType confirm = new ButtonType(confirmButton, ButtonBar.ButtonData.OK_DONE);
        ButtonType cancel = new ButtonType(cancelButton, ButtonBar.ButtonData.CANCEL_CLOSE);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, content, confirm, cancel);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.showAndWait();

        if (alert.getResult().equals(confirm)) {

            confirmation = true;
        }

        return confirmation;
    }
}
