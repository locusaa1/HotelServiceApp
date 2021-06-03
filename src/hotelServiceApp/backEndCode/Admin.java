package hotelServiceApp.backEndCode;

public final class Admin extends Person {

    private double hotelTotalCash;

    public Admin() {

    }

    public Admin(String name, String surname, String dni, String country, String address, String phone, String username, String password, double hotelTotalCash) {

        super(name, surname, dni, country, address, phone, username, password);
        this.hotelTotalCash = hotelTotalCash;
    }

    public double getHotelTotalCash() {

        return this.hotelTotalCash;
    }

    public void setHotelTotalCash(double hotelTotalCash) {

        this.hotelTotalCash = hotelTotalCash;
    }

    /**
     * public Boolean confirmAdminAccess(String username, String password)
     * This method is used to confirm the admin access into an event handler.
     * It compares if the username and password in parameters are the same of the admin in the HotelData
     */
    public Boolean confirmAdminAccess(String username, String password) {

        Boolean confirm = false;

        if (super.getUsername().equals(username) && super.getPassword().equals(password)) {

            confirm = true;
        }
        return confirm;
    }
}
