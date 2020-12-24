package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entity.Competitor;
import exceptions.*;
/**
 * Tournament class that extends Competition class
 
 *
 */
public class Tournament extends Competition{

	
	/**
	 * Constructor of a tournament
	 * @param competitors
	 */
	public Tournament(ArrayList<Competitor> competitors) {
		super(competitors);
	}
	
	/**
	 * Overloading constructor
	 * @param competitors
	 * @param nbCompetitor
	 */
	public Tournament(ArrayList<Competitor> competitors, int nbCompetitor) {
		super(competitors,nbCompetitor);
	}

	

	@Override
	public void play(ArrayList<Competitor> competitors){
		Random random = new Random();
		Competitor competitor1 = competitors.get(random.nextInt(competitors.size()));
		competitors.remove(competitor1);
		Competitor competitor2 = competitors.get(random.nextInt(competitors.size()));
		competitors.remove(competitor2);
		Match match=new FairMatch(competitor1,competitor2);
		Competitor winner=match.executeMatch();
		winner.setPoints(winner.getPoints()+1);
		this.rank.put(match.getLoser().getName(), match.getLoser().getPoints());
		competitors.add(winner);
		
	}
/**
 * the play method here must throw a NotPowerOfTwoException if 
 * the list size is not a power of 2
 */
	@Override
	public void play() throws NotPowerOfTwoException{
		if(super.getCompetitors().size()%2!=0) {
			throw new NotPowerOfTwoException("The number of participant"
				+ "to the tournament is not a power of two");}
		else {
		super.play();}
	}

	

}
