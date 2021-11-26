package live.whiteseason.whitebot.config.redis;


import live.whiteseason.whitebot.util.redis.GsonRedisSerializer;
import live.whiteseason.whitebot.util.redis.KeyExpiredListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author whiteseason
 */
@Configuration
public class RedisConfig extends CachingConfigurerSupport {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private KeyExpiredListener keyExpiredListener;


    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate<String,Object> template = new RedisTemplate <>();
        template.setConnectionFactory(factory);
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        GsonRedisSerializer<Object> gsonRedisSerializer = new GsonRedisSerializer<>(Object.class);
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(gsonRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(gsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer() {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        // 配置监听器监听的主题关联
        Topic topic = new ChannelTopic("__keyevent@0__:expired");
        redisMessageListenerContainer.addMessageListener(keyExpiredListener, topic);
        return redisMessageListenerContainer;
    }
}

