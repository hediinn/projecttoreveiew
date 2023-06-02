import java.util.HashMap;

public class TrainStation {

	private HashMap<String, Integer> map;
	private TrainStationHandler trainStationHandler;
	private VechicleDepo depo;
	private String name;

	public TrainStation(String name ,TrainStationHandler trainStationHandler) {
		this.name = name;
		this.trainStationHandler = trainStationHandler;
		this.map = new HashMap<>(8);
		this.depo = trainStationHandler.getDepo();
	}

	public void addToMap(String place, int dist) {

		this.map.put(place, dist);
	}

	public int getDist(String place) {

		return this.map.get(place);
	}

	public VechicleDepo getStationVehicles() {

		return this.depo;
	}

	public String getName() {

		return this.name;
	}

	public String getTopVec() {

		String returnString = "";

		returnString += Integer.toString(this.depo.peekCoachVehicle().getID()) + " : " +
						Integer.toString(this.depo.peekSleepingVehicle().getID()) + " : " +
						Integer.toString(this.depo.peekOpenFreight().getID()) + " : " +
						Integer.toString(this.depo.peekCoveredFreight().getID()) + " : " +
						Integer.toString(this.depo.peekElectricalEngine().getID()) + " : " +
						Integer.toString(this.depo.peekDieselEngine().getID()) + " : ";

		return returnString;
	}

	public void disasembleTrain(Train train) {
		
		for (int i = 0; i < train.getVehicleLine().length; i++) {
			
			switch (train.getVehicleLine()[i]) {

				case 0:
					this.depo.addCoachVehicle((Coach)train.getAndRemoveVehicle(0));
					break;

				case 1:
					this.depo.addSleepingVehicle((SleepingCar)train.getAndRemoveVehicle(0));
					break;

				case 2:
					this.depo.addOpenFreight ((OpenFreight)train.getAndRemoveVehicle(0));
					break;

				case 3:
					this.depo.addCoveredFreight((CoveredFreight)train.getAndRemoveVehicle(0));
					break;

				case 4:
					this.depo.addElectricalEngine((ElectricalEngine)train.getAndRemoveVehicle(0));
					break;
					
				case 5:
					this.depo.addDieselEngine((DieselEngine)train.getAndRemoveVehicle(0));
					break;

				default:
					break;
			}
		}

	}
	
}
