package list.sample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test2 {

    static int NUM = 300000;
    static String STR = "123456";
    public static void main(String[] args) {
        Test2 test = new Test2();
        long a = System.currentTimeMillis();

        test.arrayListOnlyIteration();
        long b = System.currentTimeMillis();

        //計測
        System.out.println("処理時間:" + (b - a) + "ミリ秒");
        test.arrayListAndLinkedListIteration();

        //計測
        System.out.println("処理時間:" + (System.currentTimeMillis() - b) + "ミリ秒");
    }

    private void arrayListAndLinkedListIteration() {
        // TODO Auto-generated method stub
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < NUM; i++) {
            list.add(STR);
        }
//        LinkedList<String> ll = new LinkedList<String>();
//        ll.addAll(list);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println(list.size());
//        list = new ArrayList<String>();
//        list.addAll(ll);
        System.out.println("after LinkedList iterator removal:list.size() = " + list.size());
    }

    private void arrayListOnlyIteration() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < NUM; i++) {
            list.add(STR);
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println("after ArrayList iterator removal:list.size() = " + list.size());
    }

}

