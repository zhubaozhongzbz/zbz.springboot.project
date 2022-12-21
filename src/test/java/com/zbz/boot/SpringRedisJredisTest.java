package com.zbz.boot;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

@SpringBootTest
public class SpringRedisJredisTest {



    @Test
    @DisplayName("jredis  test")
    void   test(){
        Jedis jedis = new Jedis("192.168.208.128",6379);
        jedis.select(1);
        jedis.set("jedis","111");
        System.out.println(jedis.get("jedis"));

    }
}
