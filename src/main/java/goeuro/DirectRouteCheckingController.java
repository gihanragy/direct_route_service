package goeuro;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectRouteCheckingController {

	@RequestMapping("/api/direct")
	public SolveProblem direct(@RequestParam(value = "dep_sid") int departureStopId,
			@RequestParam(value = "arr_sid") int arrivalStopId) {
		
		return new SolveProblem(departureStopId, arrivalStopId);
		
	}
}
