package tomato.plugins.jmeter.guis;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import tomato.plugins.jmeter.panels.StompOverSockJsConsumerSamplerGuiPanel;
import tomato.plugins.jmeter.samplers.StompOverSockJsConsumerSampler;

import java.awt.*;

@Slf4j
public class StompOverSockJsConsumerSamplerGui extends AbstractSamplerGui {
    private StompOverSockJsConsumerSamplerGuiPanel stompOverSockJsConsumerSamplerGuiPanel;

    public StompOverSockJsConsumerSamplerGui() {
        initComponents();
    }

    private void initComponents() {
        stompOverSockJsConsumerSamplerGuiPanel = new StompOverSockJsConsumerSamplerGuiPanel();

        setLayout(new BorderLayout());
        setBorder(makeBorder());

        add(makeTitlePanel(), BorderLayout.NORTH);
        add(stompOverSockJsConsumerSamplerGuiPanel, BorderLayout.CENTER);
    }

    @Override
    public String getLabelResource() {
        return "Stomp Over SockJs Consumer Sampler";
    }

    @Override
    public String getStaticLabel() {
        return getLabelResource();
    }

    @Override
    public TestElement createTestElement() {
        var sampler = new StompOverSockJsConsumerSampler();

        configureTestElement(sampler);

        return sampler;
    }

    @Override
    public void modifyTestElement(TestElement element) {
        super.configureTestElement(element);

        if (element instanceof StompOverSockJsConsumerSampler stompOverSockJsConsumerSampler) {
            stompOverSockJsConsumerSampler.setUri(
                    stompOverSockJsConsumerSamplerGuiPanel.getUri().getText()
            );
            stompOverSockJsConsumerSampler.setChannel(
                    stompOverSockJsConsumerSamplerGuiPanel.getChannel().getText()
            );
            stompOverSockJsConsumerSampler.setTimeout(
                    (int) stompOverSockJsConsumerSamplerGuiPanel.getTimeout().getValue()
            );
        }
    }

    /**
     * Returns whether a component of this type can be added to the test plan.
     *
     * @return true if the component can be added, false otherwise.
     */
    @Override
    public boolean canBeAdded() {
        return super.canBeAdded();
    }

    @Override
    public void configure(TestElement element) {
        super.configure(element);
    }
}
