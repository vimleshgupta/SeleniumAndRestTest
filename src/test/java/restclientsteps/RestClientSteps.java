package restclientsteps;

import com.sun.jersey.api.client.ClientResponse;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import rest.RestClient;

public class RestClientSteps {

    RestClient restClient = new RestClient();
    String url;

    @Given("^I have countries sevice url: (.*)$")
    public void i_have_countries_sevice_url_https_restcountries_eu_rest_v_all(String url) throws Throwable {
        this.url = url;
    }

    @Given("^I get list of all the countries$")
    public void i_get_list_of_all_the_countries() throws Throwable {
        ClientResponse clientResponse = restClient.get(url, "application/json");
        assert clientResponse.getStatus() == 200;
    }

    @Then("^I verify following country details$")
    public void i_verify_following_country_details(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }


}
