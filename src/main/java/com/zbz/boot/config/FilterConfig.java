package com.zbz.boot.config;

import com.zbz.boot.filter.SimpleCORSFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.Collections;

@Configuration
public class FilterConfig {
    /**
     * 基础过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean<Filter> baseFilter(){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new SimpleCORSFilter());
      //  filterRegistrationBean.setUrlPatterns(Collections.singleton("/**"));
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
