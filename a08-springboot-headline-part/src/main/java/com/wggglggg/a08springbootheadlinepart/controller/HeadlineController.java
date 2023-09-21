package com.wggglggg.a08springbootheadlinepart.controller;

import com.wggglggg.a08springbootheadlinepart.model.po.Headline;
import com.wggglggg.a08springbootheadlinepart.service.HeadlineService;
import com.wggglggg.a08springbootheadlinepart.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: HeadlineController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/21 9:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/headline")
@CrossOrigin
public class HeadlineController {
    @Autowired
    private HeadlineService headlineService;

    //登录以后才可以访问
    @PostMapping("/publish")
    public Result publish(@RequestBody Headline headline, @RequestHeader String token){

        Result result = headlineService.publish(headline, token);

        return result;

    }

    // 头条新闻回显
    @PostMapping("/findHeadlineByHid")
    public Result findHeadlineByHid(Integer hid){

        Result result = headlineService.findHeadlineByHid(hid);

        return result;
    }
    // 修改头条新闻
    @PostMapping("/update")
    public Result update(@RequestBody Headline headline){

        Result result = headlineService.updateDate(headline);

        return result;
    }

    // 删除头条新闻
    @PostMapping("/removeByHid")
    public Result removeByHid(Integer hid){

        headlineService.removeById(hid);
        return Result.ok(null);
    }
}
