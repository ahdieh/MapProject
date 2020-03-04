import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class CityEarthquakeMap extends PApplet{

	UnfoldingMap map;
	
	public void setup( ) {
		size(900, 600);
		map = new UnfoldingMap(this, new Microsoft.RoadProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
	}
	
	public void draw() {
		background(0);
		map.draw();
	}
	
}
