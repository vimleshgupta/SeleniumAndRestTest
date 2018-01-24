package portaltech.testing.pagesteps;

import portaltech.automation.framework.utility.Browser;
import portaltech.automation.framework.utility.BrowserFactory;
import portaltech.testing.utility.PropertiesHelper;

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
