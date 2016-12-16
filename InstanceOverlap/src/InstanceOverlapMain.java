import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class InstanceOverlapMain {

	public static void main(String[] args) throws IOException {
		
		ClassMapping cM = new ClassMapping();
		ArrayList<String> classNames = getClassNames();
		
	// SAME AS LINKS
		// PARAMETERS		
		/*boolean d2y = true;
		boolean d2o = true;
		boolean y2d = true;
		boolean o2d = true;
		CountSameAs same = new CountSameAs();
		same.run(classNames, cM, d2y, d2o, y2d, o2d);
		*/
	// INSTANCE MATCHES USING STRING SIMILARITY MEASURES
		
		//configure log4j for secondstring library
		org.apache.log4j.BasicConfigurator.configure();
		//LogManager.getRootLogger().setLevel(Level.OFF); //set console logger off
		
		boolean useSamples = true;
		// PARAMETERS: string similarity measures and thresholds
		boolean exactMatch = true;
		boolean jaccard = true;
		double jaccardT = 1.0;
		boolean jaro = true;
		double jaroT = 1.0;
		boolean scaledLevenstein = true;
		double scaledLevensteinT = 1.0;
		boolean tfidf = false;
		double tfidfT = 1.0;
		boolean jaroWinkler = true;
		double jaroWinklerT = 1.0;
		boolean softTfidf = true;
		double softTfidfT = 1.0;
		boolean internalSoftTfidf = false;
		String internalSoftTfidfS = "jaroWinkler"; //"jaroWinkler", "jaccard", or "scaledLevenstein"
		double internalSoftTfidfT = 0.9;
		
		classNames.clear();
		useSamples = false;
	//set param	
		double threshold = 1.0; //1.0, 0.9, 0.8
		//classNames.add("Planet"); //done for 1, .9, .8
		//classNames.add("Automobile"); //done for 1, .9, .8
		classNames.add("Song"); //done for
		
		
		
		if (threshold == 1.0)
			exactMatch = true;
		else
			exactMatch = false;
		
		StringMeasures stringMeasures = new StringMeasures(exactMatch,
				jaccard, threshold, 
				jaro, threshold, 
				scaledLevenstein, threshold, 
				tfidf, threshold, 
				jaroWinkler, threshold,
				softTfidf, threshold, internalSoftTfidf, internalSoftTfidfS, internalSoftTfidfT);
			
		/*StringMeasures stringMeasures = new StringMeasures(exactMatch,
				jaccard, jaccardT, 
				jaro, jaroT, 
				scaledLevenstein, scaledLevensteinT, 
				tfidf, tfidfT, 
				jaroWinkler, jaroWinklerT,
				softTfidf, softTfidfT, internalSoftTfidf, internalSoftTfidfS, internalSoftTfidfT);*/
		
		CountStringSimilarity stringSim = new CountStringSimilarity();
		stringSim.run(classNames, cM, stringMeasures, useSamples);
		
		/*double[] tArray = {0.9, 0.8};
		//double[] tArray = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
		stringMeasures.setExactMatch(false);
		
		for (double newT : tArray) {
			//set new thresholds
			stringMeasures.setInternalSoftTfidfT(newT);
			stringMeasures.setJaccardT(newT);
			stringMeasures.setJaroT(newT);
			stringMeasures.setJaroWinklerT(newT);
			stringMeasures.setScaledLevensteinT(newT);
			stringMeasures.setSoftTfidfT(newT);
			stringMeasures.setTfidfT(newT);
			//rerun
			stringSim.run(classNames, cM, stringMeasures, useSamples);
			System.out.println("Done with " + newT);
		}*/
		
		//CALCULATE ESTIMATED INSTANCE OVERLAP
		//EstimatedInstanceOverlap overlap = new EstimatedInstanceOverlap();
		//overlap.run(classNames, cM);
		
		System.out.println("DONE");

	}
	
	private static ArrayList<String> getClassNames() {
		ArrayList<String> classNames = new ArrayList<String>();
		classNames.addAll(Arrays.asList(
							//PERSON
							/*	"Agent",
								"Person",
								"Politician",
								"Athlete",
								"Actor",
							//ORGANIZATION
								"GovernmentOrganization",
								"Company",
								"PoliticalParty",
							//PLACE
								"Place",
								"PopulatedPlace",
								"City_Village_Town",
								"Country",
							//ART
								"Work",
								"MusicalWork",
								"Album",
								"Song",
								/*"Single",
								"Movie",
								"Book",
							//EVENT	
								"Event",
								"MilitaryConflict",
								"SocietalEvent",
								"SportsEvent",
							//TRANSPORT
								"Vehicle",
								"Automobile",
								/*"Ship",
								"Spacecraft",
							//OTHER
								"ChemicalElement_Substance",
								"CelestialBody_Object",*/
								"Planet"
							));
		return classNames;
	}
	

}