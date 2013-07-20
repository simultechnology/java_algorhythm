package network.two;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 8:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces =
                    NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                Enumeration<InetAddress> addresses =
                        networkInterface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    System.out.println("address : " + address);
                    System.out.println("hostName : " + address.getHostName());
                    System.out.println("hostAddress : " + address.getHostAddress());
                }
            }
        }
        catch (SocketException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
