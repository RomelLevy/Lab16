import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {

	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) throws IOException {
		Scanner scnr = new Scanner(System.in);

		System.out.println("Welcome to the Countries Maintenace Application!");

		System.out.println("List, Add or Exit? (1/2/3): ");
		int userInput = scnr.nextInt();

		System.out.print("Enter a country to add: ");
		String name = scnr.nextLine();
		System.out.print("Enter the population number: ");
		int populationNum = scnr.nextInt();
		Country newCountry = new Country(name, populationNum);
		appendToFile(newCountry);

		List<Country> Countries = readFile();
		for (Country c : Countries) {
			System.out.println(c.getName() + " is " + c.getPopulation());
		}

	}

	private static void appendToFile(Country country) throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath); // checks the file path
		}

		String line = country.getName() + "\t" + country.getPopulation();

		List<String> linesToAdd = Arrays.asList(line);
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

	private static List<Country> readFile() {
		// Example of reading a file into a list
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<Country> country = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("\t");
				Country p = new Country();
				p.setName(parts[0]);
				p.setPopulation(Integer.parseInt(parts[1]));
				country.add(p);
			}
			return country;

		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}
}
