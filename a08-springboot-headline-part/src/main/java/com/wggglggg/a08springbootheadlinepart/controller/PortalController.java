package com.wggglggg.a08springbootheadlinepart.controller;

import com.wggglggg.a08springbootheadlinepart.model.po.Type;
import com.wggglggg.a08springbootheadlinepart.model.vo.PortalVo;
import com.wggglggg.a08springbootheadlinepart.service.HeadlineService;
import com.wggglggg.a08springbootheadlinepart.service.TypeService;
import com.wggglggg.a08springbootheadlinepart.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: PortalController
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/20 19:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/portal")
public class PortalController {

    @Autowired
    private TypeService typeService;
    @Autowired
    private HeadlineService headlineService;

    /**
     * 查询全部类别信息
     * @return
     */
    @GetMapping("/findAllTypes")
    public Result findAllTypes(){
        List<Type> list = typeService.findAllTypes();

        return Result.ok(list);
    }

    /**
     * 首页分页查询
     * @return
     */
    @PostMapping("/findNewsPage")
    public Result findNewsPage(@RequestBody PortalVo portalVo){

        Result result = headlineService.findNewsPage(portalVo);

        return result;
    }

    @PostMapping("/showHeadlineDetail")
    public Result showHeadlineDetail(Integer hid){

        Result result = headlineService.showHeadlineDetail(hid);

        return result;
    }
}
