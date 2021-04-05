package live.whiteseason.whitebot.pojo.osu;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author whiteseason,mothership
 */
@Data
public class UserInfo {
    /**
     * 这个字段不写入数据库
     */
    @Expose
    @SerializedName("username")
    private String userName;
    @Expose
    private Integer mode;
    @Expose
    private int userId;
    @Expose
    private int count300;
    @Expose
    private int count100;
    @Expose
    private int count50;
    @Expose
    @SerializedName("playcount")
    private int playCount;
    @Expose
    private float accuracy;
    @Expose
    private float ppRaw;
//    private long rankedScore;
//    private long totalScore;
//    private float level;
    @Expose
    private int ppRank;
//    private int countRankSs;
//    private int countRankSsh;
//    private int countRankS;
//    private int countRankSh;
//    private int countRankA;
//    private LocalDate queryDate;
}
