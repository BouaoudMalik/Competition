package services;

import java.util.ArrayList;

import entity.Competitor;
import exceptions.NotPowerOfTwoException;
import util.MapUtil;
/**
 * 
 * Master class a class that organize pools and select them to a final par
 *
 */


public class Master {
	protected ArrayList<League> pools = new ArrayList<>();
	protected Selection criteria;
	protected int nbCompetitor, nbGroup;
	private Competitor winner=null;
	
	
	/**
	 * COnstructor
	 * @param criteria integer for the selection type
	 * @param nbCompetitor number of competitors
	 * @param nbGroup	   number of groups
	 */
	public Master(Selection criteria, int nbCompetitor, int nbGroup) {
		this.nbCompetitor = nbCompetitor;
		this.nbGroup = nbGroup;
		this.criteria=criteria;
		this.initPools();
	}

	

	/**
	 * getter for winner of the tournament 
	 * @return winner of finals
	 */
	public Competitor getWinnerOfFinals() {
		return this.winner;
	}
	
	/**
	 * getter for the pools list
	 * @return ArrayList of pools
	 */

	public ArrayList<League> getPools() {
		return this.pools;
	};
	
	/**
	 * initPools create an arrayList of league,
	 * Competitor will be manually put in a terminal
	 * @return ArrayList of League
	 */
	public void  initPools(){
		ArrayList<Competitor> cl = new ArrayList<>();
		String newName="";
		League pool = null;
		for(int i = 0; i <this.nbGroup; i++) {
			pool=new League(cl, (this.nbCompetitor/this.nbGroup));
			for(int j=0;j<pool.getCompetitors().size();j++) {
				newName=pool.getCompetitors().get(j).getName()+"-pool"+i;
				pool.getCompetitors().get(j).setName(newName);
			}
			this.pools.add(pool);
		}
	}

	/**
	 * getter for the number of groups
	 * @return integer number of groups
	 */
	public int getnbGroup() {
		return this.nbGroup;
	}
	
	
	/**
	 * playPools schedule the pools
	 */
	public void playPools() {
		
		for(int i=0;i<this.pools.size();i++) {
			
			System.out.printf("\nThe pool %d starts !\n",i);
			this.pools.get(i).play();
			System.out.printf("Ranking for the pool %d : ",i);
			System.out.println(this.pools.get(i).ranking());
		}
		
	}
	/**
	 * select the participant for the tournament
	 * @return
	 */
	public ArrayList<Competitor> selectionPhase(){
		ArrayList <Competitor> selectedForFinals = null;		
		for(int i=0;i<selectedForFinals.size();i++) {
			selectedForFinals.get(i).setPoints(0);
		}
		
		return selectedForFinals;
	}
	
	/**
	 * playMaster use playPools and tournament.play(ArrayList<Competitor> competitors)
	 */
	public void playMaster() /*throws NotPowerOfTwoException*/{
		System.out.println("initializing the  pools :");
		this.playPools();
		ArrayList<Competitor>selected=this.selectionPhase();
		System.out.println("\nThe selected ones are : "+selected);
		Tournament tournament = new Tournament(selected,selected.size());
		tournament.play();
		winner=MapUtil.mapToArrayList(tournament.ranking()).get(0);//tournament.mapToArrayList().get(0);
		System.out.println("\nWinner of the tournament : " + winner.getName()+ ",score : "+winner.getPoints());
		System.out.println("Tournament ranking :"+tournament.ranking());
	}
}
