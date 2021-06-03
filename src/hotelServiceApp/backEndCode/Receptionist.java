package hotelServiceApp.backEndCode;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public final class Receptionist extends Person {

    private double salary;
    private List<Payment> paymentList;

    public Receptionist() {

    }

    public Receptionist(String name, String surname, String dni, String country, String address, String phone, String username, String password, double salary) {

        super(name, surname, dni, country, address, phone, username, password);
        this.salary = salary;
        this.paymentList = new ArrayList<>();
    }

    public double getSalary() {

        return salary;
    }

    public void setSalary(double salary) {

        this.salary = salary;
    }

    public List<Payment> getPaymentList() {

        return paymentList;
    }

    public void setPaymentList(Payment payment) {

        this.paymentList.add(payment);
    }

    /**
     * public Boolean confirmReceptionistAccess(String username, String password)
     * This method confirms the receptionist access into an event handler.
     * It checks if the username and the password matches the instanced ones.
     */
    public Boolean confirmReceptionistAccess(String username, String password) {

        Boolean confirm = false;
        if (super.getUsername().equals(username) && super.getPassword().equals(password)) {

            confirm = true;
        }
        return confirm;

    }

    /**
     * public ObservableList<Payment> getPaymentsObservableList()
     * This method returns all the payments of the receptionist a an observable list to be used on a list view then.
     */
    public ObservableList<Payment> getPaymentsObservableList() {

        ObservableList<Payment> payments = FXCollections.observableList(this.paymentList);
        return payments;
    }
}
