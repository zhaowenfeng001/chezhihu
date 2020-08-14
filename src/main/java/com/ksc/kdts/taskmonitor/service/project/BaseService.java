package com.ksc.kdts.taskmonitor.service.project;


import com.ksc.kdts.taskmonitor.util.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BaseService
 * @Description 基础Service
 * @Author wenfeng.zhao
 * @Date 2018/11/15 14:35
 **/
public class BaseService {


    protected List<String> getX(Date startDate,Date endDate){
        List<String> result = new ArrayList<>();
        if(endDate == null){
            endDate = new Date();
        }
        while(startDate.compareTo(endDate)<0){
            startDate = DateUtils.getNextDay(startDate);
            result.add(DateUtils.convertDateToString(startDate));
        }

        return result;
    }

}
