package com.kellylyke.service.finance;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Contributors.
 */
@Generated("com.robohorse.robopojogenerator")
public class Contributors{

	@JsonProperty("contributor")
	private List<ContributorItem> contributor;

	@JsonProperty("@attributes")
	private Attributes attributes;

	/**
	 * Set contributor.
	 *
	 * @param contributor the contributor
	 */
	public void setContributor(List<ContributorItem> contributor){
		this.contributor = contributor;
	}

	/**
	 * Get contributor list.
	 *
	 * @return the list
	 */
	public List<ContributorItem> getContributor(){
		return contributor;
	}

	/**
	 * Set attributes.
	 *
	 * @param attributes the attributes
	 */
	public void setAttributes(Attributes attributes){
		this.attributes = attributes;
	}

	/**
	 * Get attributes attributes.
	 *
	 * @return the attributes
	 */
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