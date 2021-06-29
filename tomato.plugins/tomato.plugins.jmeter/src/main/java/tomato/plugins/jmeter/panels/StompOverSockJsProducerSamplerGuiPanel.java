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
        uri = new JTextField();
        GuiUtils.addPlaceHolder(StompOverSockJsProducerSamplerGuiPanelProperties.URI.getPlaceHolder(), uri);

        channel = new JTextField();
        GuiUtils.addPlaceHolder(StompOverSockJsProducerSamplerGuiPanelProperties.CHANNEL.getPlaceHolder(), channel);

        message = new JTextArea();
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
