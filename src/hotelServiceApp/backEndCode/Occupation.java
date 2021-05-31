package hotelServiceApp.backEndCode;

import java.util.List;


public final class Occupation {

    private Booking booking;
    private List<Passenger> passengers;
    private double occupationPrice;

    public Occupation() {

    }

    public Occupation(Booking booking, List<Passenger> passengers, double occupationPrice) {

        this.booking = booking;
        this.passengers = passengers;
        this.occupationPrice = occupationPrice;
    }

    public Booking getBooking() {

        return booking;
    }

    public void setBooking(Booking booking) {

        this.booking = booking;
    }

    public List<Passenger> getPassengers() {

        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {

        this.passengers = passengers;
    }

    public double getOccupationPrice() {

        return occupationPrice;
    }

    public void setOccupationPrice(double occupationPrice) {

        this.occupationPrice = occupationPrice;
    }

    /**
     * public StringBuilder showPassengers()
     * This method build a string appending all the passengers in the occupation.
     */
    public StringBuilder showPassengers() {
        StringBuilder aux = new StringBuilder();
        for (Passenger passenger : passengers) {
            aux.append(passenger.toString());
        }
        return aux;
    }

    /**
     * public String toString()
     * This method returns all the info of the class in String type.
     */
    @Override
    public String toString() {
        return "Ocuppation{" + "\n" +
                booking.toString() + "\n" +
                this.showPassengers() + "\n" +
                "Total amount: " + this.occupationPrice;

    }
}
