package tomato.plugins.jmeter.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StompOverSockJsConnectionSubscriptionSamplerGuiPanelProperties {
    URI("Uri (*):", "Eg: http://localhost:8082/ws?access_token=xxx"),
    SUBSCRIPTION_CHANNEL("Subscription channel (*):", "Eg: /app/topic/chat"),
    TIMEOUT("Timeout (*):", "1800000");

    private final String label;
    private final String placeHolder;
}
