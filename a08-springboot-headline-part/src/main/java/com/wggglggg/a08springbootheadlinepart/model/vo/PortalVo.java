package com.wggglggg.a08springbootheadlinepart.model.vo;

import lombok.Data;

/**
 * ClassName: PortalVo
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/9/20 19:45
 * @Version 1.0
 */
@Data
public class PortalVo {

    private String keyWords;
    private Integer type;
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
