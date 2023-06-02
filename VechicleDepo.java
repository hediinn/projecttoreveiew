import java.util.Queue;
import java.util.LinkedList;

public class VechicleDepo {
    
	private Queue<Coach> coachVehicles = new LinkedList<Coach>();
	private Queue<SleepingCar> sleepingVehicles = new LinkedList<SleepingCar>();
	private Queue<OpenFreight> openFreights = new LinkedList<OpenFreight>();
	private Queue<CoveredFreight> coveredFreights = new LinkedList<CoveredFreight>();
	private Queue<ElectricalEngine> electricalEngines = new LinkedList<ElectricalEngine>();
	private Queue<DieselEngine> dieselEngines = new LinkedList<DieselEngine>();
	
	public VechicleDepo () {

	}

	public void addCoachVehicle(Coach freight) {

		this.coachVehicles.add(freight);
	}


	public void addSleepingVehicle(SleepingCar freight) {

		this.sleepingVehicles.add(freight);
	}


	public void addOpenFreight(OpenFreight freight) {

		this.openFreights.add(freight);
	}


	public void addCoveredFreight(CoveredFreight freight) {

		this.coveredFreights.add(freight);

	}


	public void addElectricalEngine(ElectricalEngine freight) {

		this.electricalEngines.add(freight);
	}


	public void addDieselEngine(DieselEngine freight) {

		this.dieselEngines.add(freight);
	}
	
	public OpenFreight peekOpenFreight() {

		return this.openFreights.peek();
	}


	public Coach peekCoachVehicle() {

		return this.coachVehicles.peek();
	}


	public SleepingCar peekSleepingVehicle() {

		return this.sleepingVehicles.peek();
	}


	public CoveredFreight peekCoveredFreight() {

		return this.coveredFreights.peek();
	}


	public ElectricalEngine peekElectricalEngine() {

		return this.electricalEngines.peek();
	}


	public DieselEngine peekDieselEngine() {

		return this.dieselEngines.peek();
	}

	public OpenFreight getOpenFreight() {

		return this.openFreights.poll();
	}


	public Coach getCoachVehicle() {

		return this.coachVehicles.poll();
	}


	public SleepingCar getSleepingVehicle() {

		return this.sleepingVehicles.poll();
	}


	public CoveredFreight getCoveredFreight() {

		return this.coveredFreights.poll();
	}


	public ElectricalEngine getElectricalEngine() {

		return this.electricalEngines.poll();
	}


	public DieselEngine getDieselEngine() {
		
		return this.dieselEngines.poll();
	}



}
