import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

public class FigurGUI extends JFrame {

    JLabel lbl_ueberschrift, lbl_charakter, lbl_waffe, lbl_anzahl;
    JComboBox<String> cbo_charakter, cbo_waffe;
    JComboBox<Integer> cbo_anzahl;
    JCheckBox chk_rucksack;
    JButton btn_absenden, btn_reset, btn_abbrechen;

    final String Ellie = "Ellie";
    final String Joel = "Joel";
    final String Abby = "Abby";

    final String Revolver = "Revolver";
    final String Pisole = "Pistole";
    final String Gewehr = "Gewehr";
    final String Shotgun = "Shotgun";

    public FigurGUI() {
        this.setTitle("Figurauswahl");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponents();

        this.pack();
        this.setVisible(true);

    }

    private void initComponents() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbl_ueberschrift = new JLabel("Figurenauswahl");
        Font font_ueberschrift = new Font("San Serif", Font.BOLD, 24);
        lbl_ueberschrift.setFont(font_ueberschrift);
        lbl_ueberschrift.setForeground(Color.BLACK);
        lbl_ueberschrift.setHorizontalAlignment(JLabel.CENTER);
        c.gridx = 0; // Spalte
        c.gridy = 0; // Zeile
        c.gridwidth = 2; // über 2 Spalten
        c.gridheight = 1; // über 1 Zeile
        c.anchor = GridBagConstraints.SOUTH;
        c.insets = new Insets(20, 10, 10, 10);
        this.add(lbl_ueberschrift, c);

        lbl_charakter = new JLabel("Wähle deinen Charakter:");
        Font font_beschriftung = new Font("San Serif", Font.BOLD, 12);
        lbl_charakter.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_charakter, c);

        String[] charakter = { Ellie, Joel, Abby };
        cbo_charakter = new JComboBox<String>(charakter);
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(this.cbo_charakter, c);

        lbl_waffe = new JLabel("Wähle deine Waffe:");
        lbl_waffe.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_waffe, c);

        String[] waffe = { Revolver, Pisole, Gewehr, Shotgun };
        cbo_waffe = new JComboBox<String>(waffe);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(this.cbo_waffe, c);

        chk_rucksack = new JCheckBox("Rucksack");
        chk_rucksack.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(chk_rucksack, c);

        lbl_anzahl = new JLabel("Anzahl der Figuren:");
        lbl_anzahl.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 4;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_anzahl, c);

        Integer[] anzahlint = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        cbo_anzahl = new JComboBox<Integer>(anzahlint);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5, 0, 0, 10);
        cbo_anzahl.setFont(font_beschriftung);
        this.add(cbo_anzahl, c);

        MyActionListener mylistener = new MyActionListener();

        btn_reset = new JButton("Zurücksetzen");
        Font font_button = new Font("Sans Serif", Font.BOLD, 14);
        btn_reset.setFont(font_button);
        c.gridx = 1;
        c.gridy = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 0, 10);
        this.add(btn_reset, c);
        btn_reset.addActionListener(mylistener);

        btn_absenden = new JButton("Absenden");
        btn_absenden.setFont(font_button);
        c.gridx = 0;
        c.gridy = 6;
        c.insets = new Insets(0, 10, 0, 10);
        this.add(btn_absenden, c);
        btn_absenden.addActionListener(mylistener);

        btn_abbrechen = new JButton("Abbrechen");
        btn_abbrechen.setFont(font_button);
        c.gridx = 1;
        c.gridy = 7;
        c.insets = new Insets(0, 0, 15, 10);
        this.add(btn_abbrechen, c);
        btn_abbrechen.addActionListener(mylistener);
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn_reset) {
                cbo_charakter.setSelectedIndex(0); // erste Pizza wird angezeigt
                cbo_waffe.setSelectedIndex(0); // erste Pizza wird angezeigt
                cbo_anzahl.setSelectedIndex(0);
                chk_rucksack.setSelected(false);

            } else if (e.getSource() == btn_abbrechen) {
                dispose();

            } else if (e.getSource() == btn_absenden) {
                // Die Daten aus dem Formular sollen in einem Bestellung-Objekt gespeichert
                // werden
                // (String name, String sorte, int anzahl, boolean abholer, BigDecimal preis)
                String charakter = cbo_charakter.getSelectedItem().toString();
                String waffe = cbo_waffe.getSelectedItem().toString();
                int anzahl = (int) cbo_anzahl.getSelectedItem();
                boolean rucksack = chk_rucksack.isSelected();
                // BigDecimal preis = berechnePreis();

                Figur neueFigur = new Figur(charakter, waffe, anzahl, rucksack);
                dispose();

                if (rucksack == true) {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben die Figur " + charakter + " gewählt. Als Waffe ein/e " + waffe
                                    + ". Ihre Figur trägt einen Rucksack. Sie haben " + anzahl + " Figur/en bestellt.");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Sie haben die Figur " + charakter + " gewählt. Als Waffe ein/e " + waffe
                                    + ". Sie haben " + anzahl + " Figur/en bestellt.");
                }

            }
        }

    }
}
