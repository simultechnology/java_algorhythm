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

    public static void main(String[] args) throws InterruptedException {
        System.out.println("LinearSearch start!!");
        new Main().execute();
    }

    private int count = 0;
    synchronized int increment() {
        count += 1;
        return count;
    }

    private int keyCount = 0;
    synchronized int incrementKey() {
        keyCount += 1;
        return keyCount;
    }

    static final int THREAD_MAX_NUMBER = 1000;
    static final int DATA_MAX_NUMBER = 5100;

    private void execute() throws InterruptedException {
        final Search table = new BinarySearch();
        table.initMax(THREAD_MAX_NUMBER * DATA_MAX_NUMBER);

        final Random random = new Random();

        for (int i = 0; i < THREAD_MAX_NUMBER; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index + " Thread start!!");
                    for (int i = 0; i  < DATA_MAX_NUMBER; i++) {

                        //final int ranNum = random.nextInt(table.getMAX());
                        final int num = incrementKey();
                        table.add(num, String.format("this is %d", num));
                    }
                    System.out.println(index + " Thread end!!");
                    int count = increment();
                    if (count == THREAD_MAX_NUMBER) {
                        final int target = random.nextInt(table.getMAX());
                        startSearch(table, target);
                    }
                }
            }).start();
        }
    }

    private void startSearch(Search table, int target) {

        System.out.printf("table size is %d\n", table.table.length);
        System.out.println("setting data to table is completed!!");
        System.out.printf("target is %d\n", target);
        long startTime = System.currentTimeMillis();

        String x = (String) table.search(target);
        if (x != null) {
            System.out.println(String.format("value = %s", x));
        }
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.printf("duration is %d\n", duration);
        return;
    }
}
