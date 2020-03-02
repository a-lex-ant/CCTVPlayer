import javax.swing.*;
import java.awt.*;

/**
 * The type panel used to request for data to establish a connection with the server.
 */
public class PannelloRichiestaDatiPerStream extends javax.swing.JPanel
	{

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

		javax.swing.JLabel     titoloLabel = new javax.swing.JLabel();
		javax.swing.Box.Filler filler1     = new javax.swing.Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(32767, 0));
		javax.swing.JLabel     labelIP     = new javax.swing.JLabel();
		textfIP = new javax.swing.JTextField();
		javax.swing.JLabel labelPorta = new javax.swing.JLabel();
		textfPorta = new javax.swing.JTextField();

		GridLayout layout = new java.awt.GridLayout(3, 2);
		layout.setVgap(3);
		setLayout(layout);

		titoloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titoloLabel.setForeground(new java.awt.Color(224, 98, 52));
		titoloLabel.setText(l10n.getString("INSERIRE_SERVER_TITOLO"));
		add(titoloLabel);
		add(filler1);

		labelIP.setText(l10n.getString("SERVER_IP_ADDRESS"));
		add(labelIP);

		textfIP.setText("127.0.0.1");
		add(textfIP);

		labelPorta.setText(l10n.getString("PORTA"));
		add(labelPorta);

		textfPorta.setText("9999");
		add(textfPorta);

		}

	/**
	 * gets the data inserted by the user in the text fields
	 *
	 * @return the string [ ]
	 */
	public String[] getDatiInseriti()
		{
		String ip    = textfIP.getText();
		String    porta = textfPorta.getText();

		if (!ip.isEmpty() && !ip.isEmpty())
			{
			if (NetworkInfo.isValidAddress(ip))
				{
				return new String[]{ip, textfPorta.getText()};
				}
			}
		int result = JOptionPane.showConfirmDialog(
				this,l10n.getString("NO_VALID_DATA"), l10n.getString("NO_VALID_DATA_SHORT"), JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION)
			{
			 return new String[]{"127.0.0.1", "9999"};
			}
		else
			{
			return null;
			}

		}

	}
