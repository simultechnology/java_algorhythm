package network.three.single;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 8:46
 * To change this template use File | Settings | File Templates.
 */
public class TCPServer implements Runnable {

    private ServerSocket serverSocket;
    public TCPServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }
    @Override
    public void run() {
        for (;;) {
            try (Socket socket = serverSocket.accept()) {

            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
