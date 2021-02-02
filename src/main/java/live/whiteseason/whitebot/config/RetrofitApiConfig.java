package live.whiteseason.whitebot.config;

import live.whiteseason.whitebot.manager.OsuApiManager;
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

    @Bean
    public OsuApiManager osuApiManager(){
        return osuAdapter.create(OsuApiManager.class);
    }

}
