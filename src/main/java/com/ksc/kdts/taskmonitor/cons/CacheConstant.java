package com.ksc.kdts.taskmonitor.cons;

/***
 * @ClassName: CacheConstant
 * @Description: 缓存key常量
 * @Author: wm_yu
 * @Create_time: 19:26 2019-11-18
 */
public class CacheConstant {

    private CacheConstant(){}


	private static final String TOKEN_PREFIX = "changan:";
    /**
     *    TOKEN_ACCOUNT + token
     */
    public static final String  TOKEN_ACCOUNT = TOKEN_PREFIX + "auth:account:";

    /**
     * token缓存时间: 秒
     */
    public static final Integer TOKEN_CACHE_TIME = 7200;

    /**
     *    TOKEN_ACCOUNT + token
     */
    public static final String  H5_TOKEN_ACCOUNT = TOKEN_PREFIX + "authh5:account:";

    
    /**
     *    push + faceId
     */
    public static final String  PUSH_MESSAGE_TWICE_INSTORE = TOKEN_PREFIX + "push:faceId:";
    
    //系统账号
    public static final String  ACCOUNT_ID = TOKEN_PREFIX + "account:id:";
    public static final int ACCOUNT_CACHE_TIME = 30;
    
    //缓存
    public static final String  VC_CODE = TOKEN_PREFIX + "vccode:";
    
    //登录错误账号和次数
    public static final String  LOGIN_FAIL_COUNT = TOKEN_PREFIX + "loginfail:count:";
    
    /**
     * 设备ID
     *    equipment + id
     */
    public static final String  EQUIPMENT_ID = TOKEN_PREFIX + "equipment:id:";
    
    
    /**
     * 设备号
     *    equipment + sn
     */
    public static final String  EQUIPMENT_SN = TOKEN_PREFIX + "equipment:sn:";
    
    /**
     * 设备缓存放30分钟
     */
    public static final int EQUIPMENT_CACHE_TIME = 30;
    
    /**
     * 店铺ID
     */
    public static final String  STORE_ID = TOKEN_PREFIX + "store:id:";
    
    /**
     * 店铺缓存放30分钟
     */
    public static final int STORE_CACHE_TIME = 30;
    
    /**
     * h5 token缓存时间: 秒
     */
    public static final Integer H5_TOKEN_CACHE_TIME = 7200;

    /***
     * 算法请求token
     */
    public static final String ALG_TOKEN = "alg:token:";

    /***
     * 算法请求token缓存时间: 秒
     */
    public static final Integer ALG_TOKEN_CACHE_TIME = 3600;
}
