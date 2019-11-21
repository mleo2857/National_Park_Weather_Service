package com.techelevator.npgeek;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SurveyResult {

	private int surveyId;
	
	private String parkCode;
	@Email(message="Please enter a valid email address")
	@NotBlank(message="Please enter a valid email address")
	private String emailAddress;
	@NotBlank(message="Please select a state")
	private String state;
	@NotBlank(message="Please select your activity level")
	private String activityLevel;
	
	public SurveyResult() {
		
	}
	
	public SurveyResult(String parkCode, String emailAddress, String state, String activityLevel) {
		this.parkCode = parkCode;
		this.emailAddress = emailAddress;
		this.state = state;
		this.activityLevel = activityLevel;
	}
	
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
}
