import java.util.ArrayList;

/**
 * Class to Detail how the animals are housed and the functionalities related to it.
 */
public class Housing {

  static int countEnclosures;
  static int countIsolation;
  static ArrayList<Integer> emptyIsolations = new ArrayList<>();
  static ArrayList<Integer> emptyEnclosures = new ArrayList<>();
  int type;
  int cid;
  double remainingCapacity;
  double area;
  String species;
  boolean empty;

  /**
   * Constructor to initialize objects of Class Sanctuary.Housing.
   *
   * @param t takes the type of housing as parameter
   */
  public Housing(int t) {
    this.type = t;
    if (this.type == 2) {
      cid = ++countEnclosures;
    } else {
      cid = ++countIsolation;
    }
    if (this.type == 2) {
      this.area = 20.0;
    } else {
      remainingCapacity = this.area;
    }
    this.empty = true;

  }

  /**
   * To Repurpose the Cage to house a different species.
   */
  public void repurpose() {
    if (this.isEmpty()) {
      this.species = null;
    }


  }

  public static int getCountEnclosure() {
    return countEnclosures;
  }

  public static int getCountIsolation() {
    return countIsolation;
  }

  public int getType() {
    return type;
  }

  public int getCid() {
    return cid;
  }


  public double getRemainingArea() {
    return remainingCapacity;
  }

  public double getArea() {
    return this.area;
  }

  public String getSpecies() {
    return this.species;
  }

  public boolean isEmpty() {
    return this.empty;
  }

  /**
   * Method to add an enclosure to the Occupied category.
   *
   * @param add specifies the number of enclosures to be added.
   */
  public void addEnclosure(int add) {
    countEnclosures += add;
  }

  /**
   * Method to add an Isolation to the occupied category.
   *
   * @param add specifies the number of enclosures to be added.
   */
  public void addIsolation(int add) {
    countIsolation += add;
  }

  /**
   * Method to Mark a Sanctuary.Housing not Empty.
   *
   * @param locationType Type of housing
   * @param location     Unique Id given to location
   */
  public void markNotEmpty(int locationType, int location) {
    if (locationType == 1) {
      if (emptyIsolations.contains(location)) {
        emptyIsolations.remove(location);
      }
    } else {
      if (emptyEnclosures.contains(location)) {
        emptyEnclosures.remove(location);
      }
    }
  }

  /**
   * Method to Mark a Sanctuary.Housing Empty.
   *
   * @param locationType Type of housing
   * @param location     Unique Id given to location
   */
  public void markEmpty(int locationType, int location) {
    if (locationType == 1) {
      emptyIsolations.add(location);
    } else {
      emptyIsolations.add(location);
    }
  }

  public static ArrayList<Integer> getEmptyIsolations() {
    return emptyIsolations;
  }

  public static ArrayList<Integer> getEmptyEnclosures() {
    return emptyEnclosures;
  }

  /**
   * Reduce remaining capacity in Enclosure.
   */
  public void reduceRemainingCapacity(double remove) {
    remainingCapacity -= remove;
  }
}
