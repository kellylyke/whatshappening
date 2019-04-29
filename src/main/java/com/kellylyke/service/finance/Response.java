package com.kellylyke.service.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("response")
	private Response response;

	@JsonProperty("contributors")
	private Contributors contributors;

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	public void setContributors(Contributors contributors){
		this.contributors = contributors;
	}

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