package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.CompanyService;
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
@RequestMapping("/company")
public class DepartmentController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);


    @Autowired
    private CompanyService companyService;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "get")
    public Response get(@RequestParam(value="id") Long id) {
        Response response = new Response();
        CompanyDO companyDO = companyService.selectById(id);
        response.setData(companyDO);
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
    	CompanyDO menu = companyService.selectById(id);
    	if(menu == null){
    		return response.fail("菜单不存在");
    	}
    	
//    	CompanyQuery companyQuery = new CompanyQuery();
//    	companyQuery.setPid(id);
//    	if(menu.getPid() == 0 && companyService.count(companyQuery) > 0){
//    		return response.fail("该菜单有子菜单，不能删除");
//    	}
    	
    	SysRoleMenuQuery query = new SysRoleMenuQuery();
    	query.setMenuId(id);
        companyService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param company
     * @return
     */
    @RequestMapping(value = "insert")
    public Response insert(Company company){
        Response response = new Response();
        company.setCreateTime(new Date());
        try {
            company.setEntryTime(DateUtils.parseDate(company.getEntryTimeStr(),"YYYY-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        companyService.insert(company);
        return response.success();
    }

    /**
     * 修改
     * @param company
     * @return
     */
    @RequestMapping(value = "update")
    public Response update(@RequestBody Company company){
        Response response = new Response();
//    	if(StringUtils.isEmpty(company.getName())){
//            return response.fail("菜单名字不能为空");
//        }
//    	CompanyDO sourceMenu = companyService.selectById(company.getId());
//    	if(sourceMenu == null){
//    		return response.fail("菜单不存在");
//    	}
//    	//判断是否有重名
//    	if(!sourceMenu.getName().equals(company.getName())){
//    		CompanyQuery query = new CompanyQuery();
//            query.setName(company.getName());
//            List<CompanyDO> list = companyService.searchByQuery(query);
//            if(!CollectionUtils.isEmpty(list)){
//            	return response.fail("菜单名字已经存在");
//            }
//    	}
        companyService.update(company);
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
    public Response page(Integer current, Integer size, CompanyQuery query){
        Response response = new Response();
        Page<CompanyDO> page = companyService.page(new QueryPage(current,size),query);
        response.setData(page);
        return response.success();
    }

    /**
     * 分页查询
     * @param query 查询参数
     * @return
     */
    @RequestMapping("/list")
    public Response list(CompanyQuery query){
        Response response = new Response();
        List<CompanyDO> list = companyService.searchByQuery(query);
    	response.setData(list);
        return response.success();
    }
}
