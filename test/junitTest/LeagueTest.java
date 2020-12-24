package junitTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import entity.Competitor;
import mock.*;
import services.*;


class LeagueTest extends CompetitionTest {

	ArrayList<Competitor> arrayComp = Competition.initCompetitor();
	private MockLeague mckLeague = new MockLeague(arrayComp);
	/**
	 * test for play
	 */
	@Test
	public void playTest() {
		assertEquals(arrayComp.size(),8);
		mckLeague.play(arrayComp);
		//22 because we have 8 participant so it's 8*2+2+2+2
		//the 4 last participant plays  4 match
		//then the 2 lasts plays 2 match too
		assertEquals(mckLeague.getnbMatch(),22);
		
		
		
	}
	/**
	 * test for the playoneGameLeague
	 */
	@Test
	public void playOneLeagueGameTest() {
		mckLeague.playOneLeagueGame(mckLeague.getCompetitors().get(0), mckLeague.getCompetitors().get(1));
		assertEquals( mckLeague.getCompetitors().get(0).getPoints(),2);
		
	}

}
