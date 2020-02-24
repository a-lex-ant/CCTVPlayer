/*
 *  https://stackoverflow.com/questions/19476872/java-get-local-ip
 * Maxim Shoustin
 * answered Oct 20 '13 at 11:37
 * */

/*
 * Vedere: https://askubuntu.com/questions/704361/why-is-my-network-interface-named-enp0s25-instead-of-eth0 per nome
 * interfacce
 * */


import javax.swing.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

public final class NetworkInfo
    {
    public static String fornisciIndirizziLocali ()
        {
        Enumeration<NetworkInterface> networkInterfaces = null;
        try
            {
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            } catch ( SocketException e )
            {
            e.printStackTrace();
            }

        while ( networkInterfaces.hasMoreElements() && ( networkInterfaces != null ) )
            {

            NetworkInterface currentNetInterface = networkInterfaces.nextElement();
            if ( !currentNetInterface.getName().equals("virbr0") )
                {
                Enumeration<InetAddress> enumInetAddresses = currentNetInterface.getInetAddresses();


                while ( enumInetAddresses.hasMoreElements() )
                    {
                    InetAddress currentInetAddress = enumInetAddresses.nextElement();
                    if ( ( currentInetAddress.getHostAddress().contains(":") == false ) && ( currentInetAddress.isLoopbackAddress() == false ) )
                        {
                        return currentNetInterface.getName() + " " + currentInetAddress.getHostAddress();
                        }
                    }
                }
            }
        return "---";
        }

    public static boolean checkIfServerAvailable(String[] datiDaControllare)
        {
        try(Socket clientSocketDiProva = new Socket(datiDaControllare[0],Integer.parseInt(datiDaControllare[1]));)
            {
            ;
            }
        catch (Exception e)
            {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    e.getLocalizedMessage(),
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
            if(e.getMessage().contains("Host unreachable")) return false;
            }
        return true;
        }


    }