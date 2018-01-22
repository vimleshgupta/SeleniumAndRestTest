package utility;

import org.openqa.selenium.Dimension;

public class BrowserContext {
    private final String hostUrl;
    private final String screenShotPath;

    public BrowserContext() {
        this.screenShotPath = System.getProperty("screenShotPath", System.getProperty("user.dir") + "/seleniumscreenshots/");
        this.hostUrl = System.getProperty("qa.hostName", "https://www.easyjet.com");
    }

    public String getScreenshotPath() {
        return screenShotPath;
    }

    public String getHotUrl() {
        return hostUrl;
    }
}
