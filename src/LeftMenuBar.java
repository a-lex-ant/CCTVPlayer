import com.sun.jna.platform.unix.X11;

import javax.swing.*;
import java.awt.*;

public class LeftMenuBar extends JPanel
    {

    public LeftMenuBar ()
        {
        LayoutManager grid = new GridLayout(8 , 1);
        this.setLayout(grid);

        JButton statusMenu = new JButton(Principale.bundle_lingua.getString("STATUS"));
        statusMenu.setBackground(new Color(255 , 255 , 255));
        statusMenu.setOpaque(true);
        statusMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/book.png"));
        this.add(statusMenu);

        JButton screenshotMenu = new JButton(Principale.bundle_lingua.getString("SCREENSHOT"));
        screenshotMenu.setBackground(new Color(255 , 255 , 255));
        screenshotMenu.setOpaque(true);
        screenshotMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/camera" +
                ".png"));
        this.add(screenshotMenu);

        /*JButton avviaStreamMenu = new JButton(Principale.bundle_lingua.getString("AVVIA_STREAM"));
        avviaStreamMenu.setBackground(new Color(255 , 255 , 255));
        avviaStreamMenu.setOpaque(true);
        avviaStreamMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/database" +
                ".png"));
        this.add(avviaStreamMenu);
        */

        JButton ConnessioneMenu = new JButton(Principale.bundle_lingua.getString("CONNESSIONE"));
        ConnessioneMenu.setBackground(new Color(255 , 255 , 255));
        ConnessioneMenu.setOpaque(true);
        ConnessioneMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/database" +
                ".png"));
        this.add(ConnessioneMenu);


        screenshotMenu.addActionListener(arg0 -> Principale.getP().SnapshotAndSave());

        /*avviaStreamMenu.addActionListener(arg0 ->
        {
        //get server info
        JOptionPane.showMessageDialog(null , Principale.bundle_lingua.getString("IP_DEL_SERVER_CORRENTE") ,
                Principale.bundle_lingua.getString("IP_INFO") , JOptionPane.PLAIN_MESSAGE);
        });
        */

        ConnessioneMenu.addActionListener(arg0 -> JOptionPane.showMessageDialog(null ,
                Principale.bundle_lingua.getString("IP_DEL_CLIENT_CORRENTE") + NetworkInfo.fornisciIndirizziLocali()
                , "Info sul client" , JOptionPane.PLAIN_MESSAGE));

        statusMenu.addActionListener(arg0 ->
        {
        //open status frame
        });


        this.setVisible(true);

        }
    }
