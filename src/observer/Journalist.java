package observer;
import services.*;
/**
 * Observing class Journalist
 *
 */
public class Journalist implements MatchListener{
/**
 * constructor
 */
	public Journalist() {}
	/**
	 * methods that listen to the match, it will be called when a match is over
	 * in this class it displays the result of a match
	 */
	@Override
	public void matchWasPlayed(MatchEvent event) {
		
		 Match m = (Match) event.getSource();
		 System.out.println("--**JOURNALIST**--");
		 System.out.println("Result of the match "+m.getWinner().getName()+" vs "+
				 			m.getLoser().getName() +"-> WINNER : "+m.getWinner().getName());
		
	}

}
