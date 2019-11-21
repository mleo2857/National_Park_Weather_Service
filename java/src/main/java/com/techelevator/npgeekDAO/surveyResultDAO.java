package com.techelevator.npgeekDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.SurveyResult;

public interface surveyResultDAO {

	public void save(SurveyResult survey);
	
	public List <SurveyResult> getAllSurveys();
	
	
	public Map<ArrayList<Park>,Map<String, Integer> >getParkSurveyCount();
	
	
}
