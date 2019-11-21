package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.techelevator.npgeekDAO.parkDAO;

public class ParkDAOIntegrationTests extends DAOIntegrationTest {

	

	@Test
	public void get_all_parks_returns_all_parks() {
		int initialNumberOfPark = parkdao.getAllParks().size();
		try {
			PreparedStatement sqlCommand = conn.prepareStatement("INSERT INTO park(parkCode, parkName, state, acreage, elevationInFeet, milesOfTrail, numberOfCampsites, climate, yearFounded, annualVisitorCount, inspirationalQuote, inspirationalQuoteSource, parkDescription, entryFee, numberOfAnimalSpecies) "
					+ "VALUES ('MDME', 'Mordor', 'Middle Earth', 0, 0, 2, 1, 'Death', 8, 2, 'One Ring to rule them all, One Ring to find them, " + 
					"One Ring to bring them all and in the darkness bind them', 'John Muir', 'Mordor had three enormous mountain ranges surrounding it, from the north, from the west and from the south. The mountains both protected the land from an unexpected invasion by any of the people living in those directions and kept those living in Mordor from escaping. Tolkien was reported to have identified Mordor with the volcano of Stromboli off Sicily, in terms of geographic equivalency with the real world.',"
					+ "1,1);");
			sqlCommand.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int resultNumOfParks = parkdao.getAllParks().size();
		assertEquals("The number of parks returned was not as expected", resultNumOfParks, initialNumberOfPark + 1);
	}
	
	@Test
	public void get_park_by_code_returns_correct_park() {
		try {
			PreparedStatement sqlCommand = conn.prepareStatement("INSERT INTO park(parkCode, parkName, state, acreage, elevationInFeet, milesOfTrail, numberOfCampsites, climate, yearFounded, annualVisitorCount, inspirationalQuote, inspirationalQuoteSource, parkDescription, entryFee, numberOfAnimalSpecies) "
					+ "VALUES ('MDME', 'Mordor', 'Middle Earth', 0, 0, 2, 1, 'Death', 8, 2, 'One Ring to rule them all, One Ring to find them, " + 
					"One Ring to bring them all and in the darkness bind them', 'John Muir', 'Mordor had three enormous mountain ranges surrounding it, from the north, from the west and from the south. The mountains both protected the land from an unexpected invasion by any of the people living in those directions and kept those living in Mordor from escaping. Tolkien was reported to have identified Mordor with the volcano of Stromboli off Sicily, in terms of geographic equivalency with the real world.',"
					+ "1,1);");
			sqlCommand.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		String returnParkName = parkdao.getParkByParkCode("MDME").getParkName();
		assertEquals("The park returned was not the expected one", "Mordor", returnParkName);
	}
}
