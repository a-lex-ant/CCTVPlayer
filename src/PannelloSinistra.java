import javax.swing.*;
import java.awt.*;

public class PannelloSinistra extends JPanel
    {


    private PannelloInfoConnessione pInfo;


    public PannelloSinistra ()
        {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200 , 100));

        this.pInfo = new PannelloInfoConnessione();

        this.add(pInfo , BorderLayout.CENTER);

        }


    }
