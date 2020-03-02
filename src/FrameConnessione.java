import javax.swing.*;
import javax.swing.Box.Filler;

/**
 * The type Frame connessione.
 */
public class FrameConnessione extends javax.swing.JFrame
	{

	private JButton chiudiConnessioneBtn;
	private JButton avviaBtn;
	private JButton spegniBtn;
	private JLabel statodata;

	/**
	 * The TCP client created after clicking on the avviaBtn.
	 */
	private ClientTCP      client;

	/**
	 * Instantiates a new Connection Frame.
	 */
	public FrameConnessione()
		{

		initComponents();

		}

	/**
	 * Initializes components.
	 */
	private void initComponents()
		{

		JTabbedPane jTabbedPane1 = new JTabbedPane();
		JPanel connectionPanel = new JPanel();
		avviaBtn             = new JButton();
		chiudiConnessioneBtn = new JButton();
		JLabel statotitolo = new JLabel();
		statodata            = new JLabel();
		JPanel remoteControlPanel = new JPanel();
		JLabel spegnimentoLabel   = new JLabel();
		spegniBtn            = new JButton();
		Filler filler1 = new Filler(new java.awt.Dimension(0, 300), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
		Filler filler2 = new Filler(new java.awt.Dimension(0, 300), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));

		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setTitle(l10n.getString("STATUS"));


		connectionPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(40, 1, 10, 1),
		                                                                         javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		connectionPanel.setLayout(new java.awt.GridLayout(4, 2, 10, 10));

		avviaBtn.setBackground(new java.awt.Color(183, 254, 193));
		avviaBtn.setText(l10n.getString("AVVIA_CLIENT_TCP"));
		avviaBtn.setForeground(new java.awt.Color(46, 64, 48));
		avviaBtn.addActionListener(event ->
		                           {
		                           try
			                           {
			                           avviaActionPerformed();
			                           }
		                           catch (Exception e)
			                           {
			                           e.printStackTrace();
			                           }
		                           });
		connectionPanel.add(avviaBtn);

		chiudiConnessioneBtn.setBackground(new java.awt.Color(255, 145, 145));
		chiudiConnessioneBtn.setForeground(new java.awt.Color(64, 36, 36));
		chiudiConnessioneBtn.setText(l10n.getString("ETICHETTA_CHIUDI_CONNESSIONE"));
		chiudiConnessioneBtn.setEnabled(false);
		connectionPanel.add(chiudiConnessioneBtn);

		statotitolo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		statotitolo.setText(l10n.getString("STATO_CONNESSIONE"));
		connectionPanel.add(statotitolo);

		statodata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		statodata.setText("---");
		connectionPanel.add(statodata);

		jTabbedPane1.addTab(l10n.getString("CONNESSIONE"), connectionPanel);

		remoteControlPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 10, 180, 10));
		remoteControlPanel.setLayout(new java.awt.GridLayout(3, 2, 5, 0));

		spegnimentoLabel.setText(l10n.getString("SPEGNIMENTO_REMOTO_SERVER"));
		remoteControlPanel.add(spegnimentoLabel);

		spegniBtn.setText(l10n.getString("ETICHETTA_ARRESTA_SISTEMA_REMOTO"));
		spegniBtn.setBackground(new java.awt.Color(255, 239, 148));
		spegniBtn.setForeground(new java.awt.Color(128, 113, 38));

		remoteControlPanel.add(spegniBtn);
		remoteControlPanel.add(filler1);
		remoteControlPanel.add(filler2);

		jTabbedPane1.addTab(l10n.getString("CONTROLLO_REMOTO"), remoteControlPanel);

		getContentPane().add(jTabbedPane1, java.awt.BorderLayout.CENTER);

		pack();
		}

	/**
	 * Mehod called after the click of the avviaBtn
	 *
	 */
	private void avviaActionPerformed()
		{
		PannelloRichiestaDatiPerTCP pannelloInput;
		int risp = JOptionPane.showConfirmDialog(this, pannelloInput = new PannelloRichiestaDatiPerTCP(),
		                                         l10n.getString("INSERIMENTO") + l10n.getString("INDIRIZZO_SERVER"),
		                                         JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (risp == JOptionPane.OK_OPTION)
			{

			try
				{
				String indirizzo = pannelloInput.getIpInput();
				int    port      = Integer.parseInt(pannelloInput.getPortaInput());
				client = new ClientTCP(indirizzo, port, this);
				aggiungiActionListeners();
				}
			catch (NumberFormatException e)
				{
				JOptionPane.showMessageDialog(null, l10n.getString("INPUT_NON_VALIDO_ERRORE") + e.getMessage(),
				                              l10n.getString("INPUT_NON_VALIDO"), JOptionPane.ERROR_MESSAGE);
				} //TODO: aggiungere ulteriore gestione dell'input, nel caso si mettano cose senza senso. Fare prove!
			catch (Exception e)
				{
				e.printStackTrace();
				}

			}

		}

	/**
	 * Adds action listeners to the buttons of the frame
	 */
	private void aggiungiActionListeners()
		{
		spegniBtn.addActionListener(client);
		chiudiConnessioneBtn.addActionListener(client);
		}

	/**
	 * Enables the avviaBtn after closing the previous connection
	 */
	void avviaSetEnabled()
		{
		chiudiConnessioneBtn.setEnabled(false);
		avviaBtn.setEnabled(true);
		}

	/**
	 * Enables the chiudiConnessioneBtn for closing a connection after opening one
	 */
	void chiudiSetEnabled()
		{
		chiudiConnessioneBtn.setEnabled(true);
		avviaBtn.setEnabled(false);
		}

	/**
	 * Updates status label.
	 */
	public void updateStatusLabel(String status)
		{
		statodata.setText(status);
		}

	}