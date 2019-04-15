package com.kellylyke.service.vote;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class VotesItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("amendment")
	private Amendment amendment;

	@JsonProperty("question")
	private String question;

	@JsonProperty("vote_type")
	private String voteType;

	@JsonProperty("independent")
	private Independent independent;

	@JsonProperty("congress")
	private int congress;

	@JsonProperty("session")
	private int session;

	@JsonProperty("republican")
	private Republican republican;

	@JsonProperty("bill")
	private Bill bill;

	@JsonProperty("description")
	private String description;

	@JsonProperty("source")
	private String source;

	@JsonProperty("url")
	private String url;

	@JsonProperty("nomination")
	private Nomination nomination;

	@JsonProperty("question_text")
	private String questionText;

	@JsonProperty("result")
	private String result;

	@JsonProperty("roll_call")
	private int rollCall;

	@JsonProperty("total")
	private Total total;

	@JsonProperty("chamber")
	private String chamber;

	@JsonProperty("democratic")
	private Democratic democratic;

	@JsonProperty("vote_uri")
	private String voteUri;

	@JsonProperty("time")
	private String time;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setAmendment(Amendment amendment){
		this.amendment = amendment;
	}

	public Amendment getAmendment(){
		return amendment;
	}

	public void setQuestion(String question){
		this.question = question;
	}

	public String getQuestion(){
		return question;
	}

	public void setVoteType(String voteType){
		this.voteType = voteType;
	}

	public String getVoteType(){
		return voteType;
	}

	public void setIndependent(Independent independent){
		this.independent = independent;
	}

	public Independent getIndependent(){
		return independent;
	}

	public void setCongress(int congress){
		this.congress = congress;
	}

	public int getCongress(){
		return congress;
	}

	public void setSession(int session){
		this.session = session;
	}

	public int getSession(){
		return session;
	}

	public void setRepublican(Republican republican){
		this.republican = republican;
	}

	public Republican getRepublican(){
		return republican;
	}

	public void setBill(Bill bill){
		this.bill = bill;
	}

	public Bill getBill(){
		return bill;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setNomination(Nomination nomination){
		this.nomination = nomination;
	}

	public Nomination getNomination(){
		return nomination;
	}

	public void setQuestionText(String questionText){
		this.questionText = questionText;
	}

	public String getQuestionText(){
		return questionText;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setRollCall(int rollCall){
		this.rollCall = rollCall;
	}

	public int getRollCall(){
		return rollCall;
	}

	public void setTotal(Total total){
		this.total = total;
	}

	public Total getTotal(){
		return total;
	}

	public void setChamber(String chamber){
		this.chamber = chamber;
	}

	public String getChamber(){
		return chamber;
	}

	public void setDemocratic(Democratic democratic){
		this.democratic = democratic;
	}

	public Democratic getDemocratic(){
		return democratic;
	}

	public void setVoteUri(String voteUri){
		this.voteUri = voteUri;
	}

	public String getVoteUri(){
		return voteUri;
	}

	public void setTime(String time){
		this.time = time;
	}

	public String getTime(){
		return time;
	}

	@Override
 	public String toString(){
		return 
			"VotesItem{" + 
			"date = '" + date + '\'' + 
			",amendment = '" + amendment + '\'' + 
			",question = '" + question + '\'' + 
			",vote_type = '" + voteType + '\'' + 
			",independent = '" + independent + '\'' + 
			",congress = '" + congress + '\'' + 
			",session = '" + session + '\'' + 
			",republican = '" + republican + '\'' + 
			",bill = '" + bill + '\'' + 
			",description = '" + description + '\'' + 
			",source = '" + source + '\'' + 
			",url = '" + url + '\'' + 
			",nomination = '" + nomination + '\'' + 
			",question_text = '" + questionText + '\'' + 
			",result = '" + result + '\'' + 
			",roll_call = '" + rollCall + '\'' + 
			",total = '" + total + '\'' + 
			",chamber = '" + chamber + '\'' + 
			",democratic = '" + democratic + '\'' + 
			",vote_uri = '" + voteUri + '\'' + 
			",time = '" + time + '\'' + 
			"}";
		}
}