package com.techelevator.npgeekDAO;

import java.util.List;

import com.techelevator.npgeek.Weather;

public interface weatherDAO {
	
	public List <Weather> getWeatherByParkCode(String parkCode);
}
