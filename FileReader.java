
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class FileReader {

	private ArrayList<String> textOfFile;

	public FileReader(String file) {
		
				
		this.textOfFile = new ArrayList<String>();

		String newLine = "";
		
		try (Scanner inFile = new Scanner(Paths.get(file))) {

			while (inFile.hasNext()) {

				newLine = inFile.nextLine();

				if (newLine != "") {

					this.textOfFile.add(newLine);
				}
			}

		} catch (NoSuchElementException | IllegalStateException | IOException e ) {

			System.err.println("Error");
			System.err.println(e);
			System.exit(1);
		}

	}

	public ArrayList<String> getText() {
		
		return this.textOfFile;
	}

}
