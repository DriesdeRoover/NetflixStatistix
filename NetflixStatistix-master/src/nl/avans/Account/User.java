package nl.avans.Account;

public class User {

    private String Email;
    private String Wachtwoord;
    private String Voornaam;
    private String Achternaam;
    private String Straat;
    private int Huisnummer;
    private String Postcode;
    private String Woonplaats;

    public User(String email, String wachtwoord,String voornaam, String achternaam, String straat, int huisnummer, String postcode, String woonplaats) {
        Email = email;
        Wachtwoord = wachtwoord;
        Achternaam = achternaam;
        Straat = straat;
        Huisnummer = huisnummer;
        Postcode = postcode;
        Woonplaats = woonplaats;
        Voornaam = voornaam;
    }


        // Getters voor gegevens
    public String getEmail() {
        return Email;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public String getVoornaam(){
        return Voornaam;
    }

    public String getAchternaam() {
        return Achternaam;
    }

    public String getStraat() {
        return Straat;
    }

    public int getHuisnummer() {
        return Huisnummer;
    }

    public String getPostcode() {
        return Postcode;
    }

    public String getWoonplaats() {
        return Woonplaats;
    }


        // Setters voor verandering van adres

    public void setWachtwoord(String wachtwoord) {
        Wachtwoord = wachtwoord;
    }

    public void setVoornaam(String voornaam){
        Voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        Achternaam = achternaam;
    }

    public void setStraat(String straat) {
        Straat = straat;
    }

    public void setHuisnummer(int huisnummer) {
        Huisnummer = huisnummer;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public void setWoonplaats(String woonplaats) {
        Woonplaats = woonplaats;
    }
}
