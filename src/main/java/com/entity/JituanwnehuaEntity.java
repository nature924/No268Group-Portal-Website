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
 * 集团文化
 *
 * @author 
 * @email
 */
@TableName("jituanwnehua")
public class JituanwnehuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JituanwnehuaEntity() {

	}

	public JituanwnehuaEntity(T t) {
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
     * 编号
     */
    @ColumnInfo(comment="编号",type="varchar(200)")
    @TableField(value = "jituanwnehua_uuid_number")

    private String jituanwnehuaUuidNumber;


    /**
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "jituanwnehua_name")

    private String jituanwnehuaName;


    /**
     * 展示照片
     */
    @ColumnInfo(comment="展示照片",type="varchar(200)")
    @TableField(value = "jituanwnehua_photo")

    private String jituanwnehuaPhoto;


    /**
     * 视频
     */
    @ColumnInfo(comment="视频",type="varchar(200)")
    @TableField(value = "jituanwnehua_video")

    private String jituanwnehuaVideo;


    /**
     * 文化类型
     */
    @ColumnInfo(comment="文化类型",type="int(11)")
    @TableField(value = "jituanwnehua_types")

    private Integer jituanwnehuaTypes;


    /**
     * 热度
     */
    @ColumnInfo(comment="热度",type="int(11)")
    @TableField(value = "jituanwnehua_clicknum")

    private Integer jituanwnehuaClicknum;


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
     * 详情
     */
    @ColumnInfo(comment="详情",type="longtext")
    @TableField(value = "jituanwnehua_content")

    private String jituanwnehuaContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jituanwnehua_delete")

    private Integer jituanwnehuaDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
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
	 * 获取：编号
	 */
    public String getJituanwnehuaUuidNumber() {
        return jituanwnehuaUuidNumber;
    }
    /**
	 * 设置：编号
	 */

    public void setJituanwnehuaUuidNumber(String jituanwnehuaUuidNumber) {
        this.jituanwnehuaUuidNumber = jituanwnehuaUuidNumber;
    }
    /**
	 * 获取：标题
	 */
    public String getJituanwnehuaName() {
        return jituanwnehuaName;
    }
    /**
	 * 设置：标题
	 */

    public void setJituanwnehuaName(String jituanwnehuaName) {
        this.jituanwnehuaName = jituanwnehuaName;
    }
    /**
	 * 获取：展示照片
	 */
    public String getJituanwnehuaPhoto() {
        return jituanwnehuaPhoto;
    }
    /**
	 * 设置：展示照片
	 */

    public void setJituanwnehuaPhoto(String jituanwnehuaPhoto) {
        this.jituanwnehuaPhoto = jituanwnehuaPhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getJituanwnehuaVideo() {
        return jituanwnehuaVideo;
    }
    /**
	 * 设置：视频
	 */

    public void setJituanwnehuaVideo(String jituanwnehuaVideo) {
        this.jituanwnehuaVideo = jituanwnehuaVideo;
    }
    /**
	 * 获取：文化类型
	 */
    public Integer getJituanwnehuaTypes() {
        return jituanwnehuaTypes;
    }
    /**
	 * 设置：文化类型
	 */

    public void setJituanwnehuaTypes(Integer jituanwnehuaTypes) {
        this.jituanwnehuaTypes = jituanwnehuaTypes;
    }
    /**
	 * 获取：热度
	 */
    public Integer getJituanwnehuaClicknum() {
        return jituanwnehuaClicknum;
    }
    /**
	 * 设置：热度
	 */

    public void setJituanwnehuaClicknum(Integer jituanwnehuaClicknum) {
        this.jituanwnehuaClicknum = jituanwnehuaClicknum;
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
	 * 获取：详情
	 */
    public String getJituanwnehuaContent() {
        return jituanwnehuaContent;
    }
    /**
	 * 设置：详情
	 */

    public void setJituanwnehuaContent(String jituanwnehuaContent) {
        this.jituanwnehuaContent = jituanwnehuaContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJituanwnehuaDelete() {
        return jituanwnehuaDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJituanwnehuaDelete(Integer jituanwnehuaDelete) {
        this.jituanwnehuaDelete = jituanwnehuaDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jituanwnehua{" +
            ", id=" + id +
            ", jituanwnehuaUuidNumber=" + jituanwnehuaUuidNumber +
            ", jituanwnehuaName=" + jituanwnehuaName +
            ", jituanwnehuaPhoto=" + jituanwnehuaPhoto +
            ", jituanwnehuaVideo=" + jituanwnehuaVideo +
            ", jituanwnehuaTypes=" + jituanwnehuaTypes +
            ", jituanwnehuaClicknum=" + jituanwnehuaClicknum +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", jituanwnehuaContent=" + jituanwnehuaContent +
            ", jituanwnehuaDelete=" + jituanwnehuaDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
