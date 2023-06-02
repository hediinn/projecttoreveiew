import java.time.LocalTime;
import java.util.ArrayList;
import java.time.temporal.*;

public class Simulator {

    private String[] timeAsString = new String[2];
    private ArrayList<Train> trainss = new ArrayList<>(20);
    private ArrayList<Train> finishedTrains = new ArrayList<>(130);
    private ArrayList<TrainStation> stations = new ArrayList<>(10);
    private ArrayList<Train> lateTrains = new ArrayList<>(10);
    private ArrayList<Train> brokeTrains = new ArrayList<>(10);
    private int runs = 0;



    public Simulator() {

        Handlers handlers = new Handlers();
        this.stations = handlers.getStations();
        this.trainss = handlers.getTrains();
        this.timeAsString = "00:00".split(":");

    }

    public Simulator(String startTime) {

        Handlers handlers = new Handlers();
        this.stations = handlers.getStations();
        this.trainss = handlers.getTrains();
        if(startTime.contains(":")) {
            this.timeAsString = startTime.split(":");
        } else {
                System.err.println("format of startTime is wrong");
                System.exit(0);
            }

    }
    public void updateSim() {
        this.timeAsString = TimeKepper.timeUp(this.timeAsString);
        LocalTime localTime = TimeKepper.stringToTime(this.timeAsString);
        LocalTime trainTime;
        LocalTime trainArivalTime;
        int sizeOfTrains = this.trainss.size();
        Train tempTrain;

        System.out.printf("%n------------------- "+
                          "current time is %s ------------------- %n",
                          localTime );
        System.out.printf("%-4s| %-5s%n","num","STime");
        for (int i = 0; i< sizeOfTrains; i++) {

            tempTrain = this.trainss.get(i);
            trainTime = TimeKepper.stringToTime(tempTrain.
                                                getStartTime());
            trainArivalTime = TimeKepper.stringToTime(tempTrain.
                                                      getEndTime());

            if((localTime.until(trainTime, ChronoUnit.MINUTES) <= 30) &&
               ((tempTrain.getStatus().equals(StatusEnum.NOT_ASSEMBLED)) ||
                (tempTrain.getStatus().equals(StatusEnum.INCOMPLETE)))) {

                for (int j = 0; j < this.stations.size(); j++) {

                    if(this.stations.get(j).getName().equals(tempTrain.
                                                             getStart())) {

                        if(tempTrain.tryToAssemble(this.stations.get(j).
                                                   getStationVehicles())){

                            TrainMaker.addVehiclesToTrain(tempTrain,
                                                          this.stations.get(j));
                            tempTrain.setStatus(StatusEnum.ASSEMBLED);
                            tempTrain.setStateChange(true);

                        } else {

                            tempTrain.setStatus(StatusEnum.INCOMPLETE);
                            tempTrain.addTime();
                            tempTrain.setStateChange(true);
                        }

                    }
                }
            }

            if((tempTrain.getStatus().equals(StatusEnum.ASSEMBLED))&&
               (!tempTrain.getStateChange())&&
               (localTime.until(trainTime, ChronoUnit.MINUTES) <= 10)) {

                tempTrain.setStatus(StatusEnum.READY);
                tempTrain.setStateChange(true);
            }

            if((tempTrain.getStatus().equals(StatusEnum.READY))&&
               (!tempTrain.getStateChange())&&
               (localTime.until(trainTime, ChronoUnit.MINUTES) <= 0)) {
                tempTrain.setStatus(StatusEnum.RUNNING);
                tempTrain.setStateChange(true);
            }

            if((tempTrain.getStatus().equals(StatusEnum.RUNNING))&&
               (!tempTrain.getStateChange())&&
               (localTime.until(trainArivalTime, ChronoUnit.MINUTES) <= 0)) {

                tempTrain.setStatus(StatusEnum.ARRIVED);
                tempTrain.setStateChange(true);

            }

            for (TrainStation trainStation : this.stations) {

                if(tempTrain.getDesto().equals(trainStation.getName())) {

                    if((tempTrain.getStatus().equals(StatusEnum.ARRIVED)) &&
                       (localTime.until(trainArivalTime.plusMinutes(20),
                                        ChronoUnit.MINUTES)<=0)){

                        tempTrain.setStatus(StatusEnum.FINISHED);
                        tempTrain.setStateChange(true);
                        trainStation.disasembleTrain(tempTrain);
                    }
                }
            }

            if(tempTrain.getStateChange()) {
                if(this.runs>0) {
                    System.out.printf("%s :  %n", tempTrain.trainString(0));
                }
                if(this.runs == 0) {
                    System.out.printf("%-25s %-3s", tempTrain.trainString(0)," | ");
                    if(i%2 == 0) {
                       System.out.println();
                    }
                }

                tempTrain.setStateChange(false);

            }
            if (tempTrain.getStatus().equals(StatusEnum.FINISHED)) {

                if(!tempTrain.areTimesGood()) {

                    this.lateTrains.add(this.trainss.remove(i));

                } else {

                    this.finishedTrains.add(this.trainss.remove(i));
                }
            }

            sizeOfTrains = this.trainss.size();
        }


        this.runs ++;


    }

    public void finishSim() {
        Train tempTrain;
        LocalTime localTime = TimeKepper.stringToTime(this.timeAsString);
        LocalTime trainArivalTime;

        for (int i = 0; i < this.trainss.size(); i++) {
            tempTrain = this.trainss.get(i);
            trainArivalTime = TimeKepper.stringToTime(tempTrain.getEndTime());
            if ((tempTrain.getStatus().equals(StatusEnum.INCOMPLETE)) ||
                    (tempTrain.getStatus().equals(StatusEnum.NOT_ASSEMBLED))) {

                brokeTrains.add(this.trainss.remove(i));
            } else {
                for (TrainStation trainStation : this.stations) {
                    if ((tempTrain.getStatus().equals(StatusEnum.ARRIVED)) && (localTime.minusHours(1)
                            .until(trainArivalTime.minusHours(1).plusMinutes(20), ChronoUnit.MINUTES) <= 0)) {
                        tempTrain.setStatus(StatusEnum.FINISHED);
                        tempTrain.setStateChange(true);
                        trainStation.disasembleTrain(tempTrain);
                    }
                }
                System.out.println(this.trainss.get(i).trainString(0));
                System.out.println(TimeKepper.stringToTime(this.timeAsString));
            }
            if ((tempTrain.getStatus().equals(StatusEnum.RUNNING))
                    && (localTime.minusHours(1).until(trainArivalTime.minusHours(1), ChronoUnit.MINUTES) <= 0)) {

                tempTrain.setStatus(StatusEnum.ARRIVED);
                tempTrain.setStateChange(true);


            }
        }
        updateSim();
        System.out.println(this.trainss.size());

    }
    
    public ArrayList<Train> getActiveTrains() {
        return this.trainss;
    }
    public ArrayList<Train> getLateTrains() {
        return this.lateTrains;
    }
    public ArrayList<Train> getFinishedTrains() {
        return this.finishedTrains;
    }

    public int getRuns() {

        return this.runs;

    }

    public void printTopNTrains(int n) {
        System.out.printf("%-3s | %-16s | %-5s | %-5s | %-16s | %-5s | %-5s%n",
                          "nr.","start station","Stim","OGSti",
                          "End station","Etim","OGEti");
        System.out.println(
                           "-------------------------------------"+
                           "-------------------------------------"
                           );
        for(int i = 0; i < n; i++ ) {
            System.out.println(this.trainss.get(i).trainString(1));
        }
    }

    public void printBeweenTrains(int start, int end) {
        System.out.printf("%-3s | %-16s | %-5s | %-5s | %-16s | %-5s | %-5s%n",
                          "nr.","start station","Stim","OGSti",
                          "End station","Etim","OGEti");
        System.out.println(
                           "-------------------------------------"+
                           "-------------------------------------"
                           );
        if(end > this.trainss.size()) {
            end = this.trainss.size();
        }
        for(int i = start; i < end; i++ ) {
            System.out.println(this.trainss.get(i).trainString(1));
        }

    }
    public String[] getTime() {
        return this.timeAsString;
    }

    public ArrayList<TrainStation> getStations() {
        return this.stations;
    }

    public String getTrainNumber(int num) {
        String temp = "";
        for (Train train : this.trainss) {
            if(train.getTrainNum()  == num) {
                temp = train.trainString(2);
            }
        }
            if(temp.equals("")) {
                temp = "NO TRAIN Found";
            }
        return temp;
    }
    public ArrayList<Train> getBrokeTrains() {
        return this.brokeTrains;
    }

}
