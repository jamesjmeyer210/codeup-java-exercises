import java.util.Scanner;

class MethodsExercises {

  public static double add(double a, double b){
    return a + b;
  }

  public static double sub(double a, double b){
    return a - b;
  }

  public static double mul(double a, double b){
    return a * b;
  }

  public static double div(double a, double b){
    return a / b;
  }

  public static double mod(double a, double b){
    return a % b;
  }

  public static int getInteger(int low, int high){
    Scanner scan = new Scanner(System.in);
    int userint = scan.nextInt();

    if(userint > low && userint < high){
      return userint;
    }

    System.out.printf("Invalid input.\n"
      + "Please enter a number greater than " + low
      + " and less than " + high + ":");
    userint = getInteger(low, high);
    return userint;
  }

  public static int factorial(final int n){
    if(n > 15){
      return -1;
    }
    else if(n == 1 || n == 0){
      return 1;
    }

    return n * factorial(n - 1);
  }

  public static void rollDice(){
    System.out.print("Please enter the number of sides for the die: ");
    Scanner scan = new Scanner(System.in);

    int span = scan.nextInt();
    {
      // clear out the scanner, then ditch this String
      String forget = scan.nextLine();
    }
    int die[] = new int[2];
    boolean done = false;
    String userin = "";

    do{
      die[0] = (int)(Math.random() * span) + 1;
      die[1] = (int)(Math.random() * span) + 1;

      System.out.println("die 1: " + die[0] + "\ndie 2: " + die[1]);
      System.out.print("Would you like to roll again? (Y|N): ");
      userin = scan.nextLine();

      if(userin.toUpperCase().equals("N")){
        done = true;
      }
    }while(!done);
  }

  public static void main(String[] args){

    {
      double a = 1.01;
      double b = 2.02;
      System.out.println("" + a + " + " + b + " = " + add(a, b));
      System.out.println("" + a + " - " + b + " = " + sub(a, b));
      System.out.println("" + a + " * " + b + " = " + mul(a, b));
      System.out.println("" + a + " / " + b + " = " + div(a, b));
      System.out.println("" + a + " % " + b + " = " + mod(a, b));
    }

    {
      double a = 7;
      double b = 11;
      System.out.println("" + a + " + " + b + " = " + add(a, b));
      System.out.println("" + a + " - " + b + " = " + sub(a, b));
      System.out.println("" + a + " * " + b + " = " + mul(a, b));
      System.out.println("" + a + " / " + b + " = " + div(a, b));
      System.out.println("" + a + " % " + b + " = " + mod(a, b));
    }

    //System.out.print("Enter a number between 1 and 10: ");
    //int userInput = getInteger(1, 10);
    for(int i = 0; i < 16; i++){
      System.out.println("" + i + "! = " + factorial(i));
    }

    rollDice();
  }
}
