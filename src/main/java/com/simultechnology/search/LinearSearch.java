package com.simultechnology.search;

/**
 * Created with IntelliJ IDEA.
 * User: ishikawatakatsugu
 * Date: 2012/10/25
 * Time: 1:43
 * To change this template use File | Settings | File Templates.
 */
public class LinearSearch extends Search {

    /**
     * キーに対応するデータを探す
     *
     * @param key キー
     * @return キーに対応するデータ。キーが見つからなければnullを返す
     */
    public Object search(int key) {
        int calculateCount = 0;
        for (Entry et : table) {
            calculateCount += 1;
            if (et != null && et.key == key) {
                System.out.printf("calculateCount : %d\n", calculateCount);
                return et.data;
            }
        }
        System.out.printf("calculateCount : %d\n", calculateCount);
        return null;
    }
}
