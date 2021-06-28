package tomato.plugins.stompoversockjssamplers.services;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.Arrays;

@Slf4j
@Data
public class Client {
    private final String uri;
    private WebSocketStompClient client;

    public Client(String uri) {
        this.uri = uri;

        client = new WebSocketStompClient(
                new SockJsClient(
                        Arrays.asList(
                                new WebSocketTransport(new StandardWebSocketClient()),
                                new RestTemplateXhrTransport()
                        )
                )
        );
    }

    public void connect() {
        client.connect(uri, new Handler(uri));
    }

    public void close() {
        if (client.isRunning()) {
            client.stop();
        }
    }
}
