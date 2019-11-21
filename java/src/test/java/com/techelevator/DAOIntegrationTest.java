package com.techelevator;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeekDAO.parkDAO;
import com.techelevator.npgeekDAO.surveyResultDAO;
import com.techelevator.npgeekDAO.weatherDAO;
import com.techelevator.npgeekJDBC.JDBCparkDAO;
import com.techelevator.npgeekJDBC.JDBCsurveyResultDAO;
import com.techelevator.npgeekJDBC.JDBCweatherDAO;

public abstract class DAOIntegrationTest {

	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	@Autowired
	protected static parkDAO parkdao;
	protected static weatherDAO weatherdao;
	protected static surveyResultDAO surveydao;
	protected static Connection conn;
	private static Statement stmt;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
		parkdao = new JDBCparkDAO(dataSource);
		weatherdao = new JDBCweatherDAO(dataSource);
		surveydao = new JDBCsurveyResultDAO(dataSource);
	
		/* Create a Statement object so that we can execute a SQL Query */
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/* This method provides access to the DataSource for subclasses so that
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void get_park_by_code_returns_correct_park() {
		
	}
	@Test
	public void get_all_parks_returns_all_parks() {
		
	}
}
