package observer;
import java.util.*;

import services.*;

public class MatchEvent extends EventObject{

	public MatchEvent(Match source) {
		super(source);
		
	}

}
