package live.whiteseason.whitebot.manager;

import live.whiteseason.whitebot.domain.entity.ClientCredentialToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import java.util.Map;

/**
 * OSU！APIV2管理
 * @author whiteseason
 */
public interface OsuApiV2Manager {
    /**
     * 请求token
     * @param clientId 官网申请的id
     * @param clientSecret 官网申请
     * @param grantType 必须为client_credentials
     * @param scope 必须为public
     * @return public token
     */
    @POST("oauth/token")
    @FormUrlEncoded
    Call<ClientCredentialToken> getClientCredentialToken(@Field("client_id") int clientId,
                                                         @Field("client_secret") String clientSecret,
                                                         @Field("grant_type") String grantType,
                                                         @Field("scope") String scope);
    @POST("oauth/token")
    @FormUrlEncoded
    Call<ClientCredentialToken> getClientCredentialToken(@FieldMap Map<String, String> map);


}
