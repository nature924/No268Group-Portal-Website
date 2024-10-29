package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JituanwnehuaLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 集团文化留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jituanwnehua_liuyan")
public class JituanwnehuaLiuyanView extends JituanwnehuaLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 集团文化
		/**
		* 编号
		*/

		@ColumnInfo(comment="编号",type="varchar(200)")
		private String jituanwnehuaUuidNumber;
		/**
		* 标题
		*/

		@ColumnInfo(comment="标题",type="varchar(200)")
		private String jituanwnehuaName;
		/**
		* 展示照片
		*/

		@ColumnInfo(comment="展示照片",type="varchar(200)")
		private String jituanwnehuaPhoto;
		/**
		* 视频
		*/

		@ColumnInfo(comment="视频",type="varchar(200)")
		private String jituanwnehuaVideo;
		/**
		* 文化类型
		*/
		@ColumnInfo(comment="文化类型",type="int(11)")
		private Integer jituanwnehuaTypes;
			/**
			* 文化类型的值
			*/
			@ColumnInfo(comment="文化类型的字典表值",type="varchar(200)")
			private String jituanwnehuaValue;
		/**
		* 热度
		*/

		@ColumnInfo(comment="热度",type="int(11)")
		private Integer jituanwnehuaClicknum;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 详情
		*/

		@ColumnInfo(comment="详情",type="longtext")
		private String jituanwnehuaContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jituanwnehuaDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public JituanwnehuaLiuyanView() {

	}

	public JituanwnehuaLiuyanView(JituanwnehuaLiuyanEntity jituanwnehuaLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, jituanwnehuaLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 集团文化

		/**
		* 获取： 编号
		*/
		public String getJituanwnehuaUuidNumber() {
			return jituanwnehuaUuidNumber;
		}
		/**
		* 设置： 编号
		*/
		public void setJituanwnehuaUuidNumber(String jituanwnehuaUuidNumber) {
			this.jituanwnehuaUuidNumber = jituanwnehuaUuidNumber;
		}

		/**
		* 获取： 标题
		*/
		public String getJituanwnehuaName() {
			return jituanwnehuaName;
		}
		/**
		* 设置： 标题
		*/
		public void setJituanwnehuaName(String jituanwnehuaName) {
			this.jituanwnehuaName = jituanwnehuaName;
		}

		/**
		* 获取： 展示照片
		*/
		public String getJituanwnehuaPhoto() {
			return jituanwnehuaPhoto;
		}
		/**
		* 设置： 展示照片
		*/
		public void setJituanwnehuaPhoto(String jituanwnehuaPhoto) {
			this.jituanwnehuaPhoto = jituanwnehuaPhoto;
		}

		/**
		* 获取： 视频
		*/
		public String getJituanwnehuaVideo() {
			return jituanwnehuaVideo;
		}
		/**
		* 设置： 视频
		*/
		public void setJituanwnehuaVideo(String jituanwnehuaVideo) {
			this.jituanwnehuaVideo = jituanwnehuaVideo;
		}
		/**
		* 获取： 文化类型
		*/
		public Integer getJituanwnehuaTypes() {
			return jituanwnehuaTypes;
		}
		/**
		* 设置： 文化类型
		*/
		public void setJituanwnehuaTypes(Integer jituanwnehuaTypes) {
			this.jituanwnehuaTypes = jituanwnehuaTypes;
		}


			/**
			* 获取： 文化类型的值
			*/
			public String getJituanwnehuaValue() {
				return jituanwnehuaValue;
			}
			/**
			* 设置： 文化类型的值
			*/
			public void setJituanwnehuaValue(String jituanwnehuaValue) {
				this.jituanwnehuaValue = jituanwnehuaValue;
			}

		/**
		* 获取： 热度
		*/
		public Integer getJituanwnehuaClicknum() {
			return jituanwnehuaClicknum;
		}
		/**
		* 设置： 热度
		*/
		public void setJituanwnehuaClicknum(Integer jituanwnehuaClicknum) {
			this.jituanwnehuaClicknum = jituanwnehuaClicknum;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 详情
		*/
		public String getJituanwnehuaContent() {
			return jituanwnehuaContent;
		}
		/**
		* 设置： 详情
		*/
		public void setJituanwnehuaContent(String jituanwnehuaContent) {
			this.jituanwnehuaContent = jituanwnehuaContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJituanwnehuaDelete() {
			return jituanwnehuaDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJituanwnehuaDelete(Integer jituanwnehuaDelete) {
			this.jituanwnehuaDelete = jituanwnehuaDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "JituanwnehuaLiuyanView{" +
			", jituanwnehuaUuidNumber=" + jituanwnehuaUuidNumber +
			", jituanwnehuaName=" + jituanwnehuaName +
			", jituanwnehuaPhoto=" + jituanwnehuaPhoto +
			", jituanwnehuaVideo=" + jituanwnehuaVideo +
			", jituanwnehuaClicknum=" + jituanwnehuaClicknum +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", jituanwnehuaContent=" + jituanwnehuaContent +
			", jituanwnehuaDelete=" + jituanwnehuaDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
