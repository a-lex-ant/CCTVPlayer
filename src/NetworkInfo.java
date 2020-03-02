import com.google.common.net.InetAddresses;

import javax.swing.*;
import java.io.IOException;
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
					if ((!currentInetAddress.getHostAddress()
					                        .contains(":")) && (!currentInetAddress.isLoopbackAddress()))
						{
						return currentNetInterface.getName() + " " + currentInetAddress.getHostAddress();
						}
					}
				}
			}
		return "---";
		}


	public static boolean isValidAddress(String ip)
		{
		if (InetAddresses.isInetAddress(ip)) return true;
		return false;
		}

	public static boolean hostAvailabilityCheck(String serverStringPassata) throws IOException
		{
		boolean reacheable = InetAddress.getByName(serverStringPassata)
		                                .isReachable(2000);
		boolean valid = NetworkInfo.isValidAddress(serverStringPassata);
		if(reacheable && valid) return true;
		return false;
		}

	}