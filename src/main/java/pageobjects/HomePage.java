package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import sections.DatePicker;
import sections.FlightTabSection;

public class HomePage extends AbstractPage {

    public HomePage(RemoteWebDriver driver) {
        super(driver);
    }

    public static HomePage newPage(RemoteWebDriver driver) {
        return new HomePage(driver);
    }

    public FlightTabSection flightTab() {
        return new FlightTabSection(driver.findElement(By.name("searchPodForm")), waiter);
    }

    public DatePicker datePicker() {
        return new DatePicker(driver.findElement(By.className("routedatepicker")), waiter);
    }
}
