//package com.ksc.kdts.taskmonitor.interception;
//
//
//import com.alibaba.fastjson.JSON;
//import com.ksc.kdts.taskmonitor.cons.CacheConstant;
//import com.ksc.kdts.taskmonitor.cons.Constant;
//import com.ksc.kdts.taskmonitor.util.CacheHelper;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///***
// * @ClassName: TokenInterceptor
// * @Description: token拦截器, 校验token, 是否过期
// * @Author: wm_yu
// * @Create_time: 17:59 2020-1-8
// */
//@Component("adminTokenInterceptor")
//public class AdminTokenInterceptor implements HandlerInterceptor {
//
//    private Logger log = LoggerFactory.getLogger(AdminTokenInterceptor.class);
//
//    private static final String TOKEN_KEY = "token";
//
//    @Autowired
//    private CacheHelper cacheHelper;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String oldToken = request.getHeader(TOKEN_KEY);
//        response.setCharacterEncoding("utf-8");
//        response.setHeader("Content-Type", "application/json;charset=UTF-8");
//        String adminSysId = cacheHelper.getValue(CacheConstant.TOKEN_ACCOUNT + oldToken);
//        log.info("token拦截器,获取到的用户id:[{}],请求的token:[{}]", adminSysId,oldToken);
//        if (StringUtils.isEmpty(oldToken) || StringUtils.isEmpty(adminSysId)) {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, JSON.toJSONString(Constant.TOKEN_EMPTY));
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
//        log.info("");
//    }
//
//
//}
