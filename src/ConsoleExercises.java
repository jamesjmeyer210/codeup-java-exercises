import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.lang.Iterable;

class ConsoleExercises {

  public static void main(String[] args){

    final double pi = 3.14159;
    System.out.format("The value of pi is approximately %s.\n",
      new DecimalFormat("#.00").format(pi));

    Scanner scan = new Scanner(System.in);

    System.out.print("Please enter an integer: ");
    try {
      int intUserIn = scan.nextInt();
    } catch(InputMismatchException e){
      System.out.println("Input was not an integer. Exiting...");
      System.exit(1);
    }

    {
      // clear the junk out the piles up in the scanner
      final String forget = scan.nextLine();
    }

    System.out.print("Please enter three words: ");
    try {
      String strUserIn = scan.nextLine();

      strUserIn = strUserIn.replace(' ', '\n');
      System.out.println(strUserIn);

    } catch(InputMismatchException e){
      e.printStackTrace();
    }
  }
}
