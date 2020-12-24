package mock;


import java.util.*;
import entity.Competitor;
import exceptions.NoCompetitorAvailableException;
import services.*;
import util.MapUtil;

/**
 * Mock of Competition
 * 
 *
 */

public class MockCompetition extends Competition {
	
	protected Map<String, Integer> rank = new HashMap<String, Integer>();
	protected Competitor winner = null;

	/**
	 * Constructor using the super class constructor
	 * @param competitors List of Competitors
	 */
	
	public MockCompetition(ArrayList<Competitor> competitors) {
		super(competitors);	
	}
	
	/*
	public void initCompetition() {
		this.competitorsList=Competitor.initCompetitor();
	}*/
	
	/**
	 * get the ranking Map
	 * @return Map with key =Name and value =score
	 */
	public Map<String, Integer> getRank(){
		MapUtil.sortByDescendingValue(rank);
		return this.rank;
	}
	
	/**
	 * When a competition is finished we should have one winner
	 * so the playMock
	 */
	@Override
	public void play(ArrayList<Competitor> competitors) throws NoCompetitorAvailableException{
		if(competitors.size()==0) throw new NoCompetitorAvailableException("No One is participating");
		int i=0;
		while(super.getCompetitors().size()!=1) {
			super.getCompetitors().remove(i);
			rank.put(this.getCompetitors().get(i).getName(), this.getCompetitors().get(i).getPoints());
		}
		// the winner should have more than 0 points
		super.getCompetitors().get(0).setPoints(5);
	}

	public Competitor getWinner() {
		return this.winner;
	}
	
	/**
	 * static method that create a nbc number of participant and put them into an ArrayList
	 * @param nbc number of participant to create
	 * @return an arrayList of participant
	 */
		public static ArrayList<Competitor> initCompetitor(int nbc){
			
			
			int cpt=1;
			ArrayList<Competitor> cl=new ArrayList<Competitor>();
			
			for(int i=0;i<nbc;i++) {
				cl.add(new Competitor((String)("Competitor")+i));
				cpt++;
			}
			return cl;
		}

}
