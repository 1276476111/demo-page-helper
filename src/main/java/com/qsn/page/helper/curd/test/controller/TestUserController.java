package com.qsn.page.helper.curd.test.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.qsn.page.helper.common.base.PageData;
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.common.result.RestResult;
import com.qsn.page.helper.common.result.ResultGenerator;
import com.qsn.page.helper.curd.test.entity.TestUser;
import com.qsn.page.helper.curd.test.service.TestUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前端控制器
 *
 * @author qiusn
 * @since 2019-11-13
 */
@Slf4j
@RestController
@RequestMapping("/test-user")
public class TestUserController {

    @Resource
    private TestUserService testUserService;


    /**
     * 详情
     */
    @PostMapping("info")
    public TestUser getById(@RequestBody TestUser search) {
        TestUser testUser = testUserService.getById(search.getId());
        return testUser;
    }


    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    @PostMapping("page")
    public JSONArray page(@RequestBody PageForm<TestUser> pageData) {
        PageData<TestUser> page = testUserService.page(pageData);

        RestResult restResult = ResultGenerator.getSuccessResult(page.getData());

        String jsonStrPageData = JSON.toJSONString(page.getData());
        return JSONArray.parseArray(jsonStrPageData);
    }


    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn
     */
    @PostMapping("list")
    public List<TestUser> list(@RequestBody TestUser search) {
        List<TestUser> list = testUserService.list(search);
        RestResult restResult = ResultGenerator.getSuccessResult(list);
//        return restResult;
        return list;
    }

    /**
     * 新增
     *
     * @param testUser 新增信息
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("insert")
    public RestResult insert(@RequestBody TestUser testUser) {
        testUserService.insert(testUser);
        return ResultGenerator.getSuccessResult();
    }

    /**
     * 修改
     *
     * @param testUser 主键
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("update")
    public RestResult update(@RequestBody TestUser testUser) {
        testUserService.update(testUser);
        return ResultGenerator.getSuccessResult();
    }

    /**
     * 删除
     *
     * @param testUser 主键
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("delete")
    public RestResult delete(@RequestBody TestUser testUser) {
        testUserService.delete(testUser.getId());
        return ResultGenerator.getSuccessResult();
    }


}
