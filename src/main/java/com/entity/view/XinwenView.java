package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.XinwenEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 集团新闻
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("xinwen")
public class XinwenView extends XinwenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 新闻类型的值
	*/
	@ColumnInfo(comment="新闻类型的字典表值",type="varchar(200)")
	private String xinwenValue;




	public XinwenView() {

	}

	public XinwenView(XinwenEntity xinwenEntity) {
		try {
			BeanUtils.copyProperties(this, xinwenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "XinwenView{" +
			", xinwenValue=" + xinwenValue +
			"} " + super.toString();
	}
}
