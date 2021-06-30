package tomato.plugins.jmeter.guis;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;
import tomato.plugins.jmeter.panels.StompOverSockJsProducerSamplerGuiPanel;
import tomato.plugins.jmeter.samplers.StompOverSockJsProducerSampler;

import java.awt.*;

@Slf4j
public class StompOverSockJsProducerSamplerGui extends AbstractSamplerGui {
    private StompOverSockJsProducerSamplerGuiPanel stompOverSockJsProducerSamplerGuiPanel;

    public StompOverSockJsProducerSamplerGui() {
        initComponents();
    }

    private void initComponents() {
        stompOverSockJsProducerSamplerGuiPanel = new StompOverSockJsProducerSamplerGuiPanel();

        setLayout(new BorderLayout());
        setBorder(makeBorder());

        add(makeTitlePanel(), BorderLayout.NORTH);
        add(stompOverSockJsProducerSamplerGuiPanel, BorderLayout.CENTER);
    }

    @Override
    public String getLabelResource() {
        return "Stomp Over SockJs Producer Sampler";
    }

    @Override
    public String getStaticLabel() {
        return getLabelResource();
    }

    @Override
    public TestElement createTestElement() {
        var sampler = new StompOverSockJsProducerSampler();

        configureTestElement(sampler);

        return sampler;
    }

    @Override
    public void modifyTestElement(TestElement element) {
        super.configureTestElement(element);

        if (element instanceof StompOverSockJsProducerSampler stompOverSockJsProducerSampler) {
            stompOverSockJsProducerSampler.setUri(
                    stompOverSockJsProducerSamplerGuiPanel.getUri().getText()
            );
            stompOverSockJsProducerSampler.setChannel(
                    stompOverSockJsProducerSamplerGuiPanel.getChannel().getText()
            );
            stompOverSockJsProducerSampler.setMessage(
                    stompOverSockJsProducerSamplerGuiPanel.getMessage().getText()
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
