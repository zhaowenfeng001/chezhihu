package com.ksc.kdts.taskmonitor.service.project;

import com.ksc.kdts.taskmonitor.cons.CacheConstant;
import com.ksc.kdts.taskmonitor.cons.ErrorConstant;
import com.ksc.kdts.taskmonitor.mapper.monitor.SysAccountMapper;
import com.ksc.kdts.taskmonitor.model.*;
import com.ksc.kdts.taskmonitor.service.SysAccountService;
import com.ksc.kdts.taskmonitor.util.BeanUtils;
import com.ksc.kdts.taskmonitor.util.CacheHelper;
import com.ksc.kdts.taskmonitor.util.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 账号表 服务实现类
 * </p>
 *
 * @author Richard
 * @since 2019-11-18
 */
@Service("sysAccountService")
public class SysAccountServiceImpl implements SysAccountService {
    @Autowired
    private SysAccountMapper sysAccountMapper;
    @Autowired
    private CacheHelper cacheHelper;

    
    private int maxLoginFailCount = 5;

    public String login(SysAccountQuery req) {
        if(StringUtils.isEmpty(req.getLoginName())){
            return ErrorConstant.LOGIN_NAME_EMPTY;
        }
        if(StringUtils.isEmpty(req.getPassword())){
            return ErrorConstant.LOGIN_PASS_EMPTY;
        }
//        if(StringUtils.isEmpty(req.getVcCode())){
//        	return "验证码不能为空";
//        }
//        String redisVccode = cacheHelper.getValue(CacheConstant.VC_CODE + req.getVcToken()).toLowerCase();
//        if(!req.getVcCode().toLowerCase().equals(redisVccode)){
//        	return "验证码有误";
//        }
        
        String loginKey = CacheConstant.LOGIN_FAIL_COUNT + req.getLoginName();
        String loginFailCount = cacheHelper.getValue(loginKey);
        if(StringUtils.isNotEmpty(loginFailCount) && Integer.parseInt(loginFailCount) >= maxLoginFailCount){
        	return "登录失败达到"+maxLoginFailCount+"次，账号无法登录，第二天账号自动解锁";
        }
        
        SysAccountQuery query = new SysAccountQuery();
        query.setLoginName(req.getLoginName());
        query.setPassword(req.getPassword());
        SysAccount account = sysAccountMapper.searchSysAccount(query);
        if(ObjectUtils.isEmpty(account)){
        	//给账号标记登录错误次数
        	int failCount = 0;
        	if(StringUtils.isNotEmpty(loginFailCount)){
        		failCount = Integer.parseInt(loginFailCount);
        	}
        	cacheHelper.setValue(loginKey,failCount + 1, 24, TimeUnit.HOURS);
            return ErrorConstant.LOGIN_FAIL;
        }
        //生成token,存入redis
        String token = CommonUtil.createToken();
        String cacheKey = CacheConstant.TOKEN_ACCOUNT + token;
        cacheHelper.setValue(cacheKey,account.getId(), CacheConstant.TOKEN_CACHE_TIME, TimeUnit.SECONDS);
        //清除登录错误的所有缓存
        cacheHelper.delete(loginKey);
        return token;
    }

    @Override
    public SysAccount selectById(Long id) {
        if (cacheHelper.getValue(CacheConstant.ACCOUNT_ID + id) == null) {
            SysAccountQuery sysAccountQuery = new SysAccountQuery();
            sysAccountQuery.setId(id);
            SysAccount e = sysAccountMapper.searchSysAccount(sysAccountQuery);
            if (e != null) {
                // 将账号信息放进缓存
                cacheHelper.setValue(CacheConstant.ACCOUNT_ID + id, e, CacheConstant.ACCOUNT_CACHE_TIME, TimeUnit.MINUTES);
                return BeanUtils.copyProperties(e, SysAccountDO.class);
            }
        }
        return cacheHelper.getValue(CacheConstant.ACCOUNT_ID + id, SysAccountDO.class);
    }

    @Override
    public Integer count(SysAccountQuery sysAccountQuery) {
        return sysAccountMapper.count(sysAccountQuery);
    }

    @Override
    public void deleteById(Long id) {
        sysAccountMapper.deleteById(id);
    }

    @Override
    public void insert(SysAccount sysAccount) {
        sysAccountMapper.insert(sysAccount);
    }

    @Override
    public List<SysAccountDO> searchByQuery(SysAccountQuery sysAccountQuery) {
        List<SysAccountDO> sysAccountDOS = sysAccountMapper.searchByQuery(sysAccountQuery);
        for(SysAccountDO sysAccountDO:sysAccountDOS){

        }

        return sysAccountDOS;
    }

    @Override
    public void update(SysAccount sysAccount) {
        sysAccountMapper.update(sysAccount);
    }

    @Override
    public Page<SysAccountDO> page(QueryPage queryPage, SysAccountQuery sysAccountQuery) {
        Page result = new Page();
        sysAccountQuery.setSize(queryPage.getSize());
        sysAccountQuery.setBegin(queryPage.getBegin());
        List sysAccountList = sysAccountMapper.searchByQuery(sysAccountQuery);
        result.setRecords(sysAccountList);

        Integer total = sysAccountMapper.count(sysAccountQuery);
        result.setTotal(Long.parseLong(total.toString()));
        return result;
    }

}
