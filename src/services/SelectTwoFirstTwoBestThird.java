package services;

import java.util.ArrayList;

import entity.Competitor;
import exceptions.NotEnoughtCompetitorException;
import util.MapUtil;
/**
 * class that implement the interface Selection to define it's 
 * selectedForTournament method
 *
 */

public class SelectTwoFirstTwoBestThird extends SelectTwoFirsts{
	
	/**
	 * Constructor
	 */
	public SelectTwoFirstTwoBestThird() {}

	/**
	 * Here the method choose the two first and two best third from each pool from an ArrayList of
	 * pool given, and put the participant
	 * into the arrayList with calling the super class method that select the two first
	 * so here we have to get the 2 best third only 
	 */ 
	
	@Override
	public ArrayList<Competitor> selectedForTournament(ArrayList<League> pools) throws NotEnoughtCompetitorException{
		
		if(pools.get(0).getCompetitors().size()/pools.size()<3) {
			throw new NotEnoughtCompetitorException("Nombre de compétiteur insuffisant : "
					+ "Il faut au moins 3 competiteurs par poule ");
		}
		
		ArrayList<Competitor> selectedOnes = super.selectedForTournament(pools);
		
		ArrayList<Competitor> allThird=new ArrayList<>();
		for(League l:pools) {
			allThird.add(MapUtil.mapToArrayList(l.ranking()).get(2));
		}
		
		Competitor compFirstthird=Competition.getMaxScoreCompetitor(allThird);
		allThird.remove(compFirstthird);
		Competitor compSecondthird=Competition.getMaxScoreCompetitor(allThird);
		
		selectedOnes.add(compFirstthird);
		selectedOnes.add(compSecondthird);
		
		return selectedOnes;
	}
	

}
