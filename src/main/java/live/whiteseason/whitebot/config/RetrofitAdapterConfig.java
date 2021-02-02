package live.whiteseason.whitebot.config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author whiteseason
 */
@Configuration
public class RetrofitAdapterConfig {

    Gson gson =  new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();
    /**
     * 获取RestAdapter单例Bean
     *
     * @return Retrofit
     */
    @Bean("OsuAdapter")
    public Retrofit getOsuAdapter() {
        /*
         * setEndpoint("https://osu.ppy.sh/api/get_user"):指定基本的URL，
         * API接口中的URL是相对于该URL的路径的，
         * 不能少了协议名，例如写成：localhost:8081就不行
         */
        return new Retrofit.Builder()
                .baseUrl("https://osu.ppy.sh")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
