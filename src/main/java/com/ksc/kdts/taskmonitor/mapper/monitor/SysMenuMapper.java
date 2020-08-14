package com.ksc.kdts.taskmonitor.mapper.monitor;

import com.ksc.kdts.taskmonitor.model.*;
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
public interface SysMenuMapper {


    SysMenuDO selectById(SysMenuQuery sysMenuQuery);

    Integer count(SysMenuQuery smquery);

    void deleteById(Long id);

    void insertMenu(SysMenu sysMenu);

    List<SysMenuDO> searchByQuery(SysMenuQuery query);

    void update(SysMenu sysMenu);

}
