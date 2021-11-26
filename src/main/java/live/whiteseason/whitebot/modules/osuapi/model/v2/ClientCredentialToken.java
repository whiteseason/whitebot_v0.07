package live.whiteseason.whitebot.modules.osuapi.model.v2;

import com.gitee.sunchenbin.mybatis.actable.annotation.IgnoreTable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * OSU Api v2版本验证
 * @author whiteseason
 */
@Data
@IgnoreTable
public class ClientCredentialToken implements Serializable {
    private static final long serialVersionUID = 8680281182685496018L;
    @Expose
    @SerializedName("token_type")
    private String tokenType;
    @Expose
    @SerializedName("expires_in")
    private Long expiresIn;
    @Expose
    @SerializedName("access_token")
    private String accessToken;

}
