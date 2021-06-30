package tomato.plugins.jmeter.panels;

import lombok.Getter;
import tomato.plugins.jmeter.properties.StompOverSockJsConsumerSamplerGuiPanelProperties;
import tomato.plugins.jmeter.utils.GuiUtils;

import javax.swing.*;
import java.awt.*;

@Getter
public class StompOverSockJsConsumerSamplerGuiPanel extends JPanel {
    private JTextField uri;
    private JTextField channel;
    private JSpinner timeout;

    public StompOverSockJsConsumerSamplerGuiPanel() {
        initComponents();
    }

    private void initComponents() {
        final String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJ1c2VyX2lkXCI6MTkyLFwicm9sZXNcIjpbXCJzdHVkZW50XCJdLFwidXNlcm5hbWVcIjpcIjA5MTI5ODUxMjVcIixcImVtYWlsXCI6bnVsbCxcInByaW5jaXBhbFwiOlwiMDkxMjk4NTEyNVwiLFwiYXBwX2lkXCI6XCJsbXMtd2ViXCIsXCJhY2NvdW50X2lkXCI6XCIwZGZmNjdkYi0wNGE1LTQ4ZDItYjkwZS1hMmRjYmQ4OGIwM2ZcIn0iLCJpYXQiOjE2MjUwMjEwNDAsImV4cCI6MTYyNTYyNTgzOX0.YO92Av6CK50E0FPVZJbSOMGLgc5tSWKLCCai4JH9bsk";
        uri = new JTextField("http://localhost:8082/ws?access_token=" + accessToken);
        GuiUtils.addPlaceHolder(StompOverSockJsConsumerSamplerGuiPanelProperties.URI.getPlaceHolder(), uri);

        channel = new JTextField("/topic/scheduled-LS4T1-4T1");
        GuiUtils.addPlaceHolder(StompOverSockJsConsumerSamplerGuiPanelProperties.CHANNEL.getPlaceHolder(), channel);

        var spinnerNumberModule = new SpinnerNumberModel(60, 60, 1800, 10);
        timeout = new JSpinner(spinnerNumberModule);

        setBorder(BorderFactory.createTitledBorder("Settings"));
        setLayout(createLayout());
    }

    private LayoutManager createLayout() {
        var layout = new GroupLayout(this);

        var uriLabel = new JLabel(StompOverSockJsConsumerSamplerGuiPanelProperties.URI.getLabel());
        uriLabel.setLabelFor(uri);

        var channelLabel = new JLabel(StompOverSockJsConsumerSamplerGuiPanelProperties.CHANNEL.getLabel());
        channelLabel.setLabelFor(channel);

        var timeoutLabel = new JLabel(StompOverSockJsConsumerSamplerGuiPanelProperties.TIMEOUT.getLabel());
        timeoutLabel.setLabelFor(timeoutLabel);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(uriLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(uri)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        )
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(channelLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(channel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        )
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(timeoutLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(timeout)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(uriLabel)
                                        .addComponent(
                                                uri,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(channelLabel)
                                        .addComponent(
                                                channel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(timeoutLabel)
                                        .addComponent(
                                                timeout,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
        );

        return layout;
    }
}
