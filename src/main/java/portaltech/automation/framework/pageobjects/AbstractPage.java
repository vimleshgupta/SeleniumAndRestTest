package portaltech.automation.framework.pageobjects;

import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import portaltech.automation.framework.utility.Waiter;

public abstract class AbstractPage {

    protected final RemoteWebDriver driver;
    protected final Waiter waiter;

    protected AbstractPage(RemoteWebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
        this.waiter.waitUntil(pageIsLoaded());
        this.waiter.waitUntil(allAngularAjaxRequestComplete());
    }

    public void closeCookiePolicySection() {
        try {
            if (driver.findElement(By.id("close-drawer-link")).isDisplayed())
                driver.findElement(By.id("close-drawer-link")).click();
        } catch (NoSuchElementException e) {
            // ignore
        }
    }

    public Predicate<WebDriver> pageIsLoaded() {
        return new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
    }

    public Predicate<WebDriver> allAngularAjaxRequestComplete() {
        return new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver driver) {
                try {
                    return (Boolean) ((JavascriptExecutor) driver).executeScript("return angular.element('*[ng-app]').injector().get('$http').pendingRequests.length == 0");
                } catch (Exception e) {
                    return false;
                }
            }
        };
    }

}
