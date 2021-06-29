package tomato.plugins.jmeter.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StompOverSockJsProducerSamplerGuiPanelProperties {
    URI("Uri: ", "Eg: http://localhost:8082/ws?access_token=xxx"),
    CHANNEL("Channel: ", "Eg: /app/topic/chat"),
    MESSAGE("Message: ", "Eg: A message to send");

    private final String label;
    private final String placeHolder;
}
