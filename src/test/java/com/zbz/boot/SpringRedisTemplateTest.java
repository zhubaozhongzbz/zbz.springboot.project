package com.zbz.boot;

import com.zbz.boot.format.fileUbload.dto.FileChunkDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;

@SpringBootTest
public class SpringRedisTemplateTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    @DisplayName("测试redisTemplate")
    void   test(){
        FileChunkDTO chunkDTO=new FileChunkDTO();
        chunkDTO.setIdentifier("6b0d992a6910dc037863883f25295aa3");
        chunkDTO.setFilename(" 123");
        chunkDTO.setChunkNumber(12);
        redisTemplate.opsForSet().add(chunkDTO.getFilename().substring(0,1)+chunkDTO.getIdentifier(),0);
        redisTemplate.opsForSet().add("aa",0);
        Set aa = redisTemplate.opsForSet().members(chunkDTO.getFilename().substring(0,1)+chunkDTO.getIdentifier());
        System.out.println(aa);
        System.out.println(redisTemplate.getClass().getName());
    }
}
