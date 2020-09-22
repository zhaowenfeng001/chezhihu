package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.Message;
import com.ksc.kdts.taskmonitor.model.MessageDO;
import com.ksc.kdts.taskmonitor.model.MessageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @InterfaceName ProjectFlowsMapper
 * @Author wenfeng.zhao
 * @Date 2018/11/21 14:09
 **/
@Repository
@Mapper
public interface MessageMapper {


    MessageDO selectById(MessageQuery messageQuery);

    Integer count(MessageQuery messageQuery);

    void deleteById(Long id);

    void insert(Message message);

    List<MessageDO> searchByQuery(MessageQuery messageQuery);

    void update(Message message);

}
