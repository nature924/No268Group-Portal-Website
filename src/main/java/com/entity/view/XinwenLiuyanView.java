package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XinwenLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 集团新闻留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xinwen_liuyan")
public class XinwenLiuyanView extends XinwenLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 集团新闻
		/**
		* 新闻标题
		*/

		@ColumnInfo(comment="新闻标题",type="varchar(200)")
		private String xinwenName;
		/**
		* 新闻类型
		*/
		@ColumnInfo(comment="新闻类型",type="int(11)")
		private Integer xinwenTypes;
			/**
			* 新闻类型的值
			*/
			@ColumnInfo(comment="新闻类型的字典表值",type="varchar(200)")
			private String xinwenValue;
		/**
		* 新闻图片
		*/

		@ColumnInfo(comment="新闻图片",type="varchar(200)")
		private String xinwenPhoto;
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
		* 点击量
		*/

		@ColumnInfo(comment="点击量",type="int(11)")
		private Integer xinwenClicknum;
		/**
		* 新闻详情
		*/

		@ColumnInfo(comment="新闻详情",type="longtext")
		private String xinwenContent;
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



	public XinwenLiuyanView() {

	}

	public XinwenLiuyanView(XinwenLiuyanEntity xinwenLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, xinwenLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 集团新闻

		/**
		* 获取： 新闻标题
		*/
		public String getXinwenName() {
			return xinwenName;
		}
		/**
		* 设置： 新闻标题
		*/
		public void setXinwenName(String xinwenName) {
			this.xinwenName = xinwenName;
		}
		/**
		* 获取： 新闻类型
		*/
		public Integer getXinwenTypes() {
			return xinwenTypes;
		}
		/**
		* 设置： 新闻类型
		*/
		public void setXinwenTypes(Integer xinwenTypes) {
			this.xinwenTypes = xinwenTypes;
		}


			/**
			* 获取： 新闻类型的值
			*/
			public String getXinwenValue() {
				return xinwenValue;
			}
			/**
			* 设置： 新闻类型的值
			*/
			public void setXinwenValue(String xinwenValue) {
				this.xinwenValue = xinwenValue;
			}

		/**
		* 获取： 新闻图片
		*/
		public String getXinwenPhoto() {
			return xinwenPhoto;
		}
		/**
		* 设置： 新闻图片
		*/
		public void setXinwenPhoto(String xinwenPhoto) {
			this.xinwenPhoto = xinwenPhoto;
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
		* 获取： 点击量
		*/
		public Integer getXinwenClicknum() {
			return xinwenClicknum;
		}
		/**
		* 设置： 点击量
		*/
		public void setXinwenClicknum(Integer xinwenClicknum) {
			this.xinwenClicknum = xinwenClicknum;
		}

		/**
		* 获取： 新闻详情
		*/
		public String getXinwenContent() {
			return xinwenContent;
		}
		/**
		* 设置： 新闻详情
		*/
		public void setXinwenContent(String xinwenContent) {
			this.xinwenContent = xinwenContent;
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
		return "XinwenLiuyanView{" +
			", xinwenName=" + xinwenName +
			", xinwenPhoto=" + xinwenPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", xinwenClicknum=" + xinwenClicknum +
			", xinwenContent=" + xinwenContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
