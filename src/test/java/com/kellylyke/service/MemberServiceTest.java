package com.kellylyke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import com.kellylyke.service.*;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {


    Properties properties = new Properties();
    private String propFile = "/home/klyke/student/IdeaProjects/whatshappening/src/main/resources/apiKey.properties";
    private  String key;

    @Test
    public void getAllMembersJSON() throws Exception {


        try (InputStream input = new FileInputStream(propFile)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            key = prop.getProperty("propublica_key");
        } catch (Exception exception) {
            exception.printStackTrace();

        }

        Client client = ClientBuilder.newClient();


        //Feature feature = OAuth2ClientSupport.feature("EjcU3jawD3adUpd3uSvrEmohhU64va19IQBoXY4J");
        // client.register(feature);
        WebTarget target =
                client.target("https://api.propublica.org/congress/v1/115/senate/members.json");

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header("x-api-key", key);

        Response response = invocationBuilder.get();
        String responseData = response.readEntity(String.class);

        // target.request(MediaType.APPLICATION_JSON).get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(responseData, Results.class);

        assertEquals("???", responseData);


    }


}



