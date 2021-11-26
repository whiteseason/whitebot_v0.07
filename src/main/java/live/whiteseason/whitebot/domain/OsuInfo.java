package live.whiteseason.whitebot.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 存储玩家基本数据
 *
 * @author whiteseason
 * @since 2021-02-02
 */
@Table
@TableCharset(MySqlCharsetConstant.UTF8)
@Data
@EqualsAndHashCode(callSuper = false)
public class OsuInfo extends Model<OsuInfo> implements Serializable {


    private static final long serialVersionUID = 141356971450034587L;
    /**
     * 玩家uid
     */
    @IsKey
    @Column(name = "osu_id")
    @IsNotNull
    private Integer osuId;

    /**
     * 玩家模式
     */
    @Column
    private Integer mode;

    /**
     * 玩家pp
     */
    @Column(name = "pp_raw")
    private Float ppRaw;

    /**
     * 玩家acc
     */
    @Column(decimalLength = 2)
    private Float accuracy;

    /**
     * 玩家游玩次数
     */
    @Column(name = "play_count")
    private Integer playCount;

    /**
     * 总点击次数
     */
    @Column
    private Long tth;
    /**
     * 总rank分数
     */
    @Column(name = "rank_score")
    private Long rankScore;
    /**
     * 地区排名
     */
    @Column(name = "country_rank")
    private int countryRank;
    /**
     * 世界排名
     */
    @Column(name = "pp_rank")
    private int ppRank;
    /**
     * 版本
     */
    @ColumnType(MySqlTypeConstant.TIMESTAMP)
    @Column
    @Version
    private LocalDateTime version;

}
