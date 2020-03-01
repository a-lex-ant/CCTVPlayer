import java.awt.*;

/**
 * The type panel used to request for data to establish a connection with the server.
 */
public class PannelloRichiestaDatiPerStream extends javax.swing.JPanel
	{

	private javax.swing.Box.Filler filler1;
	private javax.swing.JLabel     labelIP;
	private javax.swing.JLabel     labelPorta;
	private javax.swing.JLabel     titoloLabel;
	private javax.swing.JTextField textfIP;
	private javax.swing.JTextField textfPorta;

	/**
	 * Instantiates a new panel.
	 */
	public PannelloRichiestaDatiPerStream()
		{
		initComponents();
		this.setVisible(true);
		}

	/**
	 * Initialize components.
	 */
	private void initComponents()
		{

		titoloLabel = new javax.swing.JLabel();
		filler1     = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
		labelIP     = new javax.swing.JLabel();
		textfIP     = new javax.swing.JTextField();
		labelPorta  = new javax.swing.JLabel();
		textfPorta  = new javax.swing.JTextField();

		GridLayout layout = new java.awt.GridLayout(3, 2);
		layout.setVgap(3);
		setLayout(layout);

		titoloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titoloLabel.setForeground(new java.awt.Color(224, 98, 52));
		titoloLabel.setText(CCTVPlayer.bundle_lingua.getString("INSERIRE_SERVER_TITOLO"));
		add(titoloLabel);
		add(filler1);

		labelIP.setText(CCTVPlayer.bundle_lingua.getString("SERVER_IP_ADDRESS"));
		add(labelIP);

		textfIP.setText("192.168.1.4");
		add(textfIP);

		labelPorta.setText(CCTVPlayer.bundle_lingua.getString("PORTA"));
		add(labelPorta);

		textfPorta.setText("8554");
		add(textfPorta);

		}

	/**
	 * gets the data inserted by the user in the text fields
	 *
	 * @return the string [ ]
	 */
	public String[] getDatiInseriti()
		{
		if (!textfIP.getText()
		            .isEmpty() && !textfPorta.getText()
		                                     .isEmpty())
			{
			return new String[]{textfIP.getText(), textfPorta.getText()};
			}
		else { return new String[]{"192.168.1.4", "8554"}; }
		}

	}
