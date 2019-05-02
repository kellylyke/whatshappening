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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Properties;

public class FinanceService implements PropertiesLoader{
    private Properties prop;
    private final Logger logger = LogManager.getLogger(this.getClass());


    public Contributors getFinancialDataForCandidate(String id) throws IOException, URISyntaxException {
        String firstLink;
        String secondLink;
        //String hardid = "N00007360";
        Client client = ClientBuilder.newClient();
         prop = getProperties();
        firstLink = prop.getProperty("open_secrets_first");
        secondLink = prop.getProperty("open_secrets_last");

        String uri = firstLink + id + secondLink;


        logger.info(uri);

        WebTarget target =
               client.target(uri);
                //client.target("https://www.opensecrets.org/api/?method=candContrib&cid=N00007360&output=json&cycle=2018&apikey=c23c1c3c25533552d3db11fbdb1389dc");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        String responseData = response.readEntity(String.class);


        ObjectMapper mapper = new ObjectMapper();

        com.kellylyke.service.finance.Response results = mapper.readValue(responseData, com.kellylyke.service.finance.Response.class);


        return results.getResponse().getContributors();

   }


    /**
     * Loads properties for the application
     *
     * @return properties for the application
     */
    private Properties getProperties() {
        // Load properties
        Properties prop = new Properties();

        try {
            prop = loadProperties("/apiKey.properties");
        } catch (IOException ioException) {
            logger.error(ioException.getMessage());
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        return prop;
    }
}
