package utility;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Runtime.getRuntime;
import static java.lang.System.out;

public class BrowserFactory {

    private static final int IMPLICIT_WAIT_TIMEOUT_IN_SECONDS = 3;

    static {
        getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    driver.quit();
                } catch (Exception e) {
                    out.println(e.getMessage());
                }
            }
        });
    }

    private static Browser browser;
    private static RemoteWebDriver driver;

    public Browser create() {

        if (browser == null) {
            DesiredCapabilities firefoxDriverCapabilities = DesiredCapabilities.firefox();
            firefoxDriverCapabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
            driver = new FirefoxDriver(firefoxDriverCapabilities);
            driver.manage()
                    .timeouts()
                    .implicitlyWait(IMPLICIT_WAIT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);

            BrowserContext context = new BrowserContext();
            browser = new Browser(driver, context);
        }
        return browser;
    }
}
