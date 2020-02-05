import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.io.*;

public class PannelloInfoConnessione extends JPanel
    {

    private JLabel clientIPDataLabel;
    private JTextArea statusDataTextArea;

    /**
     * Create the panel.
     */
    public PannelloInfoConnessione ()
        {
        setFont(new Font("DialogInput" , Font.PLAIN , 12));
        setPreferredSize(new Dimension(400 , 300));
        setMinimumSize(new Dimension(0 , 0));
        setLayout(new BorderLayout());

        JSplitPane splitPane = new JSplitPane();
        add(splitPane , BorderLayout.CENTER);


        JPanel panelSinistraTitoli = new JPanel();
        panelSinistraTitoli.setBackground(Color.LIGHT_GRAY);
        splitPane.setLeftComponent(panelSinistraTitoli);
        panelSinistraTitoli.setLayout(new GridLayout(0 , 1 , 0 , 0));

        JLabel statusTitle = new JLabel("Status");
        statusTitle.setFont(new Font("DialogInput" , Font.BOLD , 12));
        statusTitle.setBorder(new MatteBorder(1 , 1 , 1 , 0 , new Color(0 , 0 , 0)));
        statusTitle.setHorizontalAlignment(SwingConstants.CENTER);
        panelSinistraTitoli.add(statusTitle);

        JLabel serverAddressTitle = new JLabel("Server IP Address");
        serverAddressTitle.setFont(new Font("DialogInput" , Font.BOLD , 12));
        serverAddressTitle.setHorizontalAlignment(SwingConstants.CENTER);
        serverAddressTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        serverAddressTitle.setBorder(new MatteBorder(1 , 1 , 1 , 0 , new Color(0 , 0 , 0)));
        panelSinistraTitoli.add(serverAddressTitle);

        JLabel clientAddressTitle = new JLabel("Client IP Address");
        clientAddressTitle.setFont(new Font("DialogInput" , Font.BOLD , 12));
        clientAddressTitle.setHorizontalAlignment(SwingConstants.CENTER);
        clientAddressTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        clientAddressTitle.setBorder(new MatteBorder(1 , 1 , 1 , 0 , new Color(0 , 0 , 0)));
        panelSinistraTitoli.add(clientAddressTitle);

        JPanel panelDestraDati = new JPanel();
        panelDestraDati.setPreferredSize(new Dimension(200 , 100));
        panelDestraDati.setBackground(SystemColor.menu);
        splitPane.setRightComponent(panelDestraDati);
        panelDestraDati.setLayout(new GridLayout(0 , 1 , 0 , 0));

        //PANNELLO DEI MESSAGGI
        statusDataTextArea = new JTextArea("---\n" , 5 , 1);
        statusDataTextArea.setEditable(false);
        statusDataTextArea.setFont(new Font("DialogInput" , Font.BOLD , 12));
        statusDataTextArea.setBorder(new MatteBorder(1 , 0 , 1 , 1 , new Color(0 , 0 , 0)));
        panelDestraDati.add(statusDataTextArea);
        statusDataTextArea.setLineWrap(true);

        //aggiunta dello scroll pane alla JTextArea
        JScrollPane sp = new JScrollPane(statusDataTextArea);
        //aggiunta dello scroll pane al pannello che contiene la JTextArea
        panelDestraDati.add(sp);

        aggiornaStatusDataLabel();

        // FINE PANNELLO MESSAGGI


        JLabel serverIpDataLabel = new JLabel("---");
        serverIpDataLabel.setFont(new Font("DialogInput" , Font.BOLD , 12));
        serverIpDataLabel.setBorder(new MatteBorder(1 , 0 , 1 , 1 , new Color(0 , 0 , 0)));
        serverIpDataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelDestraDati.add(serverIpDataLabel);

        clientIPDataLabel = new JLabel("---");
        clientIPDataLabel.setFont(new Font("DialogInput" , Font.BOLD , 12));
        clientIPDataLabel.setBorder(new MatteBorder(1 , 0 , 1 , 1 , new Color(0 , 0 , 0)));
        clientIPDataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelDestraDati.add(clientIPDataLabel);
        aggiornaclientIPDataLabel();

        }

    @Override
    protected void paintComponent ( Graphics g )
        {
        //vedere classe NetworkInfo per ottenere dati da mettere nella label:

        try
            {
            clientIPDataLabel.setText(NetworkInfo.fornisciIndirizziLocali());
            } catch ( Exception e )
            {
            e.printStackTrace();
            }

        aggiornaStatusDataLabel();
        aggiornaclientIPDataLabel();


        }

    public void aggiornaStatusDataLabel ()
        {

        //NB: QUESTO FILE APERTO DI LOG È SOLO PER PROVA, non c'entra con il programma
        try
            {
            statusDataTextArea.read(new BufferedReader(new FileReader(new File("/home/lex/Documenti/laboratorio PAJC/mediaPlayerDaFile/log client"))) , null);
            } catch ( FileNotFoundException e )
            {
            e.printStackTrace();
            } catch ( IOException e )
            {
            e.printStackTrace();
            }
        }

    public void aggiornaclientIPDataLabel ()
        {
        clientIPDataLabel.setText(NetworkInfo.fornisciIndirizziLocali());
        }

    }
