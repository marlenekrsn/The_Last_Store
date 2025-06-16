import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Font;
import java.awt.GridBagConstraints;

public class BestellungLoeschenGUI extends JFrame{

    JLabel lbl_titel;

 public BestellungLoeschenGUI(){
        this.setTitle("Bestellung Löschen");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();

        setSize(550,350);
        setLocationRelativeTo(null);

        this.setVisible(true);
    }

    private void initComponents(){
    this.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    

    // Titel
    this.lbl_titel = new JLabel("Bestellung Löschen");
    Font font_titel = new Font("San Serif", Font.BOLD, 24);
    lbl_titel.setFont(font_titel);
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 3;
    c.insets = new Insets(20, 10, 10, 10);
    c.anchor = GridBagConstraints.CENTER;
    this.add(lbl_titel, c);

    }
}
