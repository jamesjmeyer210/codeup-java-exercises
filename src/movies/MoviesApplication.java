package movies;

class MoviesApplication {

  public static void printOptions(){
    System.out.println(
      "What would you like to do?\n\n" +
      "0 - exit\n" +
      "1 - view all movies\n" +
      "2 - view movies in the animated category\n" +
      "3 - view movies in the drama category\n" +
      "4 - view movies in the horror category\n" +
      "5 - view movies in the scifi category\n"
    );
  }

  public static void main(String[] args){

    printOptions();

  }

}
