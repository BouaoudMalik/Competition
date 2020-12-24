package services;

import java.util.*;
import entity.Competitor;

/**
 * Interface that contains only a method that we be implemented by sub classes
 */
public interface Selection {

	public ArrayList<Competitor> selectedForTournament(ArrayList<League> pools);
	
}
