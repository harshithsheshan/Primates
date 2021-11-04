import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for Sanctuary.Sanctuary type to create a base interface for the requirement.
 */
public interface Sanctuary {

  /**
   * Method to create an alphabetical list of all species in the Sanctuary.Sanctuary.
   *
   * @return Array List of Sorted species
   */
  public ArrayList<Monkey> listSpeciesAlphabetical();

  ArrayList<Monkey> listNamesAlphabetical();

  String createSign(int locationType, int location);

  /**
   * Method to search for a specific species in the sanctuary.
   *
   * @return list of locations where the species was found
   */
  public ArrayList<Monkey> searchSpecies(String key);

  /**
   * Method to create a shopping list to buy food for the sanctuary.
   * @return
   */
  public HashMap<String, Double> createShoppingList();

  /**
   * Method to get the number of animals in Isolation.
   *
   * @return int Number in isolation
   */
  public int getNumInIsolation();

  /**
   * Method to get the number of animals in Enclosure.
   *
   * @return int Number in enclosure
   */
  public int getNumInEnclosure();

  /**
   * Method to enrol/add a monkey to the sanctuary.
   */
  public void enrolMonkey(String name, int location, int lType, double weight,
                          Monkey.sex sexM, Monkey.favFood favFoodM, Monkey.size sizeM,
                          Monkey.healthStatus healthM, String species);

  /**
   * Method to transfer monkey to an enclosure.
   */
  public void transferIsolationToEnclosure(int id);

  /**
   * Method to transfer monkey to isolation.
   */
  public void transferEnclosureToIsolation(int id);

  /**
   * Method to update sanctuary size in future based on requirements and funding.
   */
  public void updateSanctuarySize(int newSizeIsolation, int newSizeEnclosure);

  /**
   * Method to check if an Enclosure is empty.
   *
   * @return True/False
   */
  public int isEnclosureAvailable();

  /**
   * Method to check if an Isolation is empty.
   *
   * @return True/False
   */
  public int isIsolationAvailable();
}
