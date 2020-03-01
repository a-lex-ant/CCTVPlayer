import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * The type Frame metadata.
 */
public class FrameMetadata extends JFrame
	{

	private JLabel lblDataAudioBuffers;
	private JLabel lblDataPicturesLost;
	private JLabel lblDataDemuxCorrupted;

	/**
	 * Instantiates the new frame.
	 */
	public FrameMetadata()
		{
		setTitle(CCTVPlayer.bundle_lingua.getString("STATISTICHE"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanel);

		JPanel rootPanel = new JPanel();
		contentPanel.add(rootPanel, BorderLayout.CENTER);
		rootPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, CCTVPlayer.bundle_lingua.getString("STAT_SULLA_CONNESSIONE"), TitledBorder.LEADING, TitledBorder.TOP, null,
				                 null));
		rootPanel.add(panel, BorderLayout.CENTER);
		panel.add(new NetworkMonitorPanel());

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, CCTVPlayer.bundle_lingua.getString("INFORMAZIONI_SUL_MEDIA"), TitledBorder.LEADING, TitledBorder.TOP, null,
				                 null));
		contentPanel.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths  = new int[]{2, 0, 0, 0};
		gbl_panel_1.rowHeights    = new int[]{2, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights    = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel             lbl_AUDIO_BUFFERS_LOST = new JLabel(CCTVPlayer.bundle_lingua.getString("AUDIO_BUFFERS_LOST"));
		GridBagConstraints gbc_lblNewLabel        = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx  = 0;
		gbc_lblNewLabel.gridy  = 0;
		panel_1.add(lbl_AUDIO_BUFFERS_LOST, gbc_lblNewLabel);

		lblDataAudioBuffers = new JLabel("" + CCTVPlayer.getPannelloMediaPlayer()
		                                                .getAudioBuffersLost());
		GridBagConstraints gbc_lblAaa = new GridBagConstraints();
		gbc_lblAaa.insets = new Insets(0, 0, 5, 0);
		gbc_lblAaa.gridx  = 2;
		gbc_lblAaa.gridy  = 0;
		panel_1.add(lblDataAudioBuffers, gbc_lblAaa);

		JLabel             lblPicturesLost     = new JLabel(CCTVPlayer.bundle_lingua.getString("PICTURES_LOST"));
		GridBagConstraints gbc_lblPicturesLost = new GridBagConstraints();
		gbc_lblPicturesLost.insets = new Insets(0, 0, 5, 5);
		gbc_lblPicturesLost.gridx  = 0;
		gbc_lblPicturesLost.gridy  = 1;
		panel_1.add(lblPicturesLost, gbc_lblPicturesLost);

		lblDataPicturesLost = new JLabel("" + CCTVPlayer.getPannelloMediaPlayer()
		                                                .getPicturesLost());
		GridBagConstraints gbc_lblAaa_1 = new GridBagConstraints();
		gbc_lblAaa_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAaa_1.gridx  = 2;
		gbc_lblAaa_1.gridy  = 1;
		panel_1.add(lblDataPicturesLost, gbc_lblAaa_1);

		JLabel             lblDemuxCorrupted     = new JLabel(CCTVPlayer.bundle_lingua.getString("DEMUX_CORRUPTED"));
		GridBagConstraints gbc_lblDemuxCorrupted = new GridBagConstraints();
		gbc_lblDemuxCorrupted.insets = new Insets(0, 0, 0, 5);
		gbc_lblDemuxCorrupted.gridx  = 0;
		gbc_lblDemuxCorrupted.gridy  = 2;
		panel_1.add(lblDemuxCorrupted, gbc_lblDemuxCorrupted);

		lblDataDemuxCorrupted = new JLabel("" + CCTVPlayer.getPannelloMediaPlayer()
		                                                           .getDemuxCorrupted());
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.gridx = 2;
		gbc_label.gridy = 2;
		panel_1.add(lblDataDemuxCorrupted, gbc_label);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.requestFocus(true);

		runTimer();

		}

	/**
	 * Sets new texts for the labels, reflecting the new data.
	 *
	 * @param demux the demux value to set
	 * @param audio the audio value to set
	 * @param pic   the pic value to set
	 */
	private void updateLabels(int demux, int audio, int pic)
		{

		if (lblDataDemuxCorrupted != null)
			{
			this.lblDataDemuxCorrupted.setText("" + demux);
			}
		if (this.lblDataAudioBuffers != null)
			{
			this.lblDataAudioBuffers.setText(("" + audio));
			}
		if (this.lblDataPicturesLost != null)
			{
			this.lblDataPicturesLost.setText(("" + pic));
			}

		}

	/**
	 * Instantiates and runs a timer that checks for new data and calls the updateLabels method.
	 */
	private void runTimer()
		{
		Timer t = new Timer(1000, actionEvent ->
		{
		try
			{
			updateLabels(CCTVPlayer.getPannelloMediaPlayer()
			                       .getDemuxCorrupted(), CCTVPlayer.getPannelloMediaPlayer()
			                                                       .getAudioBuffersLost(), CCTVPlayer.getPannelloMediaPlayer()
			                                                                                         .getPicturesLost());
			}
		catch (Exception e)
			{
			updateLabels(0, 0, 0);
			}
		});

		t.start();

		}

	}
