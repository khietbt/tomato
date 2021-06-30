package tomato.plugins.jmeter.panels;

import lombok.Getter;
import tomato.plugins.jmeter.properties.StompOverSockJsProducerSamplerGuiPanelProperties;
import tomato.plugins.jmeter.utils.GuiUtils;

import javax.swing.*;
import java.awt.*;

@Getter
public class StompOverSockJsProducerSamplerGuiPanel extends JPanel {
    private JTextField uri;
    private JTextField channel;
    private JTextArea message;

    public StompOverSockJsProducerSamplerGuiPanel() {
        initComponents();
    }

    private void initComponents() {
        uri = new JTextField("http://localhost:8082/ws?access_token=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJ1c2VyX2lkXCI6MTkyLFwicm9sZXNcIjpbXCJzdHVkZW50XCJdLFwidXNlcm5hbWVcIjpcIjA5MTI5ODUxMjVcIixcImVtYWlsXCI6bnVsbCxcInByaW5jaXBhbFwiOlwiMDkxMjk4NTEyNVwiLFwiYXBwX2lkXCI6XCJsbXMtd2ViXCIsXCJhY2NvdW50X2lkXCI6XCIwZGZmNjdkYi0wNGE1LTQ4ZDItYjkwZS1hMmRjYmQ4OGIwM2ZcIn0iLCJpYXQiOjE2MjUwMjEwNDAsImV4cCI6MTYyNTYyNTgzOX0.YO92Av6CK50E0FPVZJbSOMGLgc5tSWKLCCai4JH9bsk");
        GuiUtils.addPlaceHolder(StompOverSockJsProducerSamplerGuiPanelProperties.URI.getPlaceHolder(), uri);

        channel = new JTextField("/app/chat/private/mikai43");
        GuiUtils.addPlaceHolder(StompOverSockJsProducerSamplerGuiPanelProperties.CHANNEL.getPlaceHolder(), channel);

        message = new JTextArea("{\"sender\":\"xxxx\",\"message\":\"xxxxx\"}");
        GuiUtils.addPlaceHolder(StompOverSockJsProducerSamplerGuiPanelProperties.MESSAGE.getPlaceHolder(), message);

        setBorder(BorderFactory.createTitledBorder("Settings"));
        setLayout(createLayout());
    }

    private LayoutManager createLayout() {
        var layout = new GroupLayout(this);

        var uriLabel = new JLabel(StompOverSockJsProducerSamplerGuiPanelProperties.URI.getLabel());
        uriLabel.setLabelFor(uri);

        var channelLabel = new JLabel(StompOverSockJsProducerSamplerGuiPanelProperties.CHANNEL.getLabel());
        channelLabel.setLabelFor(this.channel);

        var messageLabel = new JLabel(StompOverSockJsProducerSamplerGuiPanelProperties.MESSAGE.getLabel());
        messageLabel.setLabelFor(message);

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
                                        .addComponent(messageLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(message)
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
                                        .addComponent(messageLabel)
                                        .addComponent(
                                                message,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
        );

        return layout;
    }
}
