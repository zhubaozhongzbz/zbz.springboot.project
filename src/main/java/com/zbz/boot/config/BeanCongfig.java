package com.zbz.boot.config;

import com.zbz.boot.format.bean.Pet;
import com.zbz.boot.format.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //这是一个配置类

//@ConditionalOnBean(name ="user")
@EnableConfigurationProperties(Pet.class)
public class BeanCongfig {
    @Bean
    public User user01(){
        return  new User("zhangsan",18,tomCat());
    }
    @Bean("tom")
    public Pet  tomCat(){
        return  new Pet("tomcat");
    }


}
