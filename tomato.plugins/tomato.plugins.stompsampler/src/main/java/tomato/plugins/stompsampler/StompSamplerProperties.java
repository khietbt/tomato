package tomato.plugins.stompsampler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StompSamplerProperties {
    URI("STOMP_SAMPLER_PROPERTIES.URI", "Uri:"),
    SUBSCRIPTION_CHANNEL("STOMP_SAMPLER_PROPERTIES.SUBSCRIPTION_CHANNEL", "Subscription channel:"),
    MESSAGE("STOMP_SAMPLER_PROPERTIES.MESSAGE", "Message:");

    private final String id;
    private final String label;
}