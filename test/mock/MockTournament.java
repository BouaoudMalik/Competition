package mock;

import java.util.*;

import entity.Competitor;
import services.*;
import util.MapUtil;

/**
 * 
 * Mock on Tournament class
 *
 */

public class MockTournament extends Tournament {
	
	private Competitor winner = null;
	
	/**
	* Constructor
	* @param competitors Competitor's list
	*/
	public MockTournament(ArrayList<Competitor> competitors) {	
		super(competitors);
	}
	
	/**
	 * get the ranking map
	 * @return Map 
	 */
	
	public Map<String, Integer> getRank(){
		MapUtil.sortByDescendingValue(rank);
		return this.rank;
	}
	
	/**
	 * get the winner
	 * @return Competitor
	 */
	public Competitor getWinner() {
		return this.winner;
	}
	
	/**
	 * takes a list of Competitors and schedule a match between 2 of them
	 */
	@Override
	public void play(ArrayList<Competitor> competitors) {
		Competitor competitor1 = competitors.get(0);
		Competitor competitor2 = competitors.get(1);
		competitors.remove(competitor1);
		competitors.remove(competitor2);
		MockMatch match=new MockMatch(competitor1,competitor2);
		Competitor winner=match.executeMatch();
		competitors.add(winner);
	}
	
	

}