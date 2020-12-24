package services;

import java.util.*;

import entity.Competitor;
import observer.*;

/**
 * 
 * FairMatch class 
 *
 */
public class FairMatch extends Match{
	/**
	 * the loser competitor
	 */
	private Competitor loser=null;
	private Competitor winner=null;

	ArrayList<MatchListener> matchObservers=new ArrayList<>();
	
	
	/**
	 * Constructor 
	 * @param competitorOne player 1
	 * @param competitorTwo	player 2
	 */
	public FairMatch(Competitor competitorOne, Competitor competitorTwo) {
		super(competitorOne, competitorTwo);

	}
	
	/**
	 * executeMatch choose a random 
	 * number between 0 and 1 
	 * if 1 the winner is the player one
	 * if not the winner is the second one
	 */
	@Override
	public Competitor executeMatch() {
		Random random=new Random();
		int winner =random.nextInt(2);
		this.addMatchListener(new Bookmaker()); // we add the observers
		this.addMatchListener(new Journalist());
		if(winner==0) {
			this.loser=this.getCompetitorTwo();
			this.winner=this.getCompetitorOne();
			this.fireMatchListener();          //the match ended we have to notify the observer
			return this.getCompetitorOne();
		}
		else {
			this.loser=this.getCompetitorOne();
			this.winner=this.getCompetitorTwo();
			this.fireMatchListener();		//the match ended we have to notify the observer
			return this.getCompetitorTwo();
		}
	}
	
	

	@Override
	public Competitor getLoser() {
		return this.loser;
	}
	
	@Override
	public Competitor getWinner() {
		return this.winner;
	}

	
	
	
	
	public void addMatchListener (MatchListener ml) {
		this.matchObservers.add(ml);
	}

	public void removeMatchListener (MatchListener ml) {
		this.matchObservers.remove(ml);
	}
	
	
	public void fireMatchListener() {
		
		MatchEvent event=new MatchEvent(this);
		
		for(MatchListener ml: matchObservers) {
			ml.matchWasPlayed(event);
		}
		
	}
	

}

