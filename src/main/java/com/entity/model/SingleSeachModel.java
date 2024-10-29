package com.entity.model;

import com.entity.SingleSeachEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 单页数据
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SingleSeachModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 名字
     */
    private String singleSeachName;


    /**
     * 数据类型
     */
    private Integer singleSeachTypes;


    /**
     * 图片
     */
    private String singleSeachPhoto;


    /**
     * 内容
     */
    private String singleSeachContent;


    /**
     * 创建时间 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：名字
	 */
    public String getSingleSeachName() {
        return singleSeachName;
    }


    /**
	 * 设置：名字
	 */
    public void setSingleSeachName(String singleSeachName) {
        this.singleSeachName = singleSeachName;
    }
    /**
	 * 获取：数据类型
	 */
    public Integer getSingleSeachTypes() {
        return singleSeachTypes;
    }


    /**
	 * 设置：数据类型
	 */
    public void setSingleSeachTypes(Integer singleSeachTypes) {
        this.singleSeachTypes = singleSeachTypes;
    }
    /**
	 * 获取：图片
	 */
    public String getSingleSeachPhoto() {
        return singleSeachPhoto;
    }


    /**
	 * 设置：图片
	 */
    public void setSingleSeachPhoto(String singleSeachPhoto) {
        this.singleSeachPhoto = singleSeachPhoto;
    }
    /**
	 * 获取：内容
	 */
    public String getSingleSeachContent() {
        return singleSeachContent;
    }


    /**
	 * 设置：内容
	 */
    public void setSingleSeachContent(String singleSeachContent) {
        this.singleSeachContent = singleSeachContent;
    }
    /**
	 * 获取：创建时间 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
