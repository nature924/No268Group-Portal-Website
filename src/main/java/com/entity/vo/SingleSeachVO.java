package com.entity.vo;

import com.entity.SingleSeachEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 单页数据
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("single_seach")
public class SingleSeachVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 名字
     */

    @TableField(value = "single_seach_name")
    private String singleSeachName;


    /**
     * 数据类型
     */

    @TableField(value = "single_seach_types")
    private Integer singleSeachTypes;


    /**
     * 图片
     */

    @TableField(value = "single_seach_photo")
    private String singleSeachPhoto;


    /**
     * 内容
     */

    @TableField(value = "single_seach_content")
    private String singleSeachContent;


    /**
     * 创建时间 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：名字
	 */
    public String getSingleSeachName() {
        return singleSeachName;
    }


    /**
	 * 获取：名字
	 */

    public void setSingleSeachName(String singleSeachName) {
        this.singleSeachName = singleSeachName;
    }
    /**
	 * 设置：数据类型
	 */
    public Integer getSingleSeachTypes() {
        return singleSeachTypes;
    }


    /**
	 * 获取：数据类型
	 */

    public void setSingleSeachTypes(Integer singleSeachTypes) {
        this.singleSeachTypes = singleSeachTypes;
    }
    /**
	 * 设置：图片
	 */
    public String getSingleSeachPhoto() {
        return singleSeachPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setSingleSeachPhoto(String singleSeachPhoto) {
        this.singleSeachPhoto = singleSeachPhoto;
    }
    /**
	 * 设置：内容
	 */
    public String getSingleSeachContent() {
        return singleSeachContent;
    }


    /**
	 * 获取：内容
	 */

    public void setSingleSeachContent(String singleSeachContent) {
        this.singleSeachContent = singleSeachContent;
    }
    /**
	 * 设置：创建时间 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
