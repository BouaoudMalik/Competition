package mock;

import java.util.*;
import entity.Competitor;
import services.*;
/**
 * Mock class of League
 * 
 *
 */
public class MockLeague extends League {

	private int nbMatch;
	/**
	 * Constructor of the class
	 * @param competitors List of Competitor
	 */
	public MockLeague(ArrayList<Competitor> competitors) {
		super(competitors);
		nbMatch = 0;
	}
	
	public MockLeague(ArrayList<Competitor> competitors,int nbc) {
		super(competitors);
		competitors=MockCompetition.initCompetitor(nbc);
	}
	/**
	 * getter for match number
	 * @return int 
	 */
	public int getnbMatch() {
		return this.nbMatch;
	}

	/**
	 * the first player gets 2 points because he wins 2 time
	 */
	@Override
	public void playOneLeagueGame(Competitor c1, Competitor c2) {
		nbMatch++;
		MockMatch match=new MockMatch(c1,c2);
		match.executeMatch();
		match.executeMatch();			
	}
	
	
}
