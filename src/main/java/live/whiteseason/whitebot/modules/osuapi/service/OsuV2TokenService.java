package live.whiteseason.whitebot.modules.osuapi.service;

/**
 * Token相关功能管理
 * @author whiteseason
 */
public interface OsuV2TokenService {
    /**
     * 获取客户端模式请求token
     */
    void saveClientCredentialToken();

    String getClientCredentialToken();
}
