package tomato.backends.websocketclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatMessage {
    private String sender;
    private String content;

    @JsonProperty("message_type")
    private String messageType;

    private Integer type;
}
