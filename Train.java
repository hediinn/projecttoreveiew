
import java.util.ArrayList;
import java.util.Arrays;

public class Train {

	private StatusEnum statusEnum = StatusEnum.NOT_ASSEMBLED; 

	final int maxVehicles; 
	final int trainNumber;

	private ArrayList<Cart> vehicles;

	final int[] vehicleLine;
	final String desto;
	final String start;

	private String[] startTime;
	private String[] endTime;

	final int speed;

	private boolean stateChange;

	final String oGStartTime;
	final String oGEndTime;


	public Train(int trainNum, String start,
			String desto, String startTime,
			String endTime, int speed, int[] vecLine) {
		// This is a Train class constroctor
		this.vehicleLine = vecLine;
		this.trainNumber = trainNum;
		this.maxVehicles = vecLine.length;
		this.desto = desto;
		this.start = start;
		this.startTime = startTime.split(":");
		this.endTime = endTime.split(":");
		this.oGStartTime = startTime;
		this.oGEndTime = endTime;
		this.speed = speed;
		this.stateChange = true;
		this.vehicles = new ArrayList<Cart>(vecLine.length);
		
	}

	public boolean tryToAssemble(VechicleDepo data) {

		Boolean[] checkVec = new Boolean[this.maxVehicles];
		int i = 0;

		for (int j = 0; j <this.vehicleLine.length; j++) {
			checkVec[j] = false;
		}

		for (int part : this.vehicleLine) {

			switch (part) {

				case 0:

					if (data.peekCoachVehicle() != null) {
						checkVec[i] = true;
					} 
					break;

				case 1:

					if (data.peekSleepingVehicle() != null) {
						checkVec[i] = true;	
					}
					break;

				case 2:

					if (data.peekOpenFreight() != null) {
						checkVec[i] = true;	
					}
					break;

				case 3:

					if (data.peekCoveredFreight() != null) {
						checkVec[i] = true;
					}
					break;

				case 4:

					if (data.peekElectricalEngine() != null) {
						checkVec[i] = true;
					}
					break;

				case 5:

					if (data.peekDieselEngine() != null) {
						checkVec[i] = true;
					}
					break;
	
				default:
					break;
			}

			i++;
		}

		return !Arrays.asList(checkVec).contains(false);
	}

	public boolean areTimesGood() {

		return this.oGStartTime.equals(this.startTime[0] + ":"+ this.startTime[1]);
	}


	public int[] getVehicleLine() {

		return this.vehicleLine;
	}

	public ArrayList<Cart> getVehicles() {

		return this.vehicles;
	}

	public int getTrainNum() {

		return this.trainNumber;	
	}

	public Cart getAndRemoveVehicle(int index) {

		return this.vehicles.remove(index);
	}

	public void addVehcle(Cart vec) {

		this.vehicles.add(vec);
	}

	public void addTime() {

		this.startTime = TimeKepper.timeUp(this.startTime);
		this.endTime = TimeKepper.timeUp(this.endTime);

	}

	public void setStatus(StatusEnum status) {

		this.statusEnum = status;
	}

	public StatusEnum getStatus() {

		return this.statusEnum;
	}

	public boolean getStateChange() {

		return this.stateChange;
	}
	
	public void setStateChange(boolean state) {

			this.stateChange = state;
	}

	public String getDesto() {

		return this.desto;
	}


	public String getStart() {

		return this.start;
	}
	
	public String[] getStartTime() {

		return this.startTime;
	}

	public String[] getEndTime() {

		return this.endTime;
	}

	public int getSpeed() {

		return this.speed;
	}

	public String trainString(int version) {

		String returnString = "";
		String veString = "";
		if(vehicles.size() <0) {
			for (int i = 0; i < vehicles.size(); i++) {
				veString += vehicles.get(i).getID() + " | " + vehicles.get(i).getType() + "\n";
			}
		}


		if (version == 0) {
			returnString += String.format("%-3s | %-5s | %-5s | %-12s | %-5s | %-5s" ,
									trainNumber, startTime[0] + ":"+startTime[1] ,
									endTime[0] + ":"+endTime[1], statusEnum, oGStartTime, oGEndTime);
		}

		if (version == 1) {
			returnString += String.format("%-3s | %-16s | %-5s | %-5s | %-16s | %-5s | %-5s" ,
									trainNumber, start, startTime[0] + ":"+startTime[1], oGStartTime, desto,
									endTime[0] + ":"+endTime[1], oGEndTime);
		}

		if (version == 2) {
			returnString += String.format("%-12s : %-3s |%n%-6s : %-13s |%n%-22s : %s | %s %n" +
										  "%-17s %-5s | %-5s %n%-28s %-5s | %-5s %n%s%n%s",
										  "train number",trainNumber,"Status",statusEnum,
										  "Start station | End Station:", start, desto,
										  "Start time | End time:",
										  startTime[0] + ":" + startTime[1],
										  endTime[0] + ":" + endTime[1],
										  "Original Start time | Original End time",
										  oGStartTime, oGEndTime, "vehicle ID | Type", veString);
		}


		return returnString;
	}
}
