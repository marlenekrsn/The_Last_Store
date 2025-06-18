public class Kunde {
    private String name;
    private String adresse;
    private String ort;
    private String plz;
    private String email;

    public Kunde(String name, String adresse, String ort, String plz, String email) {
        this.name = name;
        this.adresse = adresse;
        this.ort = ort;
        this.plz = plz;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
