import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class FrameConnessione extends javax.swing.JFrame
    {

    private static javax.swing.JButton chiudiConnessioneBtn;
    private static javax.swing.JButton avviaBtn;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;

    private static javax.swing.JButton spegniBtn;
    private javax.swing.JLabel spegnimentoLabel;
    private static javax.swing.JLabel statodata;
    private javax.swing.JLabel statotitolo;

    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;

    private static Locale l;
    private static ClientTCP client;
    protected static ResourceBundle rboundle;


    public FrameConnessione ()
        {

        rboundle = Principale.bundle_lingua;
        initComponents();

        }

    private void initComponents ()
        {

        jTabbedPane1         = new javax.swing.JTabbedPane();
        jPanel1              = new javax.swing.JPanel();
        avviaBtn             = new javax.swing.JButton();
        chiudiConnessioneBtn = new javax.swing.JButton();
        statotitolo          = new javax.swing.JLabel();
        statodata            = new javax.swing.JLabel();
        jPanel2              = new javax.swing.JPanel();
        spegnimentoLabel     = new javax.swing.JLabel();
        spegniBtn            = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 300), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 300), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setTitle(rboundle.getString("STATUS"));

        jTabbedPane1.setName("");

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(40 , 1 , 10 , 1) , javax.swing.BorderFactory.createEmptyBorder(20 , 20 , 20 , 20)));
        jPanel1.setLayout(new java.awt.GridLayout(4 , 2 , 10 , 10));

        avviaBtn.setBackground(new java.awt.Color(183, 254, 193));
        avviaBtn.setText(rboundle.getString("AVVIA_CLIENT_TCP"));
        avviaBtn.setForeground(new java.awt.Color(46,64,48));
        avviaBtn.addActionListener(event ->
        {
        try
            {
            avviaActionPerformed(event);
            } catch ( Exception e )
            {
            e.printStackTrace();
            }
        });
        jPanel1.add(avviaBtn);

        chiudiConnessioneBtn.setBackground(new java.awt.Color(255, 145, 145));
        chiudiConnessioneBtn.setForeground(new java.awt.Color(64, 36, 36));
        chiudiConnessioneBtn.setText(rboundle.getString("ETICHETTA_CHIUDI_CONNESSIONE"));
        chiudiConnessioneBtn.setEnabled(false);
        jPanel1.add(chiudiConnessioneBtn);


        statotitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statotitolo.setText(rboundle.getString("STATO_CONNESSIONE"));
        jPanel1.add(statotitolo);

        statodata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statodata.setText("---");
        jPanel1.add(statodata);

        jTabbedPane1.addTab(rboundle.getString("CONNESSIONE") , jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 180, 10));
        jPanel2.setLayout(new java.awt.GridLayout(3, 2, 5, 0));

        spegnimentoLabel.setText(rboundle.getString("SPEGNIMENTO_REMOTO_SERVER"));
        jPanel2.add(spegnimentoLabel);

        spegniBtn.setText(rboundle.getString("ETICHETTA_ARRESTA_SISTEMA_REMOTO"));
        spegniBtn.setBackground(new java.awt.Color(255, 214, 0));

        jPanel2.add(spegniBtn);
        jPanel2.add(filler1);
        jPanel2.add(filler2);

        jTabbedPane1.addTab(rboundle.getString("CONTROLLO_REMOTO") , jPanel2);

        getContentPane().add(jTabbedPane1 , java.awt.BorderLayout.CENTER);

        pack();
        }

    private void avviaActionPerformed ( ActionEvent evt )
        {
        PannelloRichiestaDatiPerTCP pannelloInput;
        int risp = JOptionPane.showConfirmDialog(this , pannelloInput = new PannelloRichiestaDatiPerTCP() ,
                rboundle.getString("INSERIMENTO") + rboundle.getString("INDIRIZZO_SERVER") , JOptionPane.OK_CANCEL_OPTION , JOptionPane.PLAIN_MESSAGE);
        if ( risp == JOptionPane.OK_OPTION )
            {

            try
                {
                String indirizzo = pannelloInput.getIpInput();
                int port = Integer.parseInt(pannelloInput.getPortaInput());
                client = new ClientTCP(indirizzo , port, this);
                aggiungiActionListeners();
                } catch ( NumberFormatException e )
                {
                JOptionPane.showMessageDialog(null , rboundle.getString("INPUT_NON_VALIDO_ERRORE") + e.getMessage() , rboundle.getString("INPUT_NON_VALIDO") , JOptionPane.ERROR_MESSAGE);
                } catch ( Exception e )
                {
                e.printStackTrace();
                }

            }


        //refreshStatusLabel();
        }

    private void aggiungiActionListeners ()
        {
        spegniBtn.addActionListener(client);
        chiudiConnessioneBtn.addActionListener(client);
        }

    static void avviaSetEnabled ()
        {
        chiudiConnessioneBtn.setEnabled(false);
        avviaBtn.setEnabled(true);
        }

    static void chiudiSetEnabled ()
        {
        chiudiConnessioneBtn.setEnabled(true);
        avviaBtn.setEnabled(false);
        }


    public static void refreshStatusLabel ()
        {
        statodata.setText(ClientTCP.inArrivoDalServer);
        }


    }