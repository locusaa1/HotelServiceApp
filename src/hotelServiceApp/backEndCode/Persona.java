package hotelServiceApp.backEndCode;

public class Persona {

    String name;
    String surname;
    String dni;

    public Persona (){

    }

    public Persona(String name, String surname, String dni){
        this.name=name;
        this.surname=surname;
        this.dni=dni;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDni() {
        return dni;
    }
}
