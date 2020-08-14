package com.ksc.kdts.taskmonitor.util;

import com.ksc.kdts.taskmonitor.controller.ExecutionJobController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/***
 * @ClassName: CommonUtil
 * @Description:
 * @Author: wm_yu
 * @Create_time: 19:22 2019-11-18
 */
public class CommonUtil {

    private static final Logger log = LoggerFactory.getLogger(ExecutionJobController.class);

    private CommonUtil(){}

    public static String createToken(){
        String token = UUID.randomUUID().toString().trim().replace("-", "");
        return token;
    }




    /**
     * 判断date1是否在date2之后,返回true,否则false
     * @return
     */
    public static boolean compareDate(Date date1,Date date2){
        Instant instant1 = date1.toInstant();
        Instant instant2 = date2.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        //date转localDateTime
        LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, zone);
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant2, zone);
        return localDateTime1.isAfter(localDateTime2);
    }

    /**
     * 获取到 15:30格式字符串
     * @return
     */
    public static String getHourMinutes(Date date){
        if(ObjectUtils.isEmpty(date)){
            return null;
        }
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        //date转localDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return String.format("%s:%s",localDateTime.getHour(),localDateTime.getMinute());
    }


    /**
     * 将对象转换为map
     * @param obj
     * @param ignoreNull true为值为null的忽略掉,不转换为map
     * @return
     */
    public static Map<String, Object> object2Map(Object obj,boolean ignoreNull) {
        Map<String, Object> map = new HashMap();
        if (obj == null) {
            return map;
        } else {
            Class clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();

            
                Field[] var4 = fields;
                int var5 = fields.length;
                for(int var6 = 0; var6 < var5; ++var6) {
                    Field field = var4[var6];
                    if(Modifier.isFinal(field.getModifiers()) ||Modifier.isStatic(field.getModifiers()) || Modifier.isAbstract(field.getModifiers())){
                        continue;
                    }
                    field.setAccessible(true);
                    Object o = null;
					try {
						o = field.get(obj);
					} catch (IllegalArgumentException e) {
						log.error("object2Map IllegalArgumentException error ",e);
					} catch (IllegalAccessException e) {
						log.error("object2Map IllegalAccessException error ",e);
					}
                    //判断是否忽略null值
                    if(ignoreNull && ObjectUtils.isEmpty(o)){
                        continue;
                    }else{
                    	try {
                    	   map.put(field.getName(), field.get(obj));
						} catch (IllegalArgumentException e) {
							log.error("object2Map field.get(obj) IllegalArgumentException error ",e);
						} catch (IllegalAccessException e) {
							log.error("object2Map field.get(obj) IllegalAccessException error ",e);
						}
                    }
                }
                return map;
            
        }
    }



    public static Integer getMinutes(Date var1,Date var2){
        if(ObjectUtils.isEmpty(var2)){
            return 0;
        }
        Long v1 = ObjectUtils.isEmpty(var1) ? 0:var1.getTime();
        Long v2 = var2.getTime();
        Long l = v2 - v1;
        return l.intValue()/(60*1000);
    }


    /**
     * 比较两个日期是否同一个
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1,Date date2){
        if(ObjectUtils.isEmpty(date1) || ObjectUtils.isEmpty(date2)){
            return false;
        }
        LocalDateTime dateTime1 = dateToLocalDateTime(date1);
        LocalDateTime dateTime2 = dateToLocalDateTime(date2);
        return dateTime1.isEqual(dateTime2);
    }

    /**
     * Date转换为localDateTime
     * @param date
     * @return
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        //date转localDateTime
        return LocalDateTime.ofInstant(instant, zone);
    }


    /**
     * 将数值转换为百分比字符串
     * @return
     */
    public static String toPercent(Number number){
        if(ObjectUtils.isEmpty(number)){
            return "0%";
        }
        //截取小数点后两位
        String format = new DecimalFormat("##.00%").format(number);
        return ".00%".equals(format) ? "0%":format;
    }

}
