package services;

import java.util.*;
import entity.Competitor;
import util.MapUtil;
/**
 * League class that extends Competition
 * 
 *
 */
public class League extends Competition{
	
	//private Competitor winner = this.getCompetitors().get(0);

	public League(ArrayList<Competitor> competitors) {
		super(competitors);
	}
	/**
	 * Overloading constructor
	 * @param Empty competitors List Of participant
	 * @param nbc number of them
	 */
	public League(ArrayList<Competitor> competitors,int nbc) {
		super(competitors,nbc);
		this.competitorsList=Competition.initCompetitor(nbc);
	}
	

	@Override
	public void play(ArrayList<Competitor> competitors) {


		for (int i =0; i<competitors.size(); i++) {
			for(int j = 0; j<competitors.size(); j++) 
				if(competitors.get(i)!=competitors.get(j)) {
					playOneLeagueGame(competitors.get(i),competitors.get(j));
				}
					
				
			rank.put(competitors.get(i).getName(), competitors.get(i).getPoints());
			competitors.remove(competitors.get(i));
		}
	}
	

	
	protected void playOneLeagueGame(Competitor c1, Competitor c2) {
		Match match=new FairMatch(c1,c2);
		Competitor winnerAller=match.executeMatch();
		winnerAller.setPoints(winnerAller.getPoints()+1);
		Competitor winnerRetour=match.executeMatch();
		winnerRetour.setPoints(winnerRetour.getPoints()+1);
		System.out.println("match allé : " + c1 + " vs " + c2 + "-->" + winnerAller + " wins!"  );
		Competitor retour=match.executeMatch();
		System.out.println("match retour : " + c2 + " vs " + c1 + "-->" + winnerRetour + " wins!"  );
		

	}
	
	public Competitor getlWinnerLeague() {
		Competitor realwinner=this.getCompetitors().get(0);
		for(Competitor c : MapUtil.mapToArrayList(this.ranking())) {
			if(realwinner.getPoints()<=c.getPoints()){
				realwinner=c;
			}
			
		}
		return realwinner;
		
	}
	
	
	
	
}
