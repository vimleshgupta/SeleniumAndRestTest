package portaltech.testing.pagesteps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import portaltech.automation.framework.model.ContactDetails;
import portaltech.automation.framework.pageobjects.CheckoutPage;
import portaltech.automation.framework.sections.ContactDetailsSection;

import java.util.List;
import java.util.Map;

public class CheckoutPageSteps extends CommonInitializationSteps {

    CheckoutPage checkoutPage;


    @Then("^I am on checkout page$")
    public void i_am_on_checkout_page() throws Throwable {
        checkoutPage = CheckoutPage.newPage(browser().getDriver());
    }

    @Then("^I select new user and enter my email addrresss: (.*)$")
    public void i_selct_new_user_and_enter_my_email_addrresss(String email) throws Throwable {
        checkoutPage.accountSection().selectNewCustomer();
        checkoutPage.accountSection().typeEmail(email);
    }

    @Then("^I see Booker's contact details section$")
    public void i_see_Booker_s_contact_details_section() throws Throwable {
        Assert.assertTrue(checkoutPage.contactDetailsSection().isDisplayed());
    }

    @Then("^I enter following Booker's contact details$")
    public void i_enter_following_Booker_s_contact_details(DataTable data) throws Throwable {
        ContactDetailsSection contactDetailsSection = checkoutPage.contactDetailsSection();
        for (List<String> row : data.raw()) {
            String field = row.get(0);
            String value = row.get(1);
            switch (field) {
                case "Title":
                    contactDetailsSection.selectTitle(value);
                    break;
                case "Firstname":
                    contactDetailsSection.typeFirstName(value);
                    break;
                case "Sirname":
                    contactDetailsSection.typeSurname(value);
                    break;
                case "Password":
                    contactDetailsSection.typePasssword(value);
                    break;
                case "Address":
                    contactDetailsSection.typeAddress(value);
                    break;
                case "Town/City":
                    contactDetailsSection.typeTownOrCity(value);
                    break;
                case "Postcode":
                    contactDetailsSection.typePostcode(value);
                    break;
                case "Telephone number":
                    contactDetailsSection.typeTelephoneNumber(value);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown field name: " + field);
            }
        }
    }

    @When("^I click on continue button for (.*) in the checkout page")
    public void i_click_on_continue_button(String section) throws Throwable {
        if ("sign up".equals(section)) {
            checkoutPage.accountSection().clickOnContinueAndCreateAccountButton();
        } else if ("Passenger details".equals(section)) {
            checkoutPage.passengerDetailsSection().clickOnContinueButton();
        } else {
            checkoutPage.contactDetailsSection().clickOnContinueButton();
        }
    }

    @Then("^I see (.*) section is done$")
    public void i_see_Booker_s_contact_details_section_is_done(String section) throws Throwable {
        if ("Passenger details".equals(section)) {
            Assert.assertTrue(checkoutPage.passengerDetailsSection().isDone());
        } else {
            Assert.assertTrue(checkoutPage.contactDetailsSection().isDone());
        }
    }

    @Then("^I following information in the Booker's contact details section$")
    public void i_following_information_in_the_Booker_s_contact_details_section(DataTable data) throws Throwable {
        ContactDetails contactDetails = checkoutPage.contactDetailsSection().getContactDetails();
        for (List<String> row : data.raw()) {
            String field = row.get(0);
            String value = row.get(1);
            switch (field) {
                case "Name":
                    Assert.assertEquals(value, contactDetails.getName());
                    break;
                case "Email":
                    Assert.assertEquals(value, contactDetails.getEmail());
                    break;
                case "Country":
                    Assert.assertEquals(value, contactDetails.getCountry());
                    break;
                case "Mobile":
                    Assert.assertEquals(value, contactDetails.getMobile());
                    break;
                case "Address":
                    Assert.assertEquals(value, contactDetails.getAddress());
                    break;
                default:
                    throw new IllegalArgumentException("Unknown field name: " + field);
            }
        }
    }

    @Then("^I see Passenger details section$")
    public void i_see_Passenger_details_section() throws Throwable {
        Assert.assertTrue(checkoutPage.passengerDetailsSection().isDisplayed());
    }

    @Then("^I select (.*) as reason for travel$")
    public void i_select_Leisure_as_reason_for_travel(String reason) throws Throwable {
        checkoutPage.passengerDetailsSection().selectReasonForTravel(reason);
    }

    @Then("^I enter following passenger details$")
    public void i_enter_following_passenger_details(List<Map<String, String>> details) throws Throwable {
        for (Map<String, String> map : details) {
            if (map.containsKey("Title"))
                checkoutPage.passengerDetailsSection().selectTitle(map.get("Title"));
            if (map.containsKey("Firstname"))
                checkoutPage.passengerDetailsSection().typeFirstname(map.get("Firstname"));
            if (map.containsKey("Lastname"))
                checkoutPage.passengerDetailsSection().typeLastname(map.get("Lastname"));
            if (map.containsKey("Age"))
                checkoutPage.passengerDetailsSection().selectAge(map.get("Age"));
        }
    }

    @Then("^I see passenger details in the Passenger details section: (.*)$")
    public void i_following_information_in_the_Passenger_details_section_vimlesh_gupta_aged(String details) throws Throwable {
        Assert.assertEquals(details, checkoutPage.passengerDetailsSection().getDetails());
    }
}
