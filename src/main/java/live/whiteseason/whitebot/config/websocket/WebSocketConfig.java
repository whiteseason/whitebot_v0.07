package live.whiteseason.whitebot.config.websocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.session.StandardSessionFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
public class WebSocketConfig extends ServerEndpointConfig.Configurator{

    private static final String HttpSession = null;
    /* 修改握手,就是在握手协议建立之前修改其中携带的内容 */
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        /**
         * {upgrade=[websocket], host=[localhost:8081], x-self-id=[1319756695], connection=[Upgrade], sec-websocket-key=[F0pWvU/0n8oOt8jnS9bWSw==], x-client-role=[Universal], sec-websocket-version=[13], user-agent=[CQHttp/4.15.0]}
         */
        Map<String, List<String>> headers = request.getHeaders();
        log.info("获取连接，header = "+headers);
        sec.getUserProperties().put("x-self-id",headers.get("x-self-id").get(0));
        super.modifyHandshake(sec, request, response);
    }
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
