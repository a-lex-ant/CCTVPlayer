import com.formdev.flatlaf.IntelliJTheme;
import com.sun.jdi.PathSearchingVirtualMachine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Enumeration;

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
	private static JFrame              frame;

	/**
	 * The entry point of the application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args)
		{

		new l10n();

		System.setProperty("awt.useSystemAAFontSettings", "on");

		setLookAndFeel();
		registerAndSetFont();

		frame = createFrame();

		MenuBarra barraMenu = new MenuBarra();

		pannelloMediaPlayer = new PannelloMediaPlayer();

		new DataUtility(pannelloMediaPlayer);

		LeftMenuBar menubarleft = new LeftMenuBar(); // The left menu bar.

		JSplitPane splitPane = createSplitPane(menubarleft);

		frame.getContentPane()
		     .add(splitPane, BorderLayout.CENTER);

		frame.getContentPane()
		     .add(barraMenu, BorderLayout.NORTH);

		frame.getContentPane()
		     .add(new PannelloOrologio(), BorderLayout.SOUTH);

		frame.setVisible(true);

		frame.pack();

		}

	private static JSplitPane createSplitPane(LeftMenuBar menubarleft)
		{
		JSplitPane splitPaneCreato = new JSplitPane();
		splitPaneCreato.setOneTouchExpandable(true);
		splitPaneCreato.setDividerLocation(150);
		splitPaneCreato.setRightComponent(pannelloMediaPlayer);
		splitPaneCreato.setLeftComponent(menubarleft);
		return splitPaneCreato;
		}

	private static JFrame createFrame()
		{
		JFrame frameCreata = new JFrame(l10n.getString("LETTORE_VIDEO"));
		try
			{
			BufferedImage iconImage = ImageIO.read(LeftMenuBar.class.getResource("resources/cast.png"));
			frameCreata.setIconImage(iconImage);
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		frameCreata.setMinimumSize(new Dimension(200, 200));
		frameCreata.setLayout(new BorderLayout());
		frameCreata.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return frameCreata;
		}

	/**
	 * Load, install and set custom font.
	 */
	private static void registerAndSetFont()
		{
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		try
			{
			SaveUtilities.checkForDirectoryExistance("/FontResources");
			InputStream fontResourceAsStream                    = CCTVPlayer.class.getResourceAsStream("Fonts/Roboto-Regular.ttf");
			File fontFile = new File("FontResources/roboto.ttf");
			FileOutputStream fontFileOutputStream = new FileOutputStream("FontResources/roboto.ttf");
			fontResourceAsStream.transferTo(fontFileOutputStream);

			Font roboto = Font.createFont(Font.TRUETYPE_FONT, fontFile)
			                  .deriveFont(15f);
			graphicsEnvironment.registerFont(roboto);

			putUIManagerSettings(roboto);

			}
		catch (FontFormatException | IOException | NullPointerException e)
			{
			System.out.println(l10n.getString("NO_FILE_FONT") + " " + e.getMessage());
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
	 *
	 * @Warning do NOT change the smooth scrolling setting: there's a bug in Vlcj that causes an immediate crash of the JRE.
	 */
	private static void setLookAndFeel()
		{

		UIManager.put("ScrollPane.smoothScrolling", false);
		IntelliJTheme.install(CCTVPlayer.class.getResourceAsStream("Temi/AtomOneDarkContrast.theme.json"));

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
