package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysRoleMenuService;
import com.ksc.kdts.taskmonitor.service.SysRoleService;
import com.ksc.kdts.taskmonitor.util.SysMenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/sysRole")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysRoleMenuService sysRoleMenuService;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping("get")
    public Response get(@RequestParam(value = "id") Long id) {
        Response response = new Response();
        SysRoleDO sysRoleDO = sysRoleService.selectById(id);
        response.setData(sysRoleDO);
        return response.success();
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @RequestMapping("delete")
    public Response delete(@RequestParam(value = "id") Long id){
        Response response = new Response();
        sysRoleService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param sysRole
     * @return
     */
    @RequestMapping("insert")
    public Response insert(@RequestBody SysRole sysRole){
        Response response = new Response();
        sysRoleService.insert(sysRole);
        return response.success();
    }

    /**
     * 修改
     * @param sysRole
     * @return
     */
    @RequestMapping("update")
    public Response update(@RequestBody SysRole sysRole){
        Response response = new Response();
        sysRoleService.update(sysRole);
        return response.success();
    }

    /**
     * 分页查询
     * @param current   查询页
     * @param size   每页显示条数
     * @param query 查询参数
     * @return
     */
    @GetMapping("/page")
    public Response page(Integer current, Integer size, SysRoleQuery query){
        Response response = new Response();
        Page<SysRoleDO> page = sysRoleService.page(new QueryPage(current,size),query);
        response.setData(page);
        return response.success();
    }

    /**
     * 列表查询
     * @param query 查询参数
     * @return
     */
    @GetMapping("/list")
    public Response list(SysRoleQuery query){
        Response response = new Response();
        List<SysMenuDO> list = sysRoleService.searchByQuery(query);
        response.setData(list);
        return response.success();
    }

    /**
     * 设置权限
     * @param sysRoleDO 提交的参数
     * @return
     */
    @PostMapping("/settingMenu")
    public Response settingMenu(@RequestBody SysRoleDO sysRoleDO){
        Response response = new Response();
        if(sysRoleDO.getId() == null){
            return response.fail("角色id为空");
        }
        sysRoleMenuService.settingMenu(sysRoleDO);
        return response.success();
    }

    /**
     * 获取权限
     * @param query 提交的参数
     * @return
     */
    @GetMapping("/listMenuId")
    public Response listMenuId(SysRoleMenuQuery query){
        Response response = new Response();
        if(query.getRoleId() == null){
            return response.fail("角色id为空");
        }
        List<Long> menuIdList = sysRoleMenuService.listMenuId(query);
        response.setData(menuIdList);
        return response.success();
    }
}

