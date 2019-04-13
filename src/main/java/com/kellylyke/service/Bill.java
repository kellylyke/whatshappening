package com.kellylyke.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Bill{

	@JsonProperty("bill_id")
	private String billId;

	@JsonProperty("number")
	private String number;

	@JsonProperty("api_uri")
	private String apiUri;

	@JsonProperty("latest_action")
	private String latestAction;

	@JsonProperty("title")
	private String title;

	@JsonProperty("sponsor_id")
	private String sponsorId;

	public void setBillId(String billId){
		this.billId = billId;
	}

	public String getBillId(){
		return billId;
	}

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
	}

	public void setApiUri(String apiUri){
		this.apiUri = apiUri;
	}

	public String getApiUri(){
		return apiUri;
	}

	public void setLatestAction(String latestAction){
		this.latestAction = latestAction;
	}

	public String getLatestAction(){
		return latestAction;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
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
			"Bill{" + 
			"bill_id = '" + billId + '\'' + 
			",number = '" + number + '\'' + 
			",api_uri = '" + apiUri + '\'' + 
			",latest_action = '" + latestAction + '\'' + 
			",title = '" + title + '\'' + 
			",sponsor_id = '" + sponsorId + '\'' + 
			"}";
		}
}