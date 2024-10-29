package com.dao;

import com.entity.JituanwnehuaLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JituanwnehuaLiuyanView;

/**
 * 集团文化留言 Dao 接口
 *
 * @author 
 */
public interface JituanwnehuaLiuyanDao extends BaseMapper<JituanwnehuaLiuyanEntity> {

   List<JituanwnehuaLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
