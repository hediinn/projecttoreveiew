
import java.util.ArrayList;

public class TrainMapTextHandler {
	
	
	private ArrayList<String[]> unSortedTrainsMap = new ArrayList<String[]>();

	public TrainMapTextHandler(ArrayList<String> textOfFile) {
	
		textOfFile.forEach((x) -> {this.unSortedTrainsMap.add(x.split("\\ "));});
		


	}

	public void PrintUnSorted() {

		int d = 0;
		int m = 27/3;
		int n = m*2;

		for (int i = 0; i < 27/3; i++) {
			
			System.out.printf("%-17s %-17s %-3s | %-17s %-17s %-3s | %-17s %-17s %-3s %n",
			this.unSortedTrainsMap.get(d)[0],	this.unSortedTrainsMap.get(d)[1],	this.unSortedTrainsMap.get(d)[2],
			this.unSortedTrainsMap.get(m)[0], 	this.unSortedTrainsMap.get(m)[1],	this.unSortedTrainsMap.get(m)[2],
			this.unSortedTrainsMap.get(n)[0], 	this.unSortedTrainsMap.get(n)[1],	this.unSortedTrainsMap.get(n)[2]);
			d++;
			m++;
			n++;
		}

	}

	public ArrayList<String[]> GetUnsortedMap() {

		return this.unSortedTrainsMap;
	}

	public ArrayList<String[]> GetStationCon (String station) {

		String[] stations = new String[3];
		ArrayList<String[]> sortedTrainsMap = new ArrayList<String[]>(8);

		stations[0] = station;
		stations[1] = station;
		stations[2] = "0";
		sortedTrainsMap.add(stations);
		

		for (String[] sss : this.unSortedTrainsMap) {

			stations = new String[3];

			if(!sss[0].equals(station)) {

				stations[0] = sss[1];
				stations[1] = sss[0];
				stations[2] = sss[2];

			} else {

				stations[0] = sss[0];
				stations[1] = sss[1];
				stations[2] = sss[2];
			}

			if((sss[0].equals(station)) || (sss[1].equals(station))) {
				
				sortedTrainsMap.add(stations);
			}

		}
		
		return sortedTrainsMap;

	}
		
	
}
