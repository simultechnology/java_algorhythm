package my.sample;

import java.time.Year;

/**
 * Created by ishi on 15/04/26.
 */
public class Anniversary {

    public static Anniversary ANNIVERSARY = new Anniversary();
    private static int BIRTH_YEAR = Year.of(1995).getValue();
    private static int THIS_YEAR = Year.now().getValue();
    private final int age;

    private Anniversary() {
        age = THIS_YEAR - BIRTH_YEAR;
    }

    public int getAge() {
        return age;
    }

    public static void main(String... args) {
        System.out.println(
                "The " + ANNIVERSARY.getAge() + "th Anniversary!"
        );
    }

}
