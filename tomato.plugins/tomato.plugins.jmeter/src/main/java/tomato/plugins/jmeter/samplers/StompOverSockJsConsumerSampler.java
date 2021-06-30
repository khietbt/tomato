package tomato.plugins.jmeter.samplers;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import tomato.plugins.jmeter.clients.StompOverSockJsClient;
import tomato.plugins.jmeter.properties.StompOverSockJsConsumerSamplerGuiPanelProperties;

@Slf4j
@SuppressWarnings("unused")
public class StompOverSockJsConsumerSampler extends AbstractSampler {
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

        final String uri = getUri();
        final String channel = getChannel();
        final int timeout = getTimeout();

        log.error("Uri = {}", uri);
        log.error("Channel = {}", channel);
        log.error("Timeout = {}", timeout);

        var client = new StompOverSockJsClient(uri);

        try {
            client.connect();

            client.subscribe(channel);

            Thread.sleep(timeout * 1000L);

            result.setResponseMessage(String.join("\n", client.getLogs()));
            result.setSuccessful(true);
        } catch (Exception exception) {
            var logs = client.getLogs();
            logs.add("ERROR: " + exception.getMessage());

            result.setSuccessful(false);
            result.setResponseMessage(String.join("\n", logs));
        } finally {
            client.disconnect();
        }

        result.sampleEnd();

        return result;
    }

    @Override
    public void removed() {
        super.removed();
    }

    public String getUri() {
        return getPropertyAsString(StompOverSockJsConsumerSamplerGuiPanelProperties.URI.name());
    }

    public void setUri(String uri) {
        setProperty(StompOverSockJsConsumerSamplerGuiPanelProperties.URI.name(), uri);
    }

    public String getChannel() {
        return getPropertyAsString(StompOverSockJsConsumerSamplerGuiPanelProperties.CHANNEL.name());
    }

    public void setChannel(String channel) {
        setProperty(StompOverSockJsConsumerSamplerGuiPanelProperties.CHANNEL.name(), channel);
    }

    public int getTimeout() {
        return getPropertyAsInt(StompOverSockJsConsumerSamplerGuiPanelProperties.TIMEOUT.name());
    }

    public void setTimeout(int timeout) {
        setProperty(StompOverSockJsConsumerSamplerGuiPanelProperties.TIMEOUT.name(), timeout);
    }
}

