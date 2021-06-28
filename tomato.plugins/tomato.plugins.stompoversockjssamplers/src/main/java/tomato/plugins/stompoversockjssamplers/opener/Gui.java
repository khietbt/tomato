package tomato.plugins.stompoversockjssamplers.opener;

import lombok.extern.slf4j.Slf4j;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

import java.awt.*;

@Slf4j
public class Gui extends AbstractSamplerGui {
    private Panel panel;

    public Gui() {
        initComponents();

        setLayout(new BorderLayout());
        setBorder(makeBorder());

        add(makeTitlePanel(), BorderLayout.NORTH);

        add(panel, BorderLayout.CENTER);
    }

    private void initComponents() {
        panel = new Panel();
    }

    /**
     * Get the component's resource name, which getStaticLabel uses to derive
     * the component's label in the local language. The resource name is fixed,
     * and does not vary with the selected language.
     * <p>
     * Normally this method should be overridden in preference to overriding
     * getStaticLabel(). However where the resource name is not available or required,
     * getStaticLabel() may be overridden instead.
     *
     * @return the resource name
     */
    @Override
    public String getLabelResource() {
        return Properties.LABEL_RESOURCE.getLabel();
    }

    @Override
    public String getStaticLabel() {
        return getLabelResource();
    }

    /**
     * JMeter test components are separated into a model and a GUI
     * representation. The model holds the data and the GUI displays it. The GUI
     * class is responsible for knowing how to create and initialize with data
     * the model class that it knows how to display, and this method is called
     * when new test elements are created.
     *
     * <p>
     * The canonical implementation looks like this:
     * <pre>
     * public TestElement createTestElement() {
     *     TestElementXYZ el = new TestElementXYZ();
     *     modifyTestElement(el);
     *     return el;
     * }
     * </pre>
     *
     * @return the Test Element object that the GUI component represents.
     */
    @Override
    public TestElement createTestElement() {
        var sampler = new Sampler();

        configureTestElement(sampler);

        return sampler;
    }

    /**
     * GUI components are responsible for populating TestElements they create
     * with the data currently held in the GUI components. This method should
     * overwrite whatever data is currently in the TestElement as it is called
     * after a user has filled out the form elements in the gui with new
     * information.
     *
     * <p>
     * The canonical implementation looks like this:
     * <pre>
     * public void modifyTestElement(TestElement element) {
     *     element.clear(); // many implementations use this
     *     configureTestElement(element);
     *     // Using the element setters (preferred):
     *     TestElementXYZ xyz = (TestElementXYZ) element;
     *     xyz.setState(guiState.getText());
     *     xyz.setCode(guiCode.getText());
     *     ... other GUI fields ...
     *     // or directly (do not use unless there is no setter for the field):
     *     element.setProperty(TestElementXYZ.STATE, guiState.getText())
     *     element.setProperty(TestElementXYZ.CODE, guiCode.getText())
     *     ... other GUI fields ...
     * }
     * </pre>
     *
     * @param element the TestElement to modify
     */
    @Override
    public void modifyTestElement(TestElement element) {
        super.configureTestElement(element);

        if (element instanceof Sampler sampler) {
            sampler.setUri(panel.getUri().getText());
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
