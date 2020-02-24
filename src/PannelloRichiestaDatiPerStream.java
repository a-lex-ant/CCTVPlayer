import java.awt.*;

public class PannelloRichiestaDatiPerStream extends javax.swing.JPanel
    {
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel labelIP;
    private javax.swing.JLabel labelPorta;
    private javax.swing.JLabel titoloLabel;
    private javax.swing.JTextField textfIP;
    private javax.swing.JTextField textfPorta;


    public PannelloRichiestaDatiPerStream ()
        {
        initComponents();
        this.setVisible(true);
        }

    private void initComponents ()
        {

        titoloLabel = new javax.swing.JLabel();
        filler1     = new javax.swing.Box.Filler(new java.awt.Dimension(0 , 0) , new java.awt.Dimension(0 , 0) ,
                new java.awt.Dimension(32767 , 0));
        labelIP     = new javax.swing.JLabel();
        textfIP     = new javax.swing.JTextField();
        labelPorta  = new javax.swing.JLabel();
        textfPorta  = new javax.swing.JTextField();

        GridLayout layout = new java.awt.GridLayout(3 , 2);
        layout.setVgap(3);
        setLayout(layout);

        titoloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titoloLabel.setText("Inserire indirizzo e porta del server trasmissivo:");
        add(titoloLabel);
        add(filler1);

        labelIP.setText("Indirizzo IP");
        add(labelIP);

        textfIP.setText("192.168.1.4");
        add(textfIP);

        labelPorta.setText("Porta:");
        add(labelPorta);

        textfPorta.setText("8554");
        add(textfPorta);


        }


    public String[] getDatiInseriti ()
        {
        if ( !textfIP.getText().isEmpty() && !textfPorta.getText().isEmpty() )
            {
            return new String[] { textfIP.getText() , textfPorta.getText() };
            }
        else
            return new String[] { "192.168.1.4" , "8554" };
        }
    }
