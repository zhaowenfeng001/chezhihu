package com.ksc.kdts.taskmonitor.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysMenuService;
import com.ksc.kdts.taskmonitor.service.SysRoleMenuService;
import com.ksc.kdts.taskmonitor.util.SysMenuUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
@RestController
@RequestMapping("/admin/sysMenu")
public class SysMenuController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionJobController.class);


    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "get")
    public Response get(@RequestParam(value="id") Long id) {
        Response response = new Response();
        SysMenuDO sysMenuDO = sysMenuService.selectById(id);
        response.setResult(sysMenuDO);
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
    	SysMenuDO menu = sysMenuService.selectById(id);
    	if(menu == null){
    		return response.fail("菜单不存在");
    	}
    	
    	SysMenuQuery smquery = new SysMenuQuery();
    	smquery.setPid(id);
    	if(menu.getPid() == 0 && sysMenuService.count(smquery) > 0){
    		return response.fail("该菜单有子菜单，不能删除");
    	}
    	
    	SysRoleMenuQuery query = new SysRoleMenuQuery();
    	query.setMenuId(id);
    	if(sysRoleMenuService.count(query) > 0){
    		return response.fail("该菜单已经关联角色，不能删除");
    	}
        sysMenuService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "insert")
    public Response insert(@RequestBody SysMenu sysMenu){
        Response response = new Response();
        sysMenuService.insertMenu(sysMenu);
        return response.success();
    }

    /**
     * 修改
     * @param sysMenu
     * @return
     */
    @RequestMapping(value = "update")
    public Response update(@RequestBody SysMenu sysMenu){
        Response response = new Response();
    	if(StringUtils.isEmpty(sysMenu.getName())){
            return response.fail("菜单名字不能为空");
        }
    	SysMenuDO sourceMenu = sysMenuService.selectById(sysMenu.getId());
    	if(sourceMenu == null){
    		return response.fail("菜单不存在");
    	}
    	//判断是否有重名
    	if(!sourceMenu.getName().equals(sysMenu.getName())){
    		SysMenuQuery query = new SysMenuQuery();
            query.setName(sysMenu.getName());
            List<SysMenuDO> list = sysMenuService.searchByQuery(query);
            if(!CollectionUtils.isEmpty(list)){
            	return response.fail("菜单名字已经存在");
            }
    	}
        sysMenuService.update(sysMenu);
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
    public Response page(Integer current, Integer size, SysMenuQuery query){
        Response response = new Response();
        Page<SysMenuDO> page = sysMenuService.page(new QueryPage(current,size),query);
        response.setResult(page);
        return response.success();
    }

    /**
     * 分页查询
     * @param query 查询参数
     * @return
     */
    @RequestMapping("/list")
    public Response list(SysMenuQuery query){
        Response response = new Response();
        List<SysMenuDO> list = sysMenuService.searchByQuery(query);
    	list = SysMenuUtil.convertChildList(list);
    	response.setResult(list);
        return response.success();
    }
}
