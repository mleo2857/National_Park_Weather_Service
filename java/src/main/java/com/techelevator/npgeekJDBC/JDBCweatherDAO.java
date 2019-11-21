package com.techelevator.npgeekJDBC;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.Weather;
import com.techelevator.npgeekDAO.weatherDAO;

@Component
public class JDBCweatherDAO implements weatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired 
	public JDBCweatherDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getWeatherByParkCode(String parkCode) {
		List<Weather> weatherList = new ArrayList<>();
		String sqlSelectAllWeathers = "SELECT * FROM weather WHERE parkcode = '" + parkCode +"'";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllWeathers);
		while (results.next()) {
			weatherList.add(mapRowToWeather(results));
		}
		return weatherList;
	}
	

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		weather.setParkCode(results.getString("parkcode"));
		weather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		weather.setLow(results.getInt("low"));
		weather.setHigh(results.getInt("high"));
		if (results.getString("forecast").equals("partly cloudy")) {
			weather.setForecast("partlyCloudy");
		}
		else {
			weather.setForecast(results.getString("forecast"));
		}
		weather.setForecastName(results.getString("forecast"));
		
		return weather;
	}
	
	
	
}
