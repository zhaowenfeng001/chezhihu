package com.ksc.kdts.taskmonitor.service;


import com.ksc.kdts.taskmonitor.model.*;

import java.util.List;

/**
 * @ClassName ExecutionJobService
 * @Description ExecutionJobService
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:06
 **/
public interface MessageService {

    MessageDO selectById(Long id);

    Integer count(MessageQuery messageQuery);

    void deleteById(Long id);

    void insert(Message message);

    List<MessageDO> searchByQuery(MessageQuery query);

    void update(Message message);

    Page<MessageDO> page(QueryPage queryPage, MessageQuery query);
}
