package mock;

import java.util.ArrayList;

import entity.Competitor;
import services.*;

public class MockMaster extends Master{

	public MockMaster(Selection criteria, int nbCompetitor, int nbGroup) {
		super(criteria, nbCompetitor, nbGroup);
	}

	@Override
	public void initPools() {
		ArrayList<Competitor> cl = new ArrayList<>();
		String newName="";
		League pool = null;
		for(int i = 0; i <this.nbGroup; i++) {
			pool=new MockLeague(cl, (this.nbCompetitor/this.nbGroup));
			for(int j=0;j<pool.getCompetitors().size();j++) {
				newName=pool.getCompetitors().get(j).getName()+"-pool"+i;
				pool.getCompetitors().get(j).setName(newName);
			}
			this.pools.add(pool);
		}
	}
	
	

}
