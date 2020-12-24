package services;

import entity.Competitor;

/**
 * 
 * Match class
 *
 */
public abstract class Match {


	private Competitor competitorOne,competitorTwo;
	/**
	 * class constructor
	 * @param competitorOne
	 * @param competitorTwo
	 */
	public Match(Competitor competitorOne,Competitor competitorTwo) {
		this.competitorOne=competitorOne;
		this.competitorTwo=competitorTwo;
	}

	/**
	 * getter of the first player
	 * @return player 1
	 */
	public Competitor getCompetitorOne() {
		return competitorOne;
	}

	/**
	 * setter of the first competitor
	 * @param competitorOne player 1
	 */
	public void setCompetitorOne(Competitor competitorOne) {
		this.competitorOne = competitorOne;
	}

	/**
	 * getter of the second player
	 * @return player 2
	 */
	public Competitor getCompetitorTwo() {
		return competitorTwo;
	}

	/**
	 * setter of the second competitor
	 * @param competitorTwo
	 */
	public void setCompetitorTwo(Competitor competitorTwo) {
		this.competitorTwo = competitorTwo;
	}
	
	/**
	 * this methods runs a game
	 * it takes the two competitors of the class
	 * and return one of them according to the sub class
	 * 
	 * @return the winner of the game
	 */
	public abstract Competitor executeMatch();
	
	
	/**
	 * get loser of the match
	 * @return competitor
	 */
	public abstract Competitor getLoser();
	
	/**
	 * get the winner of the match
	 * @return competitor
	 */
	public abstract Competitor getWinner();
}

