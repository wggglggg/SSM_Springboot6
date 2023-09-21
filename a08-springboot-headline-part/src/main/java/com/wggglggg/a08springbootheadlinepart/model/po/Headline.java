package com.wggglggg.a08springbootheadlinepart.model.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName news_headline
 */

@Data
public class Headline implements Serializable {
    /**
     * 头条id
     */
    @TableId(value = "hid", type = IdType.AUTO)
    private Integer hid;

    /**
     * 头条标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 头条新闻内容
     */
    @TableField(value = "article")
    private String article;

    /**
     * 头条类型id
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 头条发布用户id
     */
    @TableField(value = "publisher")
    private Integer publisher;

    /**
     * 头条浏览量
     */
    @TableField(value = "page_views")
    private Integer pageViews;

    /**
     * 头条发布时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 头条最后的修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    @Version
    private Integer version;

    /**
     * 头条是否被删除 1 删除  0 未删除
     */
    @TableField(value = "is_deleted")
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}