package goeuro;

import java.util.ArrayList;
import java.util.Collections;

public class Route {
	private final int id;
	private final ArrayList<Integer> stops;

	public Route(int id, ArrayList<Integer> stops) {
		this.id = id;
		Collections.sort(stops); // sort the stops to enhance the search
		this.stops = stops;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Integer> getStops() {
		return stops;
	}

	public boolean hasStop(int stopId) {

		int index = Collections.binarySearch(stops, stopId);

		return index >= 0;
	}
}
