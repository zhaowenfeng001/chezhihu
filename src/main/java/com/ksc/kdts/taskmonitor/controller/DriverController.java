package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.DriverService;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ksc.kdts.taskmonitor.model.Driver;
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
@RequestMapping("/driver")
public class DriverController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);


    @Autowired
    private DriverService driverService;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "get")
    public Response get(@RequestParam(value="id") Long id) {
        Response response = new Response();
        DriverDO driverDO = driverService.selectById(id);
        response.setData(driverDO);
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
    	DriverDO menu = driverService.selectById(id);
    	if(menu == null){
    		return response.fail("菜单不存在");
    	}
    	
    	SysRoleMenuQuery query = new SysRoleMenuQuery();
    	query.setMenuId(id);
        driverService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param driver
     * @return
     */
    @RequestMapping(value = "insert")
    public Response insert(Driver driver){
        Response response = new Response();
        driver.setCreateTime(new Date());
        try {
            driver.setEntryTime(DateUtils.parseDate(driver.getEntryTimeStr(),"YYYY-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        driverService.insert(driver);
        return response.success();
    }

    /**
     * 修改
     * @param driver
     * @return
     */
    @RequestMapping(value = "update")
    public Response update(@RequestBody Driver driver){
        Response response = new Response();
        driverService.update(driver);
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
    public Response page(Integer current, Integer size, DriverQuery query){
        Response response = new Response();
        Page<DriverDO> page = driverService.page(new QueryPage(current,size),query);
        response.setData(page);
        return response.success();
    }

    /**
     * 分页查询
     * @param query 查询参数
     * @return
     */
    @RequestMapping("/list")
    public Response list(DriverQuery query){
        Response response = new Response();
        List<DriverDO> list = driverService.searchByQuery(query);
    	response.setData(list);
        return response.success();
    }
}
