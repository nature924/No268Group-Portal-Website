package com.entity.vo;

import com.entity.XinwenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 集团新闻
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinwen")
public class XinwenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 新闻标题
     */

    @TableField(value = "xinwen_name")
    private String xinwenName;


    /**
     * 新闻类型
     */

    @TableField(value = "xinwen_types")
    private Integer xinwenTypes;


    /**
     * 新闻图片
     */

    @TableField(value = "xinwen_photo")
    private String xinwenPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 点击量
     */

    @TableField(value = "xinwen_clicknum")
    private Integer xinwenClicknum;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 新闻详情
     */

    @TableField(value = "xinwen_content")
    private String xinwenContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：新闻标题
	 */
    public String getXinwenName() {
        return xinwenName;
    }


    /**
	 * 获取：新闻标题
	 */

    public void setXinwenName(String xinwenName) {
        this.xinwenName = xinwenName;
    }
    /**
	 * 设置：新闻类型
	 */
    public Integer getXinwenTypes() {
        return xinwenTypes;
    }


    /**
	 * 获取：新闻类型
	 */

    public void setXinwenTypes(Integer xinwenTypes) {
        this.xinwenTypes = xinwenTypes;
    }
    /**
	 * 设置：新闻图片
	 */
    public String getXinwenPhoto() {
        return xinwenPhoto;
    }


    /**
	 * 获取：新闻图片
	 */

    public void setXinwenPhoto(String xinwenPhoto) {
        this.xinwenPhoto = xinwenPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：点击量
	 */
    public Integer getXinwenClicknum() {
        return xinwenClicknum;
    }


    /**
	 * 获取：点击量
	 */

    public void setXinwenClicknum(Integer xinwenClicknum) {
        this.xinwenClicknum = xinwenClicknum;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：新闻详情
	 */
    public String getXinwenContent() {
        return xinwenContent;
    }


    /**
	 * 获取：新闻详情
	 */

    public void setXinwenContent(String xinwenContent) {
        this.xinwenContent = xinwenContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
