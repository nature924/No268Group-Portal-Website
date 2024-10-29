package com.dao;

import com.entity.XinwenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinwenView;

/**
 * 集团新闻 Dao 接口
 *
 * @author 
 */
public interface XinwenDao extends BaseMapper<XinwenEntity> {

   List<XinwenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
