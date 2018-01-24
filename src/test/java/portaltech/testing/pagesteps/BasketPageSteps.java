package portaltech.testing.pagesteps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import portaltech.automation.framework.model.Flight;
import portaltech.automation.framework.pageobjects.BasketPage;

public class BasketPageSteps extends CommonInitializationSteps {

    BasketPage basketPage;
    Flight from;
    Flight to;

    @Then("^I am on basket page$")
    public void i_am_on_basket_page() throws Throwable {
        basketPage = BasketPage.newPage(browser().getDriver());
    }

    @When("^I pick first available flight from (departure|return) route on (.*)$")
    public void i_pick_first_available_flight_from_and_to(String route, String date) throws Throwable {
        if ("departure".equals(route)) {
            from = basketPage.flightPickerOnDepartureRoute().selectFirstAvailableFlight(date);
        } else {
            to = basketPage.flightPickerOnReturnRoute().selectFirstAvailableFlight(date);
        }
    }

    @When("^I see selected (.*) flight details in the basket on (.*)$")
    public void i_see_selected_flight_details_in_the_basket(String route, String date) throws Throwable {
        if ("departure".equals(route)) {
            Flight actualFrom = basketPage.basket().getDepartureFlightDetails();
            assertFlight(date, from, actualFrom);
        } else {
            Flight actualTo = basketPage.basket().getReturnFlightDetails();
            assertFlight(date, to, actualTo);
        }
    }

    private void assertFlight(String date, Flight expectedFrom, Flight actualFrom) {
        Assert.assertEquals(expectedFrom.getTitle(), actualFrom.getTitle());
        Assert.assertEquals(expectedFrom.getDepartureTime() + " " + date, actualFrom.getDepartureTime());
        Assert.assertEquals(expectedFrom.getArrivalTime(), actualFrom.getArrivalTime());
        Assert.assertEquals(expectedFrom.getFare(), actualFrom.getFare());
    }

    @When("^I pick first available flight from Alicante to London Luton return route$")
    public void i_pick_first_available_flight_from_Alicante_to_London_Luton_return_route() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I click on continue button in the basket section$")
    public void i_click_on_continue_button() throws Throwable {
        basketPage.basket().clickOnContinueButton();
        basketPage = BasketPage.newPage(browser().getDriver());
    }

    @Given("^I skip the (.*) page$")
    public void i_skip_the_page_seat_selection_page(String page) throws Throwable {
        basketPage.waitForPage(page);
        basketPage.basket().skip();
        basketPage = BasketPage.newPage(browser().getDriver());
    }

    @Then("^I accept and continue cabin bags only$")
    public void i_accept_and_continue_cabin_bags_only() throws Throwable {
        basketPage.cabinBag().clickOnAcceptAndContinueButton();
    }

}
