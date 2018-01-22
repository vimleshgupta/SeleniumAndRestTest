package pagesteps;

import utility.Browser;
import utility.BrowserFactory;

public class CommonInitializationSteps {

    private final BrowserFactory factory = new BrowserFactory();

    protected final Browser browser() {
        return factory.create();
    }
}
