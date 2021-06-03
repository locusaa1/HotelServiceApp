package hotelServiceApp.backEndCode;

import java.time.LocalDate;

public class Payment {

    private LocalDate date;
    private double payment;
    private String description;

    public Payment() {

    }

    public Payment(LocalDate date, double payment, String description) {

        this.date = date;
        this.payment = payment;
        this.description = description;
    }

    public LocalDate getDate() {

        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public double getPayment() {

        return payment;
    }

    public void setPayment(double payment) {

        this.payment = payment;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    /**
     * public String toString()
     * This method returns all the info of the class as a String.
     */
    @Override
    public String toString() {
        return "date: " + this.date + "\n" +
                "payment: " + this.payment + "\n" +
                "description: " + this.description + "\n";
    }
}
