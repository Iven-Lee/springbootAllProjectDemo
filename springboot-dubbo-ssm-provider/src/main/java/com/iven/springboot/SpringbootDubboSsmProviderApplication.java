package com.iven.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.iven.springboot.mapper")
@EnableDubboConfiguration   //开启dubbo配置
public class SpringbootDubboSsmProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboSsmProviderApplication.class, args);
    }

}
