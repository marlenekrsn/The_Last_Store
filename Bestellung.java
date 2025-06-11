import java.math.BigDecimal;

//Diese Klass ist ein Abbild der Datenbanktabelle Bestellungen
public class Bestellung {
    //Attribute
    private int kid;
    private int fid;
    private String zahlungsart;
    private BigDecimal preis;

    public Bestellung(int kid, int fid, String zahlungsart, BigDecimal preis) {
        this.kid = kid;
        this.fid = fid;
        this.zahlungsart = zahlungsart;
        this.preis = preis;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getZahlungsart() {
        return zahlungsart;
    }

    public void setZahlungsart(String zahlungsart) {
        this.zahlungsart = zahlungsart;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    

    

    
    

}
