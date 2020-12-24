package services;

import java.util.*;

import entity.Competitor;
import exceptions.NoCompetitorAvailableException;
import util.MapUtil;

/**
 * Abstract class of implementing a Competition
 *
 */
public abstract class Competition {
	
	/**
	 * ArrayList of the competitor that will play the competition
	 */
	
	protected ArrayList<Competitor> competitorsList = new ArrayList<Competitor>();
	
	
	/**
	 * ranking map couple =(name,score)
	 */
	protected Map<String, Integer> rank = new HashMap<String, Integer>();
	

	/**
	 * Constructor of a competition
	 * call to the method static init in order to have all the competitors ready
	 * @param competitorsList
	 */
	
	public Competition(ArrayList<Competitor> competitorsList) {
		this.competitorsList=competitorsList;	
		this.competitorsList=Competition.initCompetitor();
	}
	
	public Competition(ArrayList<Competitor> competitorsList,int nbc) {
		this.competitorsList=competitorsList;
	}
	

	/**
	 * methods that plays the competition until we have only one winner
	 * 
	 */
	
	public void play() {
				
		//while we still have more than one competitor the game runs
		while((this.competitorsList.size()>1)) {
		//we use the play methods to choose players and let them play
			this.play(this.competitorsList);
		}
		// adding the winner to the ranking map
		rank.put(this.getCompetitors().get(0).getName(), this.getCompetitors().get(0).getPoints());
	}
	
	
	/**
	 * getter on the list competitor
	 * @return Competitor's List
	 */
	public ArrayList<Competitor> getCompetitors() {
		return this.competitorsList;
	}
	
	
	/**
	 * method that sort the map by descending values 
	 * form the top winner to the looser
	 * @return Map with the competitors as key and his score(points) as value
	 */
	public Map<String, Integer> ranking(){
		return MapUtil.sortByDescendingValue(rank);		
	}
	
	
	/**
	 * play with List will take two players and organize a match
	 * with the method playMatch , the players are removed from the list
	 * @param competitors List competitors
	 */
	protected abstract void play(ArrayList<Competitor> competitors);
	
	/**
	 * select the competitor with the higher score
	 * @param listCompetitor a list of competitor
	 * @return a competitor
	 */

	public static Competitor getMaxScoreCompetitor(ArrayList<Competitor> listCompetitor) {
		Competitor competitorWithmaxScore=listCompetitor.get(0);
		for(Competitor c: listCompetitor) {
			if(competitorWithmaxScore.getPoints()<= c.getPoints()) {
				competitorWithmaxScore=c;
			}
		}
		
		return competitorWithmaxScore;
	}
	
	/**
	 * select the competitor with the lower score
	 * @param listCompetitor a list of competitor
	 * @return competitor
	 */
	
	public static Competitor getMinScoreCompetitor(ArrayList<Competitor> listCompetitor) {
		Competitor competitorWithminScore=listCompetitor.get(0);
		for(Competitor c: listCompetitor) {
			if(competitorWithminScore.getPoints()>= c.getPoints()) {
				competitorWithminScore=c;
			}
		}
		
		return competitorWithminScore;
	}
	
	
	
	/**
	 * static method thats return an arrayList of all competitors
	 * it will help us while creating competitions
	 * @return arrayList of competitors
	 */
	public static ArrayList<Competitor> initCompetitor() throws NoCompetitorAvailableException{ 
		ArrayList<Competitor> cl=new ArrayList<Competitor>();
		 Competitor c1=new Competitor("Sam");
		 cl.add(c1);
		 Competitor c2=new Competitor("Alex");
		 cl.add(c2);
		 Competitor c3=new Competitor("Bruno");
		 cl.add(c3);
		 Competitor c4=new Competitor("Malik");
		 cl.add(c4);
		 Competitor c5=new Competitor("maxime");
		 cl.add(c5);
		 Competitor c6=new Competitor("zack");
		 cl.add(c6);
		 Competitor c7=new Competitor("harry");
		 cl.add(c7);
		 Competitor c8=new Competitor("bill");
		 cl.add(c8);
		 
		 if(cl.size()==0) throw new NoCompetitorAvailableException("No one is Participating ");
		 
		 return cl;
		 
	}
	
	
	
	/**
	 * Overloading the previous method
	 * @param nbc number of Competitors 
	 * @return arrayList of Competitors
	 */
	public static ArrayList<Competitor> initCompetitor(int nbc){
		
		Scanner sc=new Scanner(System.in);
		Competitor competitorAdded;
		int cpt=1;
		ArrayList<Competitor> cl=new ArrayList<Competitor>();
		
		for(int i=0;i<nbc;i++) {
			System.out.printf("\nDo enter the %d competitor name  :",cpt);
			competitorAdded = new Competitor(sc.next());
			//the cote is equal to the number of participant
			competitorAdded.setCote(nbc);;
			cl.add(competitorAdded);
			cpt++;
		}
		return cl;
		
	}
	
	
	
	
	
	
}
