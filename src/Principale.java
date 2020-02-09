import javax.swing.*;
import java.awt.*;

public class Principale
    {

    private static PannelloMediaPlayer p;

    public static void main ( String[] args )
        {
        JFrame frame = new JFrame("Lettore Video da File");
        try
            {
            ImageIcon img = new ImageIcon("resources/cast.svg");
            frame.setIconImage(img.getImage());
            } catch ( Exception e )
            {
            e.printStackTrace();
            }
        frame.setMinimumSize(new Dimension(200 , 200));
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBarra barraMenu = new MenuBarra();

        p = new PannelloMediaPlayer();
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


    public static PannelloMediaPlayer getP ()
        {
        return p;
        }
    }
