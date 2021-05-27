package hotelServiceApp.backEndCode;

import java.util.List;


public final class Occupation{

    private Booking booking;
    private List<Passenger> passengers;

    public Occupation() {

    }


    public Occupation(Booking booking, List<Passenger> passengers) {

        this.booking = booking;
        this.passengers = passengers;
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

    public double totalAmount() {
        double total = this.booking.getRoom().getPrice();
        for(Passenger passenger : passengers){
            total += passenger.totalPurchases();
        }
        return total;
    }

    public StringBuilder showPassangers(){
        StringBuilder aux = new StringBuilder();
        for(Passenger passenger : passengers){
            aux.append(passenger.toString());
        }
        return aux;
    }

    @Override
    public String toString(){
        return "Ocuppation{" + "\n" +
                booking.toString() + "\n" +
                this.showPassangers() + "\n" +
                "Total amount: " + this.totalAmount();

    }
}
