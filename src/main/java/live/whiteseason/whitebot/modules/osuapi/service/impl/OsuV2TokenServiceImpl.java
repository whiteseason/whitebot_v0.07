package live.whiteseason.whitebot.modules.osuapi.service.impl;

import live.whiteseason.whitebot.modules.osuapi.model.v2.ClientCredentialToken;
import live.whiteseason.whitebot.modules.osuapi.service.manager.OsuApiTokenManager;
import live.whiteseason.whitebot.modules.osuapi.service.OsuV2TokenService;
import live.whiteseason.whitebot.util.redis.RedisUtil;
import live.whiteseason.whitebot.util.RetryCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Map;

/**
 * @author whiteseason
 */
@Service
@Slf4j
public class OsuV2TokenServiceImpl implements OsuV2TokenService {

    @Autowired
    OsuApiTokenManager v2Manager;
    @Autowired
    RedisUtil redisUtil;

    @Value("#{${OSU.V2.ClientCredentialToken}}")
    Map<String, String> clientCredentialToken;

    @Override
    public void saveClientCredentialToken() {
        Call<ClientCredentialToken> call = v2Manager.getClientCredentialToken(clientCredentialToken);
        call.enqueue(new RetryCallback<ClientCredentialToken>(call,5,5000) {
            @Override
            public void onRequestResponse(Call<ClientCredentialToken> call, Response<ClientCredentialToken> response) {
                if (response.isSuccessful()) {
                    // tasks available
                    ClientCredentialToken token1 = response.body();
                    if (token1 != null){
                        redisUtil.set(token1.getTokenType(),token1.getAccessToken(),token1.getExpiresIn());
                        log.info("Token请求成功,请求过期时间："+redisUtil.getExpire(token1.getTokenType()));
                    }else {
                        log.error("请求Token为空");
                    }

                } else {
                    // error response, no access to resource?
                    log.error("Token请求失败，error response, no access to resource");
                }
            }

            @Override
            public void onRequestFail(Call<ClientCredentialToken> call, Throwable t) {
                log.error("Token请求错误",t);
            }

            @Override
            public void onStartRetry() {
                log.warn("Token网络请求出现错误，开始重试");
            }
        });
    }

    @Override
    public String getClientCredentialToken(){
        return "Bearer " + redisUtil.get("Bearer");
    }


}
