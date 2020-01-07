package com.qsn.page.helper.configure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * 返回时间统一格式
 * <p>
 * 由于json序列化时可将日期格式化，所以这个配置可暂时忽略。
 * 若json没有设置日期， 可通过该配置来实现返回给前端的日期格式化
 *
 * @author qiusn
 * @version 1.0 2019/11/13 15:58
 */
//@Configuration
public class TimeConf {

    /**
     * 能自动注入到jack2的转换器中
     * 若在类属性上自定义了格式，以自定义的类属性格式为准
     */
    @Bean
    public ObjectMapper o1() {
        return new ObjectMapper() {

            private static final long serialVersionUID = -2628542011505917399L;

            {
                setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            }
        };
    }
}
