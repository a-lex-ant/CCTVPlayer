import javax.swing.*;
import java.awt.*;
import java.util.Locale;

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
		menuFile.setIcon(new ImageIcon("resources/file.png"));
		JMenu menuHelp = new JMenu(l10n.getString("HELP"));
		menuHelp.setIcon(new ImageIcon("resources/help.png"));
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
			ImageIcon aboutIcon       = new ImageIcon("resources/info.png");
			ImageIcon diagnosticsIcon = new ImageIcon("resources/activity.png");
			ImageIcon esciIcon        = new ImageIcon("resources/x.png");
			ImageIcon linguaIcon      = new ImageIcon("resources/globe.png");
			ImageIcon italianoIcon    = new ImageIcon("resources/ita.png");
			ImageIcon ingleseIcon     = new ImageIcon("resources/eng.png");
			voceApriDiagnostics.setIcon(diagnosticsIcon);
			voceEsci.setIcon(esciIcon);
			voceLocale.setIcon(linguaIcon);
			voceItaliano.setIcon(italianoIcon);
			voceInglese.setIcon(ingleseIcon);
			voceAbout.setIcon(aboutIcon);

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
		                               SaveUtilities.saveLocale("it","IT");
		                               JOptionPane.showMessageDialog(null, l10n.getString("CAMBIO_LOCALE"));
		                               });

		voceInglese.addActionListener(actionEvent ->
		                              {
		                              SaveUtilities.saveLocale("en","US");
		                              JOptionPane.showMessageDialog(null, l10n.getString("CAMBIO_LOCALE"));

		                              });

		this.add(Box.createHorizontalGlue());

		JButton maximize = new JButton();
		JButton minimize = new JButton();
		maximize.setIcon(new ImageIcon("resources/maximize.png"));
		maximize.setBorderPainted(false);
		maximize.addActionListener(actionEvent -> CCTVPlayer.massimizzaFrame());
		maximize.setToolTipText(l10n.getString("MASSIMIZZA"));
		minimize.setIcon(new ImageIcon("resources/minimize.png"));
		minimize.setBackground(new Color(33, 37, 43));
		maximize.setBackground(new Color(33, 37, 43));
		minimize.setToolTipText(l10n.getString("MINIMIZZA"));
		minimize.addActionListener(actionEvent -> CCTVPlayer.rimpicciolisciFrame());
		minimize.setBorderPainted(false);
		this.add(maximize);
		this.add(minimize);

		}

	}
