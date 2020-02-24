public class PannelloRichiestaDatiPerTCP extends javax.swing.JPanel
    {


    private javax.swing.JLabel indirizzoLabel;
    private javax.swing.JTextField ipInput;
    private javax.swing.JTextField portaInput;
    private javax.swing.JLabel portaLabel;
    private javax.swing.JLabel titolo;


    public PannelloRichiestaDatiPerTCP ()
        {
        initComponents();
        }

    private void initComponents ()
        {
        java.awt.GridBagConstraints gridBagConstraints;

        titolo         = new javax.swing.JLabel();
        indirizzoLabel = new javax.swing.JLabel();
        portaLabel     = new javax.swing.JLabel();
        ipInput        = new javax.swing.JTextField();
        portaInput     = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        titolo.setText(Principale.bundle_lingua.getString("CREAZIONE_TCP"));
        gridBagConstraints        = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx  = 1;
        gridBagConstraints.gridy  = 0;
        gridBagConstraints.insets = new java.awt.Insets(9 , 14 , 9 , 14);
        add(titolo , gridBagConstraints);

        indirizzoLabel.setText(Principale.bundle_lingua.getString("INDIRIZZO_IP_SERVER"));
        gridBagConstraints        = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx  = 0;
        gridBagConstraints.gridy  = 2;
        gridBagConstraints.fill   = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7 , 18 , 7 , 19);
        add(indirizzoLabel , gridBagConstraints);

        portaLabel.setText(Principale.bundle_lingua.getString("PORTA"));
        gridBagConstraints        = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx  = 0;
        gridBagConstraints.gridy  = 3;
        gridBagConstraints.fill   = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(7 , 18 , 7 , 19);
        add(portaLabel , gridBagConstraints);

        ipInput.setColumns(11);
        ipInput.setText("127.0.0.1");

        gridBagConstraints        = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx  = 1;
        gridBagConstraints.gridy  = 2;
        gridBagConstraints.fill   = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4 , 0 , 4 , 0);
        add(ipInput , gridBagConstraints);

        portaInput.setColumns(7);
        portaInput.setText("9999");
        gridBagConstraints        = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx  = 1;
        gridBagConstraints.gridy  = 3;
        gridBagConstraints.fill   = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4 , 0 , 4 , 0);
        add(portaInput , gridBagConstraints);
        }// </editor-fold>


    public String getIpInput ()
        {
        return ipInput.getText();
        }

    public String getPortaInput ()
        {
        return portaInput.getText();
        }
    }
