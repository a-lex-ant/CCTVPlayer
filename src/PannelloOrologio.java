import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PannelloOrologio extends JPanel
    {
    private JLabel orologio;

    public PannelloOrologio ()
        {
        this.setLayout(new BorderLayout());
        this.orologio = new JLabel(new Date().toString());
        this.add(orologio , BorderLayout.CENTER);
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
