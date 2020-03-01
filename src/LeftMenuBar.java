import javax.swing.*;
import java.awt.*;

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

		JButton statusMenu = new JButton(CCTVPlayer.bundle_lingua.getString("STATUS"));
		statusMenu.setOpaque(true);
		statusMenu.setIcon(new ImageIcon("resources/home.png"));
		this.add(statusMenu);

		JButton screenshotMenu = new JButton(CCTVPlayer.bundle_lingua.getString("SCREENSHOT"));
		screenshotMenu.setOpaque(true);
		screenshotMenu.setIcon(new ImageIcon("resources/camera" + ".png"));
		this.add(screenshotMenu);

		JButton connessioneMenu = new JButton(CCTVPlayer.bundle_lingua.getString("CONNESSIONE"));
		connessioneMenu.setOpaque(true);
		connessioneMenu.setIcon(new ImageIcon("resources/database.png"));
		connessioneMenu.addActionListener(actionEvent -> new FrameConnessione().setVisible(true));
		this.add(connessioneMenu);

		screenshotMenu.addActionListener(arg0 -> CCTVPlayer.getPannelloMediaPlayer()
		                                                   .SnapshotAndSave());

		statusMenu.addActionListener(arg0 -> JOptionPane.showMessageDialog(null, CCTVPlayer.bundle_lingua.getString("IP_DEL_CLIENT_CORRENTE") +
		                                                                         NetworkInfo.fornisciIndirizziLocali(), "Info sul client",
		                                                                   JOptionPane.PLAIN_MESSAGE));

		this.setVisible(true);

		}

	}
