package network.three.multi;

import network.three.single.ConnectionHandler;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 9:15
 * To change this template use File | Settings | File Templates.
 */
public class EchoConnectionHandler extends ConnectionHandler {

    public EchoConnectionHandler(Socket socket) {
        super(socket);
    }
    public void handleConversation(Socket socket) {
        System.out.println(getClass().getName() + "#" + new Throwable().getStackTrace()[0].getMethodName());
        try {
            InputStream inputStream = socket.getInputStream();
            System.out.println(inputStream);
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader br =
                    new BufferedReader(new InputStreamReader(inputStream));
            String line = br.readLine();
            System.out.println(line);

            DataOutputStream outToClient = new DataOutputStream(outputStream);
            String capitalizedSentence = line.toUpperCase() + "\r\n";
            System.out.println(capitalizedSentence);
            outToClient.writeBytes(capitalizedSentence);
        }
        catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        finally {
            try {
                System.out.println("close!!");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
