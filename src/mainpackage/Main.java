package mainpackage;

import java.util.*;

import entity.Competitor;
import exceptions.NotPowerOfTwoException;
import observer.Bookmaker;
import services.*;
import util.MapUtil;

/**
 * 
 * Class contains Main methode
 *
 */
public class Main {
/**
 * Main class
 * @param args empty  args
 */
	public static void main(String[] args) {
		
		System.out.println("Welcome to our competition application !");
		System.out.println("Enter a power of 2 number of competitors ");
		Scanner sc=new Scanner(System.in);
		int nbCompetitors=sc.nextInt();
		
		while((int)(Math.ceil((Math.log(nbCompetitors) / Math.log(2)))) != 
			       (int)(Math.floor(((Math.log(nbCompetitors) / Math.log(2)))))) {
			System.out.println("pls enter a power of 2 number of competitors ");
			nbCompetitors=sc.nextInt();
		}
		
		System.out.println("Enter the number of  pools (this number must be divisible by 2)  ");
		int nbGroup=sc.nextInt();
		System.out.println("Enter the chosen Strategy Of Selection to finals  : \n The number of participant to finals"
				+ "must be a power of 2, so please enter a suitanle type");
		System.out.println("1-TYPE : selection of the firsts Only");
		System.out.println("2-TYPE : selection of the two firsts");
		if ((nbCompetitors/nbGroup)>=3)
			System.out.println("3-TYPE :selection of the two firsts and two best third");
		if(nbGroup%2!=0) {System.out.println("You cannot choose TYPE 1 , TYPE 3 is set by default ");}

		int nbType=sc.nextInt();
		
		Selection selectionStrategy;
		
		switch(nbType) {
		case 1:
			selectionStrategy = new SelectFirsts();
			break;
		case 2:
			selectionStrategy = new SelectTwoFirsts();
			break;
		case 3:
			selectionStrategy =new SelectTwoFirstTwoBestThird();
			break;
		default :
			selectionStrategy =new SelectTwoFirstTwoBestThird();
		
		}
		
			Master master = new Master(selectionStrategy ,nbCompetitors,nbGroup);
			
			try {
			master.playMaster();
			
			System.out.println("The list of Cote : ");
			
				for (Competitor c:Bookmaker.displayListOfCompetitor()){
					System.out.println("Name : "+c.getName()+" ,cote : "+c.getCote());
				}
			}
			catch(NotPowerOfTwoException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
		
	}

