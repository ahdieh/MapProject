import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class SpecificLocationMarker extends PApplet {

	UnfoldingMap map;

	//public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	public void setup() {
		size(800, 600, OPENGL);

		//map = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());		
		//map = new UnfoldingMap(this, new MBTilesMapProvider(mbTilesString));
		map = new UnfoldingMap(this, new Microsoft.RoadProvider());
		map.zoomAndPanTo(new Location(43.6425662, -79.3870568), 14); // CN Tower

		MapUtils.createDefaultEventDispatcher(this, map);	
		
		// Adding a marker to a specified location (CN Tower) on the map
		Location loc = new Location(43.6425662, -79.3870568);
		SimplePointMarker marker = new SimplePointMarker(loc);
		marker.setColor(color(255,0,0));
		map.addMarker(marker);

	}

	public void draw() {
		background(0);
		map.draw();
	}
}
