package com.zbz.boot;
import com.google.gson.Gson;
import com.zbz.boot.format.bean.Message;
import com.zbz.boot.format.bean.User;
import com.zbz.boot.format.service.MessageService;
import com.zbz.boot.utils.RedisUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;

import java.util.HashMap;
import java.util.List;
import java.util.Set;



@SpringBootTest
public class SpringRedisTemplateTest {
    private  Gson gson=new  Gson();
    @Autowired
    RedisTemplate redisTemplate;

    RedisUtils redisUtils;

    @Test
    @DisplayName("测试redisTemplate key 的基本操作")
    void   operationKey(){
        //下面的语句可以获取得到对应的redis的连接的，可以执行更为底层的redis的操作实现的
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        System.out.println("dbsize"+connection.dbSize());
        connection.flushDb();
       // connection.select(1);//切换数据库这个会报错误,共享需要更换connectionFactory
//        LettuceConnectionFactory connectionFactory = (LettuceConnectionFactory) redisTemplate.getConnectionFactory();
//        connectionFactory.setDatabase(1);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object aaaa = redisTemplate.opsForValue().get("aaaa");
        System.out.println(aaaa);
        Set<byte[]> keys = connection.keys("*".getBytes());
        System.out.println("keys = " + keys);
        redisUtils.expire("aaaa",10000);
        redisUtils.set("b","ccc");
        redisTemplate.opsForValue().setIfPresent("b","bbb");
        redisTemplate.opsForValue().setIfAbsent("b","aaaa");
        redisTemplate.opsForValue().setIfAbsent("c","cccc");
        User user =new  User();
        user.setAge(19);
        valueOperations.set("user",user);
        Object user1 = valueOperations.get("user");
        System.out.println("user1 = " + user1);


    }
    @Test
    @DisplayName("测试redisTemplate list 的基本操作")
    void   listTest(){
        ListOperations listOperations = redisTemplate.opsForList();
        Long list1 = listOperations.rightPush("list1", 11111);
        List list11 = listOperations.range("list1", 0, -1);
        list11.forEach(System.out::println);

    }

    @Test
    @DisplayName("测试redisTemplate set 的基本操作")
    void   setTest(){
        SetOperations setOperations = redisTemplate.opsForSet();
        String [] arry=new String[] {"1","2","2","3"};
        setOperations.add("set1",arry);

        Set set1 = setOperations.members("set1");
        set1.forEach(System.out::println);
        System.out.println("set1.size(); = " + set1.size());
    }

    @Test
    @DisplayName("测试redisTemplate zset 的基本操作")
    void   zsetTest(){
        SetOperations setOperations = redisTemplate.opsForSet();
        String [] arry=new String[] {"1","2","2","3"};

    }
    @Autowired
    MessageService messageService;
    @Test
    @DisplayName("测试redisTemplate hash 的基本操作")
    void   hashTest(){
        List<Message> list = messageService.list();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("1",list);
        stringObjectHashMap.put("名字","aaaa");
        redisTemplate.opsForHash().putAll("map",stringObjectHashMap);
        List map = (List) redisTemplate.opsForHash().get("map", "1");
        map.forEach(System.out::println);

    }



}
