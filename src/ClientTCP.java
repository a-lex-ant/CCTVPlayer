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

import static java.net.InetAddress.getByName;

/**
 * The Client tcp class.
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

	/**
	 * Contains the Ip address of the server in String form.
	 */
	private String serverString;
	/**
	 * The integer that stores the port number of the server
	 */
	private int portaInt;
	/**
	 * The PrintWriter that will write the messages for the server
	 */
	private PrintWriter    out;
	/**
	 * The Socket used to talk to the server
	 */
	private Socket         socketConIlServer;
	/**
	 * The BufferedReader used to read incoming messages from the server
	 */
	private BufferedReader in;
	/**
	 * The parent component that started the tcp client.
	 */
	private FrameConnessione parentComponent;

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
			parentComponent.chiudiSetEnabled();
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
			if (NetworkInfo.hostAvailabilityCheck(serverString))
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
			System.out.println(l10n.getString("SERVER_NON_RAGGIUNGIBILE"));
			JOptionPane.showMessageDialog(parentComponent, l10n.getString("SERVER_NON_RAGGIUNGIBILE"),
			                              l10n.getString("SERVER_NON_RAGGIUNGIBILE"), JOptionPane.ERROR_MESSAGE);
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
		System.out.println(l10n.getString("INIZIO_RICEZIONE"));
		String inArrivo;
		while (in != null)
			{

			try
				{
				inArrivo = in.readLine();
				}
			catch (IOException e)
				{
				System.out.println(l10n.getString("FINE_RICEZIONE"));
				System.out.println(e.getMessage());
				break;
				}
			if (inArrivo != null)
				{
				byte[] b = inArrivo.getBytes();
				if (!(b.length >= 1000))
					{
					System.out.println(l10n.getString("INCOMING_FROM_SERVER") + " " + inArrivo);
					parentComponent.updateStatusLabel(inArrivo);
					}
				}

			}

		}

	@Override
	public void actionPerformed(ActionEvent actionEvent)
		{
		String textBtnClicked = ((JButton) actionEvent.getSource()).getText();
		if (textBtnClicked.equals(l10n.getString("ETICHETTA_ARRESTA_SISTEMA_REMOTO")))
		{
		inviaMessaggioAlServer(MESSAGGIO_ARRESTA_SISTEMA_REMOTO);
		try
			{
			Thread.sleep(300);
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
		try
			{
			out.println(textBtnClicked);
			out.flush();
			}
		catch (NullPointerException e)
			{
			close();
			}
		}

	/**
	 * Close method. Closes the used resources.
	 */
	private void close()
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
			parentComponent.avviaSetEnabled();
			}

		}



	} //end of ClientTCP class
