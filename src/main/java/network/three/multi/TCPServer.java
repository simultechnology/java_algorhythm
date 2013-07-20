package network.three.multi;

import network.three.single.ConnectionHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

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
            try {
                Socket socket = serverSocket.accept();
                SocketAddress socketAddress = socket.getRemoteSocketAddress();
                System.out.println("remoteAddress：" + socketAddress);
                new Thread(new EchoConnectionHandler(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
