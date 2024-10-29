
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
 * 集团新闻
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinwen")
public class XinwenController {
    private static final Logger logger = LoggerFactory.getLogger(XinwenController.class);

    private static final String TABLE_NAME = "xinwen";

    @Autowired
    private XinwenService xinwenService;


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
    private XinwenCollectionService xinwenCollectionService;//集团新闻收藏
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
        PageUtils page = xinwenService.queryPage(params);

        //字典表数据转换
        List<XinwenView> list =(List<XinwenView>)page.getList();
        for(XinwenView c:list){
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
        XinwenEntity xinwen = xinwenService.selectById(id);
        if(xinwen !=null){
            //entity转view
            XinwenView view = new XinwenView();
            BeanUtils.copyProperties( xinwen , view );//把实体数据重构到view中
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
    public R save(@RequestBody XinwenEntity xinwen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinwen:{}",this.getClass().getName(),xinwen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XinwenEntity> queryWrapper = new EntityWrapper<XinwenEntity>()
            .eq("xinwen_name", xinwen.getXinwenName())
            .eq("xinwen_types", xinwen.getXinwenTypes())
            .eq("zan_number", xinwen.getZanNumber())
            .eq("cai_number", xinwen.getCaiNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinwenEntity xinwenEntity = xinwenService.selectOne(queryWrapper);
        if(xinwenEntity==null){
            xinwen.setXinwenClicknum(1);
            xinwen.setInsertTime(new Date());
            xinwen.setCreateTime(new Date());
            xinwenService.insert(xinwen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinwenEntity xinwen, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinwen:{}",this.getClass().getName(),xinwen.toString());
        XinwenEntity oldXinwenEntity = xinwenService.selectById(xinwen.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(xinwen.getXinwenPhoto()) || "null".equals(xinwen.getXinwenPhoto())){
                xinwen.setXinwenPhoto(null);
        }

            xinwenService.updateById(xinwen);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinwenEntity> oldXinwenList =xinwenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xinwenService.deleteBatchIds(Arrays.asList(ids));

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
            List<XinwenEntity> xinwenList = new ArrayList<>();//上传的东西
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
                            XinwenEntity xinwenEntity = new XinwenEntity();
//                            xinwenEntity.setXinwenName(data.get(0));                    //新闻标题 要改的
//                            xinwenEntity.setXinwenTypes(Integer.valueOf(data.get(0)));   //新闻类型 要改的
//                            xinwenEntity.setXinwenPhoto("");//详情和图片
//                            xinwenEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            xinwenEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            xinwenEntity.setXinwenClicknum(Integer.valueOf(data.get(0)));   //点击量 要改的
//                            xinwenEntity.setInsertTime(date);//时间
//                            xinwenEntity.setXinwenContent("");//详情和图片
//                            xinwenEntity.setCreateTime(date);//时间
                            xinwenList.add(xinwenEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xinwenService.insertBatch(xinwenList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<XinwenView> returnXinwenViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("xinwenYesnoTypes",2);
        PageUtils pageUtils = xinwenCollectionService.queryPage(params1);
        List<XinwenCollectionView> collectionViewsList =(List<XinwenCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(XinwenCollectionView collectionView:collectionViewsList){
            Integer xinwenTypes = collectionView.getXinwenTypes();
            if(typeMap.containsKey(xinwenTypes)){
                typeMap.put(xinwenTypes,typeMap.get(xinwenTypes)+1);
            }else{
                typeMap.put(xinwenTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("xinwenTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("xinwenYesnoTypes",2);
            PageUtils pageUtils1 = xinwenService.queryPage(params2);
            List<XinwenView> xinwenViewList =(List<XinwenView>)pageUtils1.getList();
            returnXinwenViewList.addAll(xinwenViewList);
            if(returnXinwenViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("xinwenYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = xinwenService.queryPage(params);
        if(returnXinwenViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnXinwenViewList.size();//要添加的数量
            List<XinwenView> xinwenViewList =(List<XinwenView>)page.getList();
            for(XinwenView xinwenView:xinwenViewList){
                Boolean addFlag = true;
                for(XinwenView returnXinwenView:returnXinwenViewList){
                    if(returnXinwenView.getId().intValue() ==xinwenView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnXinwenViewList.add(xinwenView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnXinwenViewList = returnXinwenViewList.subList(0, limit);
        }

        for(XinwenView c:returnXinwenViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnXinwenViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinwenService.queryPage(params);

        //字典表数据转换
        List<XinwenView> list =(List<XinwenView>)page.getList();
        for(XinwenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinwenEntity xinwen = xinwenService.selectById(id);
            if(xinwen !=null){

                //点击数量加1
                xinwen.setXinwenClicknum(xinwen.getXinwenClicknum()+1);
                xinwenService.updateById(xinwen);

                //entity转view
                XinwenView view = new XinwenView();
                BeanUtils.copyProperties( xinwen , view );//把实体数据重构到view中

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
    public R add(@RequestBody XinwenEntity xinwen, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinwen:{}",this.getClass().getName(),xinwen.toString());
        Wrapper<XinwenEntity> queryWrapper = new EntityWrapper<XinwenEntity>()
            .eq("xinwen_name", xinwen.getXinwenName())
            .eq("xinwen_types", xinwen.getXinwenTypes())
            .eq("zan_number", xinwen.getZanNumber())
            .eq("cai_number", xinwen.getCaiNumber())
            .eq("xinwen_clicknum", xinwen.getXinwenClicknum())
//            .notIn("xinwen_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinwenEntity xinwenEntity = xinwenService.selectOne(queryWrapper);
        if(xinwenEntity==null){
                xinwen.setZanNumber(1);
                xinwen.setCaiNumber(1);
            xinwen.setXinwenClicknum(1);
            xinwen.setInsertTime(new Date());
            xinwen.setCreateTime(new Date());
        xinwenService.insert(xinwen);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

