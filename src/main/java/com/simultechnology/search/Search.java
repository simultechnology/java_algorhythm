package com.simultechnology.search;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/01/04
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 */
public abstract class Search {

    protected int MAX;
    public Entry[] table;
    protected int n = 0;

    static protected class Entry {

        int key;            // 比較の対象となるキー
        Object data;        // それ以外の情報

        /**
         * エントリを生成する
         * @param key
         * @param data
         */
        Entry(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    public void initMax(int max) {
        this.MAX = max;
        this.table = new Entry[this.MAX];
    }

    public int getMAX() {
        return this.MAX;
    }

    /**
     * データを登録する
     * @param key   キー
     * @param data  キーに対応するデータ
     */
    public void add(int key, Object data) {

        if (n >= MAX) {
            throw  new IllegalStateException("データの個数が多すぎます。");
        }
        table[n++] = new Entry(key, data);
    }


    public abstract Object search(int key);
}
