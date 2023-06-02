import java.time.LocalTime;
import java.util.ArrayList;

public class UserScreen {
	
	private ArrayList<Train> trainss = new ArrayList<>(20);
	private ArrayList<Train> finishedTrains = new ArrayList<>(130);
	private ArrayList<Train> lateTrains = new ArrayList<>(10);
    private ArrayList<Train> brokeTrains = new ArrayList<>(10);
	private Simulator simulator;
	private boolean stopUpdate = false;
	public UserScreen(Simulator sim) {

		this.simulator = sim;
		this.trainss = this.simulator.getActiveTrains();
		this.finishedTrains = this.simulator.getFinishedTrains();
		this.lateTrains = this.simulator.getLateTrains();
		this.brokeTrains = this.simulator.getBrokeTrains();
	}
	
	public void runSimToEnd() {

		for (int i = this.simulator.getRuns(); i < 150; i++) {

			simUpdate();
			
		}
		trainsLeft();
	}

	public void simUpdate() {
		if((this.simulator.getRuns()>5) &&
		   (TimeKepper.stringToTime(this.simulator.getTime()).isBefore(LocalTime.of(0,2)))) {

			this.stopUpdate = true;

		}
		if(!this.stopUpdate) {
			this.simulator.updateSim();
		}
		if(this.stopUpdate) {
			this.simulator.finishSim();
		}
	}

	public void trainsLeft() {

		Color red = new Color(255, 0, 0);
		Color orange = new Color(255, 137, 0);
		Color green = new Color(0, 255, 0);
		Color black = new Color(0, 0, 0);

		String line =
			"----------------------------------------"+
			"-----------------------------------";

		this.brokeTrains.stream()
			.forEach((x) -> {printWhitColor(x.trainString(1), "red");});
		System.out.println(Color.ColorCode(red, black) + line +"\u001B[0m");

		this.lateTrains.stream()
			.forEach((x) -> {printWhitColor(x.trainString(1), "orange");});
		System.out.println(Color.ColorCode(orange, black) + line +"\u001B[0m");

		this.finishedTrains.stream()
			.forEach((x) -> {printWhitColor(x.trainString(1), "green");});
		System.out.println(Color.ColorCode(green, black) + line + "\u001B[0m");
	}

	public static void printWhitColor(String stringToBePrinted, String color) {
		Color red = new Color(255, 0, 0);
		Color orange = new Color(255, 137, 0);
		Color green = new Color(0, 255, 0);
		Color black = new Color(0, 0, 0);
		Color white = new Color(255, 255, 255);
		Color blue = new Color(0, 0, 255);

		String finalString = "";
		switch (color) {
			case "green":
				finalString += Color.ColorCode(green, black); 
				break;
			
			case "orange":
				finalString += Color.ColorCode(orange, black);
				break;

			case "red":
				finalString += Color.ColorCode(red, black);
				break;

			case "blue":
				finalString += Color.ColorCode(blue, white);
				break;

			default:
				break;
		}
		finalString += stringToBePrinted + "\u001B[0m";

		System.out.println(finalString);

	}

}
