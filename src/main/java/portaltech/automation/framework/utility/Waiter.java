package portaltech.automation.framework.utility;

import com.google.common.base.Predicate;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {

    private final int MAX_WAIT_TIME = 5;
    private final WebDriver driver;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntil(ExpectedCondition<?> condition) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME, 100);
        wait.ignoring(NoSuchElementException.class);
        wait.until(condition);
    }

    public void waitUntil(Predicate<WebDriver> condition) {
        WebDriverWait wait = new WebDriverWait(driver, MAX_WAIT_TIME, 100);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.until(condition);
    }
}
