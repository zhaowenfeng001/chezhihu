package com.ksc.kdts.taskmonitor.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @ClassName DateUtils
 * @Description DateUtils
 * @Author wenfeng.zhao
 * @Date 2018/11/15 18:33
 **/
public class DateUtils {

    public static final String DEFAULT_DATE_FORMAT
            = DateUtilBean.DEFAULT_DATE_FORMAT;

    //约定范围-31天
    public static final long MS_ONE_MONTH = 1000l * 60 * 60 * 24 * 31;
// -------------------------- STATIC METHODS --------------------------

    /**
     * <p>取得两个时间之间相差的天数,参数类型为Date </p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     *
     * @param startDate 开始的时间
     * @param endDate   结束的时间
     * @return startDate 与  endDate 之间相差的天数
     * @see DateUtilBean#getDaysBetween
     */
    public static int getDaysBetween(Date startDate, Date endDate) {
        return DateUtilBean.getUtilBean().getDaysBetween(startDate, endDate);
    }

    /**
     * <p>取得两个时间之间相差的天数,参数类型为Calendar</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     *
     * @param startDate 开始的时间
     * @param endDate   结束的时间
     * @return startDate 与  endDate 之间相差的天数
     * @see DateUtilBean#getDaysBetween
     */
    public static int getDaysBetween(Calendar startDate, Calendar endDate) {
        return DateUtilBean.getUtilBean().getDaysBetween(startDate, endDate);
    }

    public static Calendar convertToCalendar(String calendarString) {
        return DateUtilBean.getUtilBean().convertToCalendar(calendarString);
    }

    /**
     * <p>Convert String to Date .</p>
     * <p>将字符串"yyyy-MM-dd"转成Calendar类型.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     *
     * @param date ：参数格式为"yyyy-MM-dd"
     * @return 根据DATE_PATTERN规则 转成的日期
     * @see DateUtilBean#convertToDate
     */
    public static Calendar convertToDate(String date) {
        return DateUtilBean.getUtilBean().convertToDate(date);
    }

    /**
     * <p> Convert DateTime to String  .</p>
     * <p>将Date类型转成字符串"yyyy-MM-dd HH:mm:ss" .</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     *
     * @param date : 待转换的日期
     * @return "yyyy-MM-dd HH:mm:ss"
     * @see DateUtilBean#convertToString
     */
    public static String convertToString(Date date) {
        return DateUtilBean.getUtilBean().convertToString(date);
    }

    /**
     * <p> Convert DateTime to String  .</p>
     * <p>将Calendar类型转成字符串"yyyy-MM-dd HH:mm:ss" .</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     *
     * @param date ：待转换的日期
     * @return "yyyy-MM-dd HH:mm:ss"
     * @see DateUtilBean#convertToString
     */
    public static String convertToString(Calendar date) {
        return DateUtilBean.getUtilBean().convertToString(date);
    }

    /**
     * <p>取得一周中的星期几.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <p/>
     * <pre>
     * 范例如下：
     * DateUtils.getDayOfWeek("2010-4-2") = 4（星期五）
     * </pre>
     *
     * @param date : 准备检验的日期
     * @return 具体日期对应的数字
     *         2=星期一、3=星期二、4=星期三、5=星期四、6=星期五、7=星期六、1=星期天
     * @see DateUtilBean#getDayOfWeek
     */
    public static int getDayOfWeek(Calendar date) {
        return DateUtilBean.getUtilBean().getDayOfWeek(date);
    }

    /**
     * getCurrentMonLastDay()
     * <p> 计算当月最后一天,返回那一天 。</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <p/>
     * <pre>
     * 范例如下：
     * 本月是4月，则：
     * DateUtils.getCurrentMonLastDay() = "2010-04-30"
     * </pre>
     *
     * @return 返回当月最后一天。
     * @see DateUtilBean#getCurrentMonLastDay
     */
    public static Calendar getCurrentMonLastDay() {
        return DateUtilBean.getUtilBean().getCurrentMonLastDay();
    }

    /**
     * getPreviousMonFirstDay()
     * <p>获取当前月份上一个月的第一天.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     * 本月是4月，则：
     * DateUtils.getPreviousMonFirstDay() = "2010-03-01"
     * </pre>
     *
     * @return 当前月份上一个月的第一天。
     * @see DateUtilBean#getPreviousMonFirstDay
     */
    public static Calendar getPreviousMonFirstDay() {
        return DateUtilBean.getUtilBean().getPreviousMonFirstDay();
    }

    /**
     * getPreviousMonLastDay()
     * <p>获取当前月份上个月的最后一天</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     * 本月是4月，则：
     * DateUtils.getPreviousMonLastDay() = "2010-03-31"
     * </pre>
     *
     * @return 当前月份上个月的最后一天
     * @see DateUtilBean#getPreviousMonLastDay
     */
    public static Calendar getPreviousMonLastDay() {
        return DateUtilBean.getUtilBean().getPreviousMonLastDay();
    }

    /**
     * getPreviousMonFirstDay()
     * <p>获取当月的第一天</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     * 本月是4月，则：
     * DateUtils.getFirstDayOfMonth() = "2010-04-01"
     * </pre>
     *
     * @return 当月的第一天
     * @see DateUtilBean#getFirstDayOfMonth
     */
    public static Calendar getFirstDayOfMonth() {
        return DateUtilBean.getUtilBean().getFirstDayOfMonth();
    }

    /**
     * getNextMonthFirst()
     * <p>获取下个月的第一天</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     * 本月是4月，则：
     * DateUtils.getNextMonthFirst() = "2010-05-01"
     * </pre>
     *
     * @return 下个月的第一天
     * @see DateUtilBean#getNextMonthFirst
     */
    public static Calendar getNextMonthFirst() {
        return DateUtilBean.getUtilBean().getNextMonthFirst();
    }

    /**
     * getNextMonthEnd()
     * <p>获取下个月最后一天.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     * 本月是4月，则：
     * DateUtils.getNextMonthEnd() = "2010-05-31"
     * </pre>
     *
     * @return 下个月的最后一天
     * @see DateUtilBean#getNextMonthEnd
     */
    public static Calendar getNextMonthEnd() {
        return DateUtilBean.getUtilBean().getNextMonthEnd();
    }

    /**
     * getToday()
     * <p>获得当天的时间 .</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     * Date date = DateUtils.getToday() = "2010-4-2";
     * </pre>
     *
     * @return 当天的时间
     * @see DateUtilBean#getToday
     */
    public static Calendar getToday() {
        return DateUtilBean.getUtilBean().getToday();
    }

    /**
     * isLeapYear(year)
     * <p>是否闰年.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     * year 格式2010,2011
     * DateUtils.isLeapYear(2010) = false
     * DateUtils.isLeapYear(2000) = true
     * </pre>
     *
     * @param year ： 待检验的年份
     * @return 是闰年则返回true 否则返回false
     * @see DateUtilBean#isLeapYear
     */
    public static boolean isLeapYear(int year) {
        return DateUtilBean.getUtilBean().isLeapYear(year);
    }

    /**
     * isBefore(start,end)
     * <p>比较日期start是否在日期end之前.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     *
     * DateUtils.isBefore("2010-4-5","2010-4-6") = true
     * DateUtils.isBefore("2010-4-6","2010-4-6") = false
     * DateUtils.isBefore("2010-4-7","2010-4-6") = false
     * </pre>
     *
     * @param start 时间1
     * @param end   时间2
     * @return 如果日期start在日期end之前返回true, 否则返回false.
     * @see DateUtilBean#isBefore
     */
    public static boolean isBefore(Calendar start, Calendar end) {
        return dateCompare(start, end) == -1;
    }

    /**
     * dateCompare(date1,date2)
     * <p>比较两个日期的大小.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     *
     * DateUtils.dateCompare("2010-4-5","2010-4-6") = -1
     * DateUtils.dateCompare("2010-4-6","2010-4-6") = 0
     * DateUtils.dateCompare("2010-4-7","2010-4-6") = 1
     * </pre>
     *
     * @param date1 时间1
     * @param date2 时间2
     * @return 如果date1等于date2 则返回 0, date1在 date2之前则返回-1, date1在date2之后返回1
     * @see DateUtilBean#dateCompare
     */
    public static int dateCompare(Calendar date1, Calendar date2) {
        return DateUtilBean.getUtilBean().dateCompare(date1, date2);
    }

    /**
     * isAfter(start,end)
     * <p>比较日期start是否在日期end之后.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     *
     * DateUtils.isAfter("2010-4-5","2010-4-6") = false
     * DateUtils.isAfter("2010-4-6","2010-4-6") = false
     * DateUtils.isAfter("2010-4-7","2010-4-6") = true
     * </pre>
     *
     * @param start 时间1
     * @param end   时间2
     * @return 如果日期start在日期end之后返回true，否则返回false.
     * @see DateUtilBean#isAfter
     */
    public static boolean isAfter(Calendar start, Calendar end) {
        return dateCompare(start, end) == 1;
    }

    /**
     * 判断时间范围是否超过一个月
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return 超过约定时间返回true
     */
    public static boolean isOverTime(long beginTime, long endTime){
        //增加一小时阈值
        long threshold = 1000l * 60 * 60;
        long diff = endTime - beginTime;
        if (diff > (MS_ONE_MONTH + threshold)){
            return true;
        }
        return false;
    }
    /**
     * isEqual(start,end)
     * <p>比较日期start是否与日期end相等.</p>
     * <p>For more details see <code>DateUtilBean</code>.</p>
     * <pre>
     * 范例如下：
     *
     * DateUtils.isAfter("2010-4-5","2010-4-6") = false
     * DateUtils.isAfter("2010-4-6","2010-4-6") = true
     * DateUtils.isAfter("2010-4-7","2010-4-6") = false
     * </pre>
     *
     * @param start 时间1
     * @param end   时间2
     * @return 如果日期star与日期end相等返回true，否则返回false.
     * @see DateUtilBean#isEqual
     */
    public static boolean isEqual(Calendar start, Calendar end) {
        return dateCompare(start, end) == 0;
    }



    public static Date getNextDay(Date date){
        if(date == null){
            date = new Date();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime();
        return date;
    }

    public static String convertDateToString(Date date) {
        return DateUtilBean.getUtilBean().convertDateToString(date);
    }



// --------------------------- CONSTRUCTORS ---------------------------

    private DateUtils() {
    }

    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(date +"========"+getNextDay(date));
    }

}
