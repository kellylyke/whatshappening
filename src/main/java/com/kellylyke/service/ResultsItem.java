package com.kellylyke.service;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ResultsItem{

	@JsonProperty("chamber")
	private String chamber;

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("congress")
	private String congress;

	@JsonProperty("members")
	private List<MembersItem> members;

	@JsonProperty("num_results")
	private int numResults;

	public void setChamber(String chamber){
		this.chamber = chamber;
	}

	public String getChamber(){
		return chamber;
	}

	public void setOffset(int offset){
		this.offset = offset;
	}

	public int getOffset(){
		return offset;
	}

	public void setCongress(String congress){
		this.congress = congress;
	}

	public String getCongress(){
		return congress;
	}

	public void setMembers(List<MembersItem> members){
		this.members = members;
	}

	public List<MembersItem> getMembers(){
		return members;
	}

	public void setNumResults(int numResults){
		this.numResults = numResults;
	}

	public int getNumResults(){
		return numResults;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"chamber = '" + chamber + '\'' + 
			",offset = '" + offset + '\'' + 
			",congress = '" + congress + '\'' + 
			",members = '" + members + '\'' + 
			",num_results = '" + numResults + '\'' + 
			"}";
		}
}