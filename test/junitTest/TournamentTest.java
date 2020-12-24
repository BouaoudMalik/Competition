package junitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import org.junit.Before;
import entity.Competitor;
import exceptions.NotPowerOfTwoException;
import mock.*;
import services.*;

public class TournamentTest extends CompetitionTest{

	ArrayList<Competitor> arrayComp = Competition.initCompetitor();
	private MockTournament mckTournament = new MockTournament(arrayComp);	
	
	@Before
	public void init() {
		assertNotNull(arrayComp.size());
		assertEquals(8,arrayComp.size());		
	}
	
	
	
	/**
	 * the number of competitor should be a power of 2
	 */
	@Test
	public void testIfnbCompetitorPowOf2() {
		int nbcompetitor=arrayComp.size();
		assertTrue((int)(Math.ceil((Math.log(nbcompetitor) / Math.log(2)))) == 
			       (int)(Math.floor(((Math.log(nbcompetitor) / Math.log(2))))));
	}
	
	/**
	 * Test if play method remove one player from the competitors list
	 * and test if the winner have at least one point
	 * the winner is on the end of the list 
	 */
	
	@Test
	public void testForPlay() {
		MockTournament mckT=new MockTournament(arrayComp);
		mckT.play(arrayComp);
		assertEquals(arrayComp.size(),7);
		assertTrue(arrayComp.get(6).getPoints()>0);
		
		
	}
	
	/**
	 * exception expected to be thrown because the number of participant is invalid
	 */
	
	@Test(expected=NotPowerOfTwoException.class)
	public void testForPlayMustReturnExceptionNotPow2() {
		ArrayList<Competitor> arrayComp2=arrayComp;
		Tournament t=new Tournament(arrayComp2);
		t.getCompetitors().remove(0);
		t.play();
		
	}
	
	
}
