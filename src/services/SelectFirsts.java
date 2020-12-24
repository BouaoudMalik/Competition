package services;

import java.util.ArrayList;

import entity.Competitor;
import util.MapUtil;
/**
 * class that implement the interface Selection to define it's 
 * selectedForTournament method
 *
 */
public class SelectFirsts implements Selection{
	/**
	 * Constructor
	 */
	public SelectFirsts() {}

	/**
	 * Here the method choose the first from each pool from an ArrayList of
	 * pool given, and put the participant
	 * into the arrayList
	 */
	@Override
	public ArrayList<Competitor> selectedForTournament(ArrayList<League> pools) {
		ArrayList<Competitor> selectedOnes=new ArrayList<>();
		
		for(League l:pools) {
			selectedOnes.add(MapUtil.mapToArrayList(l.ranking()).get(0));
		}
		return selectedOnes;
	}
	

}
