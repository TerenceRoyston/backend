import redis.clients.jedis.Jedis;

/**
 * @author XuBowen
 * @date 2022/7/24 18:31
 */
public class RedisConnection {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.80.143", 6379);
        String pong = jedis.ping();
        System.out.println(pong);
    }
}
