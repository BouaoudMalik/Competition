package junitTest;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;


import entity.Competitor;
import exceptions.NoCompetitorAvailableException;
import services.*;

/**
 * 
 * class test for competitor 
 *
 */
public class CompetitorTest {

	/**
	 * testCompetitors test if a new competitor
	 * have 0 points and the correct ID 
	 */
	@Test
	public void testCompetitor() {
		Competitor c=new Competitor("Alex");
		assertEquals("Alex",c.getName());
		assertEquals(0,c.getPoints());
		assertEquals(1,c.getId());
	}
	
	/**
	 * Test if the list contains 8 participant
	 */
	@Test
	public void testInitCompetitors() {
		assertEquals(8,Competition.initCompetitor().size());
	}
	
	/**
	 * should return an exception because we're reaching a null 
	 * value in the arrayList
	 */
	@Test(expected = NoCompetitorAvailableException.class)
	public void testInitCompetitorsWithNULLValues() {
		ArrayList<Competitor> arrayOfCompetitors=Competition.initCompetitor();
		int i=0;
		while(arrayOfCompetitors.size()>0) {
			arrayOfCompetitors.remove(i);
		}
		try {
		arrayOfCompetitors.get(1);
		}
		catch(IndexOutOfBoundsException e) {
		throw new NoCompetitorAvailableException("*Exception* The list is Empty");
		}
	}
}


