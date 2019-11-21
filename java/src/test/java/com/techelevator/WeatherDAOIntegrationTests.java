package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.techelevator.npgeek.Weather;

public class WeatherDAOIntegrationTests extends DAOIntegrationTest {
	
	@Test
	public void get_weather_by_park_code_returns_correct_weather() {
		int initialWeathers = weatherdao.getWeatherByParkCode("GNP").size();
		try {
			PreparedStatement sqlCommand = conn.prepareStatement("INSERT INTO weather(parkCode, fivedayforecastvalue, low, high, forecast) "
					+ "VALUES ('GNP',6,10,80,'tornado');");
			sqlCommand.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int finalWeathers = weatherdao.getWeatherByParkCode("GNP").size();
		assertEquals("Incorrect number of weather values", initialWeathers + 1, finalWeathers);
	}

}
