package tomato.plugins.jmeter.clients;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import tomato.plugins.jmeter.handlers.StompOverSockJsHandler;
import tomato.plugins.jmeter.handlers.StompOverSockJsSubscriptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Data
public class StompOverSockJsClient {
    private final String uri;
    private List<String> logs;

    private WebSocketStompClient client;
    private StompSession stompSession;

    public StompOverSockJsClient(String uri) {
        this.uri = uri;
        this.logs = new ArrayList<>();

        stompSession = null;

        client = new WebSocketStompClient(
                new SockJsClient(
                        Arrays.asList(
                                new WebSocketTransport(new StandardWebSocketClient()),
                                new RestTemplateXhrTransport()
                        )
                )
        );

        client.setMessageConverter(new MappingJackson2MessageConverter());
    }

    @SneakyThrows
    public void connect() {
        if (StringUtils.isBlank(uri)) {
            throw new RuntimeException("Uri is missing");
        }

        stompSession = client.connect(uri, new StompOverSockJsHandler(uri)).get();

        logs.add("Connected to endpoint=[" + uri + "] successfully");
    }

    public void subscribe(String channel) {
        if (stompSession == null) {
            throw new RuntimeException("stompSession is null");
        }

        stompSession.subscribe(channel, new StompOverSockJsSubscriptionHandler(channel, stompSession.getSessionId()));

        logs.add("Subscribed a channel=[" + channel + "]");
    }

    @SneakyThrows
    public void send(String channel, String message) {
        stompSession.send(channel, new ObjectMapper().readTree(message));

        logs.add(String.format("Sent a message=[%s] to channel=[%s] successfully", message, channel));
    }

    public void disconnect() {
        if (stompSession != null && stompSession.isConnected()) {
            stompSession.disconnect();
            stompSession = null;
        }
    }
}
