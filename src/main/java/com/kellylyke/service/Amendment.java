package com.kellylyke.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Amendment{

	@JsonProperty("number")
	private String number;

	@JsonProperty("sponsor")
	private String sponsor;

	@JsonProperty("sponsor_uri")
	private String sponsorUri;

	@JsonProperty("sponsor_party")
	private String sponsorParty;

	@JsonProperty("sponsor_state")
	private String sponsorState;

	@JsonProperty("api_uri")
	private String apiUri;

	@JsonProperty("sponsor_id")
	private String sponsorId;

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
	}

	public void setSponsor(String sponsor){
		this.sponsor = sponsor;
	}

	public String getSponsor(){
		return sponsor;
	}

	public void setSponsorUri(String sponsorUri){
		this.sponsorUri = sponsorUri;
	}

	public String getSponsorUri(){
		return sponsorUri;
	}

	public void setSponsorParty(String sponsorParty){
		this.sponsorParty = sponsorParty;
	}

	public String getSponsorParty(){
		return sponsorParty;
	}

	public void setSponsorState(String sponsorState){
		this.sponsorState = sponsorState;
	}

	public String getSponsorState(){
		return sponsorState;
	}

	public void setApiUri(String apiUri){
		this.apiUri = apiUri;
	}

	public String getApiUri(){
		return apiUri;
	}

	public void setSponsorId(String sponsorId){
		this.sponsorId = sponsorId;
	}

	public String getSponsorId(){
		return sponsorId;
	}

	@Override
 	public String toString(){
		return 
			"Amendment{" + 
			"number = '" + number + '\'' + 
			",sponsor = '" + sponsor + '\'' + 
			",sponsor_uri = '" + sponsorUri + '\'' + 
			",sponsor_party = '" + sponsorParty + '\'' + 
			",sponsor_state = '" + sponsorState + '\'' + 
			",api_uri = '" + apiUri + '\'' + 
			",sponsor_id = '" + sponsorId + '\'' + 
			"}";
		}
}