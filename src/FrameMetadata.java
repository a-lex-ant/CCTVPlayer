
import javax.swing.*;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel contentPanel = new JPanel();
		JPanel panel_1 = new JPanel();
		JLabel lbl_AUDIO_BUFFERS_LOST = new JLabel();
		lblDataAudioBuffers = new JLabel();
		JLabel lblPicturesLost = new JLabel();
		lblDataPicturesLost = new JLabel();
		JLabel lblDemuxCorrupted = new JLabel();
		lblDataDemuxCorrupted = new JLabel();


		contentPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout());

		TitledBorder titledBorder = BorderFactory.createTitledBorder(l10n.getString("INFORMAZIONI_SUL_MEDIA"));
		titledBorder.setTitleJustification(TitledBorder.CENTER);
		titledBorder.setTitlePosition(TitledBorder.DEFAULT_POSITION);
		titledBorder.setTitleColor(new java.awt.Color(224, 98, 52));
		panel_1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5),titledBorder ));
		panel_1.setLayout(new GridLayout(3, 2, 30, 5));

		lbl_AUDIO_BUFFERS_LOST.setForeground(new Color(224, 98, 52));
		lbl_AUDIO_BUFFERS_LOST.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_AUDIO_BUFFERS_LOST.setText(l10n.getString("AUDIO_BUFFERS_LOST"));
		lbl_AUDIO_BUFFERS_LOST.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_AUDIO_BUFFERS_LOST.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(10, 10, 1, 10)));
		panel_1.add(lbl_AUDIO_BUFFERS_LOST);

		lblDataAudioBuffers.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataAudioBuffers.setText("0");
		lblDataAudioBuffers.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDataAudioBuffers.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(10, 10, 1, 10)));
		panel_1.add(lblDataAudioBuffers);

		lblPicturesLost.setForeground(new Color(224, 98, 52));
		lblPicturesLost.setHorizontalAlignment(SwingConstants.CENTER);
		lblPicturesLost.setText(l10n.getString("PICTURES_LOST"));
		lblPicturesLost.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(1, 10, 1, 10)));
		panel_1.add(lblPicturesLost);

		lblDataPicturesLost.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataPicturesLost.setText("0");
		lblDataPicturesLost.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(1, 10, 1, 10)));
		panel_1.add(lblDataPicturesLost);

		lblDemuxCorrupted.setForeground(new Color(224, 98, 52));
		lblDemuxCorrupted.setHorizontalAlignment(SwingConstants.CENTER);
		lblDemuxCorrupted.setText(l10n.getString("DEMUX_CORRUPTED"));
		lblDemuxCorrupted.setVerticalAlignment(SwingConstants.TOP);
		lblDemuxCorrupted.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(1, 10, 10, 10)));
		panel_1.add(lblDemuxCorrupted);

		lblDataDemuxCorrupted.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataDemuxCorrupted.setText("0");
		lblDataDemuxCorrupted.setVerticalAlignment(SwingConstants.TOP);
		lblDataDemuxCorrupted.setBorder(BorderFactory.createCompoundBorder(null, BorderFactory.createEmptyBorder(1, 10, 10, 10)));
		panel_1.add(lblDataDemuxCorrupted);

		contentPanel.add(panel_1, BorderLayout.CENTER);

		getContentPane().add(contentPanel, BorderLayout.CENTER);

		pack();

		this.setVisible(true);

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



	private void inizializza()
		{
		
		}





	}
