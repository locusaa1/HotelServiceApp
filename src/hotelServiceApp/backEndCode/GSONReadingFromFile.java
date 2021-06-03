package hotelServiceApp.backEndCode;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GSONReadingFromFile {

    /**
     * public static void readFromFileHotelData()
     * This method is an example of how to read from a file using the library downloaded.
     */
    public static void readFromFileHotelData() {

        Gson gson = new Gson();
        try {

            BufferedReader br = new BufferedReader(new FileReader("C:hotelData.json"));
            Main.hotelData = gson.fromJson(br, HotelData.class);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}
