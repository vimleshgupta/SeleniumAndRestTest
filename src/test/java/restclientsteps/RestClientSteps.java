package restclientsteps;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.ClientResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import model.Country;
import org.junit.Assert;
import rest.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestClientSteps {

    RestClient restClient = new RestClient();
    String url;
    List<Country> countries;

    @Given("^I have countries service url: (.*)$")
    public void i_have_countries_service_url_https_restcountries_eu_rest_v_all(String url) throws Throwable {
        this.url = url;
    }

    @Given("^I get list of all the countries$")
    public void i_get_list_of_all_the_countries() throws Throwable {
        ClientResponse clientResponse = restClient.get(url, "application/json");
        assert clientResponse.getStatus() == 200;
        String data = clientResponse.getEntity(String.class);
        countries = new Gson().fromJson(data, new TypeToken<ArrayList<Country>>() {
        }.getType());
    }

    @Given("^I see total (\\d+) countries$")
    public void i_see_total_20_countries(int total) throws Throwable {
        Assert.assertEquals(total, countries.size());
    }

    @Then("^I verify following country's details$")
    public void i_verify_following_country_details(Map<String, String> data) throws Throwable {
        for (Country country : countries) {
            if (country.getName().equals(data.get("name"))) {
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
    }


}
