package com.kellylyke.service.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Contributor item.
 */
@Generated("com.robohorse.robopojogenerator")
public class ContributorItem{

	@JsonProperty("@attributes")
	private Attributes attributes;

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
			"ContributorItem{" + 
			"@attributes = '" + attributes + '\'' + 
			"}";
		}
}