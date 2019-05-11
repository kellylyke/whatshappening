package com.kellylyke.service.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Response.
 */
@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("response")
	private Response response;

	@JsonProperty("contributors")
	private Contributors contributors;

	/**
	 * Set response.
	 *
	 * @param response the response
	 */
	public void setResponse(Response response){
		this.response = response;
	}

	/**
	 * Get response response.
	 *
	 * @return the response
	 */
	public Response getResponse(){
		return response;
	}

	/**
	 * Set contributors.
	 *
	 * @param contributors the contributors
	 */
	public void setContributors(Contributors contributors){
		this.contributors = contributors;
	}

	/**
	 * Get contributors contributors.
	 *
	 * @return the contributors
	 */
	public Contributors getContributors(){
		return contributors;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"response = '" + response + '\'' + 
			",contributors = '" + contributors + '\'' + 
			"}";
		}
}