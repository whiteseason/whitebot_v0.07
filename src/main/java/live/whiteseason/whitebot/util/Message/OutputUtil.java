package live.whiteseason.whitebot.util.Message;

import live.whiteseason.whitebot.modules.osuapi.model.UserInfo;
import org.slf4j.helpers.MessageFormatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;


/**
 * 输出工具类
 */
public class OutputUtil {
    private static String USER_TEMPLATE = null;


    static {
        try {
            USER_TEMPLATE = loadTemplate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String OutputUser(UserInfo userInfo, String mod) {
        if (USER_TEMPLATE != null) {
            Object[] arr = {userInfo.getUserName(),
                    mod,
                    userInfo.getPpRaw(),
                    "",
                    userInfo.getPpRank(),
                    "",
                    userInfo.getCountry(),
                    userInfo.getCountryRank(),
                    "",
                    userInfo.getRankedScore(),
                    accChange(userInfo.getAccuracy()),
                    userInfo.getPlayCount(),
                    userInfo.getCount50()+userInfo.getCount100()+userInfo.getCount300()
            };
            return MessageFormatter.arrayFormat(USER_TEMPLATE,arr).getMessage();
        }else {
            return "数据转换错误，请联系白季解决";
        }

    }

    private static String loadTemplate() throws IOException {
        StringBuilder buffer = new StringBuilder();
        File directory = new File("src/main/resources");
        String reportPath = directory.getCanonicalPath();
        BufferedReader bf = new BufferedReader(new FileReader(reportPath+"/static/UserOutputTemplate.txt"));
        String s = null;
        while ((s = bf.readLine()) != null) {//使用readLine方法，一次读一行
            buffer.append(s.trim()+"\n");
        }
        return buffer.toString();
    }

    private static String accChange(float acc) {
        DecimalFormat df = new DecimalFormat("0.00 ");
        return df.format(acc);
    }
}
