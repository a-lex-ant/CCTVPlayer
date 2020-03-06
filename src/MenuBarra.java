import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * The MenuBar class.
 */
public class MenuBarra extends JMenuBar
	{

	/**
	 * Instantiates a new menu bar to be put north of the main frame.
	 */
	public MenuBarra()
		{

		JMenu menuFile = new JMenu(l10n.getString("FILE"));

		JMenu menuHelp = new JMenu(l10n.getString("HELP"));

		this.add(menuFile);
		this.add(menuHelp);
		JMenuItem voceAbout           = new JMenuItem(l10n.getString("ABOUT"));
		JMenu     voceLocale          = new JMenu(l10n.getString("SCEGLI_LINGUA"));
		JMenuItem voceEsci            = new JMenuItem(l10n.getString("ESCI"));
		JMenuItem voceApriDiagnostics = new JMenuItem(l10n.getString("APRI_DIAGNOSTICS"));
		JMenuItem voceItaliano        = new JMenuItem("Italiano");
		JMenuItem voceInglese         = new JMenuItem("English");
		try
			{
			BufferedImage aboutIcon       = ImageIO.read(MenuBarra.class.getResource("resources/info.png"));
			BufferedImage diagnosticsIcon = ImageIO.read(MenuBarra.class.getResource("resources/activity.png"));
			BufferedImage esciIcon        = ImageIO.read(MenuBarra.class.getResource("resources/x.png"));
			BufferedImage linguaIcon      = ImageIO.read(MenuBarra.class.getResource("resources/globe.png"));
			BufferedImage italianoIcon    = ImageIO.read(MenuBarra.class.getResource("resources/ita.png"));
			BufferedImage ingleseIcon     = ImageIO.read(MenuBarra.class.getResource("resources/eng.png"));
			BufferedImage fileIcon     = ImageIO.read(MenuBarra.class.getResource("resources/file.png"));
			BufferedImage helpIcon     = ImageIO.read(MenuBarra.class.getResource("resources/help.png"));

			menuFile.setIcon(new ImageIcon(fileIcon));
			menuHelp.setIcon(new ImageIcon(helpIcon));
			voceApriDiagnostics.setIcon(new ImageIcon(diagnosticsIcon));
			voceEsci.setIcon(new ImageIcon(esciIcon));
			voceLocale.setIcon(new ImageIcon(linguaIcon));
			voceItaliano.setIcon(new ImageIcon(italianoIcon));
			voceInglese.setIcon(new ImageIcon(ingleseIcon));
			voceAbout.setIcon(new ImageIcon(aboutIcon));

			}
		catch (Exception e)
			{
			e.printStackTrace();
			}

		menuFile.add(voceEsci);
		menuFile.add(voceApriDiagnostics);
		voceLocale.add(voceItaliano);
		voceLocale.add(voceInglese);
		menuFile.add(voceLocale);
		menuHelp.add(voceAbout);

		voceAbout.addActionListener((e) -> new CreditsFrame().setVisible(true));

		//aggiunta del comportamento della voce "esci" del menu principale
		voceEsci.addActionListener(actionEvent ->
		                           {
		                           CCTVPlayer.getPannelloMediaPlayer()
		                                     .releaseMediaPlayer();
		                           System.exit(0);

		                           });

		voceApriDiagnostics.addActionListener(actionEvent ->
		                                      {
		                                      try
			                                      {
			                                      new FrameMetadata();
			                                      }
		                                      catch (NullPointerException e)
			                                      {
			                                      JOptionPane.showMessageDialog(null, l10n.getString("NESSUNO_STREAM_VIDEO_ATTIVO"),
			                                                                    l10n.getString("NESSUN_DATO_DI_DIAGNOSTICA_DISPONIBILE"),
			                                                                    JOptionPane.ERROR_MESSAGE);
			                                      }

		                                      });

		voceItaliano.addActionListener(actionEvent ->
		                               {
		                               SaveUtilities.saveLocale("it", "IT");
		                               JOptionPane.showMessageDialog(null, l10n.getString("CAMBIO_LOCALE"));
		                               });

		voceInglese.addActionListener(actionEvent ->
		                              {
		                              SaveUtilities.saveLocale("en", "US");
		                              JOptionPane.showMessageDialog(null, l10n.getString("CAMBIO_LOCALE"));

		                              });

		this.add(Box.createHorizontalGlue());

		JButton maximize = new JButton();
		JButton minimize = new JButton();

		maximize.setBorderPainted(false);
		maximize.addActionListener(actionEvent -> CCTVPlayer.massimizzaFrame());
		maximize.setToolTipText(l10n.getString("MASSIMIZZA"));

		minimize.setBackground(new Color(33, 37, 43));
		maximize.setBackground(new Color(33, 37, 43));
		minimize.setToolTipText(l10n.getString("MINIMIZZA"));
		minimize.addActionListener(actionEvent -> CCTVPlayer.rimpicciolisciFrame());
		minimize.setBorderPainted(false);

		try
			{
			BufferedImage massimizzaIcon = ImageIO.read(MenuBarra.class.getResource("resources/minimize.png"));
			BufferedImage minimizzaIcon = ImageIO.read(MenuBarra.class.getResource("resources/maximize.png"));

			maximize.setIcon(new ImageIcon(massimizzaIcon));
			minimize.setIcon(new ImageIcon(minimizzaIcon));
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}

		this.add(maximize);
		this.add(minimize);

		}

	}
