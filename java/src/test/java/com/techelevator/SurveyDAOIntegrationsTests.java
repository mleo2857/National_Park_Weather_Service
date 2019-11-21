package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.SurveyResult;
import com.techelevator.npgeekDAO.parkDAO;

public class SurveyDAOIntegrationsTests extends DAOIntegrationTest {
	
	@Test
	public void get_all_surveys_returns_all_surveys() {
		int initialNumberOfSurveys = surveydao.getAllSurveys().size();
		try {
			PreparedStatement sqlCommand = conn.prepareStatement("INSERT INTO survey_result(parkCode, emailaddress, state, activitylevel) "
					+ "VALUES ('GNP','asdklf@test.com','OH','Inactive');");
			sqlCommand.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int finalNumberOfSurveys = surveydao.getAllSurveys().size();
		assertEquals("Did not return the correct number of survey results", initialNumberOfSurveys + 1, finalNumberOfSurveys);
	}
	
	
	@Test
	public void save_survey_saves_survey_in_database() {
		int initialNumberOfSurveys = surveydao.getAllSurveys().size();
		SurveyResult survey = new SurveyResult();
		survey.setState("OH");
		survey.setActivityLevel("Inactive");
		survey.setEmailAddress("mleo@test.com");
		survey.setParkCode("GNP");
		surveydao.save(survey);
		int finalNumberOfSurveys = surveydao.getAllSurveys().size();
		assertEquals("Did not save results in database", initialNumberOfSurveys + 1, finalNumberOfSurveys);
	}
	
	@Test
	public void get_survey_count_returns_correct_information() {
		Map<ArrayList<Park>,Map<String, Integer>> intitialMap = surveydao.getParkSurveyCount();
		boolean hasSurveyResult = intitialMap.keySet().iterator().next().contains("GNP");
		int initialSize = intitialMap.keySet().iterator().next().size();
		
		try {
			PreparedStatement sqlCommand = conn.prepareStatement("INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
					+ "VALUES ('GNP','asdklf@test.com','OH','Inactive');");
			sqlCommand.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		Map<ArrayList<Park>,Map<String, Integer>> returnMap = surveydao.getParkSurveyCount();
		int finalSize = returnMap.keySet().iterator().next().size();
		
		if (hasSurveyResult) {
			assertEquals("Incorrect number of parks returned", initialSize, finalSize);
		} else {
			assertEquals("Incorrect number of parks returned",initialSize + 1, finalSize);
		}
		
	}

}
