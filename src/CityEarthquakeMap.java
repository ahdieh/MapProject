import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
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
		
		// Adding a marker to a specified location(CN Tower) on the map
		Location loc = new Location(43.6425662, -79.3870568);
		SimplePointMarker marker = new SimplePointMarker(loc);
		map.addMarker(marker);
	}
	
	public void draw() {
		background(0);
		map.draw();
	}
	
}
