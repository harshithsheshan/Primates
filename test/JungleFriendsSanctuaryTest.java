import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;

/**
 * To Test all Methods of JungleFriendsSanctuary.
 */
public class JungleFriendsSanctuaryTest {

  JungleFriendsSanctuary jTest;
  ArrayList<Monkey> mTest;

  ArrayList<Monkey> mTest2;
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
  public void listSpeciesAlphabeticalTest() {
    mTest = jTest.listSpeciesAlphabetical();
    for (int i = 0; i < mTest.size() - 1; i++) {
      assertTrue("Alphabetical Species Test Failed",
          mTest.get(i).getSpecies().compareToIgnoreCase(mTest.get(i + 1).getSpecies()) <= 0);
    }
  }

  @Test

  public void listNamesAlphabeticalTest() {
    mTest = jTest.listNamesAlphabetical();
    for (int i = 0; i < mTest.size() - 1; i++) {
      //System.out.println(mTest.get(i).toString());
      //System.out.println(mTest.get(i+1).toString());
      assertTrue("Alphabetical Names Test Failed",
          mTest.get(i).getName().compareToIgnoreCase(mTest.get(i + 1).getName()) <= 0);
    }

  }

  @Test
  public void createSignTest() {
    s = jTest.createSign(2, 2);
    System.out.println(s);
    assertFalse("Create Sign Failed", s.isEmpty());
  }


  @Test
  public void searchSpeciesTest() {
    String key = "Langur";
    boolean flag = true;
    for (Monkey searchSpecies : jTest.searchSpecies(key)) {
      if (!searchSpecies.getSpecies().equals(key)) {
        flag = false;
        break;
      }
    }

    assertTrue("Search Species failed", flag);


  }

  @Test
  public void createShoppingListTest() {
    mTest2 = jTest.listSpeciesAlphabetical();
    HashMap<String, Double> shoppingTest = new HashMap<>();
    double addQ;
    for (Monkey monkey : jTest.monkeys) {
      String favFood = monkey.getFavFood().toString();
      String sizeM = monkey.getSize().toString();
      if (sizeM.equals("LARGE")) {
        addQ = 500;
      } else if (sizeM.equals("MEDIUM")) {
        addQ = 250;
      } else {
        addQ = 100;
      }
      if (shoppingTest.containsKey(monkey.getFavFood().toString())) {
        shoppingTest.put(favFood, shoppingTest.get(favFood) + addQ);
      } else {
        shoppingTest.put(favFood, addQ);
      }
    }
    assertEquals("Shopping List Test Failed", shoppingTest, jTest.createShoppingList());
  }


  @Test
  public void getNumInIsolationTest() {
    int testI = 0;
    for (Monkey m : jTest.listSpeciesAlphabetical()) {
      if (m.getLocationType() == 1) {
        testI++;
      }
    }
    assertEquals(testI, jTest.getNumInIsolation());

  }

  @Test
  public void getNumInEnclosureTest() {
    int testE = 0;
    for (Monkey m : jTest.listSpeciesAlphabetical()) {
      if (m.getLocationType() == 2) {
        testE++;
      }
    }
    assertEquals(testE, jTest.getNumInEnclosure());
  }


  @Test
  public void enrolMonkeyTest() {
    int beforeEnrol = jTest.getNumInIsolation();
    jTest.enrolMonkey("Togo", 1, 6, 28.0, Monkey.sex.MALE, Monkey.favFood.EGGS, Monkey.size.LARGE,
        Monkey.healthStatus.HEALTHY, "Gorilla");
    assertEquals(beforeEnrol, jTest.getNumInIsolation() - 1);
  }

  @Test
  public void transferEnclosureToIsolation() {
    int nIsolationBefore = jTest.getNumInIsolation();
    int nEnclosureBefore = jTest.getNumInEnclosure();
    jTest.transferEnclosureToIsolation(1);
    assertEquals(nIsolationBefore, jTest.getNumInIsolation());

  }

  @Test
  public void transferIsolationToEnclosure() {

    int nIsolationBefore = jTest.getNumInIsolation();
    int nEnclosureBefore = jTest.getNumInEnclosure();
    mTest = jTest.listSpeciesAlphabetical();
    for (  Monkey m : mTest) {
      System.out.println(m.toString());
    }
    jTest.transferIsolationToEnclosure(76);
    assertEquals(nIsolationBefore, jTest.getNumInIsolation() );

  }
}
