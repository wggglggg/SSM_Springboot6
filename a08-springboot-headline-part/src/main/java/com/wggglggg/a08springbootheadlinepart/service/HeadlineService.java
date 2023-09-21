package com.wggglggg.a08springbootheadlinepart.service;

import com.wggglggg.a08springbootheadlinepart.model.po.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wggglggg.a08springbootheadlinepart.model.vo.PortalVo;
import com.wggglggg.a08springbootheadlinepart.utils.Result;

/**
* @author wggglggg
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2023-09-20 11:17:23
*/
public interface HeadlineService extends IService<Headline> {

    /**
     * 首页分页查询
     * @return
     */
    Result findNewsPage(PortalVo portalVo);

    /**
     * 根据id查询详情
     * @param hid
     * @return
     */
    Result showHeadlineDetail(Integer hid);

    /**
     * 发布数据
     * @param headline
     * @return
     */
    Result publish(Headline headline, String token);

    /**
     * 根据id查询详情
     * @param hid
     * @return
     */
    Result findHeadlineByHid(Integer hid);

    /**
     * 修改头条数据
     * @param headline
     * @return
     */
    Result updateDate(Headline headline);
}
