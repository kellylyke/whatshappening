package com.kellylyke.service.congress;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class MembersItem{

	@JsonIgnore
	@JsonProperty("status")
	private String status;

	@JsonIgnore
	@JsonProperty("copyright")
	private String copyright;

	@JsonProperty("dw_nominate")
	private double dwNominate;

	@JsonProperty("gender")
	private String gender;

	@JsonProperty("date_of_birth")
	private String dateOfBirth;

	@JsonProperty("cspan_id")
	private String cspanId;

	@JsonProperty("rss_url")
	private String rssUrl;

	@JsonProperty("api_uri")
	private String apiUri;

	@JsonProperty("office")
	private String office;

	@JsonProperty("senate_class")
	private String senateClass;

	@JsonProperty("title")
	private String title;

	@JsonProperty("suffix")
	private Object suffix;

	@JsonProperty("facebook_account")
	private String facebookAccount;

	@JsonProperty("ideal_point")
	private Object idealPoint;

	@JsonProperty("leadership_role")
	private Object leadershipRole;

	@JsonProperty("google_entity_id")
	private String googleEntityId;

	@JsonProperty("total_present")
	private int totalPresent;

	@JsonProperty("short_title")
	private String shortTitle;

	@JsonProperty("crp_id")
	private String crpId;

	@JsonProperty("youtube_account")
	private String youtubeAccount;

	@JsonProperty("next_election")
	private String nextElection;

	@JsonProperty("missed_votes_pct")
	private double missedVotesPct;

	@JsonProperty("twitter_account")
	private String twitterAccount;

	@JsonProperty("id")
	private String id;

	@JsonProperty("state")
	private String state;

	@JsonProperty("fax")
	private String fax;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("votes_with_party_pct")
	private double votesWithPartyPct;

	@JsonProperty("ocd_id")
	private String ocdId;

	@JsonProperty("last_updated")
	private String lastUpdated;

	@JsonProperty("missed_votes")
	private int missedVotes;

	@JsonProperty("contact_form")
	private String contactForm;

	@JsonProperty("fec_candidate_id")
	private String fecCandidateId;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("icpsr_id")
	private String icpsrId;

	@JsonProperty("middle_name")
	private Object middleName;

	@JsonProperty("in_office")
	private boolean inOffice;

	@JsonProperty("lis_id")
	private String lisId;

	@JsonProperty("url")
	private String url;

	@JsonProperty("total_votes")
	private int totalVotes;

	@JsonProperty("state_rank")
	private String stateRank;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("votesmart_id")
	private String votesmartId;

	@JsonProperty("govtrack_id")
	private String govtrackId;

	@JsonProperty("party")
	private String party;

	@JsonProperty("seniority")
	private String seniority;

	public void setDwNominate(double dwNominate){
		this.dwNominate = dwNominate;
	}

	public double getDwNominate(){
		return dwNominate;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setDateOfBirth(String dateOfBirth){
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth(){
		return dateOfBirth;
	}

	public void setCspanId(String cspanId){
		this.cspanId = cspanId;
	}

	public String getCspanId(){
		return cspanId;
	}

	public void setRssUrl(String rssUrl){
		this.rssUrl = rssUrl;
	}

	public String getRssUrl(){
		return rssUrl;
	}

	public void setApiUri(String apiUri){
		this.apiUri = apiUri;
	}

	public String getApiUri(){
		return apiUri;
	}

	public void setOffice(String office){
		this.office = office;
	}

	public String getOffice(){
		return office;
	}

	public void setSenateClass(String senateClass){
		this.senateClass = senateClass;
	}

	public String getSenateClass(){
		return senateClass;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setSuffix(Object suffix){
		this.suffix = suffix;
	}

	public Object getSuffix(){
		return suffix;
	}

	public void setFacebookAccount(String facebookAccount){
		this.facebookAccount = facebookAccount;
	}

	public String getFacebookAccount(){
		return facebookAccount;
	}

	public void setIdealPoint(Object idealPoint){
		this.idealPoint = idealPoint;
	}

	public Object getIdealPoint(){
		return idealPoint;
	}

	public void setLeadershipRole(Object leadershipRole){
		this.leadershipRole = leadershipRole;
	}

	public Object getLeadershipRole(){
		return leadershipRole;
	}

	public void setGoogleEntityId(String googleEntityId){
		this.googleEntityId = googleEntityId;
	}

	public String getGoogleEntityId(){
		return googleEntityId;
	}

	public void setTotalPresent(int totalPresent){
		this.totalPresent = totalPresent;
	}

	public int getTotalPresent(){
		return totalPresent;
	}

	public void setShortTitle(String shortTitle){
		this.shortTitle = shortTitle;
	}

	public String getShortTitle(){
		return shortTitle;
	}

	public void setCrpId(String crpId){
		this.crpId = crpId;
	}

	public String getCrpId(){
		return crpId;
	}

	public void setYoutubeAccount(String youtubeAccount){
		this.youtubeAccount = youtubeAccount;
	}

	public String getYoutubeAccount(){
		return youtubeAccount;
	}

	public void setNextElection(String nextElection){
		this.nextElection = nextElection;
	}

	public String getNextElection(){
		return nextElection;
	}

	public void setMissedVotesPct(double missedVotesPct){
		this.missedVotesPct = missedVotesPct;
	}

	public double getMissedVotesPct(){
		return missedVotesPct;
	}

	public void setTwitterAccount(String twitterAccount){
		this.twitterAccount = twitterAccount;
	}

	public String getTwitterAccount(){
		return twitterAccount;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setFax(String fax){
		this.fax = fax;
	}

	public String getFax(){
		return fax;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}

	public void setVotesWithPartyPct(double votesWithPartyPct){
		this.votesWithPartyPct = votesWithPartyPct;
	}

	public double getVotesWithPartyPct(){
		return votesWithPartyPct;
	}

	public void setOcdId(String ocdId){
		this.ocdId = ocdId;
	}

	public String getOcdId(){
		return ocdId;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setMissedVotes(int missedVotes){
		this.missedVotes = missedVotes;
	}

	public int getMissedVotes(){
		return missedVotes;
	}

	public void setContactForm(String contactForm){
		this.contactForm = contactForm;
	}

	public String getContactForm(){
		return contactForm;
	}

	public void setFecCandidateId(String fecCandidateId){
		this.fecCandidateId = fecCandidateId;
	}

	public String getFecCandidateId(){
		return fecCandidateId;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setIcpsrId(String icpsrId){
		this.icpsrId = icpsrId;
	}

	public String getIcpsrId(){
		return icpsrId;
	}

	public void setMiddleName(Object middleName){
		this.middleName = middleName;
	}

	public Object getMiddleName(){
		return middleName;
	}

	public void setInOffice(boolean inOffice){
		this.inOffice = inOffice;
	}

	public boolean isInOffice(){
		return inOffice;
	}

	public void setLisId(String lisId){
		this.lisId = lisId;
	}

	public String getLisId(){
		return lisId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTotalVotes(int totalVotes){
		this.totalVotes = totalVotes;
	}

	public int getTotalVotes(){
		return totalVotes;
	}

	public void setStateRank(String stateRank){
		this.stateRank = stateRank;
	}

	public String getStateRank(){
		return stateRank;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setVotesmartId(String votesmartId){
		this.votesmartId = votesmartId;
	}

	public String getVotesmartId(){
		return votesmartId;
	}

	public void setGovtrackId(String govtrackId){
		this.govtrackId = govtrackId;
	}

	public String getGovtrackId(){
		return govtrackId;
	}

	public void setParty(String party){
		this.party = party;
	}

	public String getParty(){
		return party;
	}

	public void setSeniority(String seniority){
		this.seniority = seniority;
	}

	public String getSeniority(){
		return seniority;
	}

	@Override
 	public String toString(){
		return 
			"MembersItem{" + 
			"dw_nominate = '" + dwNominate + '\'' + 
			",gender = '" + gender + '\'' + 
			",date_of_birth = '" + dateOfBirth + '\'' + 
			",cspan_id = '" + cspanId + '\'' + 
			",rss_url = '" + rssUrl + '\'' + 
			",api_uri = '" + apiUri + '\'' + 
			",office = '" + office + '\'' + 
			",senate_class = '" + senateClass + '\'' + 
			",title = '" + title + '\'' + 
			",suffix = '" + suffix + '\'' + 
			",facebook_account = '" + facebookAccount + '\'' + 
			",ideal_point = '" + idealPoint + '\'' + 
			",leadership_role = '" + leadershipRole + '\'' + 
			",google_entity_id = '" + googleEntityId + '\'' + 
			",total_present = '" + totalPresent + '\'' + 
			",short_title = '" + shortTitle + '\'' + 
			",crp_id = '" + crpId + '\'' + 
			",youtube_account = '" + youtubeAccount + '\'' + 
			",next_election = '" + nextElection + '\'' + 
			",missed_votes_pct = '" + missedVotesPct + '\'' + 
			",twitter_account = '" + twitterAccount + '\'' + 
			",id = '" + id + '\'' + 
			",state = '" + state + '\'' + 
			",fax = '" + fax + '\'' + 
			",first_name = '" + firstName + '\'' + 
			",votes_with_party_pct = '" + votesWithPartyPct + '\'' + 
			",ocd_id = '" + ocdId + '\'' + 
			",last_updated = '" + lastUpdated + '\'' + 
			",missed_votes = '" + missedVotes + '\'' + 
			",contact_form = '" + contactForm + '\'' + 
			",fec_candidate_id = '" + fecCandidateId + '\'' + 
			",last_name = '" + lastName + '\'' + 
			",icpsr_id = '" + icpsrId + '\'' + 
			",middle_name = '" + middleName + '\'' + 
			",in_office = '" + inOffice + '\'' + 
			",lis_id = '" + lisId + '\'' + 
			",url = '" + url + '\'' + 
			",total_votes = '" + totalVotes + '\'' + 
			",state_rank = '" + stateRank + '\'' + 
			",phone = '" + phone + '\'' + 
			",votesmart_id = '" + votesmartId + '\'' + 
			",govtrack_id = '" + govtrackId + '\'' + 
			",party = '" + party + '\'' + 
			",seniority = '" + seniority + '\'' + 
			"}";
		}
}