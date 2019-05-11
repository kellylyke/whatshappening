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
import java.util.Properties;

/**
 * service that calls to the financial data api
 * @author klyke
 */
public class FinanceService implements PropertiesLoader {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String PROP_FILE = "/apiKey.properties";

    /**
     * calls api to get data for candidate
     *
     * @param id of candidate
     * @return contributors to candidate
     * @throws IOException read/write exception
     */
    public Contributors getFinancialDataForCandidate(String id) throws IOException {
        Client client = ClientBuilder.newClient();
        Properties prop = loadProperties(PROP_FILE);

        String uri = prop.getProperty("open_secrets_first") + id + prop.getProperty("open_secrets_last");

        WebTarget target = client.target(uri);
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();

        if (response.getStatus() == 200) {
            String responseData = response.readEntity(String.class);

            ObjectMapper mapper = new ObjectMapper();

            com.kellylyke.service.finance.Response results = mapper.readValue(responseData, com.kellylyke.service.finance.Response.class);

            return results.getResponse().getContributors();
        } else {
            logger.error("Service returned error: " + response.getStatus());
            return new Contributors();
        }


    }

}