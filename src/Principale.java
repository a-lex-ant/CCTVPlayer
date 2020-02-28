import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;


//VERSIONE DI SVILUPPO CON INTERNAZIONALIZZAZIONE

public class Principale
    {

    private static PannelloMediaPlayer p;
    private static LeftMenuBar menubarleft;

    protected static String languageChosen;
    protected static String countryChosen;
    protected static Locale currentLocale;
    protected static ResourceBundle bundle_lingua;

    public static void main ( String[] args )
        {

        setLookAndFeel();

        initializeLocale();

        JFrame frame = new JFrame(bundle_lingua.getString("LETTORE_VIDEO"));
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
        menubarleft = new LeftMenuBar();

        JSplitPane splitPane = new JSplitPane();
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        frame.getContentPane().add(splitPane , BorderLayout.CENTER);

        splitPane.setRightComponent(p);
        splitPane.setLeftComponent(menubarleft);
        frame.getContentPane().add(barraMenu , BorderLayout.NORTH);

        frame.getContentPane().add(new PannelloOrologio() , BorderLayout.SOUTH);


        frame.setVisible(true);
        frame.pack();

        }

    private static void setLookAndFeel ()
        {
        try
            {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch ( Exception e )
            {
            try
                {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
                } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex )
                {
                ex.printStackTrace();
                }
            e.printStackTrace();
            }
        }

    protected static void initializeLocale ()
        {
        Locale currentLocale = SaveUtilities.loadLocale();
        bundle_lingua = ResourceBundle.getBundle("LanguageBundles/LanguageBundle" , currentLocale);

        }


    public static PannelloMediaPlayer getP ()
        {
        return p;
        }

    public static LeftMenuBar getMenuBarLeft ()
        {
        return menubarleft;
        }

    }
