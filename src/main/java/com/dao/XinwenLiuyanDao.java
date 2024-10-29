package com.dao;

import com.entity.XinwenLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinwenLiuyanView;

/**
 * 集团新闻留言 Dao 接口
 *
 * @author 
 */
public interface XinwenLiuyanDao extends BaseMapper<XinwenLiuyanEntity> {

   List<XinwenLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
