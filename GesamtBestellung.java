import java.math.BigDecimal;

public class GesamtBestellung {
    
    private String name;
    private String charakter;
    private String waffe;
    private String rucksack;
    private int anzahl;
    private BigDecimal preis;

    public GesamtBestellung(String name, String charakter, String waffe, String rucksack, int anzahl,
            BigDecimal preis) {
        this.name = name;
        this.charakter = charakter;
        this.waffe = waffe;
        this.rucksack = rucksack;
        this.anzahl = anzahl;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharakter() {
        return charakter;
    }

    public void setCharakter(String charakter) {
        this.charakter = charakter;
    }

    public String getWaffe() {
        return waffe;
    }

    public void setWaffe(String waffe) {
        this.waffe = waffe;
    }

    public String getRucksack() {
        return rucksack;
    }

    public void setRucksack(String rucksack) {
        this.rucksack = rucksack;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public BigDecimal getPreis() {
        return preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }


    
}
