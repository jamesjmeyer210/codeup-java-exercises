import java.util.Scanner;

class HighLow {

  private static final int WON = 0;
  private static final int LOST = 1;
  private static final int GUESS_LIMIT = 5;

  public static int guess(int rnum, int guesses, Scanner scan){
    System.out.println(""
      + "========================\n"
      + "Guesses remaining: " + (GUESS_LIMIT - guesses + 1) + "\n"
      + "========================");
    int userguess = scan.nextInt();

    if(userguess == rnum){
      return WON;
    }else if(guesses == GUESS_LIMIT){
      return LOST;
    }else if(userguess > rnum){
      System.out.println("LOWER!");
    }else if(userguess < rnum){
      System.out.println("HIGHER!");
    }

    return guess(rnum, ++guesses, scan);
  }

  public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    int guesses = 0;
    int rnum = (int)((Math.random() * 100) + 1);
    int status = guess(rnum, ++guesses, scan);

    if(status == WON){
      System.out.println("GOOD GUESS!");
    }else{
      System.out.println("You ran out of guesses...");
    }
  }

}
