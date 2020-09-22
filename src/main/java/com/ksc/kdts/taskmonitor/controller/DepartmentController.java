package com.ksc.kdts.taskmonitor.controller;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.DepartmentService;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Date;
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
@RequestMapping("/department")
public class DepartmentController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @Autowired
    private DepartmentService departmentService;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "get")
    public Response get(@RequestParam(value="id") Long id) {
        Response response = new Response();
        DepartmentDO departmentDO = departmentService.selectById(id);
        response.setData(departmentDO);
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
    	DepartmentDO menu = departmentService.selectById(id);
    	if(menu == null){
    		return response.fail("菜单不存在");
    	}
    	
//    	DepartmentQuery departmentQuery = new DepartmentQuery();
//    	departmentQuery.setPid(id);
//    	if(menu.getPid() == 0 && departmentService.count(departmentQuery) > 0){
//    		return response.fail("该菜单有子菜单，不能删除");
//    	}
    	
    	SysRoleMenuQuery query = new SysRoleMenuQuery();
    	query.setMenuId(id);
        departmentService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param department
     * @return
     */
    @RequestMapping(value = "insert")
    public Response insert(Department department){
        Response response = new Response();

        DepartmentQuery departmentQuery = new DepartmentQuery();
        departmentQuery.setDepartmentName(department.getDepartmentName());
        List<DepartmentDO> departmentDOS = departmentService.searchByQuery(departmentQuery);
        if(CollectionUtils.isNotEmpty(departmentDOS)){
            return response.fail("部门名称重复，请检查");
        }

        department.setCreateTime(new Date());
        try {
            department.setEntryTime(DateUtils.parseDate(department.getEntryTimeStr(),"YYYY-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        departmentService.insert(department);
        return response.success();
    }

    /**
     * 修改
     * @param department
     * @return
     */
    @RequestMapping(value = "update")
    public Response update(@RequestBody Department department){
        Response response = new Response();
//    	if(StringUtils.isEmpty(department.getName())){
//            return response.fail("菜单名字不能为空");
//        }
//    	DepartmentDO sourceMenu = departmentService.selectById(department.getId());
//    	if(sourceMenu == null){
//    		return response.fail("菜单不存在");
//    	}
//    	//判断是否有重名
//    	if(!sourceMenu.getName().equals(department.getName())){
//    		DepartmentQuery query = new DepartmentQuery();
//            query.setName(department.getName());
//            List<DepartmentDO> list = departmentService.searchByQuery(query);
//            if(!CollectionUtils.isEmpty(list)){
//            	return response.fail("菜单名字已经存在");
//            }
//    	}
        departmentService.update(department);
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
    public Response page(Integer current, Integer size, DepartmentQuery query){
        Response response = new Response();
        Page<DepartmentDO> page = departmentService.page(new QueryPage(current,size),query);
        response.setData(page);
        return response.success();
    }

    /**
     * 分页查询
     * @param query 查询参数
     * @return
     */
    @RequestMapping("/list")
    public Response list(DepartmentQuery query){
        Response response = new Response();
        List<DepartmentDO> list = departmentService.searchByQuery(query);
    	response.setData(list);
        return response.success();
    }
}
