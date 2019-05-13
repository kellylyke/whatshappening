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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * retrieves data from congress member api
 *
 *
 */
public class MemberService implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final String PROP_FILE = "/apiKey.properties";

    /**
     * Searches for congress member in api data
     *
     * @param searchTerm user entered search term
     * @return list of members matching the term
       */
    public List<MembersItem> getSpecificMember(String searchTerm) {
        logger.info(searchTerm);
        List<MembersItem> searchedMembers = new ArrayList<>();
        List<MembersItem> senateList = getMemberJSON(getSenateLink());
        List<MembersItem> houseList = getMemberJSON(getHouseLink());

        for (MembersItem member : senateList) {
            if (searchTerm.equals(member.getLastName())) {
                searchedMembers.add(member);
            }
        }
        for (MembersItem member : houseList) {
            if (searchTerm.equals(member.getLastName())) {
                searchedMembers.add(member);
            }
        }
        if (searchedMembers.size() == 0) {
            MembersItem dummy = new MembersItem();
            dummy.setLastName("Dummy");
            searchedMembers.add(dummy);
        }

        return searchedMembers;
    }

    /**
     * Retrieves the house members link for the api from properties file
     *
     * @return link for house members
     */
    private String getHouseLink() {
        Properties prop = loadProperties(PROP_FILE);
        String link = "";
        try {
            link = prop.getProperty("house_members_link");
        } catch (Exception e) {
            logger.error("Error getting house members :" + e);
        }
        return link;
    }

    /**
     * Retrieves the senate members link for the api from properties file
     *
     * @return link for senate members
     */
    private String getSenateLink() {
        Properties prop = loadProperties(PROP_FILE);
        String link = "";
        try {
            link = prop.getProperty("senate_members_link");
        } catch (Exception e) {
            logger.error("Error getting senate members :" + e);
        }
        return link;

    }

    /**
     * Gets member data by crpId
     *
     * @param id crpId
     * @return data on member with that id
     * @throws Exception exception
     */
    public MembersItem getMemberByID(String id) throws Exception {
        MembersItem chosenMember = null;

        List<MembersItem> senateList = getMemberJSON(getSenateLink());
        List<MembersItem> houseList = getMemberJSON(getHouseLink());


        for (MembersItem member : senateList) {
            if (id.equals(member.getCrpId())) {
                chosenMember = member;
            }
        }
        for (MembersItem member : houseList) {
            if (id.equals(member.getCrpId())) {
                chosenMember = member;
            }
        }

        return chosenMember;

    }

    /**
     * Builds json file from api for list of congress members
     *
     * @param link api link
     * @return list of members
     */
    private List<MembersItem> getMemberJSON(String link) {
        Client client = ClientBuilder.newClient();
        Properties prop = loadProperties(PROP_FILE);
        String key = prop.getProperty("propublica_key");
        WebTarget target =
                client.target(link);

        Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
        invocationBuilder.header("x-api-key", key);

        Response response = invocationBuilder.get();
        if (response.getStatus() == 200) {
            String responseData = response.readEntity(String.class);

            ObjectMapper mapper = new ObjectMapper();
            Results results = null;
            try {
                results = mapper.readValue(responseData, Results.class);
                List<ResultsItem> resultsItem = new ArrayList<ResultsItem>();
                resultsItem = results.getResults();
                List<MembersItem> members = new ArrayList<MembersItem>();
                members = resultsItem.get(0).getMembers();
                return members;
            } catch (IOException e) {
                logger.error("Error mapping results from api: " + e);
                List<MembersItem> members = new ArrayList<MembersItem>();
                MembersItem empty = new MembersItem();
                members.add(empty);
                return members;
            }

        } else {
            List<MembersItem> members = new ArrayList<MembersItem>();
            MembersItem empty = new MembersItem();
            members.add(empty);
            return members;
        }
    }


}
