package junitTest;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import entity.Competitor;
import mock.*;

public class FairMatchTest extends MatchTest{

	/**
	 * Test method for executeMatch that test if a competitor
	 * is a winner by testing the number of his points 
	 * initially the winner is Bruno so we test that
	 */
	@Test
	public void executeMatch() {
		Competitor winner=new Competitor("Bruno");
		Competitor loser=new Competitor("Sam");
		MockMatch mckMatch=new MockMatch(winner,loser);
		Competitor executeMatchWinner=mckMatch.executeMatch();
		//the winner should be Bruno
		assertEquals(winner.getName(),executeMatchWinner.getName());
		//the winner should have at least one point
		assertTrue(executeMatchWinner.getPoints()>0);
		}


}
