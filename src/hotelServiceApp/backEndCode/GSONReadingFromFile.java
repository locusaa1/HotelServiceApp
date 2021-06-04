package hotelServiceApp.backEndCode;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class GSONReadingFromFile {

    /**
     * public static void readFromFileHotelData()
     * This method is an example of how to read from a file using the library downloaded.
     */
    /*public static void readFromFileHotelData() {

        Gson gson = new Gson();
        try {

            BufferedReader br = new BufferedReader(new FileReader("C:hotelData.json"));
            Main.hotelData = gson.fromJson(br, HotelData.class);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }*/

    public static void readPassengersFromFileHotelData(){

        Type PASSENGER_TYPE = new TypeToken<List<Passenger>>(){}.getType();
        Gson gson = new Gson();

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\hotelData.json"));
            List<Passenger> passengers = gson.fromJson(br, PASSENGER_TYPE);
            Main.hotelData.setPassengerEntireList(passengers);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void readBookingsFromFileHotelData(){

        Type BOOKING_TYPE = new TypeToken<List<Booking>>(){}.getType();
        Gson gson = new Gson();

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\hotelData.json"));
            List<Booking> bookings = gson.fromJson(br, BOOKING_TYPE);
            Main.hotelData.setBookingEntireList(bookings);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void readRoomsFromFileHotelData(){

        Type ROOM_TYPE = new TypeToken<List<Room>>(){}.getType();
        Gson gson = new Gson();

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\hotelData.json"));
            List<Room> rooms = gson.fromJson(br, ROOM_TYPE);
            Main.hotelData.setRoomEntireList(rooms);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void readSupplyItemsFromFileHotelData(){

        Type SUPPLY_TYPE = new TypeToken<List<SupplyItem>>(){}.getType();
        Gson gson = new Gson();

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\hotelData.json"));
            List<SupplyItem> supplyItems = gson.fromJson(br, SUPPLY_TYPE);
            Main.hotelData.setSupplyItemEntireList(supplyItems);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void readReceptionistFromFileHotelData(){

        Type RECEPTIONIST_TYPE = new TypeToken<List<Receptionist>>(){}.getType();
        Gson gson = new Gson();

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\hotelData.json"));
            List<Receptionist> receptionists = gson.fromJson(br, RECEPTIONIST_TYPE);
            Main.hotelData.setReceptionistEntireList(receptionists);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void readAdminFromFileHotelData(){

        Gson gson = new Gson();

        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\hotelData.json"));
            Admin admin = gson.fromJson(br, Admin.class);
            Main.hotelData.setAdmin(admin);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void readFromFileHotelData(){
        readPassengersFromFileHotelData();
        readBookingsFromFileHotelData();
        readRoomsFromFileHotelData();
        readSupplyItemsFromFileHotelData();
        readReceptionistFromFileHotelData();
        readAdminFromFileHotelData();
    }
}

