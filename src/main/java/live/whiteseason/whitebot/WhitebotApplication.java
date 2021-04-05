package live.whiteseason.whitebot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author whiteseason
 * @version v0.0.7
 */


@MapperScan({"com.gitee.sunchenbin.mybatis.actable.dao.*","live.whiteseason.whitebot.*"})
@MapperScan("com.gitee.sunchenbin.mybatis.actable.dao.*")
@SpringBootApplication
public class WhitebotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhitebotApplication.class, args);
    }

}
