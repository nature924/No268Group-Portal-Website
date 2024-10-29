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
 * 单页数据
 *
 * @author 
 * @email
 */
@TableName("single_seach")
public class SingleSeachEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SingleSeachEntity() {

	}

	public SingleSeachEntity(T t) {
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
     * 名字
     */
    @ColumnInfo(comment="名字",type="varchar(200)")
    @TableField(value = "single_seach_name")

    private String singleSeachName;


    /**
     * 数据类型
     */
    @ColumnInfo(comment="数据类型",type="int(11)")
    @TableField(value = "single_seach_types")

    private Integer singleSeachTypes;


    /**
     * 图片
     */
    @ColumnInfo(comment="图片",type="varchar(200)")
    @TableField(value = "single_seach_photo")

    private String singleSeachPhoto;


    /**
     * 内容
     */
    @ColumnInfo(comment="内容",type="longtext")
    @TableField(value = "single_seach_content")

    private String singleSeachContent;


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
        return "SingleSeach{" +
            ", id=" + id +
            ", singleSeachName=" + singleSeachName +
            ", singleSeachTypes=" + singleSeachTypes +
            ", singleSeachPhoto=" + singleSeachPhoto +
            ", singleSeachContent=" + singleSeachContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
