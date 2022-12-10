package com.zbz.boot;

import com.zbz.boot.bean.Person;
import com.zbz.boot.bean.User;
import com.zbz.boot.bean.asidemenu.AsideMenu;
import com.zbz.boot.mapper.AsideMenuMapper;
import com.zbz.boot.mapper.UserMapper;
import com.zbz.boot.service.AsideMenuService;
import com.zbz.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@DisplayName("assert 简单测试")
public class SpringAssertTest {
    @Autowired
    Person person;
    @Autowired
    AsideMenuService asideMenuService;
    @Autowired
    AsideMenuMapper asideMenuMapper;

    @Autowired
    UserMapper  userMapper;
    @BeforeEach
    void  beforeEachTest(){
        System.out.println("测试开始....");
    }
    @AfterEach
    void afterEachTest(){
        System.out.println("测试结束!!!!!!");
    }

    @Disabled  //隐藏,不进行测试
    @DisplayName("测试树的数据")
    @Test
    void    test1(){
       List<AsideMenu>  asidList=new ArrayList<>();
       List<AsideMenu> list= asideMenuMapper.getAll();
        Map<Integer, List<AsideMenu>> regionMap = list.stream().
                collect(Collectors.groupingBy(s->s.getFid(), Collectors.toList()));

        regionMap.forEach((a,b)->{
            if(a==0)
                asidList.addAll(b);
            b.forEach(as->{as.setChilden(regionMap.get(as.getId())) ;
            });

        });
        System.out.println(asidList);
    }

    @Test
    @DisplayName("测试mybatisplus")
    void    assertSametest2(){

        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
        assertSame(new Person(),person);
    }
    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }
    public static void main(String[] args) {
        //new Thread(() -> System.out.println(1111));



    }

}
