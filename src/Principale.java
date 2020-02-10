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
            ImageIcon img = new ImageIcon("resources/cast.png");
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
        //PannelloSinistra pannelloSinistra = new PannelloSinistra();
        LeftMenuBar menubarleft = new LeftMenuBar();

        JSplitPane splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        frame.getContentPane().add(splitPane , BorderLayout.CENTER);

        splitPane.setRightComponent(p);
        splitPane.setLeftComponent(menubarleft);
        frame.getContentPane().add(barraMenu , BorderLayout.NORTH);

        frame.getContentPane().add(new PannelloOrologio(),BorderLayout.SOUTH);



        frame.setVisible(true);


        }


    public static PannelloMediaPlayer getP ()
        {
        return p;
        }
    }
