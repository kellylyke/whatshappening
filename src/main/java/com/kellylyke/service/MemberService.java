package com.kellylyke.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kellylyke.service.congress.MembersItem;
import com.kellylyke.service.congress.Results;
import com.kellylyke.service.congress.ResultsItem;
import com.kellylyke.service.finance.ContributorItem;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MemberService {
    private String key;
    private String senateMembersLink;
    private String houseMembersLink;
    private final Logger logger = LogManager.getLogger(this.getClass());

    private void loadProperties() {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/apiKey.properties"));
            key = properties.getProperty("propublica_key");
            senateMembersLink = properties.getProperty("senate_members_link");
            houseMembersLink = properties.getProperty("house_members_link");
        } catch (IOException ioe) {
            logger.error("Database.loadProperties()...Cannot load the properties file");
            ioe.printStackTrace();
        } catch (Exception e) {
            logger.error("Database.loadProperties()..." + e);
            e.printStackTrace();
        }

    }

//    public void getMemberInformation(String searchTerm) throws Exception{
//        MembersItem member = getSpecificMember(searchTerm);
//        List<ContributorItem> items = getFinanceData(member);
//    }


    public List<MembersItem> getSenateMembersJSON() throws Exception { //TODO: handle this
        Client client = ClientBuilder.newClient();
        loadProperties();
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

    public List<MembersItem> getSpecificMember(String searchTerm) throws Exception{
        logger.info(searchTerm);
        List<MembersItem> searchedMembers = new ArrayList<>();
        List<MembersItem> senateList = getSenateMembersJSON();
        List<MembersItem> houseList = getHouseMembersJSON();

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

    public List<MembersItem> getHouseMembersJSON() throws Exception { //TODO: handle this and reuse code

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

        return members;


    }

    public MembersItem getMemberByID(String id) throws Exception {
        MembersItem chosenMember = null;
        logger.info(id);
        List<MembersItem> senateList = getSenateMembersJSON();
        List<MembersItem> houseList = getHouseMembersJSON();

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
    public List<ContributorItem> getFinanceData(MembersItem member) {
        List<ContributorItem> items = new ArrayList<ContributorItem>();
        try {
            String id = member.getCrpId();
            FinanceService financeService = new FinanceService();
            Contributors contributors = financeService.getFinancialDataForCandidate(id);
            items =  contributors.getContributor();

        } catch (Exception e) {
            logger.error("Error getting finances for member " + e);
            //probably say no results found or something??
        }
        return items;
    }

}
