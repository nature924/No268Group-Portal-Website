package com.dao;

import com.entity.SingleSeachEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SingleSeachView;

/**
 * 单页数据 Dao 接口
 *
 * @author 
 */
public interface SingleSeachDao extends BaseMapper<SingleSeachEntity> {

   List<SingleSeachView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
