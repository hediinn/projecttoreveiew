


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TrainsTextHandler {


	private ArrayList<String[]> unSortedTrains = new ArrayList<String[]>();
	private ArrayList<String[]> sortedTrains = new ArrayList<String[]>();

	public TrainsTextHandler(ArrayList<String> trainsFile) {
		
		trainsFile.forEach((x) -> {this.unSortedTrains.add(x.split("\\ "));});
		this.sortedTrains = this.unSortedTrains;
		Collections.sort(this.sortedTrains, (a,b ) -> a[3].compareTo(b[3]) );

	}

	public ArrayList<String[]> getUnsorted(){

		return this.unSortedTrains;
	}

	public ArrayList<String[]> getSorted(){

		return this.sortedTrains;
	}

	public void PrintUnsorted() {
		
		int d = 0;
		int m = 130/5;
		int n = m*2;
		int l = m*3;
		int k = m*4;

		for (int i = 0; i < 130/5; i++) {
			
			System.out.printf("%-5s %-5s %-3s | %-5s %-5s %-3s | %-5s %-5s %-3s | %-5s %-5s %-3s  | %-5s %-5s %-3s %n",
			this.unSortedTrains.get(d)[3],	this.unSortedTrains.get(d)[4],	this.unSortedTrains.get(d)[0],
			this.unSortedTrains.get(m)[3], 	this.unSortedTrains.get(m)[4],	this.unSortedTrains.get(m)[0],
			this.unSortedTrains.get(n)[3], 	this.unSortedTrains.get(n)[4],	this.unSortedTrains.get(n)[0],
			this.unSortedTrains.get(l)[3],	this.unSortedTrains.get(l)[4],	this.unSortedTrains.get(l)[0],
			this.unSortedTrains.get(k)[3],	this.unSortedTrains.get(k)[4],	this.unSortedTrains.get(k)[0]);
			d++;
			m++;
			n++;
			k++;
			l++;
		}

	}
}
