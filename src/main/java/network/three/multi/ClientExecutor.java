package network.three.multi;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/20
 * Time: 10:04
 * To change this template use File | Settings | File Templates.
 */
public class ClientExecutor {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();

        TCPClient client = new TCPClient("127.0.0.1", 55555);
        client.setOutputData(data);
        new Thread(client).start();
    }
}
