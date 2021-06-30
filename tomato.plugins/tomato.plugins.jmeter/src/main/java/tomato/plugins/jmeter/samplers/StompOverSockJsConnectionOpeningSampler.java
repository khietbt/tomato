package tomato.plugins.jmeter.samplers;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import tomato.plugins.jmeter.clients.StompOverSockJsClient;
import tomato.plugins.jmeter.properties.StompOverSockJsConnectionOpeningSamplerGuiPanelProperties;

@Slf4j
public class StompOverSockJsConnectionOpeningSampler extends AbstractSampler {
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

        var client = new StompOverSockJsClient(uri);

        try {
            client.connect();

            result.setResponseMessage("Connected successfully!");
            result.setSuccessful(true);
        } catch (Exception exception) {
            result.setResponseMessage("Connection refused: " + exception.getMessage());
            result.setSuccessful(false);
        }

        result.sampleEnd();

        return result;
    }

    /**
     * Called when the test element is removed from the test plan.
     * Must not throw any exception
     */
    @Override
    public void removed() {
        super.removed();
    }

    public String getUri() {
        return getPropertyAsString(StompOverSockJsConnectionOpeningSamplerGuiPanelProperties.URI.name());
    }

    public void setUri(String uri) {
        setProperty(StompOverSockJsConnectionOpeningSamplerGuiPanelProperties.URI.name(), uri);
    }
}
