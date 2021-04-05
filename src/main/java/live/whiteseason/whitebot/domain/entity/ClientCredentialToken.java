package live.whiteseason.whitebot.domain.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author whiteseason
 */
@Data
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
