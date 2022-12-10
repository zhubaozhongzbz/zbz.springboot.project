package com.zbz.boot;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbz.boot.bean.Message;
import com.zbz.boot.mapper.MessageMapper;
import com.zbz.boot.service.MessageService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootTest
@DisplayName("测试CompletableFutrue")
public class CompletableFutureTest {
    @Autowired
    MessageService messageService;
    @Autowired
    MessageMapper  messageMapper;

    @Test
    @DisplayName("测试创建")
    void createCompletableFuture() throws ExecutionException, InterruptedException {
        Message message = new Message();//假设传入参数

        LambdaQueryWrapper<Message> lqw=new LambdaQueryWrapper();
        lqw.eq(Message::getType,"vue");









      //第一种创建方法
        String join = CompletableFuture.supplyAsync(() -> messageMapper.selectList(lqw)).handle((a, b) -> {
//            System.out.println(a);
//            System.out.println(b);
            return "sss";
        }).join();
        //第二种创建方法
        CompletableFuture<List<Message>> listCompletableFuture =
                CompletableFuture.completedFuture(lqw).thenApply(messageMapper::selectList);
        CompletableFuture<List<Message>> handle = CompletableFuture.completedFuture(lqw).thenCompose(a -> {
            System.out.println("执行了thenCompose");
            return listCompletableFuture;
        }).handle((value, exception) -> {
            System.out.println("执行handle");
            return value;
        });


    }












    @BeforeEach
    void beforeEach(){
        System.out.println("测试开始");
    }
    @AfterEach
    void  afterEach(){
        System.out.println("测试结束");
    }
}
