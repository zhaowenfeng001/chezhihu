package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.mapper.monitor.MessageMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.MessageService;
import com.ksc.kdts.taskmonitor.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ExecutionJobServiceImpl
 * @Description ExecutionJobServiceImpl
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:07
 **/
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;


    @Override
    public MessageDO selectById(Long id) {
        MessageQuery messageQuery = new MessageQuery();
        messageQuery.setId(id);
        return messageMapper.selectById(messageQuery);
    }

    @Override
    public Integer count(MessageQuery messageQuery) {
        return messageMapper.count(messageQuery);
    }

    @Override
    public void deleteById(Long id) {
        messageMapper.deleteById(id);
    }

    @Override
    public void insert(Message message) {
        messageMapper.insert(message);
    }

    @Override
    public List<MessageDO> searchByQuery(MessageQuery messageQuery) {
        return messageMapper.searchByQuery(messageQuery);
    }

    @Override
    public void update(Message message) {
        messageMapper.update(message);
    }

    @Override
    public Page<MessageDO> page(QueryPage queryPage, MessageQuery messageQuery) {
        Page result = new Page();
        messageQuery.setSize(queryPage.getSize());
        messageQuery.setBegin(queryPage.getBegin());
        List carList = messageMapper.searchByQuery(messageQuery);
        result.setRecords(carList);

        Integer total = messageMapper.count(messageQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }
}
