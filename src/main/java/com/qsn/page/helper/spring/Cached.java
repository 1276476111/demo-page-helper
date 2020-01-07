package com.qsn.page.helper.spring;

import com.alicp.jetcache.anno.CacheConsts;
import com.alicp.jetcache.anno.CacheType;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 实现方式是spring aop,采用注解的方式@cache
 * <p>
 * 首先是作用在方法之上，运行期起作用，而该注解下面的参数，全部存在默认的配置，
 * 也就是说我们若是不指定的情况下，就会加载默认的配置。在业务中针对不同的方法可能需要的expire的时间不一样，这里可以指定。
 * <p>
 * 首先加入对cache的注解支持---@EnableMethodCache(basePackages="com.xx")
 * 后面的包名是使用该注解的方法所在的包的全路径
 * 然后在方法上采用该注解即可
 *
 * @author qiusn
 * @version 1.0 2019/11/15 15:09
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cached {
    String area() default CacheConsts.DEFAULT_AREA;

    String name() default CacheConsts.UNDEFINED_STRING;

    boolean enabled() default CacheConsts.DEFAULT_ENABLED;

    TimeUnit timeUnit() default TimeUnit.SECONDS;

    int expire() default CacheConsts.UNDEFINED_INT;

    CacheType cacheType() default CacheType.REMOTE;

    int localLimit() default CacheConsts.UNDEFINED_INT;

    String serialPolicy() default CacheConsts.UNDEFINED_STRING;

    String keyConvertor() default CacheConsts.UNDEFINED_STRING;

    boolean cacheNullValue() default CacheConsts.DEFAULT_CACHE_NULL_VALUE;

    /**
     *      * Expression attribute used for conditioning the method caching.
     *      * <p>Default is "", meaning the method is always cached.
     *      
     */
    String condition() default CacheConsts.UNDEFINED_STRING;

    /**
     *      * Expression attribute used to veto method caching.
     *      * <p>Unlike {@link #condition()}, this expression is evaluated after the method
     *      * has been called and can therefore refer to the {@code result}. Default is "",
     *      * meaning that caching is never vetoed.
     *      
     */
    String unless() default CacheConsts.UNDEFINED_STRING;
}