import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Class to implement sanctuary and run JungleFriends Sanctuary.Sanctuary.
 */
public class JungleFriendsSanctuary implements Sanctuary {

  private static final int LargeQ = 500;
  private static final int MediumQ = 250;
  private static final int SmallQ = 100;
  int numberOfIsolation;
  int numberOfEnclosures;
  ArrayList<Housing> isolation = new ArrayList<>();
  ArrayList<Housing> enclosure = new ArrayList<>();
  ArrayList<Monkey> monkeys = new ArrayList<>();
  Monkey m;
  Housing h;


  /**
   * Constructor to initialize JungleFriendsSanctuary object with number of Enclosures and
   * Isolations.
   *
   * @param n number of isolations
   * @param m number of enclosures
   */
  public JungleFriendsSanctuary(int n, int m) {

    this.numberOfIsolation = n;
    this.numberOfEnclosures = m;

    //this.isolation = new Sanctuary.Housing();
  }

  /**
   * Method to create an alphabetical list of all species in the Sanctuary.Sanctuary.
   *
   * @return Array List of Sanctuary.Monkey Species in Alphabetical order.
   */
  @Override
  public ArrayList<Monkey> listSpeciesAlphabetical() {
    if (monkeys.isEmpty()) {
      throw new IllegalStateException();
    }
    this.monkeys.sort(Comparator.comparing(Monkey::getSpecies));
    return monkeys;
  }

  /**
   * Method to create an alphabetical list of all Monkeys by name in the Sanctuary.Sanctuary.
   *
   * @return Array List of Sanctuary.Monkey Names in Alphabetical order.
   */
  @Override
  public ArrayList<Monkey> listNamesAlphabetical() {
    if (monkeys.isEmpty()) {
      throw new IllegalStateException();
    }
    this.monkeys.sort(Comparator.comparing(Monkey::getName));
    return monkeys;
  }


  /**
   * To Create a Sign in front of the Sanctuary.Housing Unit with details of the occupants.
   *
   * @param locationType Type of Sanctuary.Housing
   * @param location     Unique location id
   * @return Sign post
   */
  @Override
  public String createSign(int locationType, int location) {
    StringBuilder s = new StringBuilder();
    int found = 0;
    System.out.printf("Sign for Location Type: %d Location : %d /n", locationType, location);
    for (Monkey monkey : monkeys) {
      if (monkey.getLocationType() == locationType && monkey.getLocation() == location) {
        found = 1;
        s.append(String.format("\n**Name: %s sex: %s Favourite Food: %s Species: %s** \n",
            monkey.getName(),
            monkey.getSex().toString(), monkey.getFavFood().toString(), monkey.getSpecies()));
      }
    }
    if (found == 0) {
      throw new IllegalArgumentException();
    }
    return s.toString();
  }

  /**
   * Method to search for aa specific species in the sanctuary.
   *
   * @return list of locations where the species was found
   */
  @Override
  public ArrayList<Monkey> searchSpecies(String key) {
    ArrayList<Monkey> mSearch = new ArrayList<>();
    int found = 0;
    for (Monkey monkey : monkeys) {
      if (monkey.getSpecies().equals(key)) {
        mSearch.add(monkey);
        found = 1;
      }
    }
    if (found == 0) {
      throw new IllegalArgumentException();
    } else {
      return mSearch;
    }
  }

  /**
   * Method to create a shopping list to buy food for the sanctuary.
   *
   * @return Shopping list
   */
  @Override
  public HashMap<String, Double> createShoppingList() {
    HashMap<String, Double> shoppingList = new HashMap<>();
    double addQ;

    for (Monkey monkey : monkeys) {
      String favFood = monkey.getFavFood().toString();
      String sizeM = monkey.getSize().toString();
      if (sizeM.equals("LARGE")) {
        addQ = LargeQ;
      } else if (sizeM.equals("MEDIUM")) {
        addQ = MediumQ;
      } else {
        addQ = SmallQ;
      }
      if (shoppingList.containsKey(monkey.getFavFood().toString())) {
        shoppingList.put(favFood, shoppingList.get(favFood) + addQ);
      } else {

        shoppingList.put(favFood, addQ);
      }
    }
    return (shoppingList);
  }

  /**
   * Method to get the number of animals in Isolation.
   *
   * @return int Number in isolation
   */
  @Override
  public int getNumInIsolation() {
    int numIsolation = 0;
    for (Monkey monkey : monkeys) {
      if (monkey.getLocationType() == 1) {
        numIsolation++;
      }
    }
    return numIsolation;
  }

  /**
   * Method to get the number of animals in Enclosure.
   *
   * @return int Number in enclosure
   */
  @Override
  public int getNumInEnclosure() {
    int numEnclosure = 0;
    for (Monkey monkey : monkeys) {
      if (monkey.getLocationType() == 2) {
        numEnclosure++;
      }
    }
    return numEnclosure;
  }

  /**
   * Method to enrol/add a monkey to the sanctuary.
   */
  @Override
  public void enrolMonkey(String name, int lType, int location, double weight,
                          Monkey.sex sexM, Monkey.favFood favFoodM, Monkey.size sizeM,
                          Monkey.healthStatus healthM, String species) {
    //System.out.println("enrolling");
    if (getNumInIsolation() < numberOfIsolation) {
      Monkey mNew = new Monkey(name, lType, location, weight, sexM, favFoodM, sizeM, healthM,
          species);
      monkeys.add(mNew);
    } else {
      throw new IllegalStateException();
    }
  }


  /**
   * Method to transfer monkey to an enclosure.
   */
  @Override
  public void transferIsolationToEnclosure(int id) {
    for (Monkey monkey : monkeys) {
      //System.out.println(monkey.getId());
      //System.out.println(id);
      if (monkey.getId() == id) {
        System.out.printf("Sanctuary.Monkey found at %d\n", monkey.getLocation());
        for (Housing tempEnclosure : enclosure) {
          System.out.println("Enclosure");
          if (tempEnclosure.getSpecies().equals(monkey.getSpecies())) {
            System.out.println(MessageFormat.format("enclosure id{0}", tempEnclosure
                .getCid()));
            if (Math.abs(tempEnclosure.getRemainingArea() - monkey.getAreaRequired()) < 0.01) {
              monkey.updateLocation(2, tempEnclosure.getCid());
              calculateRemainingCapacity(monkey.getSize(), monkey.getLocation());
              return;
            }
          }
        }
        if (Housing.countEnclosures < numberOfEnclosures) {
          System.out.println();
          h = new Housing(2);
          monkey.updateLocation(2, h.getCid());
          enclosure.add(h);
          return;
        } else if (!Housing.emptyIsolations.isEmpty()) {
          System.out.println("Enclosure is Empty");
          return;
        }
      }
      throw new IllegalArgumentException();

    }
  }


  /**
   * Method to transfer monkey to isolation.
   */
  @Override
  public void transferEnclosureToIsolation(int id) {
    //System.out.println(id);
    for (Monkey monkey : monkeys) {
      //System.out.println(monkey.getId());
      if (monkey.getId() == id) {
        if (Housing.getCountIsolation() < numberOfIsolation) {
          monkey.updateLocation(1, getNumInIsolation() + 1);
          return;
        } else if (Housing.countEnclosures < numberOfIsolation) {
          Housing h;
          h = new Housing(1);
          monkey.updateLocation(1, h.getCid());
          isolation.add(h);
          return;
        }
        throw new IllegalStateException();
      }
    }
  }

  /**
   * Method to update sanctuary size in future based on requirements and funding.
   */
  @Override
  public void updateSanctuarySize(int newSizeEnclosure, int newSizeIsolation) {
    this.numberOfEnclosures = newSizeEnclosure;
    this.numberOfIsolation = newSizeIsolation;
  }

  /**
   * Method to check if an Enclosure is empty.
   *
   * @return Location available
   */
  @Override
  public int isEnclosureAvailable() {
    if (Housing.emptyEnclosures.isEmpty()) {
      if (Housing.getCountEnclosure() < numberOfEnclosures) {
        return (Housing.countEnclosures);
      } else {
        throw new IllegalStateException();
      }
    }
    return Housing.emptyEnclosures.get(0);
  }

  /**
   * Method to check if an Isolation is empty.
   *
   * @return True/False
   */

  public int isIsolationAvailable() {
    if (Housing.emptyIsolations.isEmpty()) {
      if (Housing.getCountIsolation() < numberOfIsolation) {
        return (Housing.countEnclosures);
      } else {
        throw new IllegalStateException();
      }
    }
    return 0;
  }

  void calculateRemainingCapacity(Monkey.size s, int location) {
    double remove;
    if (s.toString().equals("Large")) {
      remove = 10.0;
    } else if (s.toString().equals("Medium")) {
      remove = 5.0;
    } else {
      remove = 1.0;
    }
    for (Housing h : enclosure) {
      if (h.getType() == 2 && h.getCid() == location) {
        h.reduceRemainingCapacity(remove);
      }
    }
  }
}