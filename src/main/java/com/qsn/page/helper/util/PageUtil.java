package com.qsn.page.helper.util;

import com.github.pagehelper.PageInfo;
import com.qsn.page.helper.common.base.PageData;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页工具
 *
 * @author qiusn
 * @version 1.0 2019/11/13 15:36
 */
@Component
public class PageUtil {

    /**
     * 设置分页返回参数： 分页总数、当前页数、每页的记录数
     *
     * @param list
     * @return
     */
    public static PageData setPageInfo(List list) {
        PageInfo pageInfo = new PageInfo(list);
        PageData page = new PageData();
        page.setCurrentPage(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setData(list);
        return page;
    }

}
