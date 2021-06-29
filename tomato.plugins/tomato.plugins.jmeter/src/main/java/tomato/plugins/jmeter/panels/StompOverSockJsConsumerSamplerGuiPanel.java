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
        uri = new JTextField();
        GuiUtils.addPlaceHolder(StompOverSockJsConsumerSamplerGuiPanelProperties.URI.getPlaceHolder(), uri);

        channel = new JTextField();
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
