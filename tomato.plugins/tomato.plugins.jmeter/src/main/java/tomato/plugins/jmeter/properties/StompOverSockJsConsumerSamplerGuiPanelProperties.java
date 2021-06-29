package tomato.plugins.jmeter.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StompOverSockJsConsumerSamplerGuiPanelProperties {
    URI("Uri: ", "Eg: http://localhost:8082/ws?access_token=xxx"),
    CHANNEL("Channel: ", "Eg: /app/topic/chat"),
    TIMEOUT("Timeout: ", "Eg: 1800000");

    private final String label;
    private final String placeHolder;
}
