package tomato.plugins.jmeter.panels;

import lombok.Getter;
import tomato.plugins.jmeter.properties.StompOverSockJsConnectionSubscriptionSamplerGuiPanelProperties;
import tomato.plugins.jmeter.utils.GuiUtils;

import javax.swing.*;
import java.awt.*;

@Getter
public class StompOverSockJsConnectionSubscriptionSamplerGuiPanel extends JPanel {
    private JTextField uri;
    private JTextField subscriptionChannel;
    private JSpinner timeout;

    public StompOverSockJsConnectionSubscriptionSamplerGuiPanel() {
        initComponents();
    }

    private void initComponents() {
        uri = new JTextField();
        GuiUtils.addPlaceHolder(StompOverSockJsConnectionSubscriptionSamplerGuiPanelProperties.URI.getPlaceHolder(), uri);

        subscriptionChannel = new JTextField();
        GuiUtils.addPlaceHolder(StompOverSockJsConnectionSubscriptionSamplerGuiPanelProperties.SUBSCRIPTION_CHANNEL.getPlaceHolder(), subscriptionChannel);

        var spinnerNumberModule = new SpinnerNumberModel(60, 60, 1800, 10);
        timeout = new JSpinner(spinnerNumberModule);

        setBorder(BorderFactory.createTitledBorder("Settings"));
        setLayout(createLayout());
    }

    private LayoutManager createLayout() {
        var layout = new GroupLayout(this);

        var uriLabel = new JLabel(StompOverSockJsConnectionSubscriptionSamplerGuiPanelProperties.URI.getLabel());
        uriLabel.setLabelFor(uri);

        var subscriptionChannelLabel = new JLabel(StompOverSockJsConnectionSubscriptionSamplerGuiPanelProperties.SUBSCRIPTION_CHANNEL.getLabel());
        subscriptionChannelLabel.setLabelFor(subscriptionChannel);

        var timeoutLabel = new JLabel(StompOverSockJsConnectionSubscriptionSamplerGuiPanelProperties.TIMEOUT.getLabel());
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
                                        .addComponent(subscriptionChannelLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subscriptionChannel)
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
                                        .addComponent(subscriptionChannelLabel)
                                        .addComponent(
                                                subscriptionChannel,
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
