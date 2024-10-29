
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
 * 集团文化
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jituanwnehua")
public class JituanwnehuaController {
    private static final Logger logger = LoggerFactory.getLogger(JituanwnehuaController.class);

    private static final String TABLE_NAME = "jituanwnehua";

    @Autowired
    private JituanwnehuaService jituanwnehuaService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
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
        params.put("jituanwnehuaDeleteStart",1);params.put("jituanwnehuaDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jituanwnehuaService.queryPage(params);

        //字典表数据转换
        List<JituanwnehuaView> list =(List<JituanwnehuaView>)page.getList();
        for(JituanwnehuaView c:list){
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
        JituanwnehuaEntity jituanwnehua = jituanwnehuaService.selectById(id);
        if(jituanwnehua !=null){
            //entity转view
            JituanwnehuaView view = new JituanwnehuaView();
            BeanUtils.copyProperties( jituanwnehua , view );//把实体数据重构到view中
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
    public R save(@RequestBody JituanwnehuaEntity jituanwnehua, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jituanwnehua:{}",this.getClass().getName(),jituanwnehua.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JituanwnehuaEntity> queryWrapper = new EntityWrapper<JituanwnehuaEntity>()
            .eq("jituanwnehua_name", jituanwnehua.getJituanwnehuaName())
            .eq("jituanwnehua_video", jituanwnehua.getJituanwnehuaVideo())
            .eq("jituanwnehua_types", jituanwnehua.getJituanwnehuaTypes())
            .eq("zan_number", jituanwnehua.getZanNumber())
            .eq("cai_number", jituanwnehua.getCaiNumber())
            .eq("jituanwnehua_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JituanwnehuaEntity jituanwnehuaEntity = jituanwnehuaService.selectOne(queryWrapper);
        if(jituanwnehuaEntity==null){
            jituanwnehua.setJituanwnehuaClicknum(1);
            jituanwnehua.setJituanwnehuaDelete(1);
            jituanwnehua.setInsertTime(new Date());
            jituanwnehua.setCreateTime(new Date());
            jituanwnehuaService.insert(jituanwnehua);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JituanwnehuaEntity jituanwnehua, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jituanwnehua:{}",this.getClass().getName(),jituanwnehua.toString());
        JituanwnehuaEntity oldJituanwnehuaEntity = jituanwnehuaService.selectById(jituanwnehua.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jituanwnehua.getJituanwnehuaPhoto()) || "null".equals(jituanwnehua.getJituanwnehuaPhoto())){
                jituanwnehua.setJituanwnehuaPhoto(null);
        }
        if("".equals(jituanwnehua.getJituanwnehuaVideo()) || "null".equals(jituanwnehua.getJituanwnehuaVideo())){
                jituanwnehua.setJituanwnehuaVideo(null);
        }

            jituanwnehuaService.updateById(jituanwnehua);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JituanwnehuaEntity> oldJituanwnehuaList =jituanwnehuaService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JituanwnehuaEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JituanwnehuaEntity jituanwnehuaEntity = new JituanwnehuaEntity();
            jituanwnehuaEntity.setId(id);
            jituanwnehuaEntity.setJituanwnehuaDelete(2);
            list.add(jituanwnehuaEntity);
        }
        if(list != null && list.size() >0){
            jituanwnehuaService.updateBatchById(list);
        }

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
            List<JituanwnehuaEntity> jituanwnehuaList = new ArrayList<>();//上传的东西
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
                            JituanwnehuaEntity jituanwnehuaEntity = new JituanwnehuaEntity();
//                            jituanwnehuaEntity.setJituanwnehuaUuidNumber(data.get(0));                    //编号 要改的
//                            jituanwnehuaEntity.setJituanwnehuaName(data.get(0));                    //标题 要改的
//                            jituanwnehuaEntity.setJituanwnehuaPhoto("");//详情和图片
//                            jituanwnehuaEntity.setJituanwnehuaVideo(data.get(0));                    //视频 要改的
//                            jituanwnehuaEntity.setJituanwnehuaTypes(Integer.valueOf(data.get(0)));   //文化类型 要改的
//                            jituanwnehuaEntity.setJituanwnehuaClicknum(Integer.valueOf(data.get(0)));   //热度 要改的
//                            jituanwnehuaEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            jituanwnehuaEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            jituanwnehuaEntity.setJituanwnehuaContent("");//详情和图片
//                            jituanwnehuaEntity.setJituanwnehuaDelete(1);//逻辑删除字段
//                            jituanwnehuaEntity.setInsertTime(date);//时间
//                            jituanwnehuaEntity.setCreateTime(date);//时间
                            jituanwnehuaList.add(jituanwnehuaEntity);


                            //把要查询是否重复的字段放入map中
                                //编号
                                if(seachFields.containsKey("jituanwnehuaUuidNumber")){
                                    List<String> jituanwnehuaUuidNumber = seachFields.get("jituanwnehuaUuidNumber");
                                    jituanwnehuaUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jituanwnehuaUuidNumber = new ArrayList<>();
                                    jituanwnehuaUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jituanwnehuaUuidNumber",jituanwnehuaUuidNumber);
                                }
                        }

                        //查询是否重复
                         //编号
                        List<JituanwnehuaEntity> jituanwnehuaEntities_jituanwnehuaUuidNumber = jituanwnehuaService.selectList(new EntityWrapper<JituanwnehuaEntity>().in("jituanwnehua_uuid_number", seachFields.get("jituanwnehuaUuidNumber")).eq("jituanwnehua_delete", 1));
                        if(jituanwnehuaEntities_jituanwnehuaUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JituanwnehuaEntity s:jituanwnehuaEntities_jituanwnehuaUuidNumber){
                                repeatFields.add(s.getJituanwnehuaUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jituanwnehuaService.insertBatch(jituanwnehuaList);
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
        List<JituanwnehuaView> returnJituanwnehuaViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("jituanwnehuaYesnoTypes",2);
        PageUtils pageUtils = jituanwnehuaCollectionService.queryPage(params1);
        List<JituanwnehuaCollectionView> collectionViewsList =(List<JituanwnehuaCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JituanwnehuaCollectionView collectionView:collectionViewsList){
            Integer jituanwnehuaTypes = collectionView.getJituanwnehuaTypes();
            if(typeMap.containsKey(jituanwnehuaTypes)){
                typeMap.put(jituanwnehuaTypes,typeMap.get(jituanwnehuaTypes)+1);
            }else{
                typeMap.put(jituanwnehuaTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jituanwnehuaTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("jituanwnehuaYesnoTypes",2);
            PageUtils pageUtils1 = jituanwnehuaService.queryPage(params2);
            List<JituanwnehuaView> jituanwnehuaViewList =(List<JituanwnehuaView>)pageUtils1.getList();
            returnJituanwnehuaViewList.addAll(jituanwnehuaViewList);
            if(returnJituanwnehuaViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("jituanwnehuaYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jituanwnehuaService.queryPage(params);
        if(returnJituanwnehuaViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJituanwnehuaViewList.size();//要添加的数量
            List<JituanwnehuaView> jituanwnehuaViewList =(List<JituanwnehuaView>)page.getList();
            for(JituanwnehuaView jituanwnehuaView:jituanwnehuaViewList){
                Boolean addFlag = true;
                for(JituanwnehuaView returnJituanwnehuaView:returnJituanwnehuaViewList){
                    if(returnJituanwnehuaView.getId().intValue() ==jituanwnehuaView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJituanwnehuaViewList.add(jituanwnehuaView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJituanwnehuaViewList = returnJituanwnehuaViewList.subList(0, limit);
        }

        for(JituanwnehuaView c:returnJituanwnehuaViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJituanwnehuaViewList);
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
        PageUtils page = jituanwnehuaService.queryPage(params);

        //字典表数据转换
        List<JituanwnehuaView> list =(List<JituanwnehuaView>)page.getList();
        for(JituanwnehuaView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JituanwnehuaEntity jituanwnehua = jituanwnehuaService.selectById(id);
            if(jituanwnehua !=null){

                //点击数量加1
                jituanwnehua.setJituanwnehuaClicknum(jituanwnehua.getJituanwnehuaClicknum()+1);
                jituanwnehuaService.updateById(jituanwnehua);

                //entity转view
                JituanwnehuaView view = new JituanwnehuaView();
                BeanUtils.copyProperties( jituanwnehua , view );//把实体数据重构到view中

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
    public R add(@RequestBody JituanwnehuaEntity jituanwnehua, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jituanwnehua:{}",this.getClass().getName(),jituanwnehua.toString());
        Wrapper<JituanwnehuaEntity> queryWrapper = new EntityWrapper<JituanwnehuaEntity>()
            .eq("jituanwnehua_uuid_number", jituanwnehua.getJituanwnehuaUuidNumber())
            .eq("jituanwnehua_name", jituanwnehua.getJituanwnehuaName())
            .eq("jituanwnehua_video", jituanwnehua.getJituanwnehuaVideo())
            .eq("jituanwnehua_types", jituanwnehua.getJituanwnehuaTypes())
            .eq("jituanwnehua_clicknum", jituanwnehua.getJituanwnehuaClicknum())
            .eq("zan_number", jituanwnehua.getZanNumber())
            .eq("cai_number", jituanwnehua.getCaiNumber())
            .eq("jituanwnehua_delete", jituanwnehua.getJituanwnehuaDelete())
//            .notIn("jituanwnehua_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JituanwnehuaEntity jituanwnehuaEntity = jituanwnehuaService.selectOne(queryWrapper);
        if(jituanwnehuaEntity==null){
            jituanwnehua.setJituanwnehuaClicknum(1);
                jituanwnehua.setZanNumber(1);
                jituanwnehua.setCaiNumber(1);
            jituanwnehua.setJituanwnehuaDelete(1);
            jituanwnehua.setInsertTime(new Date());
            jituanwnehua.setCreateTime(new Date());
        jituanwnehuaService.insert(jituanwnehua);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

