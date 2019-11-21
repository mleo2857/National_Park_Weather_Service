package com.techelevator.npgeekJDBC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.SurveyResult;
import com.techelevator.npgeekDAO.parkDAO;
import com.techelevator.npgeekDAO.surveyResultDAO;

@Component
public class JDBCsurveyResultDAO implements surveyResultDAO{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public JDBCsurveyResultDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired 
	private parkDAO parkdao;

	@Override
	public void save(SurveyResult survey) {
		String insertSql = "INSERT INTO survey_result "
				+ "(parkcode, emailaddress, state, activitylevel) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(insertSql, survey.getParkCode(), survey.getEmailAddress(), 
				survey.getState(), survey.getActivityLevel());
		
	}

	@Override
	public List<SurveyResult> getAllSurveys() {
		List<SurveyResult> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while (results.next()) {
			allSurveys.add(mapRowToSurvey(results));
		}
		return allSurveys;
	}

	private SurveyResult mapRowToSurvey(SqlRowSet results) {
		SurveyResult surveyResult = new SurveyResult();
		surveyResult.setParkCode(results.getString("parkcode"));
		surveyResult.setEmailAddress(results.getString("emailaddress"));
		surveyResult.setState(results.getString("state"));
		surveyResult.setActivityLevel(results.getString("activitylevel"));
		surveyResult.setSurveyId(results.getInt("surveyid"));
		return surveyResult;
	}



	@Override
	public Map<ArrayList<Park>,Map<String, Integer> >getParkSurveyCount() {
		Map<ArrayList<Park>,Map<String, Integer> > returnMap = new HashMap<ArrayList<Park>, Map<String, Integer>>();
		ArrayList<Park> parks = new ArrayList<Park>();
		Map<String, Integer> parkSurveyCount = new HashMap<String, Integer>();
		
		String sqlSurveyCount = "SELECT parkcode, count(*) FROM survey_result GROUP BY parkcode ORDER BY count desc, parkcode";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSurveyCount);
		
		while (results.next()) {
			Park park = parkdao.getParkByParkCode(results.getString("parkcode"));
			parks.add(park);
			parkSurveyCount.put(park.getParkName(), results.getInt("count"));
		}
		returnMap.put(parks, parkSurveyCount);
		return returnMap;
	}
	
	
}
