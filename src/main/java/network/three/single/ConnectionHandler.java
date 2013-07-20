package network.three.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 8:49
 * To change this template use File | Settings | File Templates.
 */
public class ConnectionHandler implements Runnable {

    private Socket socket;
    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        handleConversation(this.socket);
    }
    public void handleConversation(Socket socket) {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            outputStream.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
