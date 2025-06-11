public class Figur {
    private String charakter;
    private String waffe;
    private int anzahl;
    private boolean rucksack;

    public Figur(String charakter, String waffe, int anzahl, boolean rucksack) {
        this.charakter = charakter;
        this.waffe = waffe;
        this.anzahl = anzahl;
        this.rucksack = rucksack;
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

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public boolean isRucksack() {
        return rucksack;
    }

    public void setRucksack(boolean rucksack) {
        this.rucksack = rucksack;
    }

}
