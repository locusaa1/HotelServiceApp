package hotelServiceApp.backEndCode;

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

    public Passenger getPassenger(int index){

        return this.passengerList.get(index);
    }

    public Boolean passengerExists(String dni) {

        Boolean confirm = false;
        for (Passenger p : this.passengerList) {
            if (p.getDni().equals(dni)) {
                confirm = true;
            }
        }
        return confirm;
    }

    public Boolean usernameExists(String username) {

        Boolean confirm = false;
        for (Passenger p : this.passengerList) {
            if (p.getUsername().equals(username)) {
                confirm = true;
            }
        }
        return confirm;
    }
}
