package com.ksc.kdts.taskmonitor.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

public class BeanUtils {
    private static final Logger log = LoggerFactory.getLogger(BeanUtils.class);

    private BeanUtils() {
    }

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        } else {
            Object target = null;

            try {
                if (Number.class.isAssignableFrom(targetClass)) {
                    return (T) source;
                }

                target = targetClass.newInstance();
                org.springframework.beans.BeanUtils.copyProperties(source, target);
            } catch (Exception var4) {
                log.error("{}", var4);
            }

            return (T) target;
        }
    }

    public static <T> T deepCopyProperties(Object source, Class<T> targetClass) {
        return source == null ? null : JSONObject.parseObject(JSONObject.toJSONString(source), targetClass);
    }

    public static <T> T copyProperties(Object source, T target) {
        if (source == null) {
            return null;
        } else {
            try {
                if (Number.class.isAssignableFrom(target.getClass())) {
                    return (T) source;
                }

                org.springframework.beans.BeanUtils.copyProperties(source, target);
            } catch (Exception var3) {
                log.error("{}", var3);
            }

            return target;
        }
    }

    public static <T> List<T> copyListProperties(List<?> sourceList, Class<T> targetClass) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return null;
        } else {
            ArrayList<T> ts = new ArrayList(sourceList.size());
            sourceList.forEach((item) -> {
                ts.add(copyProperties(item, targetClass));
            });
            return ts;
        }
    }

    public static <T> List<T> deepCopyListProperties(List<?> sourceList, Class<T> targetClass) {
        return CollectionUtils.isEmpty(sourceList) ? null : JSONArray.parseArray(JSONObject.toJSONString(sourceList), targetClass);
    }
}