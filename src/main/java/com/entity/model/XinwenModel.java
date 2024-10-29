package com.entity.model;

import com.entity.XinwenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 集团新闻
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinwenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 新闻标题
     */
    private String xinwenName;


    /**
     * 新闻类型
     */
    private Integer xinwenTypes;


    /**
     * 新闻图片
     */
    private String xinwenPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 点击量
     */
    private Integer xinwenClicknum;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 新闻详情
     */
    private String xinwenContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
