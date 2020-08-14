package com.ksc.kdts.taskmonitor.controller;

import com.ksc.kdts.taskmonitor.cons.CacheConstant;
import com.ksc.kdts.taskmonitor.model.Response;
import com.ksc.kdts.taskmonitor.model.SysAccountQuery;
import com.ksc.kdts.taskmonitor.service.SysAccountService;
import com.ksc.kdts.taskmonitor.util.CacheHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <p>
 * 账号表 前端控制器
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
@RestController
@RequestMapping("/admin/sysAccount")
public class SysAccountController extends BaseController {

    @Autowired
    private SysAccountService sysAccountService;
    @Autowired
    private CacheHelper cacheHelper;

    /**
     * 登录
     * @param req
     * @return
     */
    @PostMapping("/login")
    public Response login(SysAccountQuery req){
        Response response = new Response();
        req = Optional.ofNullable(req).orElse(new SysAccountQuery());
        String token = sysAccountService.login(req);
        return response.success(token);

    }
    
    /**
     * 退出
     * @return
     */
    @GetMapping("/loginOut")
    public Response loginOut(@RequestParam(name = "token") String token){
        Response response = new Response();
    	if(StringUtils.isNotEmpty(token)) {
            cacheHelper.delete(CacheConstant.TOKEN_ACCOUNT + token);
        }
        return response.success();
    }

}