package live.whiteseason.whitebot.domain;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.Version;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.gitee.sunchenbin.mybatis.actable.annotation.*;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlCharsetConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author whiteseason
 * @since 2021-04-22
 */
@Data
@Table
@TableCharset(MySqlCharsetConstant.UTF8)
@EqualsAndHashCode(callSuper = false)
public class User extends Model<User> implements Serializable {


    private static final long serialVersionUID = -898181373448004746L;
    /**
     * 玩家qq号
     */
    @Column(name = "qq_id")
    @IsKey
    @IsNotNull
    private Long qqId;

    /**
     * 玩家uid
     */
    @IsNotNull
    @Column(name = "osu_id")
    private Integer osuId;

    /**
     * 划定所属群
     */
    @Column
    private Long fromGroup;

    /**
     * 识别是否为管理
     */
    @Column
    private Boolean isAdmin;

    /**
     * 乐观锁
     */
    @Column
    @Version
    private LocalDateTime version;


}
