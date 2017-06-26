import java.io.Console;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    Console myConsole = System.console();

    CompactDisc radiohead = new CompactDisc("RadioHead", "OK Computer", 1997, 12);
    CompactDisc imaginedragons = new CompactDisc("Imagine Dragons", "Evolve", 2017, 12);
    CompactDisc soundgarden = new CompactDisc("Soundgarden", "Superunknown", 1994, 15);
    CompactDisc beatles = new CompactDisc("Beatles", "Revolver", 1966, 16);

    List<CompactDisc> cdList = new ArrayList<CompactDisc>();
    cdList.add(radiohead);
    cdList.add(imaginedragons);
    cdList.add(soundgarden);
    cdList.add(beatles);

    Boolean proceed = true;

    while (proceed == true) {
    System.out.println("Welcome to our CD Store. Choose an option: View All CDs, Donate a CD, Search for a CD, or Exit");

    String choice = myConsole.readLine();

    if (choice.equals("Exit")) {
      proceed = false;
    } else if (choice.equals("View All CDs")) {
      System.out.println("These are all the CDs in our inventory");
      for (CompactDisc eachCD : cdList) {
        System.out.println( "----------------------" );
        System.out.println(eachCD.mArtist);
        System.out.println(eachCD.mAlbum);
        System.out.println(eachCD.mYear);
        System.out.println(eachCD.mPrice);
      }
    } else if (choice.equals("Donate a CD")) {
      System.out.println("Enter the name of the artist");
      String inputArtist = myConsole.readLine();
      System.out.println("Enter the name of the album");
      String inputAlbum = myConsole.readLine();
      System.out.println("Enter the year it was released");
      Integer inputYear = Integer.parseInt(myConsole.readLine());
      System.out.println("Enter what you think the album is worth");
      Integer inputPrice = Integer.parseInt(myConsole.readLine());

      CompactDisc newCD = new CompactDisc(inputArtist, inputAlbum, inputYear, inputPrice);

      cdList.add(newCD);
      System.out.println(newCD.mArtist);
      System.out.println(newCD.mAlbum);
      System.out.println(newCD.mYear);
      System.out.println(newCD.mPrice);
    } else if (choice.equals("Search for a CD")) {


      System.out.println("How would you like to conduct your search? By artist, by release year, or by budget?");

      String searchChoice = myConsole.readLine();
      int artistMatches = 0;
      int yearMatches = 0;
      int budgetMatches = 0;

      if (searchChoice.equals("artist")) {
        System.out.println("Enter artist name:");
        String searchArtist = myConsole.readLine();
        for (CompactDisc eachCD : cdList) {
          if (eachCD.sameArtist(searchArtist)) {
          System.out.println( "----------------------" );
          System.out.println(eachCD.mArtist);
          System.out.println(eachCD.mAlbum);
          System.out.println(eachCD.mYear);
          System.out.println(eachCD.mPrice);
          artistMatches++;
        }
        } if (artistMatches == 0) {
          System.out.println("Sorry, there are no matches");
        }
      } else if (searchChoice.equals("year")) {
        System.out.println("Enter release year:");
        Integer searchYear = Integer.parseInt(myConsole.readLine());
        for (CompactDisc eachCD : cdList) {
          if (eachCD.sameYear(searchYear)) {
            System.out.println( "----------------------" );
            System.out.println(eachCD.mArtist);
            System.out.println(eachCD.mAlbum);
            System.out.println(eachCD.mYear);
            System.out.println(eachCD.mPrice);
            yearMatches++;
          }
        } if (yearMatches == 0) {
          System.out.println("Sorry, there are no matches");
        }
      } else if (searchChoice.equals("budget")) {
        System.out.println("How much is your budget?");
        Integer searchBudget = Integer.parseInt(myConsole.readLine());
        for (CompactDisc eachCD : cdList) {
          if (eachCD.withinBudget(searchBudget)){
            System.out.println( "----------------------" );
            System.out.println(eachCD.mArtist);
            System.out.println(eachCD.mAlbum);
            System.out.println(eachCD.mYear);
            System.out.println(eachCD.mPrice);
            budgetMatches++;
          }
          } if (budgetMatches == 0) {
            System.out.println("Sorry, try YouTube instead");
        }
      }




    } else {
      System.out.println("Please pick an option listed above");
    }


    }
  }
}
