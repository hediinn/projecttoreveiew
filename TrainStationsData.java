import java.util.ArrayList;

public class TrainStationsData {
    

    private ArrayList<TrainStation> stations = new ArrayList<>();


    public TrainStationsData(String path) {

        ArrayList<String> trainStations = new ArrayList<String>();

        FileReader trainStationReader = new FileReader(path);

        trainStations = trainStationReader.getText();

	for (int i = 0; i < trainStations.size(); i++) {

		this.stations.add(new TrainStation(trainStations.get(i).split(" ")[0], new TrainStationHandler(trainStations.get(i))));
		
	}

    }

    public TrainStation getTrainStation(int index) {

	    return this.stations.get(index);
    }
    
    public int getTrainStationLenght() {
        
        return this.stations.size();
    }

}
