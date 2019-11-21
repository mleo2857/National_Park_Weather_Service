package com.techelevator.npgeekDAO;

import java.util.List;

import com.techelevator.npgeek.Park;

public interface parkDAO {

	public List<Park> getAllParks();
	
	public Park getParkByParkCode(String parkCode);
	
	
}
