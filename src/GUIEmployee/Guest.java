package GUIEmployee;

/**
 * Created by Izabela on 2017-01-08.
 */
public class Guest {

    private String login;
    private String name;
    private String surname;
    private String PESEL;
    private String IDNumber;

    public Guest (String login, String name, String surname, String PESEL, String IDNumber){
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.IDNumber = IDNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    @Override
    public String toString(){
        return String
                .format("Guest [login=%s, name=%s, surname=%s, PESEL=%s, IDNumber=%s]",
                        login, name, surname, PESEL, IDNumber);
    }


}