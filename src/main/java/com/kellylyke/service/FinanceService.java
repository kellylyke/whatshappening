package com.kellylyke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kellylyke.service.finance.Contributors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class FinanceService implements PropertiesLoader {
    private Properties prop;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String PROP_FILE = "/apiKey.properties";


    public Contributors getFinancialDataForCandidate(String id) throws Exception {
        String firstLink;
        String secondLink;

        Client client = ClientBuilder.newClient();
        prop = loadProperties(PROP_FILE);
        firstLink = prop.getProperty("open_secrets_first");
        secondLink = prop.getProperty("open_secrets_last");

        String uri = firstLink + id + secondLink;


        WebTarget target =
                client.target(uri);
        //client.target("https://www.opensecrets.org/api/?method=candContrib&cid=N00007360&output=json&cycle=2018&apikey=c23c1c3c25533552d3db11fbdb1389dc");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();

        if (response.getStatus() == 200) {
            String responseData = response.readEntity(String.class);

            ObjectMapper mapper = new ObjectMapper();

            com.kellylyke.service.finance.Response results = mapper.readValue(responseData, com.kellylyke.service.finance.Response.class);

            return results.getResponse().getContributors();
        } else {
            return new Contributors();
        }


    }

}