package com.kellylyke.service.congress;

import com.fasterxml.jackson.databind.ObjectMapper;

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

    private  String key;
    private  Properties prop = new Properties();

    private String getKey() {
        String propFile = "src/main/resources/apiKey.properties";

        try (InputStream input = new FileInputStream(propFile)) {
            prop.load(input);

            key = prop.getProperty("propublica_key");
        } catch (Exception exception) {
            exception.printStackTrace();

        }

        return key;
    }


    @Test
    public void getSenateMembersJSON() throws Exception { //TODO: handle this
        String key = getKey();

        Client client = ClientBuilder.newClient();

        WebTarget target =
                client.target("https://api.propublica.org/congress/v1/115/senate/members.json");

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

        assertEquals(105, size); //not sure exactly why there are 105 and not 100 but that's what postman says


    }


}



