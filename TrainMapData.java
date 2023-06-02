import java.util.ArrayList;

public class TrainMapData {

    private TrainMapTextHandler trainMapTextHandler;
    
    public TrainMapData(String path) {

        ArrayList<String> trainMap = new ArrayList<String>();

        FileReader trainMapReader = new FileReader(path);

        trainMap = trainMapReader.getText();

		this.trainMapTextHandler = new TrainMapTextHandler(trainMap);
    }

    public TrainMapTextHandler getTrainMap() {
        
        return  this.trainMapTextHandler;
    }
}
