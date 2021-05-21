package hotelServiceApp.backEndCode;

public abstract class Person {

    private String name;
    private String surname;
    private String dni;
    private String country;
    private String adress;
    private String phone;
    private String username;
    private String password;

    public Person() {

    }

    public Person(String name, String surname, String dni, String country, String adress, String phone, String username, String password) {

        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.country = country;
        this.adress = adress;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {

        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public String getDni() {

        return dni;
    }

    public void setDni(String dni) {

        this.dni = dni;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public String getAdress() {

        return adress;
    }

    public void setAdress(String adress) {

        this.adress = adress;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
