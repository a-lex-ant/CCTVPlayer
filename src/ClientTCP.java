import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientTCP implements ActionListener
    {

    public static final String MESSAGGIO_CHIUSURA_CONNESSIONE = "CHIUDI CONNESSIONE";
    public static final String MESSAGGIO_ARRESTA_SISTEMA_REMOTO = "SPEGNI";


    protected static String inArrivoDalServer = "...";

    private static String serverString;
    private static int portaInt;

    private static PrintWriter out;
    private static Socket socketConIlServer;
    private static BufferedReader in;

    private static FrameConnessione parentComponent;


    public ClientTCP ( String indirizzo , int port , FrameConnessione parentComp )
        {
        serverString = indirizzo;
        portaInt     = port;
        parentComponent = parentComp;
        if ( avviaClientInvio() )
            {
            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService.submit(this::cicloRicezione);
            FrameConnessione.chiudiSetEnabled();
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
            System.out.println(Principale.bundle_lingua.getString("SERVER_NON_RAGGIUNGIBILE"));
            JOptionPane.showMessageDialog(parentComponent, Principale.bundle_lingua.getString("SERVER_NON_RAGGIUNGIBILE"), Principale.bundle_lingua.getString("SERVER_NON_RAGGIUNGIBILE"), JOptionPane.ERROR_MESSAGE);
            return false;
            } catch ( IOException e )
            {
            e.printStackTrace();
            return false;
            }


        } //fine avvia client


    private void cicloRicezione ()
        {
        System.out.println(Principale.bundle_lingua.getString("INIZIO_RICEZIONE"));
        String inArrivo = "";
        while ( in != null )
            {

            try
                {
                inArrivo = in.readLine();
                } catch ( IOException e )
                {
                System.out.println(Principale.bundle_lingua.getString("FINE_RICEZIONE"));
                System.out.println(e.getMessage());
                break;
                }
            if ( inArrivo != null )
                {
                byte[] b = inArrivo.getBytes();
                if(!(b.length >= 1000))
                    {
                    inArrivoDalServer = inArrivo;
                    System.out.println(Principale.bundle_lingua.getString("INCOMING_FROM_SERVER")+ " " + inArrivoDalServer);
                    FrameConnessione.refreshStatusLabel();
                    }
                }


            }
        Thread.currentThread().interrupt();

        }


    @Override
    public void actionPerformed ( ActionEvent actionEvent )
        {
        String textBtnClicked = ( (JButton) actionEvent.getSource() ).getText();
        if ( textBtnClicked.equals(FrameConnessione.rboundle.getString("ETICHETTA_CHIUDI_CONNESSIONE")) )
            {
            inviaMessaggioAlServer(MESSAGGIO_CHIUSURA_CONNESSIONE);
            try
                {
                Thread.sleep(1000);
                } catch ( InterruptedException e )
                {
                System.out.println("4");
                e.printStackTrace();
                }
            close();
            }
        if ( textBtnClicked.equals(FrameConnessione.rboundle.getString("ETICHETTA_ARRESTA_SISTEMA_REMOTO" )));
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
            System.out.println("5");
            e.printStackTrace();
            } finally
            {
            FrameConnessione.avviaSetEnabled();
            }


        }


    public static boolean hostAvailabilityCheck () throws IOException
        {
        if (
                InetAddress.getByName(serverString).isReachable(2000)
        ) return true;
        return false;
        }


    } //fine classe
