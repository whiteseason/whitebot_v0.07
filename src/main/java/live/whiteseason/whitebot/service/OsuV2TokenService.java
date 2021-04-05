package live.whiteseason.whitebot.service;

/**
 * Token相关功能管理
 * @author whiteseason
 */
public interface OsuV2TokenService {
    /**
     * 获取客户端模式请求token
     * @return 返回是否获取成功
     */
    boolean getClientCredentialToken();
}
