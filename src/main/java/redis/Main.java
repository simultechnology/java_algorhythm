package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: ishi
 * Date: 2013/04/25
 * Time: 6:35
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379, 10);
        jedis.set("foo", "bar");
        System.out.println(jedis.get("foo"));
        System.out.println(jedis.get("greeting"));

        jedis.set("foo", "123");
        System.out.println(jedis.get("foo"));

        System.out.println(jedis.get("my-name"));
        Transaction transaction = jedis.multi();
        transaction.set("my-name", "t-issi-");
        transaction.incr("count");
        transaction.exec();

        System.out.println(jedis.get("my-name"));
        System.out.println(jedis.get("count"));
    }
}
