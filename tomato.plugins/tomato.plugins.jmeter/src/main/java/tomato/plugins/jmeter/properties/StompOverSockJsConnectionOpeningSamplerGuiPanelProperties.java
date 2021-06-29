package tomato.plugins.jmeter.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StompOverSockJsConnectionOpeningSamplerGuiPanelProperties {
    URI("Uri (*):", "Eg: http://localhost:8082/ws?access_token=xxx");

    private final String label;
    private final String placeHolder;
}
