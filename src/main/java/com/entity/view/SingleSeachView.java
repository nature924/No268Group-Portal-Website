package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.SingleSeachEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 单页数据
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("single_seach")
public class SingleSeachView extends SingleSeachEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 数据类型的值
	*/
	@ColumnInfo(comment="数据类型的字典表值",type="varchar(200)")
	private String singleSeachValue;




	public SingleSeachView() {

	}

	public SingleSeachView(SingleSeachEntity singleSeachEntity) {
		try {
			BeanUtils.copyProperties(this, singleSeachEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 数据类型的值
	*/
	public String getSingleSeachValue() {
		return singleSeachValue;
	}
	/**
	* 设置： 数据类型的值
	*/
	public void setSingleSeachValue(String singleSeachValue) {
		this.singleSeachValue = singleSeachValue;
	}




	@Override
	public String toString() {
		return "SingleSeachView{" +
			", singleSeachValue=" + singleSeachValue +
			"} " + super.toString();
	}
}
