
public class TrainMaker {


	public static Train makeAMeATrain(String[] temp) {

		int[] tempInts;
		tempInts = new int[temp.length-6];

		for (int j = 6; j < temp.length; j++) {

				tempInts[j-6] = Integer.parseInt(temp[j]);
			}

		return new Train(Integer.parseInt(temp[0]),
					temp[1], temp[2], temp[3],
					temp[4], Integer.parseInt(temp[5]), tempInts);

	}

	public static void addVehiclesToTrain(Train train, TrainStation station) {
		

		for (int var : train.getVehicleLine()) {

			switch (var) {

				case 0:
					train.addVehcle(station.getStationVehicles().getCoachVehicle());	
					break;

				case 1:
					train.addVehcle(station.getStationVehicles().getSleepingVehicle());	
					break;

				case 2:
					train.addVehcle(station.getStationVehicles().getOpenFreight());	
					break;

				case 3:
					train.addVehcle(station.getStationVehicles().getCoveredFreight());	
					break;

				case 4:
					train.addVehcle(station.getStationVehicles().getElectricalEngine());	
					break;

				case 5:
					train.addVehcle(station.getStationVehicles().getDieselEngine());	
					break;
					
				default:
					break;
			}
		} 


	}



}
