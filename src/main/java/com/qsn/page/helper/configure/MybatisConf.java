package com.qsn.page.helper.configure;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * mybatis 配置
 *
 * @author qiusn 2019-11-13
 */
@Configuration
public class MybatisConf {
    /**
     * 用代码实现分页参数配置
     * 不与yml分页配置冲突，两种方式可同时配置
     *
     * @author 2019-11-13
     */
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    /**
     * 当查询结果集返回为null时， 该字段是否显示（避免暴露数据库结构）
     * 此方法属于重新定义需要在yml添加： spring.main.allow-bean-definition-overriding: true
     *
     * @author qiusn 2019-11-14
     */
    @Bean
    public void sqlSessionFactory() {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // true 显示null， false 不显示null
        configuration.setCallSettersOnNulls(false);
        bean.setConfiguration(configuration);
    }


}