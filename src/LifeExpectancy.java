import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

/**
 * Visualizing Life Expectancy in different countries
 * @author ahdieh
 *
 */

public class LifeExpectancy extends PApplet{

	UnfoldingMap map;
	
	public void setup() {
		size(950, 600);
		map = new UnfoldingMap(this, new Microsoft.RoadProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	public void draw() {
		map.draw();
	}
}
