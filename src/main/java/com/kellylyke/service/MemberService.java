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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemberService implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String PROP_FILE = "/apiKey.properties";


    public List<MembersItem> getSpecificMember(String searchTerm) throws Exception{
        logger.info(searchTerm);
        List<MembersItem> searchedMembers = new ArrayList<>();
        List<MembersItem> senateList = getMemberJSON(getSenateLink());
        List<MembersItem> houseList = getMemberJSON(getHouseLink());

        for(MembersItem member : senateList) {
            if(searchTerm.equals(member.getLastName())) {
                searchedMembers.add(member);
            }
        }
        for(MembersItem member : houseList) {
            if(searchTerm.equals(member.getLastName())) {
                searchedMembers.add(member);
            }
        }

        logger.info(searchedMembers);
        return searchedMembers;
    }

    private String getHouseLink() throws Exception {
        Properties prop = loadProperties(PROP_FILE);

        return prop.getProperty("house_members_link");
    }

    private String getSenateLink() throws Exception {
        Properties prop = loadProperties(PROP_FILE);

        return prop.getProperty("senate_members_link");
    }



    public MembersItem getMemberByID(String id) throws Exception {
        MembersItem chosenMember = null;

        List<MembersItem> senateList = getMemberJSON(getSenateLink());
        List<MembersItem> houseList = getMemberJSON(getHouseLink());


        for(MembersItem member : senateList) {
            if(id.equals(member.getCrpId())) {
                chosenMember = member;
            }
        }
        for(MembersItem member : houseList) {
            if(id.equals(member.getCrpId())) {
                chosenMember = member;
            }
        }


        return chosenMember;


    }

    private List<MembersItem> getMemberJSON(String link) throws Exception {
        Client client = ClientBuilder.newClient();
        Properties prop = loadProperties(PROP_FILE);
        String key = prop.getProperty("propublica_key");
        WebTarget target =
                client.target(link);

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


}
