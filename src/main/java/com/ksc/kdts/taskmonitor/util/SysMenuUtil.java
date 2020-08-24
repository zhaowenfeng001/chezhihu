package com.ksc.kdts.taskmonitor.util;


import com.ksc.kdts.taskmonitor.model.SysMenuDO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class SysMenuUtil {
    //把平级list转换成childList
    public static List<SysMenuDO> convertChildList(List<SysMenuDO> menuList){

        if(CollectionUtils.isEmpty(menuList)){
            return new ArrayList<SysMenuDO>();
        }

        List<SysMenuDO> firstList = new ArrayList<>();
        List<SysMenuDO> secondList = new ArrayList<>();

        //区分一二级list,分别装成list
        for(SysMenuDO menu : menuList){
            if(menu.getPid() == 0l){
                firstList.add(menu);
            } else {
                secondList.add(menu);
            }
        }
        //循环加载自己的子节点
        for(SysMenuDO first : firstList){
            List<SysMenuDO> childList = new ArrayList<>();

            for(SysMenuDO second : secondList){
                if(second.getPid().intValue() == first.getId().intValue()){
                    childList.add(second);
                }
            }
            first.setChildList(BeanUtils.copyListProperties(childList, SysMenuDO.class));
        }
        return firstList;
    }
}

