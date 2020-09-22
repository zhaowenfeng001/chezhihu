package com.ksc.kdts.taskmonitor.controller;

import com.alibaba.fastjson.JSON;
import com.ksc.kdts.taskmonitor.cons.CacheConstant;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysAccountService;
import com.ksc.kdts.taskmonitor.service.SysAccountService;
import com.ksc.kdts.taskmonitor.service.SysMenuService;
import com.ksc.kdts.taskmonitor.service.SysRoleMenuService;
import com.ksc.kdts.taskmonitor.util.BeanUtils;
import com.ksc.kdts.taskmonitor.util.CacheHelper;
import com.ksc.kdts.taskmonitor.util.SysMenuUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * <p>
 * 账号表 前端控制器
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
@RestController
@RequestMapping("/admin/sysAccount")
public class SysAccountController extends BaseController {

    private Logger log = LoggerFactory.getLogger(SysAccountController.class);

    @Autowired
    private SysAccountService sysAccountService;
    @Autowired
    private CacheHelper cacheHelper;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;
    @Autowired
    private SysMenuService sysMenuService;


    /**
     * 登录
     * @param req
     * @return
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public Response login(@RequestBody SysAccountQuery req){
        Response response = new Response();
        req = Optional.ofNullable(req).orElse(new SysAccountQuery());
        String token = sysAccountService.login(req);
        return response.success(token);

    }
    
    /**
     * 退出
     * @return
     */
    @GetMapping("/loginOut")
    public Response loginOut(@RequestParam(name = "token") String token){
        Response response = new Response();
    	if(StringUtils.isNotEmpty(token)) {
            cacheHelper.delete(CacheConstant.TOKEN_ACCOUNT + token);
        }
        return response.success();
    }

    @GetMapping("/current")
    public Response current(){
        Response response = new Response();
        Long id = super.currentAdminId();
        SysAccount account = sysAccountService.selectById(id);
        if(account == null){
            return response.success();
        }
        SysAccountDO sa = BeanUtils.copyProperties(account, SysAccountDO.class);
        //加载登录用户的菜单
        SysRoleMenuQuery srmQuery = new SysRoleMenuQuery();
        srmQuery.setRoleId(account.getRoleId());
        List<Long> menuIdList = sysRoleMenuService.listMenuId(srmQuery);
        if(!CollectionUtils.isEmpty(menuIdList)){
            SysMenuQuery menuQuery = new SysMenuQuery();
            menuQuery.setIdList(menuIdList);
            List<SysMenuDO> menuList = sysMenuService.searchByQuery(menuQuery);
            menuList = SysMenuUtil.convertChildList(menuList);
            sa.setMenuList(menuList);
        }
        response.setData(sa);
        return response.success();

    }


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "get")
    public Response get(@RequestParam(value="id") Long id) {
        Response response = new Response();
        SysAccount sysAccount = sysAccountService.selectById(id);
        response.setData(sysAccount);
        return response.success();
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    public Response delete(@RequestParam(value="id") Long id){
        Response response = new Response();
        SysAccount sysAccount = sysAccountService.selectById(id);
        if(sysAccount == null){
            return response.fail("用户不存在");
        }

        SysRoleMenuQuery query = new SysRoleMenuQuery();
        query.setMenuId(id);
        sysAccountService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param sysAccount
     * @return
     */
    @RequestMapping(value = "insert")
    public Response insert(SysAccount sysAccount){
        Response response = new Response();
        sysAccount.setCreateTime(new Date());
        if(StringUtils.isNotEmpty(sysAccount.getEntryTimeStr())){
            try {
                sysAccount.setEntryTime(DateUtils.parseDate(sysAccount.getEntryTimeStr(),"YYYY-MM-DD HH:mm:ss"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        sysAccountService.insert(sysAccount);
        return response.success();
    }

    /**
     * 修改
     * @param sysAccount
     * @return
     */
    @RequestMapping(value = "update")
    public Response update(@RequestBody SysAccount sysAccount){
        Response response = new Response();
        sysAccountService.update(sysAccount);
        return response.success();
    }

    /**
     * 分页查询
     * @param current   查询页
     * @param size   每页显示条数
     * @param query 查询参数
     * @return
     */
    @RequestMapping(value="page")
    public Response page(Integer current, Integer size, SysAccountQuery query){
        Response response = new Response();
        Page<SysAccountDO> page = sysAccountService.page(new QueryPage(current,size),query);
        response.setData(page);
        return response.success();
    }

    /**
     * 分页查询
     * @param query 查询参数
     * @return
     */
    @RequestMapping("/list")
    public Response list(SysAccountQuery query){
        Response response = new Response();
        List<SysAccountDO> list = sysAccountService.searchByQuery(query);
        response.setData(list);
        return response.success();
    }

}