import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * Die BestellungDAO-Klasse erhält alle Methoden, die neue Einträge in 
 * die DB schreiben oder bereits bestehende Einträge aus der DB laden.
 * 
 */

public class BestellungDAO {

    //Methode, die ein bestellobjekt in die DB speichert
    public void speichernBestellung(Bestellung bestellung){
        String sql = "INSERT INTO bestellungen (kid,fid,zahlungsart,preis) VALUES (?,?,?,?)";

        //1. Schritt: Verbindung aufbauen
        try (Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){

                //2. Schritt: Stmt mit Werten verknüpfen - für jedes Fragezeichen muss ein Wert mitgeschickt werden
                //ACHTUNG, je nach Typ muss die richtige Setup Methode verwendet werden
                stmt.setInt(1, bestellung.getKid());
                stmt.setInt(2, bestellung.getFid());
                stmt.setString(3, bestellung.getZahlungsart());
                stmt.setBigDecimal(5, bestellung.getPreis());

                stmt.executeUpdate();
                System.out.println("Bestellung erfolgreich gespeichert");

            }catch (SQLException e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Die Bestellung konnte leider nicht gespeichert werden.");
            }


    }//end speichernBestellung

    //Methode zum Laden aller Bestellungen
    public List<GesamtBestellung> ladeAlleBestellungen(){

        List<GesamtBestellung> liste = new ArrayList<>();
        String sql = "SELECT bestellungen.bid, kunde.name, figur.charakter, figur.waffe, figur.rucksack, figur.anzahl, bestellungen.preis FROM `bestellungen` INNER JOIN figur on bestellungen.fid = figur.fid INNER Join kunde on bestellungen.kid = kunde.kid";

        try(Connection conn = DatabaseConnector.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){

                //Verarbeiten des ResultSet (Antwort auf die SELECT-Abfrage)
                while (rs.next()) {//jede Datenzeile aus dem ResultSet wird durchlaufen
                    //Daten aus einer Daten zeile in ein Bestellung Objekt speichern
                    GesamtBestellung b = new GesamtBestellung( rs.getString("name"),
                                                    rs.getString("charakter"),
                                                    rs.getString("waffe"),
                                                    rs.getString("rucksack"),
                                                    rs.getInt("anzahl"),
                                                    rs.getBigDecimal("preis"));
                    
                    //Bestellung-Objekt in Liste speichern
                    liste.add(b);
                }

        }catch(SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Fehler beim Laden der Bestellungen!");
        }
        return liste;
    }
    
}//end class
