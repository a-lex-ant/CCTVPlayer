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
	private JPanel panelStatisticheConnessione;

	/**
	 * Instantiates the new frame.
	 */
	public FrameMetadata()
		{
		setTitle(l10n.getString("STATISTICHE"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanel);

		JPanel rootPanel = new JPanel();
		contentPanel.add(rootPanel, BorderLayout.CENTER);
		rootPanel.setLayout(new BorderLayout(0, 0));

		/*panelStatisticheConnessione = new JPanel();
		panelStatisticheConnessione.setBorder(
				new TitledBorder(null, l10n.getString("STAT_SULLA_CONNESSIONE"), TitledBorder.LEADING, TitledBorder.TOP, null,
				                 null));
		rootPanel.add(panelStatisticheConnessione, BorderLayout.CENTER);
		//panelStatisticheConnessione.add(new NetworkMonitorPanel());

		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, l10n.getString("INFORMAZIONI_SUL_MEDIA"), TitledBorder.LEADING, TitledBorder.TOP, null,
				                 null));
		contentPanel.add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbLayout_panel_1 = new GridBagLayout();
		gbLayout_panel_1.columnWidths  = new int[]{2, 0, 0, 0};
		gbLayout_panel_1.rowHeights    = new int[]{2, 0, 0, 0};
		gbLayout_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbLayout_panel_1.rowWeights    = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbLayout_panel_1);



		JLabel             lbl_AUDIO_BUFFERS_LOST = new JLabel(l10n.getString("AUDIO_BUFFERS_LOST"));
		GridBagConstraints gbConstraints_lblNewLabel        = new GridBagConstraints();
		gbConstraints_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbConstraints_lblNewLabel.gridx  = 0;
		gbConstraints_lblNewLabel.gridy  = 0;
		panel_1.add(lbl_AUDIO_BUFFERS_LOST, gbConstraints_lblNewLabel);

		lblDataAudioBuffers = new JLabel("" + DataUtility
		                                                .getAudioBuffersLost());
		GridBagConstraints gbConstraints_lblAaa = new GridBagConstraints();
		gbConstraints_lblAaa.insets = new Insets(0, 0, 5, 0);
		gbConstraints_lblAaa.gridx  = 2;
		gbConstraints_lblAaa.gridy  = 0;
		panel_1.add(lblDataAudioBuffers, gbConstraints_lblAaa);

		JLabel             lblPicturesLost     = new JLabel(l10n.getString("PICTURES_LOST"));
		GridBagConstraints gbConstraints_lblPicturesLost = new GridBagConstraints();
		gbConstraints_lblPicturesLost.insets = new Insets(0, 0, 5, 5);
		gbConstraints_lblPicturesLost.gridx  = 0;
		gbConstraints_lblPicturesLost.gridy  = 1;
		panel_1.add(lblPicturesLost, gbConstraints_lblPicturesLost);

		lblDataPicturesLost = new JLabel("" + DataUtility
		                                                .getPicturesLost());
		GridBagConstraints gbConstraints_lblAaa_1 = new GridBagConstraints();
		gbConstraints_lblAaa_1.insets = new Insets(0, 0, 5, 0);
		gbConstraints_lblAaa_1.gridx  = 2;
		gbConstraints_lblAaa_1.gridy  = 1;
		panel_1.add(lblDataPicturesLost, gbConstraints_lblAaa_1);

		JLabel             lblDemuxCorrupted     = new JLabel(l10n.getString("DEMUX_CORRUPTED"));
		GridBagConstraints gbConstraints_lblDemuxCorrupted = new GridBagConstraints();
		gbConstraints_lblDemuxCorrupted.insets = new Insets(0, 0, 0, 5);
		gbConstraints_lblDemuxCorrupted.gridx  = 0;
		gbConstraints_lblDemuxCorrupted.gridy  = 2;
		panel_1.add(lblDemuxCorrupted, gbConstraints_lblDemuxCorrupted);

		lblDataDemuxCorrupted = new JLabel("" + DataUtility.getDemuxCorrupted());
		GridBagConstraints gbConstraintsonstraints_label = new GridBagConstraints();
		gbConstraintsonstraints_label.gridx = 2;
		gbConstraintsonstraints_label.gridy = 2;
		panel_1.add(lblDataDemuxCorrupted, gbConstraintsonstraints_label);

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
			updateLabels(DataUtility.getDemuxCorrupted(), (int)DataUtility.getAudioBuffersLost(), (int)DataUtility.getPicturesLost());
			}
		catch (Exception e)
			{
			updateLabels(0, 0, 0);
			}
		});

		t.start();

		}


	}
