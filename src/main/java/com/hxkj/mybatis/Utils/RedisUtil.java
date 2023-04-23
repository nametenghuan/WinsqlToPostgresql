package com.hxkj.mybatis.Utils;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * 要尊重编程
 *
 * @Author: 庞欢腾
 * @Date: 2023/4/23
 * @Description: mybatis
 */
public class RedisUtil {

    /**
     * 清理 dict:tdd:suizhouhydrology_data
     */
    public static void delRedisCache() {

        Jedis jedis = null;
        try {
            jedis = new Jedis("172.20.38.97", 6379);
            jedis.auth("hxkj123..");
            jedis.select(1);

            /*Set<String> keys = jedis.keys("*");
            Iterator<String> iterator = keys.iterator();
            while (iterator.hasNext()) {
                String k = iterator.next();
                System.out.println(k);
            }*/

            // 清理 dict:tdd:suizhouhydrology_data
            jedis.del("dict:tdd:suizhouhydrology_data");
        } finally {
            jedis.close();
        }
    }
}
