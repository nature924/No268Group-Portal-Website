package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JituanwnehuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 集团文化
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jituanwnehua")
public class JituanwnehuaView extends JituanwnehuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 文化类型的值
	*/
	@ColumnInfo(comment="文化类型的字典表值",type="varchar(200)")
	private String jituanwnehuaValue;




	public JituanwnehuaView() {

	}

	public JituanwnehuaView(JituanwnehuaEntity jituanwnehuaEntity) {
		try {
			BeanUtils.copyProperties(this, jituanwnehuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "JituanwnehuaView{" +
			", jituanwnehuaValue=" + jituanwnehuaValue +
			"} " + super.toString();
	}
}
