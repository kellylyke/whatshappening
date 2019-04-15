package com.kellylyke.service.vote;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Nomination{

	@JsonProperty("number")
	private String number;

	@JsonProperty("agency")
	private String agency;

	@JsonProperty("name")
	private String name;

	@JsonProperty("nomination_id")
	private String nominationId;

	public void setNumber(String number){
		this.number = number;
	}

	public String getNumber(){
		return number;
	}

	public void setAgency(String agency){
		this.agency = agency;
	}

	public String getAgency(){
		return agency;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setNominationId(String nominationId){
		this.nominationId = nominationId;
	}

	public String getNominationId(){
		return nominationId;
	}

	@Override
 	public String toString(){
		return 
			"Nomination{" + 
			"number = '" + number + '\'' + 
			",agency = '" + agency + '\'' + 
			",name = '" + name + '\'' + 
			",nomination_id = '" + nominationId + '\'' + 
			"}";
		}
}