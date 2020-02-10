import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class LeftMenuBar extends JPanel
    {

    public LeftMenuBar ()
        {
        LayoutManager grid = new GridLayout(0,1);
        this.setLayout(grid);

        JButton statusMenu = new JButton("Status");
        statusMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/book.png"));
        this.add(statusMenu);

       JButton screenshotMenu = new JButton("Screenshot");
        screenshotMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/camera.png"));
        this.add(screenshotMenu);

        JButton ipServerMenu = new JButton("Server IP");
        ipServerMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/database.png"));
        this.add(ipServerMenu);

        JButton ipClientMenu = new JButton("Client IP");
        ipClientMenu.setIcon(new ImageIcon("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/resources/home.png"));
        this.add(ipClientMenu);


        screenshotMenu.addActionListener(arg0 -> Principale.getP().SnapshotAndSave());

        ipServerMenu.addActionListener(arg0 ->
        {
        //get server info
        JOptionPane.showMessageDialog(null,  "Ip del server corrente: ---","ip info", JOptionPane.PLAIN_MESSAGE);
        });

        ipClientMenu.addActionListener(arg0 -> JOptionPane.showMessageDialog(null,  "Ip del client corrente: " + NetworkInfo.fornisciIndirizziLocali(), "Info sul client", JOptionPane.PLAIN_MESSAGE));

        statusMenu.addActionListener(arg0 ->
        {
        //open status frame
        });



        this.setVisible(true);

        }
    }
