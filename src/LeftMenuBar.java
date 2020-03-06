import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;

//orange: #E06234

/**
 * The Left menu bar class.
 */
public class LeftMenuBar extends JPanel
	{

	/**
	 * Instantiates a new Left menu bar.
	 */
	public LeftMenuBar()
		{
		LayoutManager grid = new GridLayout(8, 1);
		this.setLayout(grid);

			JButton statusMenu = new JButton(l10n.getString("STATUS"));
			statusMenu.setOpaque(true);

		JButton screenshotMenu = new JButton(l10n.getString("SCREENSHOT"));
		screenshotMenu.setOpaque(true);

		this.add(screenshotMenu);

		JButton connessioneMenu = new JButton(l10n.getString("CONNESSIONE"));
		connessioneMenu.setOpaque(true);

		connessioneMenu.addActionListener(actionEvent -> new FrameConnessione().setVisible(true));
		this.add(connessioneMenu);

		screenshotMenu.addActionListener(arg0 -> CCTVPlayer.getPannelloMediaPlayer()
		                                                   .SnapshotAndSave());

		this.add(statusMenu);
		statusMenu.addActionListener(
				arg0 -> JOptionPane.showMessageDialog(null, l10n.getString("IP_DEL_CLIENT_CORRENTE") + NetworkInfo.fornisciIndirizziLocali(),
				                                      l10n.getString("INFO_CLIENT"), JOptionPane.PLAIN_MESSAGE));

		try
			{
			BufferedImage statusImage = ImageIO.read(LeftMenuBar.class.getResource("resources/home.png"));
			BufferedImage screenshotImage = ImageIO.read(LeftMenuBar.class.getResource("resources/camera.png"));
			BufferedImage connessioneImage = ImageIO.read(LeftMenuBar.class.getResource("resources/database.png"));

			statusMenu.setIcon(new ImageIcon(statusImage));
			screenshotMenu.setIcon(new ImageIcon(screenshotImage));
			connessioneMenu.setIcon(new ImageIcon(connessioneImage));
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}

		this.setVisible(true);

		}

	}
