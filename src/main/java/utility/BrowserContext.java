package utility;

public class BrowserContext {
    private final String screenShotPath;

    public BrowserContext() {
        this.screenShotPath = System.getProperty("screenShotPath", System.getProperty("user.dir") + "/seleniumscreenshots/");
    }

    public String getScreenshotPath() {
        return screenShotPath;
    }
}
