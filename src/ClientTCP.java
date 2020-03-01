import javax.swing.*;
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

/**
 * The type Client tcp.
 * Implements the behaviour of the TCP client.
 */
public class ClientTCP implements ActionListener
	{
	/**
	 * The constant MESSAGGIO_CHIUSURA_CONNESSIONE.
	 */
	public static final String MESSAGGIO_CHIUSURA_CONNESSIONE   = "CHIUDI CONNESSIONE";
	/**
	 * The constant MESSAGGIO_ARRESTA_SISTEMA_REMOTO.
	 */
	public static final String MESSAGGIO_ARRESTA_SISTEMA_REMOTO = "SPEGNI";
	protected static String inArrivoDalServer = "...";
	/**
	 * Contains the Ip address of the server in String form.
	 */
	private static String serverString;
	/**
	 * The integer that stores the port number of the server
	 */
	private static int    portaInt;
	/**
	 * The PrintWriter that will write the messages for the server
	 */
	private static PrintWriter    out;
	/**
	 * The Socket used to talk to the server
	 */
	private static Socket         socketConIlServer;
	/**
	 * The BufferedReader used to read incoming messages from the server
	 */
	private static BufferedReader in;
	/**
	 * The parent component that started the tcp client.
	 */
	private static FrameConnessione parentComponent;

	/**
	 * Instantiates a new Client tcp.
	 *
	 * @param indirizzo  the IPv4 address
	 * @param port       the port number
	 * @param parentComp the parent component (FrameConnessione)
	 */
	public ClientTCP(String indirizzo, int port, FrameConnessione parentComp)
		{
		serverString    = indirizzo;
		portaInt        = port;
		parentComponent = parentComp;
		if (avviaClientInvio())
			{
			ExecutorService executorService = Executors.newFixedThreadPool(1);
			executorService.submit(this::cicloRicezione);
			FrameConnessione.chiudiSetEnabled();
			}

		}// end of constructor

	/**
	 * Starts the client
	 *
	 * @return the boolean if the process is successful
	 */
	private boolean avviaClientInvio()
		{
		try
			{
			if (hostAvailabilityCheck())
				{
				socketConIlServer = new Socket(serverString, portaInt);
				out               = new PrintWriter(socketConIlServer.getOutputStream());
				in                = new BufferedReader(new InputStreamReader(socketConIlServer.getInputStream()));
				return true;
				}
			else
				{
				return false;
				}
			}
		catch (ConnectException e)
			{
			System.out.println(CCTVPlayer.bundle_lingua.getString("SERVER_NON_RAGGIUNGIBILE"));
			JOptionPane.showMessageDialog(parentComponent, CCTVPlayer.bundle_lingua.getString("SERVER_NON_RAGGIUNGIBILE"),
			                              CCTVPlayer.bundle_lingua.getString("SERVER_NON_RAGGIUNGIBILE"), JOptionPane.ERROR_MESSAGE);
			return false;
			}
		catch (IOException e)
			{
			e.printStackTrace();
			return false;
			}

		} //end of avviaCLient

	/**
	 * While cycle that keeps checking for incoming messages from server
	 */
	private void cicloRicezione()
		{
		System.out.println(CCTVPlayer.bundle_lingua.getString("INIZIO_RICEZIONE"));
		String inArrivo;
		while (in != null)
			{

			try
				{
				inArrivo = in.readLine();
				}
			catch (IOException e)
				{
				System.out.println(CCTVPlayer.bundle_lingua.getString("FINE_RICEZIONE"));
				System.out.println(e.getMessage());
				break;
				}
			if (inArrivo != null)
				{
				byte[] b = inArrivo.getBytes();
				if (!(b.length >= 1000))
					{
					inArrivoDalServer = inArrivo;
					System.out.println(CCTVPlayer.bundle_lingua.getString("INCOMING_FROM_SERVER") + " " + inArrivoDalServer);
					FrameConnessione.refreshStatusLabel();
					}
				}

			}
		Thread.currentThread()
		      .interrupt();

		}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
		{
		String textBtnClicked = ((JButton) actionEvent.getSource()).getText();
		if (textBtnClicked.equals(FrameConnessione.rboundle.getString("ETICHETTA_CHIUDI_CONNESSIONE")))
			{
			inviaMessaggioAlServer(MESSAGGIO_CHIUSURA_CONNESSIONE);
			try
				{
				Thread.sleep(1000);
				}
			catch (InterruptedException e)
				{
				System.out.println("4");
				e.printStackTrace();
				}
			close();
			}
		if (textBtnClicked.equals(FrameConnessione.rboundle.getString("ETICHETTA_ARRESTA_SISTEMA_REMOTO")))
		{
		inviaMessaggioAlServer(MESSAGGIO_ARRESTA_SISTEMA_REMOTO);
		try
			{
			Thread.sleep(10000);
			}
		catch (InterruptedException e)
			{
			e.printStackTrace();
			}
		close();
		}

		}

	/**
	 * Sends the message to the server using a printwriter; flushes it immediately after.
	 *
	 * @param textBtnClicked the message associated with the clicked button
	 */
	private void inviaMessaggioAlServer(String textBtnClicked)
		{
		out.println(textBtnClicked);
		out.flush();
		}

	/**
	 * Close method. Closes the used resources.
	 */
	private static void close()
		{
		try
			{
			if ((socketConIlServer != null)) { if (socketConIlServer.isConnected()) { socketConIlServer.close(); } }

			if (out != null) { out.close(); }

			if (in != null) { in.close(); }
			}
		catch (IOException e)
			{
			e.printStackTrace();
			}
		finally
			{
			FrameConnessione.avviaSetEnabled();
			}

		}

	/**
	 * Host availability check. Checks if the server's address is reacheable
	 *
	 * @return the boolean
	 *
	 * @throws IOException IOException
	 */
	public static boolean hostAvailabilityCheck() throws IOException
		{
		return InetAddress.getByName(serverString)
		                  .isReachable(2000);
		}

	} //end of ClientTCP class
