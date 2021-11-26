package live.whiteseason.whitebot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 小白季 v0.0.7版本
 * 使用框架：
 * 平台：Java + Spring Boot
 * 数据库：MySQL
 * 数据库连接组件：
 *  数据库连接池：Druid
 *  ORM/持久层框架：MyBatis-Plus
 * API接口请求组件：
 *  REST 客户端：Retrofit2
 *  数据缓存组件：Redis + RedisTemplate
 * @author whiteseason
 * @version v0.0.7
 */

@SpringBootApplication
@MapperScan("com.gitee.sunchenbin.mybatis.actable.dao.*")
@ComponentScan(basePackages = {"com.gitee.sunchenbin.mybatis.actable.manager.*","live.whiteseason.whitebot"})
public class WhitebotApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhitebotApplication.class, args);
    }

}
