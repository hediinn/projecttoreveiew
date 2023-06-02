
import java.nio.file.*;
import java.util.ArrayList;



public class Handlers {


	private String[] timeAsString = new String[2];
	private ArrayList<Train> trainss = new ArrayList<>(130);
	private ArrayList<Train> finishedTrains = new ArrayList<>(130);
	private ArrayList<TrainStation> stations = new ArrayList<>(10);
	private ArrayList<String[]> textFileTrains = new ArrayList<>(130);
	private ArrayList<Train> lateTrains = new ArrayList<>(10);



	
	public Handlers(){
		Path path = Paths.get("");
		String currentPath;


		// This if/else is mostly to check that the path is correct
		// the start path should be ../whatever/whaterver/windowsbad/projectgroup_4

		if(path.toAbsolutePath().endsWith("projectgroup_4")) {

			currentPath = path.toAbsolutePath().toString();	

		} else {

			currentPath = path.resolve("projectgroup_4").toAbsolutePath().toString();	
		}
		
		ArrayList<String> TrainFiles = new ArrayList<String>();

		TrainFiles.add(currentPath +
				"/TrainMap.txt");
		TrainFiles.add(currentPath +
				"/TrainStations.txt");
		TrainFiles.add(currentPath +
				"/Trains.txt");
		

		TrainMapData trainMapData = new TrainMapData(TrainFiles.get(0));
		TrainMapTextHandler trainMapTextHandler = trainMapData.getTrainMap();
			
		TrainStationsData trainStationsData = new TrainStationsData(TrainFiles.get(1));

		for (int i = 0; i < trainStationsData.getTrainStationLenght(); i++) {
			this.stations.add(trainStationsData.getTrainStation(i));
		}

		TrainsData trainsData = new TrainsData(TrainFiles.get(2));
		TrainsTextHandler trainsTextHandler = trainsData.getTrainsTextHandler();
		
		
		this.textFileTrains = trainsTextHandler.getSorted();	
	
		String[] temp;
		this.timeAsString = "00:00".split(":");

		for (int i = 0; i < 130; i++) {
			
			temp = this.textFileTrains.remove(0);

			// bad italian accent Make'a Me A Train (Mario)
			this.trainss.add(TrainMaker.makeAMeATrain(temp));

		}

	}

	public ArrayList<Train> getTrains () {
		return this.trainss;
	}

	public ArrayList<TrainStation> getStations () {
		return this.stations;
	}
	
	public ArrayList<String[]> getTextFileTrains() {
		return this.textFileTrains;
	}
}
