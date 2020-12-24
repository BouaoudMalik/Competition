package mock;

import entity.Competitor;
import services.*;
/**
 * 
 * Mock on Match class
 *
 */
public class MockMatch extends Match{
	

	/**
	 * Constructor
	 * @param competitorOne player 1
	 * @param competitorTwo player 2
	 */
	public MockMatch(Competitor competitorOne, Competitor competitorTwo) {
		super(competitorOne, competitorTwo);

	}

	/**
	 * getter of the first player
	 * @return competitor one 
	 */
	public Competitor getCompetitorOneMock() {
		return super.getCompetitorOne();
	}

	/**
	 * getter of the second player
	 * @return competitor two
	 */
	public Competitor getCompetitorTwoMock() {
		return super.getCompetitorTwo();
	}

	/**
	 * play a match means having one winner with one point
	 * forcing the return value
	 * @return competitor winner of the current match
	 */
	
	@Override
	public Competitor executeMatch() {
		this.getCompetitorOne().setPoints(this.getCompetitorOne().getPoints()+1);
		return this.getCompetitorOne();
	}
	
	/**
	 * return the second participant of the match
	 */
	@Override
	public Competitor getLoser() {
		return this.getCompetitorTwo();
	}

	@Override
	public Competitor getWinner() {
		return this.getCompetitorOne();
	}
	

}

