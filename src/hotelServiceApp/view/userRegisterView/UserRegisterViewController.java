package hotelServiceApp.view.userRegisterView;

import hotelServiceApp.backEndCode.Main;
import hotelServiceApp.backEndCode.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class UserRegisterViewController {

    @FXML
    private TextField surname;

    @FXML
    private TextField name;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField dni;

    @FXML
    void saveUserInfo(ActionEvent event) {
        System.out.println(name.getText());
        System.out.println(surname.getText());
        System.out.println(dni.getText());

    }

}
