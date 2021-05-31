package hotelServiceApp.backEndCode;

public abstract class Person {

    protected String name;
    protected String surname;
    protected String dni;
    protected String country;
    protected String address;
    protected String phone;
    protected String username;
    protected String password;

    public Person() {

    }

    public Person(String name, String surname, String dni, String country, String address, String phone, String username, String password) {

        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.country = country;
        this.address = address;
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

        return address;
    }

    public void setAdress(String adress) {

        this.address = adress;
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

    /**
     * public String toString()
     * This method returns all the info of the class in String type.
     */
    @Override
    public String toString(){
        return "User information: " + "\n" +
                "Name: " + this.name + "\n" +
                "Surname: " + this.surname + "\n" +
                "Dni: " + this.dni + "\n" +
                "Country: " + this.country + "\n" +
                "Address: " + this.address + "\n" +
                "Phone: " + this.phone + "\n" +
                "Username: " + this.username;
    }
}
