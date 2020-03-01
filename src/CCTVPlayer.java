import com.formdev.flatlaf.IntelliJTheme;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.Collections.list;

/**
 * The main Class, which starts the application.
 */
public class CCTVPlayer
	{

	/**
	 * the media player panel
	 */
	private static PannelloMediaPlayer pannelloMediaPlayer;
	/**
	 * The main frame.
	 */
	private static JFrame frame;
	/**
	 * The language bundle for internationalization.
	 */
	protected static ResourceBundle bundle_lingua;

	/**
	 * The entry point of the application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args)
		{

		System.setProperty("awt.useSystemAAFontSettings", "on");

		setLookAndFeel();
		registerAndSetFont();
		initializeLocale();

		frame = new JFrame(bundle_lingua.getString("LETTORE_VIDEO"));
		try
			{
			ImageIcon img = new ImageIcon("resources/cast.png");
			frame.setIconImage(img.getImage());
			}
		catch (Exception e)

			{
			e.printStackTrace();
			}
		frame.setMinimumSize(new Dimension(200, 200));
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MenuBarra barraMenu = new MenuBarra();

		pannelloMediaPlayer = new PannelloMediaPlayer();

		LeftMenuBar menubarleft = new LeftMenuBar(); // The left menu bar.

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		splitPane.setDividerLocation(150);
		frame.getContentPane()
		     .add(splitPane, BorderLayout.CENTER);

		splitPane.setRightComponent(pannelloMediaPlayer);
		splitPane.setLeftComponent(menubarleft);
		frame.getContentPane()
		     .add(barraMenu, BorderLayout.NORTH);

		frame.getContentPane()
		     .add(new PannelloOrologio(), BorderLayout.SOUTH);

		frame.setVisible(true);
		frame.pack();

		}

	/**
	 * Install and set custom font.
	 */
	private static void registerAndSetFont()
		{
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try
			{

			Font roboto = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Roboto-Regular.ttf"))
			                  .deriveFont(15f);
			graphicsEnvironment.registerFont(roboto);

			putUIManagerSettings(roboto);

			}
		catch (FontFormatException | IOException e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * "Universally" installs the font by getting all the UIDefault keys that contain "font" in their name.
	 *
	 * @param roboto the custom font name
	 */
	private static void putUIManagerSettings(Font roboto)
		{
		UIDefaults          defaults        = UIManager.getDefaults();
		Enumeration<Object> keysEnumeration = defaults.keys();
		ArrayList<Object>   keysList        = list(keysEnumeration);
		Object[] array = keysList.stream()
		                         .map(Object::toString)
		                         .filter(k -> k.contains("font"))
		                         .toArray();
		for (Object o : array)
			{
			if (o instanceof String)
				{
				UIManager.put(o, roboto);
				}
			}
		}

	/**
	 * Sets look and feel.
	 * @Warning do NOT change the smooth scrolling setting: there's a bug in Vlcj that causes an immediate crash of the JRE.
	 */
	private static void setLookAndFeel()
		{

		UIManager.put("ScrollPane.smoothScrolling", false);
		IntelliJTheme.install(CCTVPlayer.class.getResourceAsStream("Temi/AtomOneDarkContrast.theme.json"));

		}

	/**
	 * Initializes the locale, loading it from the HDD.
	 */
	protected static void initializeLocale()
		{
		Locale currentLocale = SaveUtilities.loadLocale();
		bundle_lingua = ResourceBundle.getBundle("LanguageBundles/LanguageBundle", currentLocale);

		}


	public static PannelloMediaPlayer getPannelloMediaPlayer()
		{
		return pannelloMediaPlayer;
		}

	/**
	 * Resizes the main frame to a smaller standard size.
	 */
	public static void rimpicciolisciFrame()
		{
		frame.setExtendedState(JFrame.NORMAL);
		}

	/**
	 * Maximises the main frame.
	 */
	public static void massimizzaFrame()
		{
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		}

	}
