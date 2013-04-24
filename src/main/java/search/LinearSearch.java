package search;

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
        for (Entry et : table) {
            if (et != null && et.key == key) {
                return et.data;
            }
        }
        return null;
    }
}
