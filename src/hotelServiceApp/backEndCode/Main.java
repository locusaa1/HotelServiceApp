package hotelServiceApp.backEndCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    public static Stage mainStage;
    public static Scene logInScene;
    public static HotelData hotelData;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/logInview/LogIn.fxml"));
        this.mainStage = primaryStage;
        this.logInScene = new Scene(root,800,600);
        primaryStage.setTitle("Hotel Service App");
        primaryStage.setScene(this.logInScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Main.hotelData = new HotelData();
        Passenger p = new Passenger("carlos","garcia","111","USA","Calle 40","223","carlitos","123");
        Room room = new Room(1,5,500);
        Booking booking = new Booking(LocalDate.now(),p,room,LocalDate.now().plusDays(1),LocalDate.now().plusDays(2));
        p.setBooking(booking);
        Main.hotelData.setBookingList(booking);
        Main.hotelData.setRoomList(room);
        Main.hotelData.setPassengerList(p);
        launch(args);
    }
}
