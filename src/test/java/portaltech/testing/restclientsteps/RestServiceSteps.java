package portaltech.testing.restclientsteps;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import portaltech.automation.framework.model.Country;
import portaltech.testing.pagesteps.CommonInitializationSteps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class RestServiceSteps extends CommonInitializationSteps {

    String url;
    Response response;

    @Given("^I have countries service url to get all countries$")
    public void i_have_countries_service_url_to_get_all_countries() throws Throwable {
        String baseUrl = getProperties().getProperty("countriesService.baseUrl");
        String basePath = getProperties().getProperty("countriesService.basePath");
        String allCountries = getProperties().getProperty("countriesService.all");
        this.url = baseUrl + basePath + allCountries;
    }

    @Given("^I have countries service url to get (.*) country details$")
    public void i_have_countries_service_url_to_get_country_detail(String countryName) throws Throwable {
        String baseUrl = getProperties().getProperty("countriesService.baseUrl");
        String basePath = getProperties().getProperty("countriesService.basePath");
        String specificCountry = getProperties().getProperty("countriesService.specificCountry");
        this.url = baseUrl + basePath + String.format(specificCountry, countryName);
    }

    @Given("^I request to get details$")
    public void i_request_to_get_all_countries() throws Throwable {
        response = given().when().get(url).then().extract().response();
    }

    @Then("^I get status code as (\\d+)$")
    public void the_status_code_is(int statuscode) {
        Assert.assertEquals(statuscode, response.getStatusCode());
    }

    @Given("^I get total (\\d+) countries$")
    public void i_see_total_20_countries(int total) throws Throwable {
        List<Country> countries = Arrays.asList(response.getBody().as(Country[].class));
        Assert.assertEquals(total, countries.size());
    }

    @Then("^I verify following country's details$")
    public void i_verify_following_country_details(Map<String, String> data) throws Throwable {

        List<Country> countries = Arrays.asList(response.getBody().as(Country[].class));
        Country country = countries.get(0);

        Assert.assertEquals(data.get("name"), country.getName());
        Assert.assertEquals(data.get("topLevelDomain"), country.getTopLevelDomain().toString());
        Assert.assertEquals(data.get("alpha2Code"), country.getAlpha2Code());
        Assert.assertEquals(data.get("alpha3Code"), country.getAlpha3Code());
        Assert.assertEquals(data.get("callingCodes"), country.getCallingCodes().toString());
        Assert.assertEquals(data.get("capital"), country.getCapital());
        Assert.assertEquals(data.get("altSpellings"), country.getAltSpellings().toString());
        Assert.assertEquals(data.get("region"), country.getRegion());
        Assert.assertEquals(data.get("subregion"), country.getSubregion());
        Assert.assertEquals(data.get("population"), String.valueOf(country.getPopulation()));
        Assert.assertEquals(data.get("latlng"), country.getLatlng().toString());
        Assert.assertEquals(data.get("demonym"), country.getDemonym());
        Assert.assertEquals(data.get("area"), String.valueOf(country.getArea()));
        Assert.assertEquals(data.get("gini"), String.valueOf(country.getGini()));
        Assert.assertEquals(data.get("timezones"), country.getTimezones().toString());
        Assert.assertEquals(data.get("borders"), country.getBorders().toString());
        Assert.assertEquals(data.get("nativeName"), country.getNativeName());
        Assert.assertEquals(data.get("numericCode"), country.getNumericCode());
        Assert.assertEquals(data.get("currencies"), country.getCurrencies().toString());
        Assert.assertEquals(data.get("languages"), country.getLanguages().toString());
        Assert.assertEquals(data.get("translations"), country.getTranslations().toString());
        Assert.assertEquals(data.get("relevance"), country.getRelevance());
    }
}
