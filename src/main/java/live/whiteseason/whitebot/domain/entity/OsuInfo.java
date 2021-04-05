package live.whiteseason.whitebot.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;
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
@Table(name = "osu_info")
@Data
@EqualsAndHashCode(callSuper = false)
public class OsuInfo extends Model<OsuInfo> {

    private static final long serialVersionUID = 1L;

    @IsKey
    @IsAutoIncrement
    @IsNotNull
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 玩家uid
     */
    @IsNotNull
    @ColumnType(MySqlTypeConstant.INT)
    @Column(comment = "玩家uid")
    private Integer osuId;

    /**
     * 玩家模式
     */
    @IsNotNull
    @DefaultValue("0")
    @Column(comment = "玩家模式")
    private Integer mode;

    /**
     * 玩家pp
     */
    @Column(comment = "玩家总pp")
    private Float ppRaw;

    /**
     * 玩家acc
     */
    @Column(comment = "玩家总acc")
    private Float accuracy;

    /**
     * 玩家游玩次数
     */
    @Column(comment = "玩家pc")
    private Integer playCount;

    /**
     * 总点击次数
     */
    @Column(comment = "总点击次数")
    private Long tth;

    /**
     * 版本
     */
    @Version
    @ColumnType(MySqlTypeConstant.TIMESTAMP)
    @Column(comment = "乐观锁")
    private LocalDateTime version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
