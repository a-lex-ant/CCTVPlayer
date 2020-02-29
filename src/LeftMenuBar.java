

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;


//colore arancione: #E06234

public class LeftMenuBar extends JPanel
    {
    //private ClientTCPGUI ctg;

    public LeftMenuBar ()
        {
        LayoutManager grid = new GridLayout(8 , 1);
        this.setLayout(grid);

        JButton statusMenu = new JButton(Principale.bundle_lingua.getString("STATUS"));
//        statusMenu.setBackground(new Color(255 , 255 , 255));
        statusMenu.setOpaque(true);
        statusMenu.setIcon(new ImageIcon("resources/home.png"));
        this.add(statusMenu);

        JButton screenshotMenu = new JButton(Principale.bundle_lingua.getString("SCREENSHOT"));
 //       screenshotMenu.setBackground(new Color(255 , 255 , 255));
        screenshotMenu.setOpaque(true);
        screenshotMenu.setIcon(new ImageIcon("resources/camera" +
                ".png"));
        this.add(screenshotMenu);

        /*JButton avviaStreamMenu = new JButton(Principale.bundle_lingua.getString("AVVIA_STREAM"));
        avviaStreamMenu.setBackground(new Color(255 , 255 , 255));
        avviaStreamMenu.setOpaque(true);
        avviaStreamMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/database" +
                ".png"));
        this.add(avviaStreamMenu);
        */

        JButton connessioneMenu = new JButton(Principale.bundle_lingua.getString("CONNESSIONE"));
 //       connessioneMenu.setBackground(new Color(255 , 255 , 255));
        connessioneMenu.setOpaque(true);
        connessioneMenu.setIcon(new ImageIcon("resources/database.png"));
        connessioneMenu.addActionListener(new ActionListener()
            {
            @Override
            public void actionPerformed ( ActionEvent actionEvent )
                {
                    new FrameConnessione().setVisible(true);
                }
            });
        this.add(connessioneMenu);



        screenshotMenu.addActionListener(arg0 -> Principale.getP().SnapshotAndSave());

        /*avviaStreamMenu.addActionListener(arg0 ->
        {
        //get server info
        JOptionPane.showMessageDialog(null , Principale.bundle_lingua.getString("IP_DEL_SERVER_CORRENTE") ,
                Principale.bundle_lingua.getString("IP_INFO") , JOptionPane.PLAIN_MESSAGE);
        });
        */

        statusMenu.addActionListener(arg0 -> JOptionPane.showMessageDialog(null ,
                Principale.bundle_lingua.getString("IP_DEL_CLIENT_CORRENTE") + NetworkInfo.fornisciIndirizziLocali()
                , "Info sul client" , JOptionPane.PLAIN_MESSAGE));



        this.setVisible(true);

        }


    }
