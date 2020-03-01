import javax.swing.*;

/**
 * The panel to request data to establish a TCP connection with the server.
 */
public class PannelloRichiestaDatiPerTCP extends JPanel
	{

	private JTextField ipInput;
	private JTextField portaInput;

	/**
	 * Instantiates the panel.
	 */
	public PannelloRichiestaDatiPerTCP()
		{
		initComponents();
		}

	/**
	 * Initializes components.
	 */
	private void initComponents()
		{
		java.awt.GridBagConstraints gridBagConstraints;

		JLabel titolo         = new JLabel();
		JLabel indirizzoLabel = new JLabel();
		JLabel portaLabel     = new JLabel();
		ipInput        = new JTextField();
		portaInput     = new JTextField();

		setLayout(new java.awt.GridBagLayout());

		titolo.setText(l10n.getString("CREAZIONE_TCP"));
		titolo.setForeground(new java.awt.Color(224, 98, 52));
		gridBagConstraints        = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx  = 1;
		gridBagConstraints.gridy  = 0;
		gridBagConstraints.insets = new java.awt.Insets(9, 14, 9, 14);
		add(titolo, gridBagConstraints);

		indirizzoLabel.setText(l10n.getString("INDIRIZZO_IP_SERVER"));
		gridBagConstraints        = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx  = 0;
		gridBagConstraints.gridy  = 2;
		gridBagConstraints.fill   = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 19);
		add(indirizzoLabel, gridBagConstraints);

		portaLabel.setText(l10n.getString("PORTA"));
		gridBagConstraints        = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx  = 0;
		gridBagConstraints.gridy  = 3;
		gridBagConstraints.fill   = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new java.awt.Insets(7, 18, 7, 19);
		add(portaLabel, gridBagConstraints);

		ipInput.setColumns(11);
		ipInput.setText("127.0.0.1");

		gridBagConstraints        = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx  = 1;
		gridBagConstraints.gridy  = 2;
		gridBagConstraints.fill   = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
		add(ipInput, gridBagConstraints);

		portaInput.setColumns(7);
		portaInput.setText("9999");
		gridBagConstraints        = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx  = 1;
		gridBagConstraints.gridy  = 3;
		gridBagConstraints.fill   = java.awt.GridBagConstraints.BOTH;
		gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
		add(portaInput, gridBagConstraints);
		}

	/**
	 * Gets the ip input from the user.
	 *
	 * @return the ip input
	 */
	public String getIpInput()
		{
		return ipInput.getText();
		}

	/**
	 * Gets the port input from the user.
	 *
	 * @return the port input
	 */
	public String getPortaInput()
		{
		return portaInput.getText();
		}

	}
