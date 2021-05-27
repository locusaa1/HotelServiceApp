package hotelServiceApp.backEndCode;

public final class Admin extends Person{

    public Admin() {
    }

    public Admin(String name, String surname, String dni, String country, String address, String phone, String username, String password) {
        super(name, surname, dni, country, address, phone, username, password);
    }

    @Override
    public String toString(){
        return "Administrator User" +
                super.toString();
    }
}
