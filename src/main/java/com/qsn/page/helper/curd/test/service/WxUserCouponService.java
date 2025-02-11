package com.qsn.page.helper.curd.test.service;

import com.qsn.page.helper.common.base.PageData;
import com.qsn.page.helper.common.base.PageForm;
import com.qsn.page.helper.curd.test.entity.WxUserCoupon;

import java.util.List;

/**
 * 用户卡券表 服务类
 *
 * @author qiusn
 * @since 2019-11-13
 */
public interface WxUserCouponService {

    /**
     * 分页
     *
     * @param pageData 分页参数及查询条件
     * @return 集合
     * @author qiusn 2019-11-12
     */
    PageData<WxUserCoupon> page(PageForm<WxUserCoupon> pageData);

    /**
     * 列表
     *
     * @param search 查询条件
     * @return 集合
     * @author qiusn 2019-11-13
     */
    List<WxUserCoupon> list(WxUserCoupon search);

    /**
     * 新增
     *
     * @param wxUserCoupon 新增信息
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    Boolean insert(WxUserCoupon wxUserCoupon);

    /**
     * 修改
     *
     * @param wxUserCoupon 主键、待修改信息
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    Boolean update(WxUserCoupon wxUserCoupon);

    /**
     * 删除
     *
     * @param id 主键
     * @return 成功或异常
     * @author qiusn 2019-11-13
     */
    Boolean delete(Long id);

}
