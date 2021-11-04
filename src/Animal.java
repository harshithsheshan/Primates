/**
 * Interface to be used as a base for all species of animals that can be found in a Sanctuary.
 * Sanctuary.
 */

public interface Animal {

  /**
   * Returns Name of Sanctuary.Monkey
   *
   * @return Unique name of Sanctuary.Monkey.
   */
  public String getName();

  /**
   * Returns ID assigned to the Sanctuary.Monkey.
   *
   * @return Unique id assigned to the monkey.
   */
  public int getId();

  /**
   * Returns the weight of the Sanctuary.Monkey.
   *
   * @return weight
   */
  public double getWeight();

  /**
   * Returns the location of the monkey.
   *
   * @return weight
   */
  public int getLocation();

  /**
   * Gives the Area Required by animal.
   *
   * @return Area
   */
  public double getAreaRequired();
}
