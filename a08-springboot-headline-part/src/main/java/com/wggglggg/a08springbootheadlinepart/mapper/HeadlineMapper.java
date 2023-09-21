package com.wggglggg.a08springbootheadlinepart.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wggglggg.a08springbootheadlinepart.model.po.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wggglggg.a08springbootheadlinepart.model.vo.PortalVo;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
* @author wggglggg
* @description 针对表【news_headline】的数据库操作Mapper
* @createDate 2023-09-20 11:17:23
* @Entity com.wggglggg.a08springbootheadlinepart.model.po.Headline
*/
public interface HeadlineMapper extends BaseMapper<Headline> {
    //自定义分页查询方法
    IPage<Map> selectPageMap(IPage<Headline> page, PortalVo portalVo);


    Map showHeadlineDetail(Integer hid);
}




