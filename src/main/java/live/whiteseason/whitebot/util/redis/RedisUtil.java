package live.whiteseason.whitebot.util.redis;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 * @author whiteseason
 */
@Slf4j
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 指定缓存失效时间
     * @param key 键
     * @param timeout 失效时间
     * @return 操作结果
     */
    public boolean expire(String key,long timeout){
        try {
           if (timeout > 0){
               redisTemplate.expire(key,timeout, TimeUnit.SECONDS);
           }
           return true;
        }catch (Exception e){
            log.error("设置缓存失效时间错误",e);
            return false;
        }
    }

    /**
     * 根据key返回失效时间
     * @param key 键
     * @return 失效时间
     */
    public long getExpire(String key){
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        if (expire == null){
            return -1L;
        }
        return expire;
    }

    /**
     * 判断key是否存在
     * @param key 键
     * @return 返回是否存在
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        }catch (Exception e){
            log.error("查询key是否存在发生错误",e);
            return false;
        }
    }

    /**
     * 普通缓存获取
     * @param key 键
     * @return 获取缓存
     */
    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     * @param key 键
     * @param value 值
     * @return 返回是否存储成功
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        }catch (Exception e){
            log.error("缓存存储失败",e);
            return false;
        }
    }

    /**
     * 普通缓存带失效时间放入
     * @param key 键
     * @param value 值
     * @param timeout 失效时间（秒）
     * @return 返回存储结果
     */
    public boolean set(String key, Object value, long timeout){
        try {
            if (timeout > 0) {
                redisTemplate.opsForValue().set(key,value,timeout,TimeUnit.SECONDS);
                return true;
            }else {
                return set(key, value);
            }
        }catch (Exception e){
            log.error("带失效时间缓存存储失败",e);
            return false;
        }
    }
    /**
     * 删除缓存
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public void del(String ... key){
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete((Collection<String>) CollectionUtils.arrayToList(key));
            }
        }
    }
}
