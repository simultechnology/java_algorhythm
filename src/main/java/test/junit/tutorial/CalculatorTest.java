package test.junit.tutorial;

import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/11/20
 * Time: 6:21
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {
    @Test
    public void test3multiply4() {
        Calculator calculator = new Calculator();
        int expected = 12;
        int actual = calculator.multiply(3, 4);
        assertThat(actual, is(expected));
    }
    @Test
    public void multiplyで5と7の乗算結果が取得できる() {
        Calculator calculator = new Calculator();
        int expected = 35;
        int actual = calculator.multiply(5, 7);
        assertThat(actual, is(expected));
    }
    @Test
    public void divideで3と2の除算結果が取得できること() {
        Calculator calc = new Calculator();
        float expected = 1.5f;
        float actual = calc.divide(3, 2);
        assertThat(actual, is(expected));
    }
}
