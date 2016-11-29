package goeuro;

public class SolveProblem {

	private final int departureStopId;
	private final int arrivalStopId;
	private final boolean  direct;
	
	public SolveProblem(int departureStopId, int arrivalStopId) {
		this.departureStopId = departureStopId;
		this.arrivalStopId = arrivalStopId;
		direct  = solve();

	}

	private boolean solve() {
		for (Route route   : Application.routs) {
			if(route.hasStop(departureStopId) && route.hasStop(arrivalStopId))
				return true;
			
		}
		
		return false;
	}

	
	public int getDep_sid() {
		return departureStopId;
	}

	public int getArr_sid() {
		return arrivalStopId;
	}
	
	
	public boolean getDirect_bus_route() {
		return direct;

	}

}
