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
        int calculateCount = 0;
        while (low <= high) {
            calculateCount += 1;
            int middle = (low + high) / 2;
            if (key == table[middle].key) {
                System.out.printf("calculateCount : %d\n", calculateCount);
                return table[middle].data;
            }
            else if (key < table[middle].key) {
                high = middle - 1;
            }
            else { // key > table[middle].keyである
                low = middle + 1;
            }
        }
        System.out.printf("calculateCount : %d\n", calculateCount);
        return null;
    }
}
