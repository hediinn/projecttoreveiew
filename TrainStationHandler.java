

public class TrainStationHandler {
	
	private	String[] spiltString;

	private VechicleDepo depo = new VechicleDepo();

	public TrainStationHandler(String trainStationFile) {

		String[] tempVeh = new String[12];	
		String[] temp = new String[4];

		int[] tempInt = new int[4];	
		
		this.spiltString = trainStationFile.split(" \\(");

		for (int i = 1; i < this.spiltString.length; i++) {

			tempVeh = this.spiltString[i].split("\\)");

			for(String string : tempVeh) {

				temp = string.replace("(", "").split(" ");
					
				for (int l = 0; l < temp.length; l++) {

					tempInt[l] = Integer.parseInt(temp[l]);
				}
				
				switch (tempInt[1]) {

					case 0:
						this.depo.addCoachVehicle(new Coach(tempInt[0], tempInt[2], tempInt[3]));
						break;

					case 1:
						this.depo.addSleepingVehicle(new SleepingCar(tempInt[0], tempInt[2]));
						break;
					
					case 2:
						this.depo.addOpenFreight(new OpenFreight(tempInt[0], tempInt[2], tempInt[3]));
						break;

					case 3:
						this.depo.addCoveredFreight(new CoveredFreight(tempInt[0], tempInt[2]));
						break;

					case 4:
						this.depo.addElectricalEngine(new ElectricalEngine(tempInt[0], tempInt[2], tempInt[3]));
						break;

					case 5:
						this.depo.addDieselEngine(new DieselEngine(tempInt[0], tempInt[2], tempInt[3]));
						break;

					default:
						break;
				}

				
			}
		}
	}

	public VechicleDepo getDepo() {
		return this.depo;
	}

	
}
