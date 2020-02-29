
import com.formdev.flatlaf.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import static java.util.Collections.list;


//VERSIONE DI SVILUPPO CON INTERNAZIONALIZZAZIONE

public class Principale
    {

    private static PannelloMediaPlayer p;
    private static LeftMenuBar menubarleft;

    private static JFrame frame;

    protected static ResourceBundle bundle_lingua;

    public static void main ( String[] args )
        {

        System.setProperty("awt.useSystemAAFontSettings","on");


        setLookAndFeel();
              registerAndSetFont();
        initializeLocale();

        frame = new JFrame(bundle_lingua.getString("LETTORE_VIDEO"));
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

    private static void registerAndSetFont ()
        {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try
            {

            Font roboto = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Roboto-Regular.ttf")).deriveFont(15f);
            graphicsEnvironment.registerFont(roboto);

            putUIManagerSettings(roboto);

            } catch ( FontFormatException | IOException e )
            {
            e.printStackTrace();
            }
        }


    private static void putUIManagerSettings ( Font roboto )
        {
        UIDefaults defaults = UIManager.getDefaults();
        Enumeration<Object> keysEnumeration = defaults.keys();
        ArrayList<Object> keysList = list(keysEnumeration);
        Object[] array = keysList.stream().map(k -> k.toString()).filter(k -> k.contains("font")).toArray();
        for(Object o : array)
            {
            if (o instanceof String)
                {
                UIManager.put(o,roboto);
                }
            }
        }

    private static void setLookAndFeel ()
        {

            //IntelliJTheme.install(Principale.class.getResourceAsStream("Material Lighter Contrast.theme.json"));

            //IntelliJTheme.install(Principale.class.getResourceAsStream("Atom One Light.theme.json"));
            //IntelliJTheme.install(Principale.class.getResourceAsStream("Temi/DarkFlatTheme.theme.json"));
            //UIManager.setLookAndFeel(new FlatIntelliJLaf());
        UIManager.put( "ScrollPane.smoothScrolling", false );
        IntelliJTheme.install(Principale.class.getResourceAsStream("Temi/AtomOneDarkContrast.theme.json")); //preferito

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

    public static void rimpicciolisciFrame()
        {frame.pack();}
    public static void massimizzaFrame()
        {frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }


    }
