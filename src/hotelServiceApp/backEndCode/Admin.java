package hotelServiceApp.backEndCode;

public final class Admin extends Person implements AdminUtilies{
    public Admin() {
    }

    public Admin(String name, String surname, String dni, String country, String address, String phone, String username, String password) {
        super(name, surname, dni, country, address, phone, username, password);
    }

}
