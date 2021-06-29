package tomato.plugins.jmeter.handlers;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

@Slf4j
public class StompOverSockJsHandler extends StompSessionHandlerAdapter {
    private final String uri;

    public StompOverSockJsHandler(
            String uri
    ) {
        super();

        this.uri = uri;
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return super.getPayloadType(headers);
    }

    @Override
    public void handleFrame(
            StompHeaders headers,
            Object payload
    ) {
        super.handleFrame(headers, payload);
    }

    @Override
    public void afterConnected(
            StompSession session,
            StompHeaders connectedHeaders
    ) {
        log.info("Connected to {} successfully", uri);
    }

    @Override
    @SneakyThrows
    public void handleException(
            StompSession session,
            StompCommand command,
            StompHeaders headers,
            byte[] payload,
            Throwable exception
    ) {
        super.handleException(session, command, headers, payload, exception);
        throw exception;
    }

    @SneakyThrows
    @Override
    public void handleTransportError(
            StompSession session,
            Throwable exception
    ) {
        super.handleTransportError(session, exception);
        throw exception;
    }
}
