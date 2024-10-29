package com.entity.model;

import com.entity.JituanwnehuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 集团文化
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JituanwnehuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 编号
     */
    private String jituanwnehuaUuidNumber;


    /**
     * 标题
     */
    private String jituanwnehuaName;


    /**
     * 展示照片
     */
    private String jituanwnehuaPhoto;


    /**
     * 视频
     */
    private String jituanwnehuaVideo;


    /**
     * 文化类型
     */
    private Integer jituanwnehuaTypes;


    /**
     * 热度
     */
    private Integer jituanwnehuaClicknum;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 详情
     */
    private String jituanwnehuaContent;


    /**
     * 逻辑删除
     */
    private Integer jituanwnehuaDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
