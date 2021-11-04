/**
 * Sanctuary.Monkey class to have data and methods related to a monkey.
 */
public class Monkey implements Animal {
  final String name;
  final int id;
  static int countTotal;
  int location;
  int locationType;
  double weight;
  sex sexM;
  favFood favFoodM;
  size sizeM;
  int age;
  double areaRequired;
  healthStatus healthM;
  final String species;

  /**
   * Constructor to initialize the parameters with initial values.
   *
   * @param name     Unique name assigned to the monkey on enrollment
   * @param weight   Weight of the monkey in lbs
   * @param location Location of the monkey in the sanctuary
   * @param species  Species to which the monkey belongs to
   */

  public Monkey(String name, int lType, int location, double weight, sex sexM,
                favFood favFoodM, size sizeM, healthStatus healthM,
                String species) {
    if ((lType != 1 && lType != 2) || (location < 0) || (weight < 0)) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.id = countTotal++;
    this.sexM = sexM;
    this.locationType = lType;
    this.weight = weight;
    this.location = location;
    this.favFoodM = favFoodM;
    this.sizeM = sizeM;
    this.healthM = healthM;
    this.species = species;
    String s = sizeM.toString();
    if ("SMALL".equals(s)) {
      this.areaRequired = 1;
    } else if ("MEDIUM".equals(s)) {
      this.areaRequired = 5;
    } else if ("LARGE".equals(s)) {
      this.areaRequired = 10;
    } else {
      throw new IllegalArgumentException();
    }
    if (weight < 5) {
      age = 7;
    } else if (weight < 15) {
      age = 10;
    } else {
      age = 15;
    }
  }

  /**
   * Enumeration for Sex of a monkey.
   */
  public enum sex {
    MALE,
    FEMALE,
    OTHER
  }

  /**
   * Enum for Favourite Food of a monkey.
   */
  public enum favFood {
    EGGS,
    FRUITS,
    INSECTS,
    LEAVES,
    NUTS,
    SEEDS,
    TREE_SAP
  }

  /**
   * Enum for Size of a monkey.
   */
  public enum size {
    SMALL,
    MEDIUM,
    LARGE
  }

  /**
   * Enum for Health Status of a Monkey.
   */
  public enum healthStatus {
    HEALTHY,
    SICK,
    MONITORED
  }

  public healthStatus getHealth() {
    return healthM;
  }

  public sex getSex() {
    return sexM;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getId() {
    return id;
  }

  public size getSize() {
    return sizeM;
  }

  public int getAge() {
    return age;
  }

  @Override
  public double getWeight() {
    return weight;
  }

  @Override
  public int getLocation() {
    return location;
  }

  /**
   * Returns Area Required by a monkey.
   *
   * @return Area Required for the monkey.
   */
  @Override
  public double getAreaRequired() {
    if (sizeM.toString().equals("LARGE")) {
      return (10.0);
    } else if (sizeM.toString().equals("MEDIUM")) {
      return (10.0);
    } else {
      return (1.0);
    }
  }

  public String getSpecies() {
    return species;
  }

  public int getLocationType() {
    return locationType;
  }

  /**
   * Method to update location of a monkey after Transfer.
   *
   * @param type     Location type of the housing
   * @param location Unique location Id.
   */
  public void updateLocation(int type, int location) {
    this.locationType = type;
    this.location = location;
  }

  public favFood getFavFood() {
    return favFoodM;
  }

  @Override
  public String toString() {
    return String.format(
        "Name: %s, Species: %s, Id: %d, sex: %s, weight: %.2f location type: %s,Location: %d,"
            + "favourite Food: %s", name, species, id, getSex().toString(), weight,
        locationType, location, getFavFood().toString());
  }

}
