package hotelServiceApp.backEndCode;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class GSONWritingToFile {

    /**
     * public static void writeToFileHotelData()
     * This method is an example of how to write a file using the library downloaded.
     */
    public static void writeToFileHotelData() {
        Gson gson = new Gson();
        String json = gson.toJson(Main.hotelData);
        try {
            FileWriter writer = new FileWriter("C:hotelData.json");
            writer.write(json);
            writer.close();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}