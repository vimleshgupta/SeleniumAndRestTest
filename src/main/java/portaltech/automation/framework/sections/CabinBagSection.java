package portaltech.automation.framework.sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import portaltech.automation.framework.utility.Waiter;

/**
 * Created by cts1 on 22/1/18.
 */
public class CabinBagSection {

    By cabinBagSectionlocator = By.cssSelector("[data-section-key=\"luggage-cabin-bag-info\"]");

    WebElement baseElement;
    Waiter waiter;

    public CabinBagSection(RemoteWebDriver driver, Waiter waiter) {
        this.waiter = waiter;
        this.baseElement = driver.findElement(cabinBagSectionlocator);
    }

    public void clickOnAcceptAndContinueButton() {
        baseElement.findElement(By.cssSelector("[value=\"Accept & Continue >\"]")).click();
    }
}
