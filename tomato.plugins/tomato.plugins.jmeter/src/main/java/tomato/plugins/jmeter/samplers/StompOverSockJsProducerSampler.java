package tomato.plugins.jmeter.samplers;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import tomato.plugins.jmeter.clients.StompOverSockJsClient;
import tomato.plugins.jmeter.properties.StompOverSockJsProducerSamplerGuiPanelProperties;

@Slf4j
@SuppressWarnings("unused")
public class StompOverSockJsProducerSampler extends AbstractSampler {
    /**
     * Obtains statistics about the given Entry, and packages the information
     * into a SampleResult.
     *
     * @param e the Entry
     * @return information about the sample
     */
    @Override
    public SampleResult sample(Entry e) {
        SampleResult result = new SampleResult();

        result.setSampleLabel(getName());
        result.setDataEncoding("UTF-8");

        result.sampleStart();

        /* Inputs. */
        final String uri = getUri();
        final String channel = getChannel();
        final String message = getMessage();

        log.debug("Input uri = {}", uri);
        log.debug("Channel = {}", channel);
        log.debug("Message = {}", message);

        var client = new StompOverSockJsClient(uri);

        client.connect();

        client.send(channel, message);

        result.sampleEnd();

        return result;
    }

    @Override
    public void removed() {
        super.removed();
    }

    public String getUri() {
        return getPropertyAsString(StompOverSockJsProducerSamplerGuiPanelProperties.URI.name());
    }

    public void setUri(String uri) {
        setProperty(StompOverSockJsProducerSamplerGuiPanelProperties.URI.name(), uri);
    }

    public String getChannel() {
        return getPropertyAsString(StompOverSockJsProducerSamplerGuiPanelProperties.CHANNEL.name());
    }

    public void setChannel(String channel) {
        setProperty(StompOverSockJsProducerSamplerGuiPanelProperties.CHANNEL.name(), channel);
    }

    public String getMessage() {
        return getPropertyAsString(StompOverSockJsProducerSamplerGuiPanelProperties.MESSAGE.name());
    }

    public void setMessage(String message) {
        setProperty(StompOverSockJsProducerSamplerGuiPanelProperties.MESSAGE.name(), message);
    }
}
