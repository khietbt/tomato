package tomato.plugins.jmeter.panels;

import lombok.Getter;
import tomato.plugins.jmeter.properties.StompOverSockJsConnectionOpeningSamplerGuiPanelProperties;
import tomato.plugins.jmeter.utils.GuiUtils;

import javax.swing.*;
import java.awt.*;

@Getter
public class StompOverSockJsConnectionOpeningSamplerGuiPanel extends JPanel {
    private JTextField uri;

    public StompOverSockJsConnectionOpeningSamplerGuiPanel() {
        initComponents();
    }

    private void initComponents() {
        uri = new JTextField();
        GuiUtils.createPlaceHolder(StompOverSockJsConnectionOpeningSamplerGuiPanelProperties.URI.getPlaceHolder(), uri);

        setBorder(BorderFactory.createTitledBorder("Settings"));
        setLayout(createLayout());
    }

    private LayoutManager createLayout() {
        var layout = new GroupLayout(this);

        var uriLabel = new JLabel(StompOverSockJsConnectionOpeningSamplerGuiPanelProperties.URI.getLabel());
        uriLabel.setLabelFor(uri);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(uriLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(uri)
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
        );

        return layout;
    }
}
