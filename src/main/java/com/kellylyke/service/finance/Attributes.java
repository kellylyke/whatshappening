package com.kellylyke.service.finance;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

/**
 * The type Attributes.
 */
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

	/**
	 * Set origin.
	 *
	 * @param origin the origin
	 */
	public void setOrigin(String origin){
		this.origin = origin;
	}

	/**
	 * Get origin string.
	 *
	 * @return the string
	 */
	public String getOrigin(){
		return origin;
	}

	/**
	 * Set source.
	 *
	 * @param source the source
	 */
	public void setSource(String source){
		this.source = source;
	}

	/**
	 * Get source string.
	 *
	 * @return the string
	 */
	public String getSource(){
		return source;
	}

	/**
	 * Set cycle.
	 *
	 * @param cycle the cycle
	 */
	public void setCycle(String cycle){
		this.cycle = cycle;
	}

	/**
	 * Get cycle string.
	 *
	 * @return the string
	 */
	public String getCycle(){
		return cycle;
	}

	/**
	 * Set cand name.
	 *
	 * @param candName the cand name
	 */
	public void setCandName(String candName){
		this.candName = candName;
	}

	/**
	 * Get cand name string.
	 *
	 * @return the string
	 */
	public String getCandName(){
		return candName;
	}

	/**
	 * Set cid.
	 *
	 * @param cid the cid
	 */
	public void setCid(String cid){
		this.cid = cid;
	}

	/**
	 * Get cid string.
	 *
	 * @return the string
	 */
	public String getCid(){
		return cid;
	}

	/**
	 * Set notice.
	 *
	 * @param notice the notice
	 */
	public void setNotice(String notice){
		this.notice = notice;
	}

	/**
	 * Get notice string.
	 *
	 * @return the string
	 */
	public String getNotice(){
		return notice;
	}

	/**
	 * Set total.
	 *
	 * @param total the total
	 */
	public void setTotal(String total){
		this.total = total;
	}

	/**
	 * Get total string.
	 *
	 * @return the string
	 */
	public String getTotal(){
		return total;
	}

	/**
	 * Set pacs.
	 *
	 * @param pacs the pacs
	 */
	public void setPacs(String pacs){
		this.pacs = pacs;
	}

	/**
	 * Get pacs string.
	 *
	 * @return the string
	 */
	public String getPacs(){
		return pacs;
	}

	/**
	 * Set org name.
	 *
	 * @param orgName the org name
	 */
	public void setOrgName(String orgName){
		this.orgName = orgName;
	}

	/**
	 * Get org name string.
	 *
	 * @return the string
	 */
	public String getOrgName(){
		return orgName;
	}

	/**
	 * Set indivs.
	 *
	 * @param indivs the indivs
	 */
	public void setIndivs(String indivs){
		this.indivs = indivs;
	}

	/**
	 * Get indivs string.
	 *
	 * @return the string
	 */
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