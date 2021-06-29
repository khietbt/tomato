package tomato.plugins.jmeter.handlers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;

@Slf4j
@AllArgsConstructor
public class StompOverSockJsSubscriptionHandler implements StompFrameHandler {
    private final String subscriptionChannel;

    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
        log.info("Received a message from channel {} with payload: {}", subscriptionChannel, o != null ? o.toString() : null);
    }
}
