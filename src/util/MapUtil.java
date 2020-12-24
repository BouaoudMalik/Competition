package util;

import java.util.*;
import java.util.Map.Entry;

import entity.Competitor;

/**
 * 
 * class that will allow us to sort a Map
 *
 */
public class MapUtil {
	
	
	/**
	 * sortByDecenginValue allow us to sort a map with descending value
	 */
		public static <K, V extends Comparable<? super V>> Map<K, V> sortByDescendingValue(Map<K, V> map) {
		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map. entrySet ( ) );
		Collections . sort ( sortedEntries , new Comparator<Entry<K, V>>() {
		@Override
		public int compare(Entry<K, V> e1, Entry<K, V> e2) {
		return e2. getValue ( ).compareTo(e1. getValue ( ) );
		}
		});
		Map<K, V> result = new LinkedHashMap<>();
		for (Entry<K, V> entry : sortedEntries ) {
		result. put( entry . getKey () , entry . getValue ( ) );
		}
		return result ;
		}
		
		
		
		/**
		 * Method that return an arrayList of competitors
		 * it will help us instead of looping the ranking map
		 * @return arrayList of competitor
		 */
		public static ArrayList <Competitor> mapToArrayList(Map<String,Integer> ranking){
			ArrayList<Competitor> arrayedMap=new ArrayList<>();
			Iterator it=ranking.entrySet().iterator();
			Competitor c;
			Map.Entry m;
			while(it.hasNext()) {
				m=(Map.Entry) it.next();
				c=new Competitor(m.getKey().toString());
				c.setPoints(Integer.parseInt(m.getValue().toString()));
				arrayedMap.add(c);
			}
			
			
			return arrayedMap;
			
		}

}
