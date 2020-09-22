package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.MessageService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/message")
public class MessageController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);


    @Autowired
    private MessageService messageService;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @RequestMapping(value = "get")
    public Response get(@RequestParam(value="id") Long id) {
        Response response = new Response();
        MessageDO messageDO = messageService.selectById(id);
        response.setData(messageDO);
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
    	MessageDO messageDO = messageService.selectById(id);
    	if(messageDO == null){
    		return response.fail("用车记录不存在");
    	}
    	
        messageService.deleteById(id);
        return response.success();
    }

    /**
     * 添加
     * @param message
     * @return
     */
    @RequestMapping(value = "insert")
    public Response insert(Message message){
        Response response = new Response();
        message.setCreateTime(new Date());
        if(StringUtils.isNotBlank(message.getApplicationTimeStr())){
            try {
                message.setApplicationTime(DateUtils.parseDate(message.getApplicationTimeStr(),"YYYY-MM-dd HH:mm:ss"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        messageService.insert(message);
        return response.success();
    }

    /**
     * 修改
     * @param message
     * @return
     */
    @RequestMapping(value = "update")
    public Response update(Message message){
        Response response = new Response();
        if(Objects.nonNull(message)){
            Long id = message.getId();
            if(id !=null && id != 0l){
                Message searchMessage = messageService.selectById(id);
                searchMessage = message.getUpdateMessage(searchMessage);
                messageService.update(searchMessage);
            }
        }

//        messageService.update(message);
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
    public Response page(Integer current, Integer size, MessageQuery query){
        Response response = new Response();
        Page<MessageDO> page = messageService.page(new QueryPage(current,size),query);
        response.setData(page);
        return response.success();
    }

    /**
     * 分页查询
     * @param query 查询参数
     * @return
     */
    @RequestMapping("/list")
    public Response list(MessageQuery query){
        Response response = new Response();
        List<MessageDO> list = messageService.searchByQuery(query);
    	response.setData(list);
        return response.success();
    }
}
