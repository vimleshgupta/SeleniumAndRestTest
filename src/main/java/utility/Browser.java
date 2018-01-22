package utility;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {

    public static final Dimension DESKTOP_RESOLUTION = new Dimension(1920, 1080);
    private final RemoteWebDriver driver;
    private final BrowserContext context;

    public Browser(RemoteWebDriver driver, BrowserContext context) {
        this.driver = driver;
        this.context = context;
        this.driver.manage().window().setSize(DESKTOP_RESOLUTION);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public RemoteWebDriver getDriver() {
        return this.driver;
    }

    public BrowserContext getContext() {
        return context;
    }

    public void navigateToHomePage() {
        driver.get(context.getHotUrl());
    }
}
