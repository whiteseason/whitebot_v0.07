package live.whiteseason.whitebot.domain.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author whiteseason
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OsuInfo extends Model<OsuInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 玩家uid
     */
    private Integer osuId;

    /**
     * 玩家模式
     */
    private Integer mode;

    /**
     * 玩家pp
     */
    private Float ppRaw;

    /**
     * 玩家acc
     */
    private Float accuracy;

    /**
     * 玩家游玩次数
     */
    private Integer playCount;

    /**
     * 总点击次数
     */
    private Long tth;

    /**
     * 版本
     */
    @Version
    private LocalDateTime version;


    @Override
    protected Serializable pkVal() {
        return this.osuId;
    }

}
