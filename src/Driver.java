import java.util.ArrayList;

/**
 * Sanctuary.Driver class to run the program. The Sanctuary.Driver depicts a user who can try to
 * perform operations
 * and use the functionalities provided.
 */
public class Driver {

  /**
   * The main Sanctuary.Driver class which is responsible to take user input and display the
   * results.
   */
  public static void line() {
    System.out.println(" ");
    for (int i = 0; i < 100; i++) {
      System.out.print("_");
    }
    System.out.println(" ");
  }

  /**
   * Main Function of the Sanctuary.Driver Class which impersonates a user in real world.
   *
   * @param args Arguments passed while running the application from terminal
   */
  public static void main(String[] args) {

    JungleFriendsSanctuary j = new JungleFriendsSanctuary(5, 10);
    ArrayList<Monkey> m;
    line();
    try {
      j.enrolMonkey("John", 1, 3, 20, Monkey.sex.MALE,
          Monkey.favFood.FRUITS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
      j.enrolMonkey("Hower", 1, 2, 10, Monkey.sex.FEMALE,
          Monkey.favFood.TREE_SAP, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Macau");
      j.enrolMonkey("Paul", 1, 1, 5, Monkey.sex.MALE,
          Monkey.favFood.NUTS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Macau");
      j.enrolMonkey("Donald", 2, 2, 18, Monkey.sex.MALE,
          Monkey.favFood.FRUITS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
      j.enrolMonkey("Jack", 2, 2, 30, Monkey.sex.MALE,
          Monkey.favFood.INSECTS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
      j.enrolMonkey("Tom", 2, 2, 24, Monkey.sex.MALE,
          Monkey.favFood.FRUITS, Monkey.size.MEDIUM, Monkey.healthStatus.HEALTHY, "Langur");
    } catch (IllegalArgumentException i) {
      System.out.println("Illegal Arguments passed please check the format/Order");
    } catch (IllegalStateException i) {
      System.out.println(
          "No Space in the Sanctuary.Sanctuary Please move to Partner Sanctuary.Sanctuary");
    }

    System.out.println("Welcome to Jungle Friends Sanctuary.Sanctuary");
    line();
    try {
      System.out.println("Functionality 1 ");
      System.out.println("1. Display Species alphabetically \n");
      m = j.listSpeciesAlphabetical();
      for (Object o : m) {
        System.out.println(o.toString());
      }
    } catch (IllegalStateException i) {
      System.out.println("Sanctuary.Sanctuary is Empty");
    }
    line();
    try {
      System.out.println("Functionality 2 ");
      System.out.println("2. Search for a Species \n");
      m = j.searchSpecies("Langur");
      for (Object o : m) {
        System.out.println(o.toString());
      }
    } catch (IllegalArgumentException i) {
      System.out.println("Sanctuary.Monkey Species not found");
    }


    line();
    try {
      System.out.println("Functionality 3 ");
      System.out.println("3. Create Sign \n");
      System.out.println(j.createSign(2, 2));
    } catch (IllegalArgumentException i) {
      System.out.println("Location Doesnt Exist/Is Empty");
    }
    line();
    try {
      System.out.println("Functionality 4 ");
      System.out.println("4. Display Names alphabetically \n");
      m = j.listNamesAlphabetical();
      for (Object o : m) {
        System.out.println(o.toString());
      }
    } catch (IllegalStateException i) {
      System.out.println("Sanctuary.Sanctuary is Empty");
    }

    line();
    System.out.println("Functionality 5 ");
    System.out.println("5. Create a Shopping list \n");
    System.out.println(j.createShoppingList());


    line();
    System.out.println("Functionality 6 ");
    System.out.println("6. Move Sanctuary.Monkey from Isolation to Enclosure. \n");
    System.out.println("Moving Sanctuary.Monkey from Isolation location 3 to Enclosure\n");
    j.transferIsolationToEnclosure(3);
    m = j.listSpeciesAlphabetical();
    System.out.println(m);


    line();
    System.out.println("Functionality 7");
    System.out.println("6. Move Sanctuary.Monkey from Enclosure to Isolation. \n");
    System.out.println("Moving Sanctuary.Monkey 4 from  enclosure 2 to  Isolation\n");
    j.transferEnclosureToIsolation(4);
    m = j.listSpeciesAlphabetical();
    for (Object o : m) {
      System.out.println(o.toString());
    }

  }
}

