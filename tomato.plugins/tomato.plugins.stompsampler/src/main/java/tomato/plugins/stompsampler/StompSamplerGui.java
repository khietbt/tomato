package tomato.plugins.stompsampler;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

import javax.swing.*;
import java.awt.*;

@Slf4j
@SuppressWarnings("all")
public class StompSamplerGui extends AbstractSamplerGui {
    private final JTextField txtUri;
    private final JTextField txtSubscriptionChannel;
    private final JTextField txtMessage;
    private final JCheckBox success;

    public StompSamplerGui() {
        txtUri = new JTextField();
        txtSubscriptionChannel = new JTextField();
        txtMessage = new JTextField();

        success = new JCheckBox("Success", true);

        setLayout(new BorderLayout());
        setBorder(makeBorder());
        add(makeTitlePanel(), BorderLayout.NORTH);
        add(createStompSamplerPanel(), BorderLayout.CENTER);
    }

    private JPanel createStompSamplerPanel() {
        /* Panel. */
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Steps"));

        var layout = new GroupLayout(panel);
        panel.setLayout(layout);

        /**/
        JLabel txtUri = new JLabel("Hostname");
        txtUri.setLabelFor(this.txtUri);

        JLabel lblSubscriptionChannel = new JLabel("Subscription channel");
        lblSubscriptionChannel.setLabelFor(txtSubscriptionChannel);

        JLabel lblMessage = new JLabel("Message");
        lblMessage.setLabelFor(txtMessage);

        JLabel responseCodeLabel = new JLabel("Response Code");

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(txtUri)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(this.txtUri)
                        )
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(lblMessage)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSubscriptionChannel)
                        )
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(responseCodeLabel)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMessage)
                        )
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(success)
                        )
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                txtUri,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                                        .addComponent(
                                                this.txtUri,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                lblMessage,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                                        .addComponent(
                                                txtSubscriptionChannel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                responseCodeLabel,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                                        .addComponent(
                                                txtMessage,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(
                                                success,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
        );

        return panel;
    }

    @Override
    public String getLabelResource() {
        return "STOMP Sampler";
    }

    @Override
    public String getStaticLabel() {
        return getLabelResource();
    }

    @Override
    public TestElement createTestElement() {
        StompSampler sampler = new StompSampler();
        configureTestElement(sampler);
        return sampler;
    }

    @Override
    public void modifyTestElement(TestElement element) {
        super.configureTestElement(element);
        if (element instanceof StompSampler sampler) {
            sampler.setUri(txtUri.getText());
            sampler.setMessage(txtMessage.getText());
            sampler.setSuccessful(success.isSelected());
            sampler.setSubscriptionChannel(txtSubscriptionChannel.getText());
        }
    }

    @Override
    public void configure(TestElement element) {
        super.configure(element);
        if (element instanceof StompSampler sampler) {
            txtUri.setText(sampler.getUri());
            txtMessage.setText(sampler.getMessage());
            txtSubscriptionChannel.setText(sampler.getSubscriptionChannel().toString());
            success.setSelected(sampler.getSuccessful());
        }
    }
}
