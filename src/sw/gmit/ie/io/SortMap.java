package sw.gmit.ie.io;

import java.util.Comparator;
import java.util.Map;

/*
 * Class Used to Sort the Map--can be slow dependant on the size of the file
 */
public class SortMap implements Comparator<String>{
	
	Map<String, Integer> sortMap;
	
	public SortMap(Map<String, Integer> sortMap) {
		this.sortMap = sortMap;
	}

	@Override
	public int compare(String word1, String word2) {
		// TODO Auto-generated method stub
		if(sortMap.get(word1) >= sortMap.get(word2)) {
			return -1;
		}
		else{
			return 1;
		}
	}
	
	

}
