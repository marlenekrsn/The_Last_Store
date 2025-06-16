import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;


public class StartGUI extends JFrame{
    
    JButton btn_neueBestellung, btn_anzeigenBestellung, btn_loeschenBestellung, btn_beenden;
    JLabel lbl_titel;
    public StartGUI(){
        this.setTitle("Startseite");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();

        setSize(550,350);
        setLocationRelativeTo(null);

        this.setVisible(true);
    }

    private void initComponents(){
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    MyActionListener mylistener = new MyActionListener();

    // Titel
    this.lbl_titel = new JLabel("Startseite");
    Font font_titel = new Font("San Serif", Font.BOLD, 24);
    lbl_titel.setFont(font_titel);
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 3;
    c.insets = new Insets(20, 10, 10, 10);
    c.anchor = GridBagConstraints.CENTER;
    this.add(lbl_titel, c);

    // Bild über 2 Zeilen
    ImageIcon icon = new ImageIcon("D:\\3. klasse\\APR\\TheLastStore\\The_Last_Store_Logo.png");
    Image image = icon.getImage().getScaledInstance(140, 120, Image.SCALE_SMOOTH);
    icon = new ImageIcon(image);
    JLabel lbl_bild = new JLabel(icon);
    c.gridx = 1;
    c.gridy = 1;
    c.gridheight = 2;
    c.gridwidth = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.insets = new Insets(10, 10, 10, 10);
    c.fill = GridBagConstraints.NONE;
    this.add(lbl_bild, c);
    c.gridheight = 1;

    //Buttons Einstellung
    c.fill = GridBagConstraints.BOTH;
    c.insets = new Insets(10, 10, 10, 10);
    c.weightx = 1.0;
    c.weighty = 1.0;

    //neue Bestellung
    this.btn_neueBestellung = new JButton("neue Bestellung");
    btn_neueBestellung.addActionListener(mylistener);
    c.gridx = 0;
    c.gridy = 1;
    this.add(btn_neueBestellung, c);

    //Bestellung anzeigen
    this.btn_anzeigenBestellung = new JButton("Bestellung anzeigen");
    btn_anzeigenBestellung.addActionListener(mylistener);
    c.gridx = 0;
    c.gridy = 2;
    this.add(btn_anzeigenBestellung, c);

    //Bestellung löschen
    this.btn_loeschenBestellung = new JButton("Bestellung löschen");
    btn_loeschenBestellung.addActionListener(mylistener);
    c.gridx = 2;
    c.gridy = 1;
    this.add(btn_loeschenBestellung, c);

    //Beenden
    this.btn_beenden = new JButton("Beenden");
    btn_beenden.addActionListener(mylistener);
    c.gridx = 2;
    c.gridy = 2;
    this.add(btn_beenden, c);
}

    private class MyActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == btn_neueBestellung) {
                //new FigurGUI();
            }else if (e.getSource() == btn_anzeigenBestellung) {
                new BestellungAnzeigenGUI();
            }else if (e.getSource()== btn_loeschenBestellung){
                new BestellungLoeschenGUI();
            }else if (e.getSource()== btn_beenden){
                dispose();
            }
        }
    }
}
