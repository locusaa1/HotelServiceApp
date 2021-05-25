package hotelServiceApp.backEndCode;

import com.sun.deploy.panel.ExceptionListDialog;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class HotelData {

    private List<Passenger> passengerList;

    public HotelData() {

        this.passengerList = new ArrayList<>();
    }

    public List<Passenger> getPassengerList() {

        return passengerList;
    }

    public void setPassengerList(Passenger passenger) {

        this.passengerList.add(passenger);
    }

    public Passenger getPassenger(int index) {

        return this.passengerList.get(index);
    }

    /**public Boolean passengerExists(String dni)
     *This method searches in the passengerList of the HotelData if the dni in the parameter is already saved on a existing passenger.*/

    public Boolean passengerExists(String dni) {

        Boolean confirm = false;
        for (Passenger p : this.passengerList) {
            if (p.getDni().equals(dni)) {
                confirm = true;
            }
        }
        return confirm;
    }

    /**public Boolean usernameExists(String username)
     *This method searches in the PassengerList of the HotelData if the username is already taken.*/

    public Boolean usernameExists(String username) {

        Boolean confirm = false;
        for (Passenger p : this.passengerList) {
            if (p.getUsername().equals(username)) {
                confirm = true;
            }
        }
        return confirm;
    }

    /**public Passenger usernameSearchPassenger(String username)
     *This method searches in the PassengerList of the HotelData and return the passenger.
     *We assume that the passenger already exists. It needs to be checked first using the method passengerExists.*/

    public Passenger usernameSearchPassenger(String username) {

        Passenger passenger = null;
        for (Passenger p : this.passengerList) {
            if (p.getUsername().equals(username)) {
                passenger = p;
            }
        }
        return passenger;
    }

    /**public Boolean confirmPassword(String password, Passenger passenger)
     *This method confirms if the password parameter matches the passenger parameter password*/

    public Boolean confirmPassword(String password, Passenger passenger) {

        Boolean confirm = false;
        if (passenger.getPassword().equals(password)) {
            confirm = true;
        }
        return confirm;
    }
}
