public class Country {

	String name;
	String response;
	int population;
	

	public Country() {
		super();
	}

	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + "]";
	}

}
