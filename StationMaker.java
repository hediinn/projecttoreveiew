import java.util.ArrayList;

public class StationMaker {

//	public static TrainStation MakeStation(ArrayList <String[]> arrayOfStations) {
//		TrainStation trainStation = new TrainStation("s",);
//		for (String[] station : arrayOfStations) {
//			trainStation.addToMap(station[1], Integer.parseInt(station[2]));
//		}

//		return trainStation;
//	}

	public static ArrayList<String> Uniqe(ArrayList <String[]> arrayOfStations) {

		ArrayList<String> returnString = new ArrayList<>(8);
		returnString.add(arrayOfStations.get(0)[0]);

		for (String[] stations: arrayOfStations) {

			if(!returnString.contains(stations[1])) {
				
				returnString.add(stations[1]);
			}

		}


		return returnString;

	}
}
