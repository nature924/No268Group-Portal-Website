package com.dao;

import com.entity.JituanwnehuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JituanwnehuaView;

/**
 * 集团文化 Dao 接口
 *
 * @author 
 */
public interface JituanwnehuaDao extends BaseMapper<JituanwnehuaEntity> {

   List<JituanwnehuaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
