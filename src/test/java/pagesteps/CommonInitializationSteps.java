package pagesteps;

import utility.Browser;
import utility.BrowserFactory;
import utility.PropertiesHelper;

import java.util.Properties;

public class CommonInitializationSteps {

    private final BrowserFactory factory = new BrowserFactory();
    private final PropertiesHelper propertiesHelper = PropertiesHelper.newInstance();

    protected final Browser browser() {
        return factory.create();
    }

    protected Properties getProperties() {
        return propertiesHelper.getProperties();
    }
}
