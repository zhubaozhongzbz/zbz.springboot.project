package com.zbz.boot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("类名上DisplayName")
public class SpringApplicationTest {
    //test   assert

    @BeforeEach()
    void  testBeforeEace(){
        System.out.println("测试开始.......................");
    }


    @Test
    @DisplayName("简单测试")
    void contextLoads() {
          assertEquals(call(1,2),3,"希望一致");


    }

    Integer call(int a,int b){
        return  a+b;
    }

}
