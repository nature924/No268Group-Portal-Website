package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.JituanwnehuaLiuyanDao;
import com.entity.JituanwnehuaLiuyanEntity;
import com.service.JituanwnehuaLiuyanService;
import com.entity.view.JituanwnehuaLiuyanView;

/**
 * 集团文化留言 服务实现类
 */
@Service("jituanwnehuaLiuyanService")
@Transactional
public class JituanwnehuaLiuyanServiceImpl extends ServiceImpl<JituanwnehuaLiuyanDao, JituanwnehuaLiuyanEntity> implements JituanwnehuaLiuyanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<JituanwnehuaLiuyanView> page =new Query<JituanwnehuaLiuyanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
