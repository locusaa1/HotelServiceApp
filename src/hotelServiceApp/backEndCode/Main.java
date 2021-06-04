package hotelServiceApp.backEndCode;

import hotelServiceApp.view.alerts.Alerts;
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

    /**
     * public void start(Stage primaryStage)
     * This method is override from Application in Main.
     * It's the first method executing the mainStage with the mainScene.
     * It also contains the action of the closeProgram method.
     * It has the fileReader method to read all the info from the specified file.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/logInView/LogIn.fxml"));
        this.mainStage = primaryStage;
        this.mainStage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        this.logInScene = new Scene(root, 800, 600);
        primaryStage.setTitle("Hotel Service App");
        primaryStage.setScene(this.logInScene);
        primaryStage.show();
    }

    /**
     * public void closeProgram()
     * This method is the sentence called when the mainStage is requested to be closed.
     * It has the fileWriter method to write all the info into the specified file.
     */
    public void closeProgram() {

        if (Alerts.confirmationAlert("Yes", "No", "Closing the program", "Are you sure you want to close the program?")) {

            GSONWritingToFile.writeToFileHotelData();
            this.mainStage.close();
        }
    }

    public static void main(String[] args) {

        Main.hotelData = new HotelData();
        Passenger p = new Passenger("carlos", "garcia", "111", "USA", "Calle 40", "223", "carlitos", "123");
        Room room = new Room(1, 5, 1, 500);
        Room room2 = new Room(2, 10, 2, 1000);
        Booking booking = new Booking(LocalDate.now(), p, room, LocalDate.now(), LocalDate.now().plusDays(2));
        Main.hotelData.setRoomList(room);
        Main.hotelData.setRoomList(room2);
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
        Admin admin = new Admin("leo", "gazaba", "111", "arg", "sarasa 20", "111", "admin", "admin", 10000);
        Main.hotelData.setAdmin(admin);
        Receptionist receptionist = new Receptionist("gian", "branda", "222", "arg", "asdasd", "111", "asd", "asd", 1000);
        //receptionist.setPaymentList(new Payment(LocalDate.now(), 1000, "first payment"));
        //System.out.println(receptionist.getPaymentList().get(0).toString());
        Main.hotelData.setReceptionistList(receptionist);
        GSONReadingFromFile.readFromFileHotelData();
        launch(args);

    }
}
