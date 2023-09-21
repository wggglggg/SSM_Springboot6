package com.wggglggg.a08springbootheadlinepart.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wggglggg.a08springbootheadlinepart.model.po.Headline;
import com.wggglggg.a08springbootheadlinepart.model.vo.PortalVo;
import com.wggglggg.a08springbootheadlinepart.service.HeadlineService;
import com.wggglggg.a08springbootheadlinepart.mapper.HeadlineMapper;
import com.wggglggg.a08springbootheadlinepart.utils.JwtHelper;
import com.wggglggg.a08springbootheadlinepart.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @author wggglggg
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-09-20 11:17:23
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

    @Autowired
    private HeadlineMapper headlineMapper;
    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 首页数据查询
     *
     *   1. 进行分页数据查询
     *   2. 分页数据，拼接到result即可
     *
     *   注意1： 查询需要自定义语句 自定义mapper的方法，携带分页
     *   注意2： 返回的结果List<Map>
     * @param portalVo
     * @return
     */
    @Override
    public Result findNewsPage(PortalVo portalVo) {

        //分页参数
        IPage<Headline> page = new Page<>(portalVo.getPageNum(), portalVo.getPageSize());

        //分页查询
        //查询的结果 "pastHours":"3"   // 发布时间已过小时数 我们查询返回一个map
        //自定义方法
        headlineMapper.selectPageMap(page, portalVo);

        Map pageData = new HashMap();
        pageData.put("pageData", page.getRecords());
        pageData.put("pageNum", page.getCurrent());
        pageData.put("pageSize", page.getSize());
        pageData.put("totalPage", page.getPages());
        pageData.put("totalSize", page.getTotal());

        Map pageInfo = new HashMap();
        pageInfo.put("pageInfo", pageData);


        return Result.ok(pageInfo);
    }

    /**
     * 详情数据查询
     * "headline":{
     * "hid":"1",                     // 新闻id
     * "title":"马斯克宣布 ... ...",   // 新闻标题
     * "article":"... ..."            // 新闻正文
     * "type":"1",                    // 新闻所属类别编号
     * "typeName":"科技",             // 新闻所属类别
     * "pageViews":"40",              // 新闻浏览量
     * "pastHours":"3" ,              // 发布时间已过小时数
     * "publisher":"1" ,              // 发布用户ID
     * "author":"张三"                 // 新闻作者
     * }
     * 注意: 是多表查询 , 需要更新浏览量+1
     *   2、查询对应的数据即可 【多表，头条和用户表，方法需要自定义 返回map即可】
     *   1、修改阅读量 + 1  【version乐观锁，当前数据对应的版本】
     *
     * @param hid
     * @return
     */
    @Override
    public Result showHeadlineDetail(Integer hid) {
        //1.实现根据id的查询(多表
        Map headlineDetail = headlineMapper.showHeadlineDetail(hid);

        //2.拼接头条对象(阅读量和version)进行数据更新
        Headline headline = new Headline();
        headline.setHid((Integer) headlineDetail.get("hid"));
        //阅读量+1
        headline.setPageViews((Integer) headlineDetail.get("pageViews")+1);
        //设置版本
        headline.setVersion((Integer) headlineDetail.get("version"));
        headlineMapper.updateById(headline);

        Map<String ,Object> data = new HashMap<>();
        data.put("headline", headlineDetail);


        return Result.ok(data);
    }

    /**
     * 发布头条方法
     *
     *   1. 补全数据
     *
     * @param headline token
     * @return
     */
    @Override
    public Result publish(Headline headline, String token) {
        //token查询用户id
        int userId = jwtHelper.getUserId(token).intValue();

        //数据装配
        headline.setPageViews(0);
        headline.setPublisher(userId);
        headline.setCreateTime(new Date());
        headline.setUpdateTime(new Date());

        headlineMapper.insert(headline);

        return Result.ok(null);

    }

    /**
     * 根据id查询详情
     * @param hid
     * @return
     */
    @Override
    public Result findHeadlineByHid(Integer hid) {
        Headline headline = headlineMapper.selectById(hid);

        Map<String, Object> data = new HashMap<>();
        data.put("headline", headline);

        return Result.ok(data);
    }

    /**
     * 修改头条数据
     *
     *   1.hid查询数据的最新version
     *   2.修改数据的修改时间为当前节点
     *
     * @param headline
     * @return
     */
    @Override
    public Result updateDate(Headline headline) {
        Integer version = (headlineMapper.selectById(headline.getHid())).getVersion();

        headline.setVersion(version);
        headline.setUpdateTime(new Date());

        headlineMapper.updateById(headline);

        return Result.ok(null);
    }
}




