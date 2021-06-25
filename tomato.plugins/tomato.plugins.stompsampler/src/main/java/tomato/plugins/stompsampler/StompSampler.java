package tomato.plugins.stompsampler;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.logging.log4j.util.Strings;

@Slf4j
public class StompSampler extends AbstractSampler {
    private static final String SUCCESS = "Dummy.Success";

    public void setUri(String label) {
        setProperty(
                StompSamplerProperties.URI,
                label
        );
    }

    public String getUri() {
        return getPropertyAsString(
                StompSamplerProperties.URI,
                Strings.EMPTY
        );
    }

    public void setSubscriptionChannel(String subscriptionChannel) {
        setProperty(StompSamplerProperties.SUBSCRIPTION_CHANNEL, subscriptionChannel);
    }

    public String getSubscriptionChannel() {
        return getPropertyAsString(StompSamplerProperties.SUBSCRIPTION_CHANNEL, "");
    }

    public void setMessage(String message) {
        setProperty(StompSamplerProperties.MESSAGE, message);
    }

    public String getMessage() {
        return getPropertyAsString(StompSamplerProperties.MESSAGE, "");
    }

    public void setSuccessful(boolean success) {
        setProperty(SUCCESS, success);
    }

    public boolean getSuccessful() {
        return getPropertyAsBoolean(SUCCESS, true);
    }

    public SampleResult sample(Entry entry) {
        SampleResult result = new SampleResult();

        result.setSampleLabel(getUri());
        result.setResponseCode(getMessage());
        result.setSuccessful(getSuccessful());

        result.sampleStart();
        result.sampleEnd();

        return result;
    }
}
