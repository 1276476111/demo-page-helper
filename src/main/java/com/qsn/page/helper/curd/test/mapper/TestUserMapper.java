package com.qsn.page.helper.curd.test.mapper;

import com.qsn.page.helper.curd.test.entity.TestUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author qiusn 2019-11-13
 */
public interface TestUserMapper {

    /**
     * 详情
     *
     * @param id 主键
     * @author qiusn
     */
    TestUser getById(@Param(value = "id") Long id);

    /**
     * 分页
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn 2019-11-13
     */
    List<TestUser> page(TestUser search);

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
     * @return 影响记录行数
     * @author qiusn 2019-11-13
     */
    int insert(TestUser testUser);

    /**
     * 修改
     *
     * @param testUser 主键、待修改信息
     * @return 影响记录行数
     * @author qiusn 2019-11-13
     */
    int update(TestUser testUser);

    /**
     * 删除
     *
     * @param id 主键
     * @return 影响记录行数
     * @author qiusn 2019-11-13
     */
    int delete(Long id);

}
