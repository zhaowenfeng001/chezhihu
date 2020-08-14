package com.ksc.kdts.taskmonitor.cons;

/***
 * @ClassName: ErrorConstant
 * @Description: 错误常量
 * @Author: wm_yu
 * @Create_time: 18:35 2019-11-18
 */
public class ErrorConstant {

    private ErrorConstant(){}

    public static final  String LOGIN_NAME_EMPTY = "登录账号为空";

    public static final  String LOGIN_PASS_EMPTY = "登录密码为空";
    
    public static final  String LOGIN_FAIL = "登录失败,用户名/密码错误";

    public static final  String PROPERTIES_CHECK_ERROR = "字段校验失败";

    public static final  String CUSTOMER_ID_EMPTY = "顾客ID为空";

    public static final  String MOBILE_ILLEGAL = "手机号不合法";

    public static final  String WORK_STATUS_ILLEGAL = "工作状态异常";

    public static final  String SHARE_ACCOUNT_ID_EMPTY = "被分享的销售顾问为空";

    public static final  String SHARE_ACCOUNT_ILLEGAL = "不能分享给本人";

    public static final  String SHARE_FAIL = "分享失败";

    public static final  String STORE_FAIL = "不能跨门店操作";

    public static final  String SHARE_ROLE_FAIL = "只能分享给销售顾问";

    public static final  String ASSIGN_ROLE_ERROR = "仅销售经理能进行分配";

    public static final  String ASSIGN_SALE_EMPTY = "分配的销售顾问为空";

    public static final  String ASSIGN_SALE_ERROR = "不能分配给同一人";

    public static final  String CUSTOMER_ERROR = "查无顾客信息";

    public static final  String SALES_ERROR = "查无销售顾问信息";

    public static final  String ASSIGN_SALSES_STATUS_ERROR = "仅被分配人处于空闲状态能被分配";

    public static final  String CUSTOMER_REPEAT_ERROR = "顾客已经被[%s]录入,请联系经理或前台人员";

    public static final  String SALES_ID_EMPTY = "销售经理录入顾客,销售顾问必须";

    public static final  String DATE_INTERVAL_MAX = "时间跨度最大100天";

    public static final  String CUSTOMER_RECORD_EMPTY = "查无顾客到店记录";

    public static final  String CUSTOMER_FACE_ID_EMPTY = "faceId为空";

    public static final  String CUSTOMER_WHITE_DEAL = "命中白名单人员,结束流程";

    public static final  String CUSTOMER_CHANNEL_ITEM_EMPTY = "渠道细分为空";

    public static final  String CUSTOMER_RECOMMOND_EMPTY = "推荐人信息为空";

    public static final  String CUSTOMER_NOT_WHITE = "留档顾客不允许加入白名单";

    public static final  String CUSTOMER_IMG_EMPTY = "请先上传头像";

    public static final  String DATE_NOT_EMPTY = "开始日期或结束日期不允许为空";
    
    public static final  String STARTDATE_NOT_ENDDATE= "开始日期不允许大于结束日期";
    
    public static final  String ENDDATE_NOT_NEWDATE= "结束日期不允许大于当前日期";

    public static final  String RECORDFACE_EMPTY= "识别记录为空";
    
    public static final  String EQUIPMENT_EMPTY= "未找到对应的设备";

    public static final  String SAHRE_ERROR = "当前销售顾问和分享的顾问是同一人,无需分享";
}
