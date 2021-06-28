package tomato.plugins.stompoversockjssamplers.opener;

import lombok.Getter;
import tomato.plugins.stompoversockjssamplers.utils.GuiUtils;

import javax.swing.*;
import java.awt.*;

@Getter
class Panel extends JPanel {
    private JTextField uri;

    public Panel() {
        initComponents();

        setBorder(BorderFactory.createTitledBorder("Settings"));
        setLayout(createLayout());
    }

    private void initComponents() {
        uri = new JTextField();
        GuiUtils.createPlaceHolder(Properties.URI.getPlaceHolder(), uri);
    }

    private LayoutManager createLayout() {
        var layout = new GroupLayout(this);

        var uriLabel = new JLabel(Properties.URI.getLabel());
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
