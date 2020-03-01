import javax.swing.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;


/**
 * The Network info class.
 * Utility class.
 */
public final class NetworkInfo
	{

	/**
	 * Fetches the local ip address, first getting all the current Net Interfaces, then filtering out the loopback address and others.
	 *
	 * @return the string with the local ip address
	 */
	public static String fornisciIndirizziLocali()
		{
		Enumeration<NetworkInterface> networkInterfaces = null;
		try
			{
			networkInterfaces = NetworkInterface.getNetworkInterfaces();
			}
		catch (SocketException e)
			{
			e.printStackTrace();
			}

		while (networkInterfaces.hasMoreElements() && (networkInterfaces != null))
			{

			NetworkInterface currentNetInterface = networkInterfaces.nextElement();
			if (!currentNetInterface.getName()
			                        .equals("virbr0"))
				{
				Enumeration<InetAddress> enumInetAddresses = currentNetInterface.getInetAddresses();

				while (enumInetAddresses.hasMoreElements())
					{
					InetAddress currentInetAddress = enumInetAddresses.nextElement();
					if ((currentInetAddress.getHostAddress()
					                       .contains(":") == false) && (currentInetAddress.isLoopbackAddress() == false))
						{
						return currentNetInterface.getName() + " " + currentInetAddress.getHostAddress();
						}
					}
				}
			}
		return "---";
		}

	/**
	 * Checks if the trasmission is up and running
	 *
	 * @param datiDaControllare the address and port to check
	 *
	 * @return the boolean that tells id the server is available
	 */
	public static boolean checkIfServerAvailable(String[] datiDaControllare)
		{
		try (Socket clientSocketDiProva = new Socket(datiDaControllare[0], Integer.parseInt(datiDaControllare[1])))
			{
			}
		catch (Exception e)
			{
			JOptionPane.showMessageDialog(null, e.getMessage(), e.getLocalizedMessage(), JOptionPane.ERROR_MESSAGE);
			System.out.println(e.getMessage());
			if (e.getMessage()
			     .contains("Server unreachable")) { return false; }
			}
		return true;
		}

	}