import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PannelloSinistra extends JPanel
    {


    private PannelloInfoConnessione pInfo;
    private JLabel orologio;

    public PannelloSinistra ()
        {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200 , 100));
        this.orologio = new JLabel(new Date().toString());
        this.pInfo    = new PannelloInfoConnessione();

        this.add(pInfo , BorderLayout.CENTER);

        this.add(orologio , BorderLayout.NORTH);

        ExecutorService es = Executors.newFixedThreadPool(1);
        es.submit(new AggiornaOrologio());

        }


    private class AggiornaOrologio implements Runnable
        {

        @Override
        public void run ()
            {
            Timer timer = new Timer(1000 , new ActionListener()
                {
                @Override
                public void actionPerformed ( ActionEvent actionEvent )
                    {
                    orologio.setText(( new Date().toString() ));
                    }
                });

            timer.start();
            }
        }


    }
