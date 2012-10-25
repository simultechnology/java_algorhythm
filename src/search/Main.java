package search;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: ishikawatakatsugu
 * Date: 2012/10/25
 * Time: 1:41
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("LinearSearch start!!");

        final LinearSearch table = new LinearSearch();

        final Random random = new Random();

        for (int i = 0; i < 100; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + " Thread start!!");
                    for (int i = 0; i  < 500000; i++) {
                        final int ranNum = random.nextInt(50000000);
                        table.add(ranNum, String.format("this is %d", ranNum));
                    }

                }

            }).run();
            System.out.println(index + " Thread end!!");
        }

//        for (int i = 40000000; i  < 50000000; i++) {
//            final int ranNum = random.nextInt(50000000);
//            table.add(ranNum, String.format("this is %d", ranNum));
//        }

        System.out.println("setting data to table is completed!!");

        String x = (String) table.search(10);
        if (x != null) {
            System.out.println(String.format("value = %s", x));
        }

    }
}
