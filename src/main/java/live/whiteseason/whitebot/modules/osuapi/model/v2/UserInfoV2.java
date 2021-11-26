package live.whiteseason.whitebot.modules.osuapi.model.v2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * OSU！API V2玩家数据请求返回（不会写入数据库）
 * @version 0.0.7
 * @author whiteseason
 */
@Data
public class UserInfoV2 {
    @Expose
    private Long id;
    @Expose
    @SerializedName("username")
    private String userName;

}
