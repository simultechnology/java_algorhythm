package search;

/**
 * Created with IntelliJ IDEA.
 * User: ishikawatakatsugu
 * Date: 2012/10/25
 * Time: 1:43
 * To change this template use File | Settings | File Templates.
 */
public class LinearSearch {

    static private class Entry {

        int key;            // 比較の対象となるキー
        Object data;        // それ以外の情報

        /**
         * エントリを生成する
         * @param key
         * @param data
         */
        private Entry(int key, Object data) {
            this.key = key;
            this.data = data;
        }
    }

    final static int MAX = 50000000;
    Entry[] table = new Entry[MAX];
    int n= 0;

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

    /**
     * キーに対応するデータを探す
     *
     * @param key キー
     * @return キーに対応するデータ。キーが見つからなければnullを返す
     */
    public Object search(int key) {
        for (Entry e : table) {
            if (e.key == key) {
                return e.data;
            }
        }
        return null;
    }
}
