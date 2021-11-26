package live.whiteseason.whitebot.config.retrofit;

import live.whiteseason.whitebot.modules.osuapi.service.manager.OsuApiManager;
import live.whiteseason.whitebot.modules.osuapi.service.manager.OsuApiTokenManager;
import live.whiteseason.whitebot.modules.osuapi.service.manager.OsuApiV2Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;

/**
 * @author whiteseason
 */
@Configuration
public class RetrofitApiConfig {

    @Autowired
    @Qualifier("OsuAdapter")
    Retrofit osuAdapter;

    @Autowired
    @Qualifier("OsuV2Adapter")
    Retrofit osuV2Adapter;

    @Autowired
    @Qualifier("OsuV2TokenAdapter")
    Retrofit osuV2TokenAdapter;

    @Bean
    public OsuApiManager osuApiManager() {
        return osuAdapter.create(OsuApiManager.class);
    }

    @Bean
    public OsuApiV2Manager osuApiV2Manager() {
        return osuV2Adapter.create(OsuApiV2Manager.class);
    }

    @Bean
    public OsuApiTokenManager osuApiTokenManager() {
        return osuV2TokenAdapter.create(OsuApiTokenManager.class);
    }
}
