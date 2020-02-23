import javax.swing.*;
import java.awt.*;

public class LeftMenuBar extends JPanel
    {

    public LeftMenuBar ()
        {
        LayoutManager grid = new GridLayout(0 , 1);
        this.setLayout(grid);

        JButton statusMenu = new JButton(Principale.bundle_lingua.getString("STATUS"));
        statusMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/book.png"));
        this.add(statusMenu);

        JButton screenshotMenu = new JButton(Principale.bundle_lingua.getString("SCREENSHOT"));
        screenshotMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/camera" +
                ".png"));
        this.add(screenshotMenu);

        JButton ipServerMenu = new JButton(Principale.bundle_lingua.getString("SERVER_IP"));
        ipServerMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/database" +
                ".png"));
        this.add(ipServerMenu);

        JButton ipClientMenu = new JButton(Principale.bundle_lingua.getString("CLIENT_IP"));
        ipClientMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/home" +
                ".png"));
        this.add(ipClientMenu);


        screenshotMenu.addActionListener(arg0 -> Principale.getP().SnapshotAndSave());

        ipServerMenu.addActionListener(arg0 ->
        {
        //get server info
        JOptionPane.showMessageDialog(null , Principale.bundle_lingua.getString("IP_DEL_SERVER_CORRENTE") ,
                Principale.bundle_lingua.getString("IP_INFO") , JOptionPane.PLAIN_MESSAGE);
        });

        ipClientMenu.addActionListener(arg0 -> JOptionPane.showMessageDialog(null ,
                Principale.bundle_lingua.getString("IP_DEL_CLIENT_CORRENTE") + NetworkInfo.fornisciIndirizziLocali()
                , "Info sul client" , JOptionPane.PLAIN_MESSAGE));

        statusMenu.addActionListener(arg0 ->
        {
        //open status frame
        });


        this.setVisible(true);

        }
    }
