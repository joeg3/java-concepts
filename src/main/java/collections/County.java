package collections;

import java.util.HashSet;
import java.util.Set;

public class County {
  private final String name;
  private final double population;
  private final Set<City> cities;

  public County(String name, double population) {
    this.name = name;
    this.population = population;
    this.cities = new HashSet<>();
  }

  public String getName() {
    return name;
  }

  public double getPopulation() {
    return population;
  }

  public boolean addCity(City city) {
    return this.cities.add(city);
  }

  public Set<City> getCities() {
    return new HashSet<>(this.cities); // Return new set, so client can't modify
  }
}
