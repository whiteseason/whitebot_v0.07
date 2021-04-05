package live.whiteseason.whitebot.domain.entity;

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
 * QQ信息管理
 * </p>
 *
 * @author whiteseason
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "user")
public class User extends Model<User> implements Serializable{

    /**
     * qq号
     */
    @IsKey
    @IsNotNull
    @Column(name = "qq_id")
    @ColumnComment("玩家qq号")
    private Long qqId;

    /**
     * 玩家uid
     */
    @IsNotNull
    @Column(name = "osu_id")
    @ColumnComment("玩家uid")
    private Integer osuId;

    /**
     * 所属群
     */
    @ColumnComment("划定所属群")
    @Column(name = "from_group")
    private Long fromGroup;

    /**
     * 识别是否为管理
     */
    @IsNotNull
    @DefaultValue("false")
    @Column("is_admin")
    @ColumnComment("识别是否为管理")
    private boolean isAdmin;

    /**
     * version
     */
    @Version
    @ColumnType(MySqlTypeConstant.TIMESTAMP)
    @Column(comment = "乐观锁")
    private LocalDateTime version;


    @Override
    protected Serializable pkVal() {
        return this.qqId;
    }

}
