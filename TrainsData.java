import java.util.ArrayList;

public class TrainsData {
    
    private TrainsTextHandler trainsTextHandler;

    public TrainsData(String path) {

        ArrayList<String> trains = new ArrayList<String>();

        FileReader trainsReader = new FileReader(path);
		
		trains = trainsReader.getText();

        this.trainsTextHandler = new TrainsTextHandler(trains);

    }

    public TrainsTextHandler getTrainsTextHandler() {

        return this.trainsTextHandler;
    }
}

