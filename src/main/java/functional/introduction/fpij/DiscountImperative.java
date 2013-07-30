package functional.introduction.fpij;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/07/30
 * Time: 23:29
 * To change this template use File | Settings | File Templates.
 */
public class DiscountImperative {
    private static final List<Integer> prices = Arrays.asList(10, 30, 17, 20, 15, 18, 45, 12);

    public static void main(String[] arg) {

        final double totalOfDiscountedPrices =
                prices.stream()
                .filter(price -> price > 20)
                .mapToDouble(price -> price * 0.9)
                .sum();

        System.out.println(totalOfDiscountedPrices);

    }
}
