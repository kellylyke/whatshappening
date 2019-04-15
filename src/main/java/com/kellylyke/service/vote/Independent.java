package com.kellylyke.service.vote;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Independent{

	@JsonProperty("no")
	private int no;

	@JsonProperty("not_voting")
	private int notVoting;

	@JsonProperty("yes")
	private int yes;

	@JsonProperty("present")
	private int present;

	public void setNo(int no){
		this.no = no;
	}

	public int getNo(){
		return no;
	}

	public void setNotVoting(int notVoting){
		this.notVoting = notVoting;
	}

	public int getNotVoting(){
		return notVoting;
	}

	public void setYes(int yes){
		this.yes = yes;
	}

	public int getYes(){
		return yes;
	}

	public void setPresent(int present){
		this.present = present;
	}

	public int getPresent(){
		return present;
	}

	@Override
 	public String toString(){
		return 
			"Independent{" + 
			"no = '" + no + '\'' + 
			",not_voting = '" + notVoting + '\'' + 
			",yes = '" + yes + '\'' + 
			",present = '" + present + '\'' + 
			"}";
		}
}