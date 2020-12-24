package junitTest;

import static org.junit.Assert.*;
import org.junit.Test;



import entity.Competitor;
import mock.*;
/**
 * 
 * class for testing Match class
 *
 */
public class MatchTest {
	/**
	 * method that runs the test if an exception
	 * is thrown
	 */
	@Test(expected = NullPointerException.class)
	public void initTestShouldReturnAnException() {
		Competitor c1=null;
		Competitor c2=null;
		MockMatch mckMatch=new MockMatch(c1,c2);
		mckMatch.getCompetitorOne().getPoints();
		
	}
	
	/**
	 * Test if MockMatch is correctly set
	 * by testing the names and the number of points
	 * and different ID
	 */
	@Test
	public void mockMatchtest() {
		Competitor c1=new Competitor("Adam");
		Competitor c2=new Competitor("Alexis");
		MockMatch mckMatch=new MockMatch(c1,c2);
		assertEquals("Adam", mckMatch.getCompetitorOneMock().getName());
		assertEquals("Alexis",mckMatch.getCompetitorTwoMock().getName());
		assertEquals(0,mckMatch.getCompetitorOneMock().getPoints());
		assertEquals(0,mckMatch.getCompetitorTwoMock().getPoints());
		assertFalse(c1.getId()==c2.getId());
	}

}
