import java.util.HashMap;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;


public class CountStringSimilarityResults {
	//x2y<kgClass<simMeasure, instanceCount>
	//private HashMap<String, HashMap<String, HashMap<String, Integer>>> simResults  = new HashMap<String, HashMap<String, HashMap<String, Integer>>>();
	
	//Triple<x2y, kgClass, simMeasure>, instanceCount
	private HashMap<Triple<String, String, String>, Integer> simResultsT = new HashMap<Triple<String,String,String>, Integer>(); 
	
	public CountStringSimilarityResults() {
	
	}
	
	public void addInstanceCount(String x2y, String kgClass, String simMeasure) {
		ImmutableTriple<String, String, String> t = new ImmutableTriple<String,String,String>(x2y, kgClass, simMeasure);
		
		//check if t is already in simResultT
		if (simResultsT.containsKey(t)) {
			simResultsT.put(t, simResultsT.get(t) + 1);//increase count
		} else {
			simResultsT.put(t, 1);//inizialize count
		}
	}
	
	/**
	   * Get the number of instances that overlap
	   * @param x2y (fromKG-toKG, available values:d,y,o,n,w. e.g. d2y)
	   * @param kgClass (class of the fromKG)
	   * @param simMeasure (exactMatch, jaccard, jaro, scaledLevenstein, tfidf, jaroWinkler)
	   * @return int (instance overlap count)
	   */
	public int getInstanceOverlapCount(String x2y, String kgClass, String simMeasure) {
		//return this.simResults.get(x2y).get(kgClass).get(simMeasure);
		ImmutableTriple<String, String, String> t = new ImmutableTriple<String,String,String>(x2y, kgClass, simMeasure);
		return this.simResultsT.get(t);
	}
	public Set<Triple<String, String, String>> getTriples() {
		return simResultsT.keySet();
		
	}
	
	
}