import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.base.MediaPlayerEventAdapter;
import uk.co.caprica.vlcj.player.base.SnapshotApi;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PannelloMediaPlayer extends JPanel implements ActionListener
    {

    private static String testoBottoneAvviaStream = "Avvia Stream";
    private static String testoBottoneSalvaSnap = "Salva Snapshot";
    private EmbeddedMediaPlayerComponent epc;
    private JButton apriFileBottone;
    private JButton salvaSnapshotBottone;

    public PannelloMediaPlayer ()
        {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500 , 500));
        this.setMinimumSize(new Dimension(0 , 0));
        this.apriFileBottone = new JButton(testoBottoneAvviaStream);
        apriFileBottone.setBackground(new Color(255 , 255 , 255));
        apriFileBottone.setOpaque(true);
        apriFileBottone.addActionListener(this);
        this.epc = new EmbeddedMediaPlayerComponent();
        this.add(epc , BorderLayout.CENTER);
        this.add(apriFileBottone , BorderLayout.SOUTH);
        this.setVisible(true);


        epc.mediaPlayer().events().addMediaPlayerEventListener(new MediaPlayerEventAdapter()
            {
            @Override
            public void finished ( MediaPlayer mediaPlayer )
                {
                JOptionPane.showMessageDialog(null , "Output Terminato");
                }

            @Override
            public void error ( MediaPlayer mediaPlayer )
                {
                System.exit(1);
                }
            });


        //FINE COSTRUTTORE
        }

    @Override
    public void actionPerformed ( ActionEvent actionEvent )
        {
        if ( actionEvent.getActionCommand().equals(testoBottoneAvviaStream) )
            {
            ExecutorService executorServicePlayback = Executors.newFixedThreadPool(1);
            executorServicePlayback.submit(new Runnable()
                {
                @Override
                public void run ()
                    {
                    //ATTENZIONE DOCUMENTAZIONE NON AGGIORNATA: epc.mediaPlayer() sostituisce epc.getMediaPlayer()

                    //TODO: aggiungere modo per controllare che lo stream sia stato attivato dall'altra parte, se no
                    // si chiude tutto!!

                    PannelloRichiestaDatiPerStream pnlRch;
                    JOptionPane.showConfirmDialog(null , pnlRch = new PannelloRichiestaDatiPerStream() , "Inserimento dati" ,
                            JOptionPane.OK_CANCEL_OPTION , JOptionPane.PLAIN_MESSAGE);
                    String[] dati = pnlRch.getDatiInseriti();
                    if(NetworkInfo.checkIfServerAvailable(dati))
                        {
                        epc.mediaPlayer().media().play("rtsp://" + dati[0] + ":" + dati[1] + "/");
                        }
                    }
                });

            }

        }


    public void SnapshotAndSave ()
        {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:ss");
        Date d = new Date();

        MediaPlayer mp = epc.mediaPlayer();
        SnapshotApi snapshots = mp.snapshots();
        snapshots.save(new File("snapshot_" + df.format(d) + "_.png"));
        }


    public int getAudioBuffersLost ()
        {
        if ( epc.mediaPlayer().media().info() == null | epc.mediaPlayer().media().info().statistics() == null )
            return 0;
        return epc.mediaPlayer().media().info().statistics().audioBuffersLost();
        }

    public int getPicturesLost ()
        {
        if ( epc.mediaPlayer().media().info() == null | epc.mediaPlayer().media().info().statistics() == null )
            return 0;
        return epc.mediaPlayer().media().info().statistics().picturesLost();
        }

    public int getDemuxCorrupted ()
        {
        if ( epc.mediaPlayer().media().info() == null | epc.mediaPlayer().media().info().statistics() == null )
            return 0;
        return epc.mediaPlayer().media().info().statistics().demuxCorrupted();
        }

    public double getInputBitrate ()
        {
        if ( epc.mediaPlayer().media().info() == null )
            return 0.0;
        return epc.mediaPlayer().media().info().statistics().inputBitrate();
        }


    //FINE CLASSE PANNELLO MEDIA PLAYER
    }
