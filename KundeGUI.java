import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KundeGUI extends JFrame {

    JLabel lbl_name, lbl_adresse, lbl_ort, lbl_plz, lbl_email;
    JTextField txt_name, txt_adresse, txt_ort, txt_plz, txt_email;
    JButton btn_speichern, btn_reset, btn_abbrechen;

    public KundeGUI() {
        this.setTitle("Figurauswahl");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        initComponents();

        this.pack();
        this.setVisible(true);

    }

    private void initComponents() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel lbl_ueberschrift = new JLabel("Ihre Informationen");
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

        lbl_name = new JLabel("Geben Sie Ihren Namen ein:");
        Font font_beschriftung = new Font("San Serif", Font.BOLD, 12);
        lbl_name.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_name, c);

        txt_name = new JTextField(15);
        c.gridx = 1;
        c.gridy = 1;
        // c.gridwidth = 1; Einstellungen bleiben weiterhin erhalten
        // c.gridheight = 1;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_name, c);

        lbl_adresse = new JLabel("Geben Sie Ihre Adresse ein:");
        lbl_adresse.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_adresse, c);

        txt_adresse = new JTextField(15);
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_adresse, c);

        lbl_ort = new JLabel("Geben Sie Ihren Wohnort ein:");
        lbl_ort.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_ort, c);

        txt_ort = new JTextField(15);
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_ort, c);

        lbl_plz = new JLabel("Geben Sie Ihre Postleitzahl ein:");
        lbl_plz.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_plz, c);

        txt_plz = new JTextField(15);
        c.gridx = 1;
        c.gridy = 4;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_plz, c);

        lbl_email = new JLabel("Geben Sie Ihre Email ein:");
        lbl_email.setFont(font_beschriftung);
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 10, 0, 30);
        this.add(lbl_email, c);

        txt_email = new JTextField(15);
        c.gridx = 1;
        c.gridy = 5;
        c.insets = new Insets(5, 0, 0, 10);
        this.add(txt_email, c);

        MyActionListener mylistener = new MyActionListener();

        btn_reset = new JButton("Zurücksetzen");
        Font font_button = new Font("Sans Serif", Font.BOLD, 14);
        btn_reset.setFont(font_button);
        c.gridx = 1;
        c.gridy = 6;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 0, 10);
        this.add(btn_reset, c);
        btn_reset.addActionListener(mylistener);

        btn_speichern = new JButton("Absenden");
        btn_speichern.setFont(font_button);
        c.gridx = 0;
        c.gridy = 7;
        c.insets = new Insets(0, 10, 0, 10);
        this.add(btn_speichern, c);
        btn_speichern.addActionListener(mylistener);

        btn_abbrechen = new JButton("Abbrechen");
        btn_abbrechen.setFont(font_button);
        c.gridx = 1;
        c.gridy = 8;
        c.insets = new Insets(0, 0, 15, 10);
        this.add(btn_abbrechen, c);
        btn_abbrechen.addActionListener(mylistener);
    }

    private class MyActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == btn_reset) {
                txt_name.setText("");
                txt_adresse.setText("");
                txt_ort.setText("");
                txt_plz.setText("");
                txt_email.setText("");
            } else if (e.getSource() == btn_abbrechen) {
                dispose();

            } else if (e.getSource() == btn_speichern) {

                if (txt_name.getText().isEmpty() || txt_adresse.getText().isEmpty() || txt_ort.getText().isEmpty()
                        || txt_plz.getText().isEmpty() || txt_email.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Bitte alles ausfüllen!");

                } else {

                    String name, adresse, ort, plz, email;

                    name = txt_name.getText();
                    adresse = txt_adresse.getText();
                    ort = txt_ort.getText();
                    plz = txt_plz.getText();
                    email = txt_email.getText();

                    Kunde neuerKunde = new Kunde(name, adresse, ort, plz, email);
                    FigurGUI gui1 = new FigurGUI();

                    dispose();

                }

            }

        }
    }
}
