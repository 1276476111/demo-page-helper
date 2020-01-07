package com.qsn.page.helper.curd.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.qsn.page.helper.common.base.BaseDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 测试功能类
 *
 * @author qiusn 2019-11-13
 */
@Getter
@Setter
@ToString(callSuper = true)
public class TestUser extends BaseDO {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 名称
     */
    private String userName;

    /**
     * 名称
     */
    private String password;

    /**
     * 性别（1男，2女，3不男不女）
     */
    private Boolean sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 还有多少钱
     */
    private BigDecimal money;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createTime;

    private Date updateTime;


}