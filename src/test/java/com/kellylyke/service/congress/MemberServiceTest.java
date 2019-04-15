package com.kellylyke.service.congress;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;

import java.io.FileInputStream;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class MemberServiceTest {

    private String key;
    private String senateMembersLink;
    private String houseMembersLink;
    private Properties prop = new Properties();

    @BeforeEach
    private void getKey() {
        String propFile = "src/main/resources/apiKey.properties";

        try (InputStream input = new FileInputStream(propFile)) {
            prop.load(input);

            key = prop.getProperty("propublica_key");
            senateMembersLink = prop.getProperty("senate_members_link");
            houseMembersLink = prop.getProperty("house_members_link");

        } catch (Exception exception) {
            exception.printStackTrace();

        }

    }


    @Test
    public void getSenateMembersJSON() throws Exception { //TODO: handle this
        Client client = ClientBuilder.newClient();

        WebTarget target =
                client.target(senateMembersLink);

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header("x-api-key", key);

        Response response = invocationBuilder.get();
        String responseData = response.readEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(responseData, Results.class);

        List<ResultsItem> resultsItem = new ArrayList<ResultsItem>();
        resultsItem = results.getResults();
        List<MembersItem> members = new ArrayList<MembersItem>();
        members = resultsItem.get(0).getMembers();
        int size = resultsItem.get(0).getNumResults();

        assertEquals(105, size);
        //fun fact: it's 105 and not 100 because it includes those who resigned (or died) during their term (i.e. Al Franken, John McCain)

    }


    @Test
    public void getHouseMembersJSON() throws Exception { //TODO: handle this and reuse code

        Client client = ClientBuilder.newClient();

        WebTarget target =
                client.target(houseMembersLink);

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header("x-api-key", key);

        Response response = invocationBuilder.get();
        String responseData = response.readEntity(String.class);

        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(responseData, Results.class);

        List<ResultsItem> resultsItem = new ArrayList<ResultsItem>();
        resultsItem = results.getResults();
        List<MembersItem> members = new ArrayList<MembersItem>();
        members = resultsItem.get(0).getMembers();
        int size = resultsItem.get(0).getNumResults();

        assertEquals(456, size);

    }

}



