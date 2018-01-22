package rest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestClient {

    Client client = Client.create();

    public ClientResponse get(String path, String accept) {
        WebResource webResource = client.resource(path);
        return webResource.accept(accept).get(ClientResponse.class);
    }
}