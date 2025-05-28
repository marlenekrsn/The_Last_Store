import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
//Layoutmanager importieren
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class FigurGUI extends JFrame {
    // Attribute
    JLabel lbl_ueberschrift, lbl_charakter, lbl_waffe, rucksack, lbl_anzahl;
    JTextField txt_name;
    JComboBox<String> cbo_charakter, cbo_waffe, cbo_rucksack;
    JComboBox<Integer> cbo_anzahl;
    JCheckBox chk_mais, chk_zwiebeln, chk_oliven, chk_pfefferoni, chk_abholer;
    JRadioButton opt_paypal, opt_bar;
    JButton btn_reset, btn_bestellen, btn_beenden, btn_speichernDB;

    final String Schinken = "Schinken";
    final String Salami = "Salami";
    final String Diavolo = "Diavolo";

    public FigurGUI() {
        this.setTitle("Bennos's Pizza-Bestellformular");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Komponenten für das Fenster erstellen
        initComponents();

        this.pack(); // Erstellt das GUI in der optimalen Größe aufgrund der
                     // anzuzeigenden Elemente

        this.setVisible(true);
    }

    private void initComponents() {

        // Layout festlegen
        this.setLayout(new GridBagLayout());
        // Das GridBagLayout benötigt zusätzlich eine vielzahl von Einstellungen,
        // die in einem eigenen Constraints-Objekte gespeichert werden.
        GridBagConstraints c = new GridBagConstraints();

        // Überschrift
        JLabel lbl_ueberschrift = new JLabel("Benno's Pizza Service");
        Font font_ueberschrift = new Font("Sans Serif", Font.BOLD, 24);
        lbl_ueberschrift.setFont(font_ueberschrift);
        lbl_ueberschrift.setForeground(Color.BLACK);
        lbl_ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0; // Spalte
        c.gridy = 0; // Zeile
        c.gridwidth = 2; // über 2 Spalten
        c.gridheight = 1; // über 1 Zeile
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(20, 10, 10, 10);
        this.add(lbl_ueberschrift, c); // !!!NIcht vergessen die Einstellungen (Constraints-Obj) mitzugeben

        // Name und dazugehöriges Textfeld
        lbl_charakter = new JLabel("Name:");
        Font font_beschriftung = new Font("Sans Serif", Font.PLAIN, 12);
        lbl_charakter.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_charakter, c);

        txt_name = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        // c.gridwidth = 1; Einstellungen bleiben weiterhin erhalten
        // c.gridheight = 1;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_name, c);

        // Sorte + Auswahl
        lbl_waffe = new JLabel("Sorte:");
        this.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(lbl_waffe, c);

        // Auswahlfeld - Kombinaationsfeld - Combobox
        String[] pizzasorten = { Schinken, Salami, Diavolo };
        cbo_charakter = new JComboBox<String>(pizzasorten);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(this.cbo_charakter, c);

        // Extras
        rucksack = new JLabel("Extras:");
        rucksack.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(rucksack, c);

        chk_oliven = new JCheckBox("Oliven");
        chk_oliven.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(5, 10, 0, 10);
        this.add(chk_oliven, c);

        chk_mais = new JCheckBox("Mais");
        chk_mais.setFont(font_beschriftung);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(chk_mais, c);

        chk_pfefferoni = new JCheckBox("Pfefferoni");
        chk_pfefferoni.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(3, 10, 0, 10);
        this.add(chk_pfefferoni, c);

        chk_zwiebeln = new JCheckBox("Zwiebeln");
        chk_zwiebeln.setFont(font_beschriftung);
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(chk_zwiebeln, c);

        lbl_anzahl = new JLabel("Anzahl:");
        lbl_anzahl.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(7, 10, 0, 10);
        this.add(lbl_anzahl, c);

        Integer[] anzahlint = { 1, 2, 3, 4, 5 };
        cbo_anzahl = new JComboBox<Integer>(anzahlint);
        c.gridx = 1;
        c.gridy = 6;
        c.insets = new Insets(7, 0, 0, 10);
        cbo_anzahl.setFont(font_beschriftung);
        this.add(cbo_anzahl, c);

        chk_abholer = new JCheckBox("Abholer");
        chk_abholer.setFont(font_beschriftung);
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(chk_abholer, c);

        // ButtonGroup fpr RadioButton erzeugen
        ButtonGroup zahlungsart = new ButtonGroup();

        opt_paypal = new JRadioButton("PayPal");
        opt_paypal.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(3, 10, 0, 10);
        this.add(opt_paypal, c);

        opt_bar = new JRadioButton("Bar");
        opt_bar.setFont(font_beschriftung);
        opt_bar.setSelected(true);
        c.gridx = 1;
        c.gridy = 10;
        c.insets = new Insets(3, 0, 0, 10);
        this.add(opt_bar, c);

        zahlungsart.add(opt_paypal);
        zahlungsart.add(opt_bar);

        // Button
        MyActionListener mylistener = new MyActionListener();

        btn_reset = new JButton("Zurücksetzen");
        Font font_button = new Font("Sans Serif", Font.BOLD, 16);
        btn_reset.setFont(font_button);
        c.gridx = 0;
        c.gridy = 11;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 5, 10);
        this.add(btn_reset, c);
        btn_reset.addActionListener(mylistener);

        btn_bestellen = new JButton("Speichern in Datei");
        btn_bestellen.setFont(font_button);
        c.gridx = 1;
        c.gridy = 11;
        c.insets = new Insets(10, 0, 5, 10);
        this.add(btn_bestellen, c);
        btn_bestellen.addActionListener(mylistener);

        // Neuen Button zum Speichern der Bestellung in der DB
        btn_speichernDB = new JButton("Speichern in DB");
        btn_speichernDB.setFont(font_button);
        c.gridx = 0;
        c.gridy = 12;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 15, 10);
        this.add(btn_speichernDB, c);
        btn_speichernDB.addActionListener(mylistener);

        btn_beenden = new JButton("Beenden");
        btn_beenden.setFont(font_button);
        c.gridx = 1;
        c.gridy = 12;
        c.insets = new Insets(10, 0, 15, 10);
        this.add(btn_beenden, c);
        btn_beenden.addActionListener(mylistener);

    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn_reset) {
                txt_name.setText("");
                cbo_cha.setSelectedIndex(0); // erste Pizza wird angezeigt
                chk_oliven.setSelected(false);
                chk_mais.setSelected(false);
                chk_pfefferoni.setSelected(false);
                chk_zwiebeln.setSelected(false);
                cbo_anzahl.setSelectedIndex(0);
                txt_tel.setText("");
                chk_abholer.setSelected(false);
                opt_bar.setSelected(true);
                opt_paypal.setSelected(false);
            } else if (e.getSource() == btn_beenden) {

                dispose();
            } else if (e.getSource() == btn_bestellen) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Bestellungen.txt", true));

                    String name, sorte, anzahl, abholer, preis;

                    name = txt_name.getText();
                    sorte = cbo_sorte.getSelectedItem().toString();
                    anzahl = cbo_anzahl.getSelectedItem().toString();
                    abholer = chk_abholer.getText();
                    preis = berechnePreis().toString();

                    writer.write(name + ";" + sorte + ";" + anzahl + ";" + abholer + ";" + preis);
                    writer.newLine();

                    writer.close();

                    JOptionPane.showMessageDialog(null, "Die Bestellung wurde erfolgreich gespeichert.");
                } catch (IOException ex) {
                    System.err.println("Fehler aufgetreten.");
                }

            } else if (e.getSource() == btn_speichernDB) {
                // Die Daten aus dem Formular sollen in einem Bestellung-Objekt gespeichert
                // werden
                // (String name, String sorte, int anzahl, boolean abholer, BigDecimal preis)
                String name = txt_name.getText();
                String sorte = cbo_sorte.getSelectedItem().toString();
                int anzahl = (int) cbo_anzahl.getSelectedItem();
                boolean abholer = chk_abholer.isSelected();
                BigDecimal preis = berechnePreis();

                if (abholer == true) {
                    JOptionPane.showMessageDialog(null, name + " hat die Pizza " + sorte + " " + anzahl +
                            " mal bestellt.\nDie Bestellung wird abgeholt. \nDer Preis beträgt " + preis + "€.");
                } else {
                    JOptionPane.showMessageDialog(null, name + " hat die Pizza " + sorte + " " + anzahl +
                            " mal bestellt.\nDie Bestellung wird nicht abgeholt. \nDer Preis beträgt " + preis + "€.");
                }
                // Daten in Objekt speichern
                // Bestellung neueBestellung = new Bestellung(name, sorte, anzahl, abholer,
                // preis);

                // Weiterleiten des Bestellobjekts an Klasse BestellungDAO
                // BestellungDAO dao = new BestellungDAO();

                // Klasse BestellungDAO sorgt dafür das Objekt ind DB übertragen wird (Insert
                // Into)
                // dao.speichernBestellung(neueBestellung);
            }
        }

    }

    private BigDecimal berechnePreis() {
        final BigDecimal PREIS = new BigDecimal("9.99");
        final BigDecimal EXTRA = new BigDecimal("1.50");

        int anzahl = (Integer) cbo_anzahl.getSelectedItem();
        BigDecimal extrasPreis = BigDecimal.ZERO;

        if (chk_mais.isSelected())
            extrasPreis = extrasPreis.add(EXTRA);
        if (chk_oliven.isSelected())
            extrasPreis = extrasPreis.add(EXTRA);
        if (chk_zwiebeln.isSelected())
            extrasPreis = extrasPreis.add(EXTRA);
        if (chk_pfefferoni.isSelected())
            extrasPreis = extrasPreis.add(EXTRA);

        // Preis pro Stück inkl. Extras
        BigDecimal einzelpreis = PREIS.add(extrasPreis);

        // Gesamtpreis = Preis pro Stück * Anzahl
        BigDecimal gesamtpreis = einzelpreis.multiply(BigDecimal.valueOf(anzahl));

        return gesamtpreis;

    }
}