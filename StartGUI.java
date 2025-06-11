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

        setSize(600,400);
        setLocationRelativeTo(null);

        this.setVisible(true);
    }

    private void initComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        MyActionListener mylistener = new MyActionListener();

        this.lbl_titel = new JLabel("Startseite");
        Font font_titel = new Font("San Serif", Font.BOLD, 24);
        lbl_titel.setFont(font_titel);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(20, 10, 10, 10);
        this.add(lbl_titel,c);               


        //Bild einfügen bzw logo einfügen
        ImageIcon icon = new ImageIcon("D:\\3. klasse\\APR\\TheLastStore\\The_Last_Store_Logo.png");
        Image image = icon.getImage().getScaledInstance(140, 120, Image.SCALE_SMOOTH);
        icon = new ImageIcon(image);
        JLabel lbl_bild = new JLabel(icon);
        c.gridx = 1; // Spalte
        c.gridy = 1; // Zeile
        c.gridheight = 2; 
        c.weightx = 1.0;
        c.weighty = 1.0;
        this.add(lbl_bild,c );
        
        c.gridheight = 1;


        this.btn_neueBestellung = new JButton("neue Bestellung");
        c.gridx = 0; // Spalte
        c.gridy = 2; // Zeile
        c.insets = new Insets(20, 10, 10, 10);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.5;
        btn_neueBestellung.addActionListener(mylistener);
        this.add(btn_neueBestellung,c);
        
        this.btn_anzeigenBestellung = new JButton("Bestellung anzeigen");
        c.gridx = 0; // Spalte
        c.gridy = 3; // Zeile
        c.insets = new Insets(20, 10, 10, 10);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        btn_anzeigenBestellung.addActionListener(mylistener);
        this.add(btn_anzeigenBestellung,c);

        this.btn_loeschenBestellung = new JButton("Bestellung löschen");
        c.gridx = 2; // Spalte
        c.gridy = 2; // Zeile
        c.insets = new Insets(20, 10, 10, 10);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 0.5;
        btn_loeschenBestellung.addActionListener(mylistener);
        this.add(btn_loeschenBestellung,c);


        this.btn_beenden = new JButton("Beenden");
        c.gridx = 2; // Spalte
        c.gridy = 3; // Zeile
        c.insets = new Insets(20, 10, 10, 10);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        btn_beenden.addActionListener(mylistener);
        this.add(btn_beenden,c);

    }

    private class MyActionListener implements ActionListener{

        /*public void actionPerformed(ActionEvent e){
            if (e.getSource() == btn_erstellenKundenkonto) {
                new KundenkontoErstellenGUI();   
            }else if (e.getSource() == btn_neueBestellung) {
                new FigurGUI();
            }else if (e.getSource() == btn_anzeigenBestellung) {
                new AnzeigenBestellungGUI();
            }else if(e.getSource()== btn_aendernKundenkonto){
                new AendernBestellungGUI();
            }else if (e.getSource()== btn_loeschenBestellung){
                new LoeschenBestellungGUI();
            }else if (e.getSource()== btn_aendernBestellung){
                new AendernBestellungGUI(); }
            }*/

       
    }
}
