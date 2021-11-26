package live.whiteseason.whitebot.modules.osuapi.service.manager;

import live.whiteseason.whitebot.modules.cqhttp.Enum.GameMode;
import live.whiteseason.whitebot.modules.osuapi.model.v2.UserInfoV2;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * OSU！APIV2管理
 *
 * @author whiteseason
 */
public interface OsuApiV2Manager {

    /**
     * 通过玩家名称获取玩家信息
     * @param token 通过调用{@link live.whiteseason.whitebot.modules.osuapi.service.OsuV2TokenService }中的getClientCredentialToken方法获取
     * @param userName 玩家名称
     * @return 获取玩家信息的请求对象
     */
    @GET("api/v2/users/{user}")
    Call<UserInfoV2> getUserByName(@Header("Authorization") String token, @Path("User") String userName);
    /**
     * 通过玩家名称获取玩家信息
     * @param token 通过调用{@link live.whiteseason.whitebot.modules.osuapi.service.OsuV2TokenService}中的getClientCredentialToken方法获取
     * @param userName 玩家名称
     * @param mode 通过{@link GameMode}来选择模式
     * @return 获取玩家信息的请求对象
     */
    @GET("api/v2/users/{user}/{mode}")
    Call<UserInfoV2> getUserByName(@Header("Authorization") String token,
                                   @Path("User") String userName,
                                   @Path("mode") GameMode mode);

}
