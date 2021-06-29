package tomato.plugins.jmeter.clients;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import tomato.plugins.jmeter.handlers.StompOverSockJsHandler;
import tomato.plugins.jmeter.handlers.StompOverSockJsSubscriptionHandler;

import java.util.Arrays;

@Slf4j
@Data
public class StompOverSockJsClient {
    private final String uri;
    private WebSocketStompClient client;
    private StompSession stompSession;

    public StompOverSockJsClient(String uri) {
        this.uri = uri;

        stompSession = null;

        client = new WebSocketStompClient(
                new SockJsClient(
                        Arrays.asList(
                                new WebSocketTransport(new StandardWebSocketClient()),
                                new RestTemplateXhrTransport()
                        )
                )
        );
    }

    @SneakyThrows
    public void connect() {
        stompSession = client.connect(uri, new StompOverSockJsHandler(uri)).get();
    }

    public void subscribe(String subscriptionChannel) {
        stompSession.subscribe(subscriptionChannel, new StompOverSockJsSubscriptionHandler(subscriptionChannel));
    }

    public void send(String channel, String message) {
        stompSession.send(channel, "Hello world");
    }

    public void close() {
        if (client.isRunning()) {
            client.stop();
        }
    }
}
