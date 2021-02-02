package live.whiteseason.whitebot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author whiteseason
 * @version v0.0.7
 */
@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class WhitebotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhitebotApplication.class, args);
    }

}
