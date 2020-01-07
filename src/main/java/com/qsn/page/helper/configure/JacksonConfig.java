package com.qsn.page.helper.configure;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * 使spring中的jackson配置生效
 * <p>
 * 这就将 objectmapper 交给springboot管理了, 别的模块可以实现自动注入,
 * 注意这个 objectmapper 必须是由 Jackson2ObjectMapperBuilder 创建出来的, 否则不能使用到配置文件
 *
 * @author qiusn 2019-11-15
 */
@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper getObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper om = builder.build();
        return om;
    }

}