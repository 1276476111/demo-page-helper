package com.qsn.page.helper.curd.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.qsn.page.helper.common.base.PageData;
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.configure.YmlConfig;
import com.qsn.page.helper.curd.test.entity.TestMyYmlProp;
import com.qsn.page.helper.curd.test.entity.TestUser;
import com.qsn.page.helper.curd.test.mapper.TestUserMapper;
import com.qsn.page.helper.curd.test.service.TestUserService;
import com.qsn.page.helper.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 服务实现类
 *
 * @author qiusn
 * @since 2019-11-13
 */
@Slf4j
@Service
public class TestUserServiceImpl implements TestUserService {
    @Resource
    private TestUserMapper testUserMapper;

    @Resource
    private YmlConfig ymlConfig;

    @Resource
    private TestMyYmlProp testMyYmlProp;

    @Override
    public TestUser getById(Long id) {

        /**
         * 方式一： 通过配置文件取值
         */
        // 网络定义yml取值赋值
        String[] arrStr = ymlConfig.getArrayProps();
        for (String str : arrStr) {
            System.err.println(" ------------ymlConfig.getArrayProps() :" + str);
        }
        System.err.println(" ymlConfig.getListProp1() :" + ymlConfig.getListProp1());
        System.err.println(" ymlConfig.getListProp2() :" + ymlConfig.getListProp2());
        System.err.println(" ymlConfig.getMapProps() :" + ymlConfig.getMapProps());
        System.err.println(" ymlConfig.getSimpleProp() :" + ymlConfig.getSimpleProp());

        // 自定义yml取值赋值
        System.err.println("myStrProp:" + ymlConfig.getMyStrProp());
        System.err.println("myListProp:" + ymlConfig.getMyListProp());
        System.err.println("myMapList:" + ymlConfig.getMyMapList());
        Integer[] arr = ymlConfig.getMyArr();
        for (int x : arr) {
            System.err.println("=======myArr:" + x);
        }

        /**
         * 方式二：通过@value直接取配置文件值
         */
        System.err.println("----------- @VALUE{}: " + testMyYmlProp.getMyYmlProp());

        return testUserMapper.getById(id);
    }

    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    @Override
    public PageData<TestUser> page(PageForm<TestUser> pageData) {
        PageHelper.startPage(pageData.getCurrentPage(), pageData.getPageSize());
        List<TestUser> testUsers = testUserMapper.page(pageData.getData());
        return PageUtil.setPageInfo(testUsers);
    }


    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @Cached 使用缓存
     * @CacheRefresh 刷新缓存
     * @CachePenetrationProtect 在多线程环境中同步加载数据
     * @author qiusn 2019-11-13
     */
    @Override
    public List<TestUser> list(TestUser search) {
        List<TestUser> list = testUserMapper.list(search);
        return list;
    }

    /**
     * 新增
     *
     * @param testUser 新增信息
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    @Override
    public Boolean insert(TestUser testUser) {
        int insertNum = testUserMapper.insert(testUser);
        if (insertNum == 1) {
            log.debug("新增成功");
        }
        log.info("返回参数{}", insertNum);
        log.info("=====================新增主键{}", testUser.getId().toString());
        return true;
    }

    /**
     * 修改
     *
     * @param testUser 主键、待修改信息
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    @Override
    public Boolean update(TestUser testUser) {
        int updateNum = testUserMapper.update(testUser);
        if (updateNum == 1) {
            log.debug("修改成功");
        }
        return true;
    }

    /**
     * 删除
     *
     * @param id 主键
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    @Override
    public Boolean delete(Long id) {
        int delNum = testUserMapper.delete(id);
        if (delNum == 1) {
            log.debug("删除成功");
        }
        return true;
    }

}
