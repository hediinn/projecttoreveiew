import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UserInput {
    
    private Simulator sim;
    private UserScreen userScreen;
    private Scanner scanner;

    private Stack<String[]> commands = new Stack<>();

    public UserInput() {
        this.sim = new Simulator();
        this.userScreen = new UserScreen(this.sim);
        this.commands.add("-1:To Exit".split(":"));
        this.commands.add("clear:To Clear your terminal".split(":"));
        this.commands.add("rush:To finish the simulation".split(":"));
        this.commands.add("train:To get to the train Menu".split(":"));
        this.commands.add("top:To get to see the Top Trains".split(":"));
        this.commands.add("time table:To get to see the time table".split(":"));
        this.commands.add(("station:To get to pick a station and show" + 
                            " trains at the stations \n         " + 
                            "and available vehicles").split(":"));
        this.commands.add("help:To get to here".split(":"));


    }

    public void runner() {
        this.scanner = new Scanner(System.in);
        
        int stopValue = 0;
        String tempString = "";
        while(stopValue == 0) {
            System.out.println("Press enter to move the time " +
                               "forwards, or help for help");
            tempString = scanner.nextLine().toLowerCase();


            switch (tempString) {
                case "-1":
                    stopValue = 1;
                    break;

                case "clear":
                    clearConsole();
                    break;

                case "":
                    userScreen.simUpdate();
                    break;

                case "rush":
                    userScreen.runSimToEnd();
                    break;

                case "train":
                    getTrainByNumber();
                    break;

                case "time table":
                    timeTable();
                    break;

                case "top":
                    this.sim.printTopNTrains(10);
                    break;

                case "help":
                    printHelp();
                    break;

                case "station":
                    printStation();
                    break;
                
                default:
                    break;
            }

        }
        scanner.close();
    }

    private void clearConsole() {

        try {

            if (System.getProperty("os.name").contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO()
                    .start().waitFor();

            } else {

                new ProcessBuilder("clear").inheritIO()
                    .start().waitFor();
            }

        } catch (Exception ex) { }

    }

    private void getTrainByNumber() {
        System.out.printf("Currently there are %s %n", this.sim.getActiveTrains().size());

        System.out.println("What is the train number ? : ");

        String temp = this.scanner.nextLine();
        System.out.println(this.sim.getTrainNumber(Integer.parseInt(temp)));
    }
    private void printHelp() {
        System.out.println("These are the Commands: ");
        for (String[] coms : this.commands) {
            System.out.println(coms[0] + " : " + coms[1] );
        }
    }

   private void timeTable() {

       int i = 0;
       int ammountOfTrains = sim.getActiveTrains().size();
       int pageCount = ammountOfTrains/13;
       String input = "";
       while (i>=0) {

            this.sim.printBeweenTrains(i*13, (i+1)*13);
           System.out.printf("Do you want to see page the next page of %s%n" +
                             "then press Enter, else press " +
                             "'q' and then Enter %n", pageCount);
           input = this.scanner.nextLine();

           if(input.equals("q")) {
               i = -1;
           }
           else if(input.equals("")) {
               i += 1;
           }

       }
   }

   private void printStation() {

       String input = "";
       ArrayList<TrainStation> trainStations = this.sim.getStations();
       for (int i = 0; i < trainStations.size(); i++) {
           System.out.println(trainStations.get(i).getName());
       }

       System.out.println("Give name of Station?");
       input = this.scanner.nextLine();
       for (int i = 0; i < trainStations.size(); i++) {


           // This was where the code for the station command was supose to go

           //if(input.equals(trainStations.get(i).getName())) {
           //    for ( iterable_element : iterable) {
          //         $TM_SELECTED_TEXT0
          //     }
          //     trainStations.get(i)
          // }
       }


   } 
}
