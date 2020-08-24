package com.ksc.kdts.taskmonitor.controller;

import com.alibaba.fastjson.JSON;
import com.ksc.kdts.taskmonitor.cons.CacheConstant;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysAccountService;
import com.ksc.kdts.taskmonitor.service.SysMenuService;
import com.ksc.kdts.taskmonitor.service.SysRoleMenuService;
import com.ksc.kdts.taskmonitor.util.BeanUtils;
import com.ksc.kdts.taskmonitor.util.CacheHelper;
import com.ksc.kdts.taskmonitor.util.SysMenuUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @PostMapping("/login")
    public Response login(SysAccountQuery req){
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

}