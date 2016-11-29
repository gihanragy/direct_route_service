package goeuro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static Route[] routs;
	private static String dataFilePath;

	public static void main(String[] args) {
		
		System.getProperties().put( "server.port", 8088 );	
		SpringApplication.run(Application.class, args);
		
		if (args.length > 0) {
			dataFilePath = args[0];
		} else {
			System.err.println("please include the data file path");
			System.exit(1);
		}
		loadBusData();
	}

	private static void loadBusData() {
		File file = new File(dataFilePath);
		try {
			Scanner fileScanner = new Scanner(file);
			int routsCount = fileScanner.nextInt();
			routs = new Route[routsCount];
			Scanner lineScanner;
			// ignore current line
			fileScanner.nextLine();

			Route route;
			for (int i = 0; i < routs.length; i++) {
				String line = fileScanner.nextLine();
				lineScanner = new Scanner(line);
				int routeId = lineScanner.nextInt();

				ArrayList<Integer> stops = new ArrayList<>();
				while (lineScanner.hasNextInt()) {
					stops.add(lineScanner.nextInt());
				}
				lineScanner.close();
				route = new Route(routeId, stops);
				routs[i] = route;
			}
			fileScanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
