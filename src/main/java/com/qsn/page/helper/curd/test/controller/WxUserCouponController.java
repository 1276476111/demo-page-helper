package com.qsn.page.helper.curd.test.controller;


import com.qsn.page.helper.common.base.PageData;
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.common.result.RestResult;
import com.qsn.page.helper.common.result.ResultGenerator;
import com.qsn.page.helper.curd.test.entity.WxUserCoupon;
import com.qsn.page.helper.curd.test.service.WxUserCouponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户卡券表 前端控制器
 *
 * @author qiusn
 * @since 2019-11-13
 */
@Slf4j
@RestController
@RequestMapping("/wx-user-coupon")
public class WxUserCouponController {

    @Resource
    private WxUserCouponService wxUserCouponService;

    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    @PostMapping("page")
    public RestResult page(@RequestBody PageForm<WxUserCoupon> pageData) {
        PageData<WxUserCoupon> page = wxUserCouponService.page(pageData);
        return ResultGenerator.getSuccessResult(page);
    }


    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn
     */
    @PostMapping("list")
    public RestResult list(@RequestBody WxUserCoupon search) {
        List<WxUserCoupon> list = wxUserCouponService.list(search);
        return ResultGenerator.getSuccessResult(list);
    }

    /**
     * 新增
     *
     * @param wxUserCoupon 新增信息
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("insert")
    public RestResult insert(@RequestBody WxUserCoupon wxUserCoupon) {
        wxUserCouponService.insert(wxUserCoupon);
        return ResultGenerator.getSuccessResult();
    }

    /**
     * 修改
     *
     * @param wxUserCoupon 主键
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("update")
    public RestResult update(@RequestBody WxUserCoupon wxUserCoupon) {
        wxUserCouponService.update(wxUserCoupon);
        return ResultGenerator.getSuccessResult();
    }

    /**
     * 删除
     *
     * @param wxUserCoupon 主键
     * @return 成功或异常
     * @author qiusn
     */
    @PostMapping("delete")
    public RestResult delete(@RequestBody WxUserCoupon wxUserCoupon) {
        wxUserCouponService.delete(wxUserCoupon.getId());
        return ResultGenerator.getSuccessResult();
    }


}
