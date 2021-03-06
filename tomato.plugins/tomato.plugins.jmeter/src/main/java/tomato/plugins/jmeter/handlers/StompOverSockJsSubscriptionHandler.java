package tomato.plugins.jmeter.handlers;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Data
public class StompOverSockJsSubscriptionHandler implements StompFrameHandler {
    private final String channel;
    private String sessionId;
    private List<String> logs;

    public StompOverSockJsSubscriptionHandler(String channel, String sessionId) {
        this.channel = channel;
        this.sessionId = sessionId;
        logs = new ArrayList<>();
    }

    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
        return JsonNode.class;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
        assert o != null;
        logs.add("- Received a message from channel " + channel + " with payload=[" + o + "], sessionId=" + sessionId);
    }
}
