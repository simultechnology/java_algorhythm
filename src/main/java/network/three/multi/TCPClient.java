package network.three.multi;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 9:21
 * To change this template use File | Settings | File Templates.
 */
public class TCPClient implements Runnable {
    private final String host;
    private final int port;
    private String outputData;
    Socket socket;
    public TCPClient(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write(this.outputData.getBytes()); // サーバに文字列を送付
//            outputStream.flush();
            InputStream inputStream = socket.getInputStream();
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(inputStream));

            DataOutputStream outToServer =
                    new DataOutputStream(socket.getOutputStream());
            outToServer.writeBytes(outputData + "\r\n");

            String line = br.readLine();
            System.out.println("line : " + line);
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setOutputData(String data) {
        this.outputData = data;
    }
}
