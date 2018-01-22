package sections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Waiter;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

public class AccountPageSection {
    WebElement baseElement;
    Waiter waiter;

    public AccountPageSection(WebElement baseElement, Waiter waiter) {
        this.baseElement = baseElement;
        this.waiter = waiter;
        this.waiter.waitUntil(elementToBeClickable(By.id("new-customer-radio")));
    }

    public void selectNewCustomer() {
        baseElement.findElement(By.id("new-customer-radio")).click();
    }

    public void typeEmail(String email) {
        baseElement.findElement(By.id("signup-email")).sendKeys(email);
    }

    public void clickOnContinueAndCreateAccountButton() {
        baseElement.findElement(By.id("signup-login")).click();
        this.waiter.waitUntil(invisibilityOfElementLocated(By.className("funnel-sign-in-or-sign-up")));
    }
}
