package com.kellylyke.service.vote;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Results{

	@JsonProperty("chamber")
	private String chamber;

	@JsonProperty("offset")
	private int offset;

	@JsonProperty("votes")
	private List<VotesItem> votes;

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

	public void setVotes(List<VotesItem> votes){
		this.votes = votes;
	}

	public List<VotesItem> getVotes(){
		return votes;
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
			"Results{" + 
			"chamber = '" + chamber + '\'' + 
			",offset = '" + offset + '\'' + 
			",votes = '" + votes + '\'' + 
			",num_results = '" + numResults + '\'' + 
			"}";
		}
}