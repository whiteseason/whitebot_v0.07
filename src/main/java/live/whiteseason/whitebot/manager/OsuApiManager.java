package live.whiteseason.whitebot.manager;

import live.whiteseason.whitebot.pojo.osu.UserInfo;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author whiteseason
 */
public interface OsuApiManager {
    /**
     * OSU获取玩家信息接口
     * @param apikey OSU API接口密钥
     * @param uid 玩家User id
     * @param mod 游玩模式 (0 = osu!, 1 = Taiko, 2 = CtB, 3 = osu!mania)
     * @return 返回http请求接口
     */
    @POST("/api/get_user")
    Call<UserInfo[]> getUserByUid(@Query("k") String apikey, @Query("u") String uid,@Query("m") Integer mod);
}
