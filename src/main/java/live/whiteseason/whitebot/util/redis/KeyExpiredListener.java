package live.whiteseason.whitebot.util.redis;

import live.whiteseason.whitebot.service.OsuV2TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 监听redis key失效后处理方法
 * @author whiteseason
 */
@Slf4j
@Component
public class KeyExpiredListener implements MessageListener, ApplicationRunner {
    @Autowired
    OsuV2TokenService osuV2TokenService;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void onMessage(Message message, byte[] pattern) {
//        log.info("key 失效回调事件触发");
//        System.out.println(new String(message.getBody()));
//        System.out.println(new String(message.getChannel()));
//        System.out.println(new String(pattern));
        if(message.toString().equals("Bearer")){
            osuV2TokenService.getClientCredentialToken();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!redisUtil.hasKey("Bearer")){
            osuV2TokenService.getClientCredentialToken();
        }
    }
}
