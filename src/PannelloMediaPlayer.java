import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.base.SnapshotApi;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Media Player panel class.
 */
public class PannelloMediaPlayer extends JPanel implements ActionListener
	{

	/**
	 * The embedded media player component.
	 */
	private EmbeddedMediaPlayerComponent embeddedMediaPlayerComponent;

	/**
	 * Instantiates a new media player panel.
	 */
	public PannelloMediaPlayer()
		{
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500, 500));
		this.setMinimumSize(new Dimension(100, 100));
		JButton apriFileBottone = new JButton(l10n.getString("AVVIA_STREAM"));
		apriFileBottone.setOpaque(true);
		apriFileBottone.setIcon(new ImageIcon("resources/play.png"));
		apriFileBottone.addActionListener(this);
		this.embeddedMediaPlayerComponent = new EmbeddedMediaPlayerComponent();
		this.add(embeddedMediaPlayerComponent, BorderLayout.CENTER);
		this.add(apriFileBottone, BorderLayout.SOUTH);
		this.setVisible(true);

		embeddedMediaPlayerComponent.mediaPlayer()
		                            .events()
		                            .addMediaPlayerEventListener(new MediaPlayerEventAdapter()
			   {
			   @Override
			   public void finished(MediaPlayer mediaPlayer)
				   {
				   JOptionPane.showMessageDialog(null, l10n.getString("OUTPUT_TERMINATO"));
				   }

			   @Override
			   public void error(MediaPlayer mediaPlayer)
				   {
				   releaseMediaPlayer();
				   }
			   });

		//END CONSTRUCTOR
		}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
		{
		if (actionEvent.getActionCommand()
		               .equals(l10n.getString("AVVIA_STREAM")))
			{
			ExecutorService executorServicePlayback = Executors.newFixedThreadPool(1);
			executorServicePlayback.submit(() ->
			                               {
			                               //ATTENZIONE DOCUMENTAZIONE NON AGGIORNATA: epc.mediaPlayer() sostituisce epc.getMediaPlayer()

			                               PannelloRichiestaDatiPerStream pnlRch;

			                               int choice = JOptionPane.showConfirmDialog(null, pnlRch = new PannelloRichiestaDatiPerStream(),
			                                                                          l10n.getString("INSERTING_DATA"), JOptionPane.OK_CANCEL_OPTION,
			                                                                          JOptionPane.PLAIN_MESSAGE);
			                               if (choice == 0)
				                               {
				                               String[] dati = pnlRch.getDatiInseriti();
				                               if (dati != null)
					                               {
					                               try
						                               {
						                               if (NetworkInfo.hostAvailabilityCheck(dati[0]))
							                               {
							                               embeddedMediaPlayerComponent.mediaPlayer()
							                                                           .media()
							                                                           .play("rtsp://" + dati[0] + ":" + dati[1] + "/");
							                               }
						                               else
							                               {
							                               JOptionPane.showMessageDialog(this,
							                                                             l10n.getString("SERVER_NON_RAGG"),
							                                                             l10n.getString("SERVER_NON_RAGG_SHORT"),
							                                                             JOptionPane.ERROR_MESSAGE);
							                               }
						                               }
					                               catch (IOException e)
						                               {
						                               releaseMediaPlayer();
						                               }
					                               }
				                               }
			                               });

			}

		}

	/**
	 * Take a snapshot and save.
	 */
	public void SnapshotAndSave()
		{
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:ss");
		Date             d  = new Date();

		MediaPlayer mp        = embeddedMediaPlayerComponent.mediaPlayer();
		SnapshotApi snapshots = mp.snapshots();
		snapshots.save(new File("snapshot_" + df.format(d) + "_.png"));
		}

	/**
	 * Gets the audio buffers lost.
	 *
	 * @return the audio buffers lost
	 */
	public int getAudioBuffersLost()
		{
		if (embeddedMediaPlayerComponent.mediaPlayer()
		                                .media()
		                                .info() == null | embeddedMediaPlayerComponent.mediaPlayer()
		                                                                              .media()
		                                                                              .info()
		                                                                              .statistics() == null) { return 0; }
		return embeddedMediaPlayerComponent.mediaPlayer()
		                                   .media()
		                                   .info()
		                                   .statistics()
		                                   .audioBuffersLost();
		}

	/**
	 * Gets the pictures lost.
	 *
	 * @return the pictures lost
	 */
	public int getPicturesLost()
		{
		if (embeddedMediaPlayerComponent.mediaPlayer()
		                                .media()
		                                .info() == null | embeddedMediaPlayerComponent.mediaPlayer()
		                                                                              .media()
		                                                                              .info()
		                                                                              .statistics() == null) { return 0; }
		return embeddedMediaPlayerComponent.mediaPlayer()
		                                   .media()
		                                   .info()
		                                   .statistics()
		                                   .picturesLost();
		}

	/**
	 * Gets the demux corrupted.
	 *
	 * @return the demux corrupted
	 */
	public int getDemuxCorrupted()
		{
		if (embeddedMediaPlayerComponent.mediaPlayer()
		                                .media()
		                                .info() == null | embeddedMediaPlayerComponent.mediaPlayer()
		                                                                              .media()
		                                                                              .info()
		                                                                              .statistics() == null) { return 0; }
		return embeddedMediaPlayerComponent.mediaPlayer()
		                                   .media()
		                                   .info()
		                                   .statistics()
		                                   .demuxCorrupted();
		}

	/**
	 * Gets the input bitrate.
	 *
	 * @return the input bitrate
	 */
	public double getInputBitrate()
		{
		if (embeddedMediaPlayerComponent.mediaPlayer()
		                                .media()
		                                .info() == null) { return 0.0; }
		return embeddedMediaPlayerComponent.mediaPlayer()
		                                   .media()
		                                   .info()
		                                   .statistics()
		                                   .inputBitrate();
		}

	/**
	 * Release the media player.
	 */
	protected void releaseMediaPlayer()
		{
		embeddedMediaPlayerComponent.mediaPlayer()
		                            .release();
		}

	//END OF CLASS
	}
