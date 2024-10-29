
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 集团新闻收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinwenCollection")
public class XinwenCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(XinwenCollectionController.class);

    private static final String TABLE_NAME = "xinwenCollection";

    @Autowired
    private XinwenCollectionService xinwenCollectionService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JituanwnehuaService jituanwnehuaService;//集团文化
    @Autowired
    private JituanwnehuaCollectionService jituanwnehuaCollectionService;//集团文化收藏
    @Autowired
    private JituanwnehuaLiuyanService jituanwnehuaLiuyanService;//集团文化留言
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private SingleSeachService singleSeachService;//单页数据
    @Autowired
    private XinwenService xinwenService;//集团新闻
    @Autowired
    private XinwenLiuyanService xinwenLiuyanService;//集团新闻留言
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xinwenCollectionService.queryPage(params);

        //字典表数据转换
        List<XinwenCollectionView> list =(List<XinwenCollectionView>)page.getList();
        for(XinwenCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinwenCollectionEntity xinwenCollection = xinwenCollectionService.selectById(id);
        if(xinwenCollection !=null){
            //entity转view
            XinwenCollectionView view = new XinwenCollectionView();
            BeanUtils.copyProperties( xinwenCollection , view );//把实体数据重构到view中
            //级联表 集团新闻
            //级联表
            XinwenEntity xinwen = xinwenService.selectById(xinwenCollection.getXinwenId());
            if(xinwen != null){
            BeanUtils.copyProperties( xinwen , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXinwenId(xinwen.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xinwenCollection.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XinwenCollectionEntity xinwenCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinwenCollection:{}",this.getClass().getName(),xinwenCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            xinwenCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XinwenCollectionEntity> queryWrapper = new EntityWrapper<XinwenCollectionEntity>()
            .eq("xinwen_id", xinwenCollection.getXinwenId())
            .eq("yonghu_id", xinwenCollection.getYonghuId())
            .eq("xinwen_collection_types", xinwenCollection.getXinwenCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinwenCollectionEntity xinwenCollectionEntity = xinwenCollectionService.selectOne(queryWrapper);
        if(xinwenCollectionEntity==null){
            xinwenCollection.setInsertTime(new Date());
            xinwenCollection.setCreateTime(new Date());
            xinwenCollectionService.insert(xinwenCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinwenCollectionEntity xinwenCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinwenCollection:{}",this.getClass().getName(),xinwenCollection.toString());
        XinwenCollectionEntity oldXinwenCollectionEntity = xinwenCollectionService.selectById(xinwenCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            xinwenCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            xinwenCollectionService.updateById(xinwenCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinwenCollectionEntity> oldXinwenCollectionList =xinwenCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xinwenCollectionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<XinwenCollectionEntity> xinwenCollectionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XinwenCollectionEntity xinwenCollectionEntity = new XinwenCollectionEntity();
//                            xinwenCollectionEntity.setXinwenId(Integer.valueOf(data.get(0)));   //集团新闻 要改的
//                            xinwenCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xinwenCollectionEntity.setXinwenCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            xinwenCollectionEntity.setInsertTime(date);//时间
//                            xinwenCollectionEntity.setCreateTime(date);//时间
                            xinwenCollectionList.add(xinwenCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xinwenCollectionService.insertBatch(xinwenCollectionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinwenCollectionService.queryPage(params);

        //字典表数据转换
        List<XinwenCollectionView> list =(List<XinwenCollectionView>)page.getList();
        for(XinwenCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinwenCollectionEntity xinwenCollection = xinwenCollectionService.selectById(id);
            if(xinwenCollection !=null){


                //entity转view
                XinwenCollectionView view = new XinwenCollectionView();
                BeanUtils.copyProperties( xinwenCollection , view );//把实体数据重构到view中

                //级联表
                    XinwenEntity xinwen = xinwenService.selectById(xinwenCollection.getXinwenId());
                if(xinwen != null){
                    BeanUtils.copyProperties( xinwen , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXinwenId(xinwen.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinwenCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XinwenCollectionEntity xinwenCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinwenCollection:{}",this.getClass().getName(),xinwenCollection.toString());
        Wrapper<XinwenCollectionEntity> queryWrapper = new EntityWrapper<XinwenCollectionEntity>()
            .eq("xinwen_id", xinwenCollection.getXinwenId())
            .eq("yonghu_id", xinwenCollection.getYonghuId())
            .eq("xinwen_collection_types", xinwenCollection.getXinwenCollectionTypes())
//            .notIn("xinwen_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinwenCollectionEntity xinwenCollectionEntity = xinwenCollectionService.selectOne(queryWrapper);
        if(xinwenCollectionEntity==null){
            xinwenCollection.setInsertTime(new Date());
            xinwenCollection.setCreateTime(new Date());
        xinwenCollectionService.insert(xinwenCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

