package com.kellylyke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Properties;

public class FinanceService {
    private String firstLink;
    private String secondLink;

    private Properties prop = new Properties();
    private final Logger logger = LogManager.getLogger(this.getClass());


    private void getKey() { //TODO:refactor to take param of prop name and return link
        String propFile = "/home/klyke/student/IdeaProjects/whatshappening/src/main/resources/apiKey.properties"; //obivously change this

        try (InputStream input = new FileInputStream(propFile)) {
            prop.load(input);
            firstLink = prop.getProperty("open_secrets_first");
            secondLink =  prop.getProperty("open_secrets_last");

        } catch (Exception exception) {
            logger.error("There was an error getting properties. " + exception);
        }

    }

    public com.kellylyke.service.finance.Response getFinancialDataForCandidate(String id) throws IOException {
       // String hardid = "N00007360";
        Client client = ClientBuilder.newClient();
        getKey();
        WebTarget target =
               client.target(firstLink + id + secondLink);
                //client.target("https://www.opensecrets.org/api/?method=candContrib&cid=N00007360&output=json&cycle=2018&apikey=c23c1c3c25533552d3db11fbdb1389dc");
        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.get();
        String responseData = response.readEntity(String.class);

      //  logger.info(responseData);
//        XmlMapper xmlMapper = new XmlMapper();
//        com.kellylyke.service.finance.Response results = xmlMapper.readValue(responseData, com.kellylyke.service.finance.Response.class);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(responseData);

        ObjectMapper mapper = new ObjectMapper();

        com.kellylyke.service.finance.Response results = mapper.readValue(responseData, com.kellylyke.service.finance.Response.class);

        //logger.info(results);
        return results;

    }
}
