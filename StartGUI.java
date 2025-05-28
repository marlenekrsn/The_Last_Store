import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;


public class StartGUI extends JFrame{
    
    JButton btn_erstellenKundenk, btn_neueBestellung, btn_anzeigenBestellung, btn_loeschenKundenkonto;

    public StartGUI(){
        this.setTitle("Startseite");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();

        setSize(320,100);
        setLocationRelativeTo(null);

        this.setVisible(true);
    }

    private void initComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        MyActionListener mylistener = new MyActionListener();

        this.btn_erstellenKundenk = new JButton("Kundenkonto erstellen");
        c.gridx = 0; // Spalte
        c.gridy = 0; // Zeile
        this.add(btn_erstellenKundenk,c);
        btn_erstellenKundenk.addActionListener(mylistener);


        //Bild einfügen bzw logo einfügen

        this.btn_neueBestellung = new JButton("neue Bestellung");
        c.gridx = 0; // Spalte
        c.gridy = 1; // Zeile
        this.add(btn_neueBestellung,c);
        btn_neueBestellung.addActionListener(mylistener);

        this.btn_anzeigenBestellung = new JButton("Bestellung anzeigen");
        c.gridx = 0; // Spalte
        c.gridy = 2; // Zeile
        this.add(btn_anzeigenBestellung,c);
        btn_anzeigenBestellung.addActionListener(mylistener);

        this.btn_loeschenKundenkonto = new JButton("Kundenkonto löschen");
        c.gridx = 0; // Spalte
        c.gridy = 3; // Zeile
        this.add(btn_loeschenKundenkonto,c);
        btn_loeschenKundenkonto.addActionListener(mylistener);

    }

    private class MyActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == btn_erstellenKundenk) {
                new KundenkontoErstellenGUI();   

            }else if (e.getSource() == btn_neueBestellung) {
                new neueBestellungGUI();
            }else if (e.getSource() == btn_anzeigenBestellung) {
                new anzeigenBestellungGUI();
            }

        }
    }
}
