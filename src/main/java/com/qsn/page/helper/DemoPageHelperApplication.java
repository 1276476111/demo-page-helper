package com.qsn.page.helper;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动类
 * 涵盖技术：物理分页、jackson配置（包括过滤查询结果的null字段）、全局异常捕获、 封装result、baseDO使用、yml文件读取、log4J配置、针对此项目的代码生成器
 * 缓存（不能使用key但是可以缓存）、
 *
 * @author qiusn 2019-11-11
 * @EnableMethodCache 制定开启缓存对应的包路径
 * @EnableCreateCacheAnnotation 开启对应的CreateCache注解
 */
@Slf4j
@MapperScan("com.qsn.page.helper.curd.test.mapper")
@SpringBootApplication
public class DemoPageHelperApplication {

    public static void main(String[] args) throws UnknownHostException {

//        SpringApplication.run(DemoPageHelperApplication.class, args);
        SpringApplication app = new SpringApplication(DemoPageHelperApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getActiveProfiles());
        System.out.println("------------------------------欢迎来到我的世界------------------------------");

    }


}
