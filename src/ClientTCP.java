import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTCP implements ActionListener
    {

    public static final String MESSAGGIO_CHIUSURA_CONNESSIONE = "CHIUDI CONNESSIONE";
    public static final String MESSAGGIO_ARRESTA_SISTEMA_REMOTO = "SPEGNI SISTEMA";



    protected static String inArrivoDalServer = Principale.bundle_lingua.getString("INCOMING");

    private static String serverString;
    private static int portaInt;

    private static PrintWriter out;
    private static Socket socketConIlServer;
    private static BufferedReader in;


    public ClientTCP ( String indirizzo , int port )
        {

        serverString = indirizzo;
        portaInt     = port;
        if ( avviaClientInvio() )
            {
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(this::cicloRicezione);
            ClientTCPGUI.chiudiSetEnabled();
            }


        }// fine costruttore

    private boolean avviaClientInvio ()
        {
        try
            {
            if ( hostAvailabilityCheck() )
                {
                socketConIlServer = new Socket(serverString , portaInt);
                out               = new PrintWriter(socketConIlServer.getOutputStream());
                in                = new BufferedReader(new InputStreamReader(socketConIlServer.getInputStream()));
                return true;
                } else
                {
                return false;
                }
            } catch ( ConnectException e )
            {

            e.printStackTrace();
            return false;
            } catch ( IOException e )
            {

            e.printStackTrace();
            return false;
            }


        } //fine avvia client


    private void cicloRicezione ()
        {
        System.out.println(Principale.bundle_lingua.getString("INIZIO_CICLO"));
        String inArrivo = "";
        while ( in != null )
            {

            try
                {
                inArrivo = in.readLine();
                } catch ( IOException e )
                {
                System.out.println(Principale.bundle_lingua.getString("CICLO_INTERROTTO"));
                System.out.println(e.getMessage());
                break;
                }
            if ( inArrivo != null )
                {
                inArrivoDalServer = inArrivo;
                System.out.println(inArrivo);
                ClientTCPGUI.refreshStatusLabel();
                }


            }
        Thread.currentThread().interrupt();

        }


    @Override
    public void actionPerformed ( ActionEvent actionEvent )
        {
        String textBtnClicked = ( (JButton) actionEvent.getSource() ).getText();
        if ( textBtnClicked.equals(Principale.bundle_lingua.getString("ETICHETTA_CHIUDI_CONNESSIONE")) )
            {
            inviaMessaggioAlServer(MESSAGGIO_CHIUSURA_CONNESSIONE);
            try
                {
                Thread.sleep(1000);
                } catch ( InterruptedException e )
                {
                e.printStackTrace();
                }
            close();
            }
        if ( textBtnClicked.equals(Principale.bundle_lingua.getString("ETICHETTA_ARRESTA_SISTEMA_REMOTO" )));
        {
        inviaMessaggioAlServer(MESSAGGIO_ARRESTA_SISTEMA_REMOTO);
        try
            {
            Thread.sleep(10000);
            } catch ( InterruptedException e )
            {
            e.printStackTrace();
            }
        close();
        }

        }

    private void inviaMessaggioAlServer ( String textBtnClicked )
        {
        out.println(textBtnClicked);
        out.flush();
        }

    private static void close ()
        {
        try
            {
            if ( ( socketConIlServer != null ) )
                if ( socketConIlServer.isConnected() )
                    socketConIlServer.close();

            if ( out != null )
                out.close();

            if ( in != null )
                in.close();
            } catch ( IOException e )
            {
            e.printStackTrace();
            } finally
            {
            ClientTCPGUI.avviaSetEnabled();
            }


        }


    public static boolean hostAvailabilityCheck ()
        {
        try ( Socket s = new Socket(serverString , portaInt) )
            {
            return true;
            } catch ( IOException ex )
            {
            JOptionPane.showMessageDialog(null , Principale.bundle_lingua.getString("SERVER_NON_DISPONIBILE") ,
                    "Errore di connessione" , JOptionPane.ERROR_MESSAGE);
            return false;
            }
        }


    } //fine classe
