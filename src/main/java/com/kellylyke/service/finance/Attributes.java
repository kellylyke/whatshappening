package com.kellylyke.service.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Attributes{

	@JsonProperty("origin")
	private String origin;

	@JsonProperty("source")
	private String source;

	@JsonProperty("cycle")
	private String cycle;

	@JsonProperty("cand_name")
	private String candName;

	@JsonProperty("cid")
	private String cid;

	@JsonProperty("notice")
	private String notice;

	@JsonProperty("total")
	private String total;

	@JsonProperty("pacs")
	private String pacs;

	@JsonProperty("org_name")
	private String orgName;

	@JsonProperty("indivs")
	private String indivs;

	public void setOrigin(String origin){
		this.origin = origin;
	}

	public String getOrigin(){
		return origin;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setCycle(String cycle){
		this.cycle = cycle;
	}

	public String getCycle(){
		return cycle;
	}

	public void setCandName(String candName){
		this.candName = candName;
	}

	public String getCandName(){
		return candName;
	}

	public void setCid(String cid){
		this.cid = cid;
	}

	public String getCid(){
		return cid;
	}

	public void setNotice(String notice){
		this.notice = notice;
	}

	public String getNotice(){
		return notice;
	}

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setPacs(String pacs){
		this.pacs = pacs;
	}

	public String getPacs(){
		return pacs;
	}

	public void setOrgName(String orgName){
		this.orgName = orgName;
	}

	public String getOrgName(){
		return orgName;
	}

	public void setIndivs(String indivs){
		this.indivs = indivs;
	}

	public String getIndivs(){
		return indivs;
	}

	@Override
 	public String toString(){
		return 
			"Attributes{" + 
			"origin = '" + origin + '\'' + 
			",source = '" + source + '\'' + 
			",cycle = '" + cycle + '\'' + 
			",cand_name = '" + candName + '\'' + 
			",cid = '" + cid + '\'' + 
			",notice = '" + notice + '\'' + 
			",total = '" + total + '\'' + 
			",pacs = '" + pacs + '\'' + 
			",org_name = '" + orgName + '\'' + 
			",indivs = '" + indivs + '\'' + 
			"}";
		}
}