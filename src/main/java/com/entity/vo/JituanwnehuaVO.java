package com.entity.vo;

import com.entity.JituanwnehuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 集团文化
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jituanwnehua")
public class JituanwnehuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 编号
     */

    @TableField(value = "jituanwnehua_uuid_number")
    private String jituanwnehuaUuidNumber;


    /**
     * 标题
     */

    @TableField(value = "jituanwnehua_name")
    private String jituanwnehuaName;


    /**
     * 展示照片
     */

    @TableField(value = "jituanwnehua_photo")
    private String jituanwnehuaPhoto;


    /**
     * 视频
     */

    @TableField(value = "jituanwnehua_video")
    private String jituanwnehuaVideo;


    /**
     * 文化类型
     */

    @TableField(value = "jituanwnehua_types")
    private Integer jituanwnehuaTypes;


    /**
     * 热度
     */

    @TableField(value = "jituanwnehua_clicknum")
    private Integer jituanwnehuaClicknum;


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
     * 详情
     */

    @TableField(value = "jituanwnehua_content")
    private String jituanwnehuaContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jituanwnehua_delete")
    private Integer jituanwnehuaDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：编号
	 */
    public String getJituanwnehuaUuidNumber() {
        return jituanwnehuaUuidNumber;
    }


    /**
	 * 获取：编号
	 */

    public void setJituanwnehuaUuidNumber(String jituanwnehuaUuidNumber) {
        this.jituanwnehuaUuidNumber = jituanwnehuaUuidNumber;
    }
    /**
	 * 设置：标题
	 */
    public String getJituanwnehuaName() {
        return jituanwnehuaName;
    }


    /**
	 * 获取：标题
	 */

    public void setJituanwnehuaName(String jituanwnehuaName) {
        this.jituanwnehuaName = jituanwnehuaName;
    }
    /**
	 * 设置：展示照片
	 */
    public String getJituanwnehuaPhoto() {
        return jituanwnehuaPhoto;
    }


    /**
	 * 获取：展示照片
	 */

    public void setJituanwnehuaPhoto(String jituanwnehuaPhoto) {
        this.jituanwnehuaPhoto = jituanwnehuaPhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getJituanwnehuaVideo() {
        return jituanwnehuaVideo;
    }


    /**
	 * 获取：视频
	 */

    public void setJituanwnehuaVideo(String jituanwnehuaVideo) {
        this.jituanwnehuaVideo = jituanwnehuaVideo;
    }
    /**
	 * 设置：文化类型
	 */
    public Integer getJituanwnehuaTypes() {
        return jituanwnehuaTypes;
    }


    /**
	 * 获取：文化类型
	 */

    public void setJituanwnehuaTypes(Integer jituanwnehuaTypes) {
        this.jituanwnehuaTypes = jituanwnehuaTypes;
    }
    /**
	 * 设置：热度
	 */
    public Integer getJituanwnehuaClicknum() {
        return jituanwnehuaClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setJituanwnehuaClicknum(Integer jituanwnehuaClicknum) {
        this.jituanwnehuaClicknum = jituanwnehuaClicknum;
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
	 * 设置：详情
	 */
    public String getJituanwnehuaContent() {
        return jituanwnehuaContent;
    }


    /**
	 * 获取：详情
	 */

    public void setJituanwnehuaContent(String jituanwnehuaContent) {
        this.jituanwnehuaContent = jituanwnehuaContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJituanwnehuaDelete() {
        return jituanwnehuaDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJituanwnehuaDelete(Integer jituanwnehuaDelete) {
        this.jituanwnehuaDelete = jituanwnehuaDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
