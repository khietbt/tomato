package tomato.backends.websocketclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

@Slf4j
public class StompSessionHandler extends StompSessionHandlerAdapter {
    @Override
    public void afterConnected(
            StompSession session,
            StompHeaders headers
    ) {
        log.info("New session established : " + session.getSessionId());
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        log.error("Got an exception", exception);
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        log.info("Received a frame: {}", payload);
    }
}
