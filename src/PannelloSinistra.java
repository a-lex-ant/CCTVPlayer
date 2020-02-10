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


    public PannelloSinistra ()
        {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200 , 100));

        this.pInfo    = new PannelloInfoConnessione();

        this.add(pInfo , BorderLayout.CENTER);

        }



    }
