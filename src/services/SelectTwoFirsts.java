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
public class SelectTwoFirsts extends SelectFirsts{
	/**
	 * constructor
	 */
	public SelectTwoFirsts() {}

	/**
	 * Here the method choose the two first from each pool from an ArrayList of
	 * pool given, and put the participant
	 * into the arrayList with calling to the super class method that select the firsts
	 * so we just have to select the seconds here
	 */
	@Override
	public ArrayList<Competitor> selectedForTournament(ArrayList<League> pools) throws NotEnoughtCompetitorException{
		
		if((pools.get(0).getCompetitors().size()/pools.size())<2) {
			System.out.println("test nb competitteur dans poule" + pools.get(0).getCompetitors().size()/pools.size());
			throw new NotEnoughtCompetitorException("Nombre de compétiteur insuffisant : "
					+ "Il faut au moins 2 competiteurs par poule ");
		}
		
		ArrayList<Competitor> selectedOnes = super.selectedForTournament(pools);
		
		for(League l:pools) {
			selectedOnes.add(MapUtil.mapToArrayList(l.ranking()).get(1));
		}
		return selectedOnes;
	}
	
	

}
