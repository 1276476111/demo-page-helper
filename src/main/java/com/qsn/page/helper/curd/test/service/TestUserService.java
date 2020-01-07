package com.qsn.page.helper.curd.test.service;

import com.alicp.jetcache.anno.CachePenetrationProtect;
import com.alicp.jetcache.anno.CacheRefresh;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.Cached;
import com.qsn.page.helper.common.base.PageData;
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.curd.test.entity.TestUser;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 服务类
 *
 * @author qiusn
 * @since 2019-11-13
 */
public interface TestUserService {

    /**
     * 详情
     *
     * @param id 主键
     * @return
     */

    @Cached(name = "testUser-InfoCache-", key = "#id", expire = 3600, cacheType = CacheType.BOTH, cacheNullValue = true)
    @CachePenetrationProtect
    TestUser getById(Long id);

    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    PageData<TestUser> page(PageForm<TestUser> pageData);

    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn 2019-11-13
     */
    List<TestUser> list(TestUser search);

    /**
     * 新增
     *
     * @param testUser 新增信息
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    Boolean insert(TestUser testUser);

    /**
     * 修改
     *
     * @param testUser 主键、待修改信息
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    Boolean update(TestUser testUser);

    /**
     * 删除
     *
     * @param id 主键
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    Boolean delete(Long id);

}
