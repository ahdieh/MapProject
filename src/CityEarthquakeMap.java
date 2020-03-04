import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

/**
 * Creating multiple markers on several locations.
 * @author ahdieh
 *
 */
public class CityEarthquakeMap extends PApplet{

	UnfoldingMap map;
	
	public void setup( ) {
		size(900, 600);
		map = new UnfoldingMap(this, new Microsoft.RoadProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		
		// Create a Feature object to encapsulates several information in a single object
		// It stores the a big Earthquake.
		// PointFeature object stores a location
		
		// Valdivia, Chile
		Location valLoc = new Location(-38.14f, -73.03f);
//		Feature valEq = new PointFeature(valLoc);
		PointFeature valEq = new PointFeature(valLoc);
		valEq.addProperty("title", "Valdivia, Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22, 1960");		
		
/*		// adding a marker on Valdivia		
		Marker valMk = new SimplePointMarker(valLoc, valEq.getProperties());
		valMk.setColor(color(255,0,0));
		map.addMarker(valMk);*/
		
		
		// Alaska
		Location alaskaLoc = new Location(61.02, -147.65);
//		Feature alaskaEq = new PointFeature(alaskaLoc);
		PointFeature alaskaEq = new PointFeature(alaskaLoc);		
		alaskaEq.addProperty("title", "Alaska");
		alaskaEq.addProperty("magnitude", "9.2");
		alaskaEq.addProperty("date", "April 28, 1964");
		
/*		// adding a marker on Alaska		
		Marker alaskaMk = new SimplePointMarker(alaskaLoc, alaskaEq.getProperties());
		alaskaMk.setColor(color(0,255,0));
		map.addMarker(alaskaMk);*/
		
		
		// adding a list of PointFeature objects to store multiple Feature objects (multiple locations)
		List<PointFeature> bigEqs = new ArrayList<PointFeature>();		
		bigEqs.add(valEq);
		bigEqs.add(alaskaEq);
		
		// adding a list to store markers
		List<Marker> markers = new ArrayList<Marker>();
		for (PointFeature eq: bigEqs) {
			Marker marker = new SimplePointMarker(eq.getLocation(), eq.getProperties());
			marker.setColor(color(255,0,0));
			markers.add(marker);
		}
		
		map.addMarkers(markers);
		
	}
	
	public void draw() {
		background(0);
		map.draw();
	}
	
}
