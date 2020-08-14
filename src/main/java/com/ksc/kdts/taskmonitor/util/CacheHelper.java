package com.ksc.kdts.taskmonitor.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service("acheHelper")
public class CacheHelper {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public CacheHelper() {
    }

    public CacheHelper(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public <T> List<T> getListValue(String key, Class<T> clazz) {
        if (StringUtils.isEmpty(key)) {
            return null;
        } else {
            String value = this.getValue(key);
            return StringUtils.isEmpty(value) ? null : JSONObject.parseArray(value, clazz);
        }
    }

    public <T> T getValue(String key, Class<T> clazz) {
        if (StringUtils.isEmpty(key)) {
            return null;
        } else {
            String value = this.getValue(key);
            return StringUtils.isEmpty(value) ? null : JSONObject.parseObject(value, clazz);
        }
    }

    public String getValue(String key) {
        return StringUtils.isEmpty(key) ? null : (String)this.stringRedisTemplate.opsForValue().get(key);
    }

    public void setValue(String key, Object value) {
        if (value != null) {
            String cacheValue;
            if (value instanceof String) {
                cacheValue = value.toString();
            } else {
                cacheValue = JSONObject.toJSONString(value);
            }

            this.stringRedisTemplate.opsForValue().set(key, cacheValue);
        }
    }

    public Long leftPush(String key, Object value) {
        if (value == null) {
            return null;
        } else {
            String cacheValue;
            if (value instanceof String) {
                cacheValue = value.toString();
            } else {
                cacheValue = JSONObject.toJSONString(value);
            }

            return this.stringRedisTemplate.opsForList().leftPush(key, cacheValue);
        }
    }

    public <T> T rightPop(String key, Class<T> tClass) {
        if (StringUtils.isEmpty(key)) {
            return null;
        } else {
            String value = (String)this.stringRedisTemplate.opsForList().rightPop(key);
            return StringUtils.isEmpty(value) ? null : JSONObject.parseObject(value, tClass);
        }
    }

    public Long getListLength(String key) {
        return StringUtils.isEmpty(key) ? 0L : this.stringRedisTemplate.opsForList().size(key);
    }

    public void hashSet(String key, String field, Object value) {
        if (value != null) {
            String cacheValue;
            if (value instanceof String) {
                cacheValue = value.toString();
            } else {
                cacheValue = JSONObject.toJSONString(value);
            }

            this.stringRedisTemplate.opsForHash().put(key, field, cacheValue);
        }
    }

    public Long getHashSize(String key) {
        return StringUtils.isEmpty(key) ? 0L : this.stringRedisTemplate.opsForHash().size(key);
    }

    public void hashDel(String key, String field) {
        if (!StringUtils.isEmpty(key)) {
            this.stringRedisTemplate.opsForHash().delete(key, new Object[]{field});
        }
    }

    public void setValue(String key, Object value, long timeout, TimeUnit unit) {
        if (value != null) {
            String cacheValue;
            if (value instanceof String) {
                cacheValue = value.toString();
            } else {
                cacheValue = JSONObject.toJSONString(value);
            }

            this.stringRedisTemplate.opsForValue().set(key, cacheValue, timeout, unit);
        }
    }

    public Long incrBy(String key, int increment) {
        return this.stringRedisTemplate.opsForValue().increment(key, (long)increment);
    }

    public Boolean delete(String key) {
        return this.stringRedisTemplate.delete(key);
    }

    public Boolean deleteLike(String key) {
        this.stringRedisTemplate.delete(this.keys(key));
        return true;
    }

    public Set<String> keys(String pattern) {
        return this.stringRedisTemplate.keys("*" + pattern + "*");
    }

}
