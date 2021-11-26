package live.whiteseason.whitebot.util.redis;

import live.whiteseason.whitebot.modules.osuapi.service.OsuV2TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * 监听redis key失效后更新TOKEN
 * @author whiteseason
 */
@Slf4j
@Component
public class KeyExpiredListener implements MessageListener, ApplicationRunner {
    @Lazy
    @Autowired
    OsuV2TokenService osuV2TokenService;
    //懒加载，防止出现循环依赖
    @Lazy
    @Autowired
    RedisUtil redisUtil;
    @Override
    public void onMessage(Message message, byte[] pattern) {
//        log.info("key 失效回调事件触发");
//        System.out.println(new String(message.getBody()));
//        System.out.println(new String(message.getChannel()));
//        System.out.println(new String(pattern));
        if(message.toString().equals("Bearer")){
            osuV2TokenService.saveClientCredentialToken();
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (!redisUtil.hasKey("Bearer")){
            osuV2TokenService.saveClientCredentialToken();
        }
    }
}
