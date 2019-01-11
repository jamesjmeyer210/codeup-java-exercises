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

  public static void methodsTest1(){

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

  private static int hash(String seed){
    int hash = 5381;
    int i = seed.length();

    while(i != 0){
      hash = (hash * 33) ^ seed.charAt(--i);
    }
    return Math.abs(hash);
  }

  public static boolean coinFlip(){
    int rand = (int)Math.floor(Math.random() * 100) % 2;
    if(rand == 0){
      return false;
    }else{
      return true;
    }
  }

  public static String randomWalk(int n){
    if(n < 1){
      return null;
    }

    String str = "";
    for(int i = 0; i < n; i++){
      if(coinFlip()){
        str += 1;
      }else{
        str += 0;
      }
    }
    return str;
  }

  public static int countOnes(String str){
    if(str == null){
      return -1;
    }

    char raw[] = str.toCharArray();
    int ones = 0;
    for(char ch : raw){
      if(ch == '1'){
        ones++;
      }
    }
    return ones;
  }

  public static int countZeros(String str){
    if(str == null){
      return -1;
    }

    char raw[] = str.toCharArray();
    int zeros = 0;
    for(char ch : raw){
      if(ch == '0'){
        zeros++;
      }
    }
    return zeros;
  }

  public static void methodsTest2(){
    /*
    Write a method called coinFlip that randomly returns a true or false value.
    */
    for(int i = 0; i < 5; i++){
      System.out.println(coinFlip());
    }
    /*
    Write a method named randomWalk that takes in an integer and returns a string of that many random ones and zeros. Example: randomWalk(1) returns a string with one character that is randomly 0 or 1. randomWalk(33) returns a string with 33 random 1s or 0s.
    */
    for(int i = 0; i < 5; i++){
      System.out.println(randomWalk(10));
    }
    /*
    Write a method named countOnes that takes in a string of ones and zeroes and returns a count of the ones.
    */
    {
      String rstr = "";
      for(int i = 0; i < 5; i++){
        rstr = randomWalk(10);
        System.out.format("There are %d ones in %s\n", countOnes(rstr), rstr);
      }
    }
    /*
    Write a method named countZeros that takes in a string of ones and zeroes and returns a count of the 0s.
    */
    {
      String rstr = "";
      for(int i = 0; i < 5; i++){
        rstr = randomWalk(10);
        System.out.format("There are %d zeros in %s\n", countZeros(rstr), rstr);
      }
    }
    /*
    Write a method named analyzeRandomWalk that accepts a string containing ones and zeroes and prints out the number of ones and the number of zeroes. This method is void because it does not return anything. Example: analyzeRandomWalk("11000") should print "There are 2 ones and 3 zeroes".

    Write a method named longestRun that accepts a string of ones and zeroes and returns an integer that specifies the longest consecutive sequence of either 0s or 1s. Example: longestRun("1001111100") returns 5 because there are 5 ones in a row. longestRun("01001") returns 2 because there are two consecitive zeroes.

    Write a method named secondLongestRun that accepts a string of 1s and 0s and returns an integer that specifies the length of the second longest run of consecutive numbers. Example secondLongestRun("111001") returns 2 because the two 0s in a row are the second longest run.

    Write a method named magic8ball that prompts the user to input a question. If the user inputs a string that does not have a question mark at the end, then start the method over again. When answering the magic 8 ball randomly returns one of a set of string options like the following:

    "All signs point to yes", "The future is cloudy. Ask again", "Very doubtful", "Outlook not so good.", "Don't count on it.", "You may rely on it!", "Ask again later."

    Write a method named dndDiceRoll that accepts a string of the format "2d6" where the first number(s) are the number of dice and the second number is the number of sides of each of those dice. Example: "5d4" rolls a four sided die 5 times and returns the sum of the result.

    Write a method named l5rDiceRoll that accepts a string of the following format "6k4" where the first number is the number of dice to roll, the second number is the number of dice we keep the highest values from, and each die has 10 sides. Example "4k2" rolls 4 dice of 10 sides, and returns the sum of keeping the highest 2 rolls.
    */
  }

  public static void main(String[] args){

    methodsTest2();

  }
}
