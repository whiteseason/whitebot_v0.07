package live.whiteseason.whitebot.modules.osuapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author whiteseason,mothership
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 3721387789061410583L;
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
    private String country;
    @Expose
    @SerializedName("playcount")
    private int playCount;
    @Expose
    @SerializedName("pp_country_rank")
    private int countryRank;
    @Expose
    private float accuracy;
    @Expose
    private float ppRaw;
    @Expose
    @SerializedName("ranked_score")
    private long rankedScore;
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
