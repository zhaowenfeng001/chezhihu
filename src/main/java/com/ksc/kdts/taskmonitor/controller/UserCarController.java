package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.cons.UserCarStateEnum;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.UserCarService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Objects;


/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
@RestController
@RequestMapping("/userCar")
public class UserCarController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserCarController.class);


    @Autowired
    private UserCarService userCarService;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "get")
    public Response get(@RequestParam(value="id") Long id) {
        Response response = new Response();
        UserCarDO userCarDO = userCarService.selectById(id);
        response.setData(userCarDO);
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
    	UserCarDO userCarDO = userCarService.selectById(id);
    	if(userCarDO == null){
    		return response.fail("用车记录不存在");
    	}
    	
        userCarService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param userCar
     * @return
     */
    @RequestMapping(value = "insert")
    public Response insert(UserCar userCar){
        Response response = new Response();
        userCar.setCreateTime(new Date());
        userCar.setState(UserCarStateEnum.未审核.getCode());
        if(StringUtils.isNotBlank(userCar.getApplicationTimeStr())){
            try {
                userCar.setApplicationTime(DateUtils.parseDate(userCar.getApplicationTimeStr(),"YYYY-MM-dd HH:mm:ss"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        userCarService.insert(userCar);
        return response.success();
    }

    /**
     * 修改
     * @param userCar
     * @return
     */
    @RequestMapping(value = "update")
    public Response update(UserCar userCar){
        Response response = new Response();
        if(Objects.nonNull(userCar)){
            Long id = userCar.getId();
            if(id !=null && id != 0l){
                UserCar searchUserCar = userCarService.selectById(id);
                searchUserCar = userCar.getUpdateCar(searchUserCar);
                userCarService.update(searchUserCar);
            }
        }

//        userCarService.update(userCar);
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
    public Response page(Integer current, Integer size, UserCarQuery query){
        Response response = new Response();
        Page<UserCarDO> page = userCarService.page(new QueryPage(current,size),query);
        response.setData(page);
        return response.success();
    }

    /**
     * 分页查询
     * @param query 查询参数
     * @return
     */
    @RequestMapping("/list")
    public Response list(UserCarQuery query){
        Response response = new Response();
        List<UserCarDO> list = userCarService.searchByQuery(query);
    	response.setData(list);
        return response.success();
    }
}
