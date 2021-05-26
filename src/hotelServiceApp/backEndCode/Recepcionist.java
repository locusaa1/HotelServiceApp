package hotelServiceApp.backEndCode;

public final class Recepcionist extends Person implements AdminUtilies{
    public Recepcionist() {
    }

    public Recepcionist(String name, String surname, String dni, String country, String address, String phone, String username, String password) {
        super(name, surname, dni, country, address, phone, username, password);
    }

    @Override
    public String toString(){
        return "Recepcionist User" +
                super.toString();
    }
}
