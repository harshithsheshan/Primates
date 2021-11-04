import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

/**
 * Class to test methods of class Monkey.
 */
public class MonkeyTest {

  JungleFriendsSanctuary jTest;
  ArrayList<Monkey> mTest;

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
  public void getHealth() {
    Monkey m = jTest.listSpeciesAlphabetical().get(1);
    assertEquals(m.getHealth().toString(), "HEALTHY");
  }

  @Test
  public void getSex() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getSex().toString(), "FEMALE");
  }

  @Test
  public void getName() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getName().toString(), "Hower");
  }

  @Test
  public void getId() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getId(), 140);
  }

  @Test
  public void getSize() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getSize().toString(), "MEDIUM");
  }

  @Test
  public void getAge() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getAge(), 10);
  }

  @Test
  public void getWeight() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertTrue(m.getWeight() - 10.0 < 0.01);
  }

  @Test
  public void getLocation() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getLocation(), 2);
  }

  @Test
  public void getSpecies() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getSpecies(), "Macau");
  }

  @Test
  public void getLocationType() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getLocationType(), 1);
  }

  @Test
  public void getFavFood() {
    Monkey m = jTest.listNamesAlphabetical().get(1);
    assertEquals(m.getFavFood().toString(), "TREE_SAP");
  }


}