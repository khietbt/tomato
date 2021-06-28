package tomato.plugins.stompoversockjssamplers.opener;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
enum Properties {
    LABEL_RESOURCE("Stomp Over SockJS Connection Opening Sampler", ""),
    URI("Uri (*):", "Eg: http://localhost:8082/ws?access_token=xxx");

    private final String label;
    private final String placeHolder;
}
