package live.whiteseason.whitebot.modules.osuapi.service.manager;

import live.whiteseason.whitebot.modules.osuapi.model.v2.ClientCredentialToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

public interface OsuApiTokenManager {
    /**
     * 请求token
     *
     * @param clientId     官网申请的id
     * @param clientSecret 官网申请
     * @param grantType    必须为client_credentials
     * @param scope        必须为public
     * @return public token请求对象
     */
    @POST("oauth/token")
    @FormUrlEncoded
    Call<ClientCredentialToken> getClientCredentialToken(@Field("client_id") int clientId,
                                                         @Field("client_secret") String clientSecret,
                                                         @Field("grant_type") String grantType,
                                                         @Field("scope") String scope);

    /**
     * 请求token
     * @param map 认证信息，包含clientId，clientSecret，grantType，scope
     * @return public token请求对象
     */
    @POST("oauth/token")
    @FormUrlEncoded
    Call<ClientCredentialToken> getClientCredentialToken(@FieldMap Map<String, String> map);
}
