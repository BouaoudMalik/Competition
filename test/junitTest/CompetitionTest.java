package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.*;

import entity.Competitor;
import exceptions.*;
import mock.*;
import services.*;


/**
 * the Test class of Competition
 *
 */

public class CompetitionTest {
	
	
	protected ArrayList<Competitor> arrayComp = new ArrayList<>();
	protected MockCompetition competitionMock=new MockCompetition(arrayComp);

	/**
	 * init method test if the list is up to use
	 */
	@Before
	public void init() {
		assertNotNull(competitionMock.getCompetitors().size());
		assertEquals(8,competitionMock.getCompetitors().size());		
	}
		
	/**
	 * Test of the method play, when play run we should have one winner 
	 * with points different from 0
	 */
	@Test
	public void playtest() {


		//having a winner equals to have 1 player on the list
		competitionMock.play(competitionMock.getCompetitors());
		assertEquals(1,competitionMock.getCompetitors().size());
		//the winner should have more than 0 point
		assertTrue(competitionMock.getCompetitors().get(0).getPoints()>0);
		
				
	}
	
	/**
	 * testIfThereAreEnougthCompetitor test should verify if there are enough competitors in the competition
	 * @throws Exception Exception
	*/ 
	@Test
	public void testIfThereAreEnougthCompetitor() throws Exception{
		assertTrue(competitionMock.getCompetitors().size()>1);
	}
	
	/**
	 * method that must throw an exception because the list will be empty
	 */
	@Test(expected = NoCompetitorAvailableException.class)
	public void mustReturnExceptionWhenCallingplay() {
		ArrayList<Competitor> arrayOfCompetitors=Competition.initCompetitor();
		int i=0;
		while(arrayOfCompetitors.size()>0) {
			arrayOfCompetitors.remove(i);
		}
		competitionMock.play(arrayOfCompetitors);
	}
	
	
	
	
	

}
