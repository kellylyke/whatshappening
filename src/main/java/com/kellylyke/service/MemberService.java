package com.kellylyke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kellylyke.service.congress.MembersItem;
import com.kellylyke.service.congress.Results;
import com.kellylyke.service.congress.ResultsItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemberService {
    private String key;
    private String senateMembersLink;
    private String houseMembersLink;
    private Properties prop = new Properties();
    private final Logger logger = LogManager.getLogger(this.getClass());

//    public static void main(String[] args) throws Exception {
//      MemberService please= new MemberService();
//       please.getSpecificMember("Baldwin");
//    }

    private void getKey() { //TODO:refactor to take param of prop name and return link
        String propFile = "/home/klyke/student/IdeaProjects/whatshappening/src/main/resources/apiKey.properties"; //obivously change this

        try (InputStream input = new FileInputStream(propFile)) {
            prop.load(input);

            key = prop.getProperty("propublica_key");
            senateMembersLink = prop.getProperty("senate_members_link");
            houseMembersLink = prop.getProperty("house_members_link");

        } catch (Exception exception) {
            logger.error("There was an error getting properties. " + exception);
        }

    }

    public List<MembersItem> getSenateMembersJSON() throws Exception { //TODO: handle this
        Client client = ClientBuilder.newClient();
        getKey();
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
        return members;

    }

    public MembersItem getSpecificMember(String searchTerm) throws Exception{
        //searchTerm = "Baldwin";
        logger.info(searchTerm);
        MembersItem chosenMember = null;
        List<MembersItem> membersList = getSenateMembersJSON();

        for(MembersItem member : membersList) {
            if(searchTerm.equals(member.getLastName())) {
                chosenMember = member;
            }
        }
        logger.info(chosenMember);
        return chosenMember;
    }

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



    }

}
