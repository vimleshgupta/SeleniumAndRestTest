package pagesteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriverException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class CucumberGlobalHooks extends CommonInitializationSteps {

    @Before
    public void before_every_scenario(Scenario scenario) {
        System.out.println("Executing : " + scenario.getName());
    }

    @After
    public void clearContext(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                String fileName = browser().getContext().getScreenshotPath() + scenario.getName() + ".jpg";
                try {
                    Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                    BufferedImage img = new Robot().createScreenCapture(rect);
                    File output = new File(fileName);
                    File parent = output.getParentFile();
                    if (!parent.exists()) parent.mkdirs();
                    ImageIO.write(img, "jpg", output);
                    System.out.println("Saved screenshot to " + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (Exception cce) {
                cce.printStackTrace();
            }
        }
    }
}
