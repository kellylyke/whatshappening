package com.kellylyke.service.finance;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Contributors{

//
//	@JsonProperty("response")
//	private Response response;

	@JsonProperty("contributor")
	private List<ContributorItem> contributor;

	@JsonProperty("@attributes")
	private Attributes attributes;

	public void setContributor(List<ContributorItem> contributor){
		this.contributor = contributor;
	}

	public List<ContributorItem> getContributor(){
		return contributor;
	}

	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	public Attributes getAttributes(){
		return attributes;
	}

	@Override
 	public String toString(){
		return 
			"Contributors{" + 
			"contributor = '" + contributor + '\'' + 
			",@attributes = '" + attributes + '\'' + 
			"}";
		}
}