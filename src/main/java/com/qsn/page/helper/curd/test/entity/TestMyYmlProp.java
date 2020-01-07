package com.qsn.page.helper.curd.test.entity;

import com.qsn.page.helper.common.base.BaseDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 测试用 @VALUE 取值是否成功
 *
 * @author qiusn
 * @version 1.0 2019/11/20 14:27
 */
@Getter
@Setter
@ToString
@Component
public class TestMyYmlProp extends BaseDO {

    @Value("${my-yml.myStrProp}")
    private String myYmlProp;

}
