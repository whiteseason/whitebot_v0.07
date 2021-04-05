package live.whiteseason.whitebot.config.retrofit;

import live.whiteseason.whitebot.manager.OsuApiManager;
import live.whiteseason.whitebot.manager.OsuApiV2Manager;
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

    @Bean
    public OsuApiManager osuApiManager(){
        return osuAdapter.create(OsuApiManager.class);
    }

    @Bean
    public OsuApiV2Manager osuApiV2Manager(){
        return osuV2Adapter.create(OsuApiV2Manager.class);
    }
}
