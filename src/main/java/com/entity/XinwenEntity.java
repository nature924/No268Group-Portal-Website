package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 集团新闻
 *
 * @author 
 * @email
 */
@TableName("xinwen")
public class XinwenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XinwenEntity() {

	}

	public XinwenEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 新闻标题
     */
    @ColumnInfo(comment="新闻标题",type="varchar(200)")
    @TableField(value = "xinwen_name")

    private String xinwenName;


    /**
     * 新闻类型
     */
    @ColumnInfo(comment="新闻类型",type="int(11)")
    @TableField(value = "xinwen_types")

    private Integer xinwenTypes;


    /**
     * 新闻图片
     */
    @ColumnInfo(comment="新闻图片",type="varchar(200)")
    @TableField(value = "xinwen_photo")

    private String xinwenPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 点击量
     */
    @ColumnInfo(comment="点击量",type="int(11)")
    @TableField(value = "xinwen_clicknum")

    private Integer xinwenClicknum;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 新闻详情
     */
    @ColumnInfo(comment="新闻详情",type="longtext")
    @TableField(value = "xinwen_content")

    private String xinwenContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：新闻标题
	 */
    public String getXinwenName() {
        return xinwenName;
    }
    /**
	 * 设置：新闻标题
	 */

    public void setXinwenName(String xinwenName) {
        this.xinwenName = xinwenName;
    }
    /**
	 * 获取：新闻类型
	 */
    public Integer getXinwenTypes() {
        return xinwenTypes;
    }
    /**
	 * 设置：新闻类型
	 */

    public void setXinwenTypes(Integer xinwenTypes) {
        this.xinwenTypes = xinwenTypes;
    }
    /**
	 * 获取：新闻图片
	 */
    public String getXinwenPhoto() {
        return xinwenPhoto;
    }
    /**
	 * 设置：新闻图片
	 */

    public void setXinwenPhoto(String xinwenPhoto) {
        this.xinwenPhoto = xinwenPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：点击量
	 */
    public Integer getXinwenClicknum() {
        return xinwenClicknum;
    }
    /**
	 * 设置：点击量
	 */

    public void setXinwenClicknum(Integer xinwenClicknum) {
        this.xinwenClicknum = xinwenClicknum;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：新闻详情
	 */
    public String getXinwenContent() {
        return xinwenContent;
    }
    /**
	 * 设置：新闻详情
	 */

    public void setXinwenContent(String xinwenContent) {
        this.xinwenContent = xinwenContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Xinwen{" +
            ", id=" + id +
            ", xinwenName=" + xinwenName +
            ", xinwenTypes=" + xinwenTypes +
            ", xinwenPhoto=" + xinwenPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", xinwenClicknum=" + xinwenClicknum +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", xinwenContent=" + xinwenContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
