package live.whiteseason.whitebot.config.retrofit;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import live.whiteseason.whitebot.config.retrofit.converter.CustomGsonConverterFactory;
import live.whiteseason.whitebot.util.redis.RedisUtil;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * @author whiteseason
 */
@Configuration
public class RetrofitAdapterConfig {

    @Autowired
    RedisUtil redisUtil;

    /**
     * 这里的Gson建立是为了自定义处理json的方法，可以去网上查询相关用法
     */
    Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    /**
     * @return v1接口
     */
    @Lazy
    @Bean("OsuAdapter")
    public Retrofit getOsuAdapter() {
        /*
         * baseUrl("https://osu.ppy.sh"):指定基本的URL，
         * API接口中的URL是相对于该URL的路径的，
         * 不能少了协议名，例如写成：localhost:8081就不行
         * CustomGsonConverterFactory.create(gson)中的gson引用是为了可以将自定义的gson处理方法添加到retrofit中，让他能按照我们想要的处理方法处理
         */
        return new Retrofit.Builder()
                .baseUrl("https://osu.ppy.sh")
                .addConverterFactory(CustomGsonConverterFactory.create(gson))
                .build();
    }

    /**
     * @return v2接口
     */
    @Lazy
    @Bean("OsuV2Adapter")
    public Retrofit getOsuV2Adapter() {
        return new Retrofit.Builder()
                .baseUrl("https://osu.ppy.sh")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    /**
     * v2Token请求
     */
    @Bean("OsuV2TokenAdapter")
    public Retrofit getOsuV2TokenAdapter() {

        return new Retrofit.Builder()
                .baseUrl("https://osu.ppy.sh")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
