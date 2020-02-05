import javax.swing.*;
import java.awt.*;

public class Principale
    {

    public static void main ( String[] args )
        {
        JFrame frame = new JFrame("Lettore Video da File");
        frame.setMinimumSize(new Dimension(200 , 200));
        frame.setLayout(new BorderLayout());

        MenuBarra barraMenu = new MenuBarra();

        PannelloMediaPlayer p = new PannelloMediaPlayer();
        PannelloSinistra pannelloSinistra = new PannelloSinistra();

        JSplitPane splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        frame.getContentPane().add(splitPane , BorderLayout.CENTER);

        splitPane.setRightComponent(p);
        splitPane.setLeftComponent(pannelloSinistra);
        frame.getContentPane().add(barraMenu , BorderLayout.NORTH);
        frame.setVisible(true);


        }


    }
