package tomato.backends.websocketclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

@Slf4j
public class StompSessionHandler extends StompSessionHandlerAdapter {
    @Override
    public void afterConnected(
            StompSession session,
            StompHeaders headers
    ) {
        log.error("New session established : " + session.getSessionId());

//        session.subscribe("/topic/scheduled/LS4T1/4T1", this);
//        log.info("Subscribed to /topic/scheduled/LS4T1/4T1");

//        session.send("/app/chat/private/mikai43", getSampleMessage());
//        log.info("Message sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        log.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return ChatMessage.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        ChatMessage msg = (ChatMessage) payload;
        log.info("Received : " + msg.getContent() + " from : " + msg.getSender());
    }


    private ChatMessage getSampleMessage() {
        return ChatMessage
                .builder()
                .sender("sender")
                .content("Hello world")
                .type(1)
                .messageType("chat")
                .build();
    }
}
