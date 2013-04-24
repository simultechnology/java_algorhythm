package search;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/01/04
 * Time: 10:19
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch extends Search {

    public Object search(int key) {

        int low = 0;
        int high = MAX;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (key == table[middle].key) {
                return table[middle].data;
            }
            else if (key < table[middle].key) {
                high = middle - 1;
            }
            else { // key > table[middle].keyである
                low = middle + 1;
            }
        }
        return null;
    }
}
