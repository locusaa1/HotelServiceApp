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
        this.logInScene = new Scene(root, 800, 600);
        primaryStage.setTitle("Hotel Service App");
        primaryStage.setScene(this.logInScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Main.hotelData = new HotelData();
        Passenger p = new Passenger("carlos", "garcia", "111", "USA", "Calle 40", "223", "carlitos", "123");
        Room room = new Room(1, 5, 1, 500);
        Booking booking = new Booking(LocalDate.now(), p, room, LocalDate.now().plusDays(1), LocalDate.now().plusDays(2));
        Main.hotelData.setRoomList(room);
        p.setHosted(true);
        Main.hotelData.setPassengerList(p);
        Main.hotelData.setNewBooking(p, room, booking);
        Passenger q = new Passenger("ivan", "gonzales", "222", "USA", "Calle 40", "223", "asd", "asd");
        Main.hotelData.setPassengerList(q);
        SupplyItem item1 = new SupplyItem(SupplySections.FOOD, "Cheese Burger", 20.00, 1000, "A delicious cheese burger");
        SupplyItem item2 = new SupplyItem(SupplySections.SODA, "Coca Cola", 10.00, 3000, "Sweet MF Coca <3");
        SupplyItem item3 = new SupplyItem(SupplySections.DRINKS, "Martini", 35.00, 500, "Cocktail");
        SupplyItem item4 = new SupplyItem(SupplySections.FOOD, "Tuna", 3.00, 300, "Fishy tuna");
        SupplyItem item5 = new SupplyItem(SupplySections.FOOD, "Salmon", 15.00, 0, "Fishy luxury fishy");
        Main.hotelData.setSupplyItemList(item1);
        Main.hotelData.setSupplyItemList(item2);
        Main.hotelData.setSupplyItemList(item3);
        Main.hotelData.setSupplyItemList(item4);
        Main.hotelData.setSupplyItemList(item5);
        launch(args);
    }
}
