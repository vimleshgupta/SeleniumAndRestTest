package pagesteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.HomePage;

import java.util.List;

public class HomePageSteps extends CommonInitializationSteps {

    HomePage homePage;

    @Given("^I navigate to home page$")
    public void i_navigate_to_home_page() throws Throwable {
        browser().navigateToHomePage();
        homePage = HomePage.newPage(browser().getDriver());
        homePage.closeCookiePolicySection();
    }

    @When("^I enter following details for flight$")
    public void i_enter_following_details_for_flight(DataTable data) throws Throwable {
        for (List<String> row: data.raw()) {
            String field = row.get(0);
            String value = row.get(1);
            switch (field) {
                case "From":
                    homePage.flightTab().selectFrom(value);
                    break;
                case "To":
                    homePage.flightTab().selectTo(value);
                    break;
                case "DepartureDate":
                    homePage.flightTab().clickOnDepartureDateButton();
                    homePage.datePicker().selectDate(value);
                    break;
                case "ReturnDate":
                    homePage.flightTab().clickOnReturnDateButton();
                    homePage.datePicker().selectDate(value);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown field name: " + field);
            }
        }
    }

    @When("^I see quantity as (.*) in adults passanger section$")
    public void i_see_quantity_as_in_adults_passanger_section(String quantity) throws Throwable {
        Assert.assertEquals(quantity, homePage.flightTab().getAdultsQuantity());
    }

    @When("^I click on show flights button$")
    public void i_click_on_show_flights_button() throws Throwable {
        homePage.flightTab().clickOnShowFlightsButton();
    }

    @Then("^I see (.*) error$")
    public void i_see_destination_error_Please_select_a_destination(String field) throws Throwable {
        if("destination".equals(field)) {
            Assert.assertTrue(homePage.flightTab().isDestinationErrorDisplayed());
        } else if ("departure date".equals(field)) {
            Assert.assertTrue(homePage.flightTab().isDepartureDateErrorDisplayed());
        } else if ("return date".equals(field)) {
            Assert.assertTrue(homePage.flightTab().isReturnDateErrorDisplayed());
        }
    }

    @When("^I choose one way$")
    public void i_choose_one_way() throws Throwable {
        homePage.flightTab().chooseOneway();
    }
}
