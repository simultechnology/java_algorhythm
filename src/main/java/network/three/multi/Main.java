package network.three.multi;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 9:24
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] arg) {
        try {
            TCPServer server = new TCPServer(55555);
            new Thread(server).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
