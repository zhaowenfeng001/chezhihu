package com.ksc.kdts.taskmonitor.cons;

/***
 * @ClassName: CacheConstant
 * @Description: 常量
 * @Author: wm_yu
 * @Create_time: 19:26 2019-11-18
 */
public class Constant {

	private Constant(){}

	public static final int EXPIRED_EVER = 0;//图片存储永不过期，留资的顾客使用
	public static final int EXPIRED_RECORD_FACE = 90;//识别记录图片过期时间

	public static final int EXPORT_MAX_SIZE = 2000;//最多导出2000条

	/**
     * 分享失效时长 单位秒 一天
     */
    public static final Long SHARE_EXPIRE = 24*60*60L;
    
	public static final Integer DEFAULT_CURRENT_PAGE = 1;

	public static final Integer DEFAULT_PAGE_SIZE = 100;

	/**
	 * 查询销售顾问状态定时任务时间间隔
	 */
	public static final Long WORK_STATUS_INTERVAL = 30000L;

	/**
	 * 查询未录入顾客信息定时任务时间状态
	 */
	public static final Long UN_SAVE_CUSTOMER_INTERVAL = 30000L;

	public static final String SALES_PUSH_MSG = "你有%s次接待未填写接待记录，请及时填写接待信息";

	public static final String SALES_MANAGER_PUSH_MSG = "超过80%销售顾问处于忙碌状态";

	public static final Double PUSH_THRESHOLD = 0.8D;

	public static final String TOKEN_EMPTY = "token为空/已经失效,请重新刷新token";

	/**
	 * 延时队列的延时时间
	 */
	public static final Long DELAY_QUEUE_TIME = 5L;

	/**
	 * 每日小时数
	 */
	public static final Integer  HOURS_PER_DAY = 24;

	public static final String FACE_STORE_REPOERT_TITLE = "人脸店端报表统计";

	public static final String FACE_FACTORY_REPOERT_TITLE = "人脸厂端报表统计";
}
