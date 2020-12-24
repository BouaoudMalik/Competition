package observer;
import java.util.*;

public interface MatchListener extends EventListener{
	
	public void matchWasPlayed(MatchEvent event);
	
}
