package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.model.Response;
import com.ksc.kdts.taskmonitor.util.CacheHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ExecutionJobController
 * @Author wenfeng.zhao
 * @Date 2018/11/12 14:14
 **/
@RestController
@RequestMapping(value = "task")
public class ExecutionJobController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionJobController.class);

    @Autowired
    private CacheHelper cacheHelper;


    @RequestMapping(value = "helloworld")
    private Response helloworld(@RequestParam(name = "name") String name){
        Response response = new Response();
        cacheHelper.setValue("zwf",name);

        return response.success("成功");
    }

}


