import java.util.HashMap;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

/**
 * Visualizing Life Expectancy in different countries based on 
 * LifeExpectancyWorldBankModule3.csv file in data folder
 * @author ahdieh
 *
 */

public class LifeExpectancy extends PApplet{

	UnfoldingMap map;
	Map<String, Float> lifeExpectancyByCountry;
	
	public void setup() {
		size(950, 600, OPENGL);
		map = new UnfoldingMap(this, new Microsoft.RoadProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// Load data file
		lifeExpectancyByCountry = loadCSVFile("LifeExpectancyWorldBankModule3.csv");		
		//printing Map in the console
		for (String  key:  lifeExpectancyByCountry.keySet()) {
			System.out.println(key + " , " + lifeExpectancyByCountry.get(key).toString());
		}
	}
	
	// loading a CSV file into map
	private Map<String, Float> loadCSVFile(String fileName) {

		Map<String, Float> lifeExpMap = new HashMap<String, Float>();
		
		String[] rows = loadStrings(fileName);
		for(String row : rows) {
			String[] columns = row.split(",");
			
			if(columns.length == 6 && !columns[5].contains("..") ) {
				lifeExpMap.put(columns[4], Float.parseFloat(columns[5]));
			}
			
		}
		return lifeExpMap;
	}

	public void draw() {
		map.draw();
	}
}
