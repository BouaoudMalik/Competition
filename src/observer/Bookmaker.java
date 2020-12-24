package observer;

import services.*;
import java.util.*;
import entity.Competitor;
/**
 * 
 * Observing Class BOOKMAKER
 *
 */
public class Bookmaker implements MatchListener{
	/**
	 * Constructor
	 */
	public Bookmaker(){}
	
	/**
	 * a static list because we have one list for the bookmaker
	 */
	
	private static ArrayList <Competitor> allCompetitor=new ArrayList<>();
	
	

	/**
	 * methods that listen to the match, it will be called when a match is over
	 * in this class it updates the cote of the competitors that are playing the match
	 */
	
	@Override
	public void matchWasPlayed(MatchEvent event) {
		 Match m = (Match) event.getSource();
		 /*setting the cotes*/
		 //we add one to the loser
		 m.getLoser().setCote(m.getLoser().getCote()+1);
		 //we substract one to the winner
		 m.getWinner().setCote(m.getWinner().getCote()-1);
		 System.out.println("--**BOOKMAKER**--");
		 System.out.println("la cote de "+m.getWinner().getName()+" est de : "+m.getWinner().getCote());
		 if(!allCompetitor.contains(m.getWinner())) this.allCompetitor.add(m.getWinner());
		 System.out.println("la cote de "+m.getLoser().getName()+" est de : "+m.getLoser().getCote());
		 if(!allCompetitor.contains(m.getLoser())) this.allCompetitor.add(m.getLoser());
		 
	}
	
	/**
	 * the list of the competitors
	 * @return
	 */
	public static ArrayList <Competitor>  displayListOfCompetitor(){
		
		return allCompetitor;
	}
	
}
