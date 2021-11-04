import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test the class Housing and its methods.
 */
public class HousingTest {

  JungleFriendsSanctuary jTest;
  ArrayList<Monkey> mTest;
  String s;


  @Before
  public void setup() {
    jTest = new JungleFriendsSanctuary(5, 10);
    jTest.enrolMonkey("John", 1, 3, 20, Monkey.sex.MALE,
        Monkey.favFood.FRUITS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
    jTest.enrolMonkey("Hower", 1, 2, 10, Monkey.sex.FEMALE,
        Monkey.favFood.TREE_SAP, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Macau");
    jTest.enrolMonkey("Paul", 1, 1, 5, Monkey.sex.MALE,
        Monkey.favFood.NUTS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Macau");
    jTest.enrolMonkey("Donald", 2, 2, 18, Monkey.sex.MALE,
        Monkey.favFood.FRUITS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
    jTest.enrolMonkey("Jack", 2, 2, 30, Monkey.sex.MALE,
        Monkey.favFood.INSECTS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
    jTest.enrolMonkey("Tom", 2, 2, 24, Monkey.sex.MALE,
        Monkey.favFood.FRUITS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
    mTest = jTest.listNamesAlphabetical();

  }


  @Test
  public void getType() {

    assertEquals(jTest.listSpeciesAlphabetical().get(1).getLocationType(), 2);
  }

  @Test
  public void getCid() {

    assertEquals(jTest.listSpeciesAlphabetical().get(1).getLocation(), 2);
  }

  @Test
  public void getSpecies() {
    assertEquals(jTest.listSpeciesAlphabetical().get(1).getSpecies(), "Langur");

  }

  @Test
  public void isEmpty() {
    assertTrue(jTest.listSpeciesAlphabetical().get(1).getLocation() != 1);
  }

  @Test
  public void addEnclosure() {
    int countEnclosure;
    countEnclosure = Housing.getCountEnclosure();
    Housing h = new Housing(2);
    h.addEnclosure(1);
    assertEquals(countEnclosure + 1, 2);
  }

  @Test
  public void addIsolation() {
    int countIsolation;
    countIsolation = Housing.getCountIsolation();
    Housing h = new Housing(1);
    h.addEnclosure(1);
    assertEquals(countIsolation + 1, 1);
  }


}