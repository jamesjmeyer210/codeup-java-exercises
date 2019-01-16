package movies;

import util.Input;

class MoviesApplication {

  private static void printOptions(){
    System.out.print(
      "\n\nWhat would you like to do?\n\n" +
      "0 - exit\n" +
      "1 - view all movies\n" +
      "2 - view movies in the animated category\n" +
      "3 - view movies in the drama category\n" +
      "4 - view movies in the horror category\n" +
      "5 - view movies in the scifi category\n" +
      "Enter your choice: "
    );
  }

  private static void printAllMovies(Movie[] movies){
    for(Movie movie : movies){
      System.out.println(movie.toString());
    }
  }

  private static void printByCategory(Movie[] movies, String category){
    for(Movie movie : movies){
      if(movie.getCategory().equals(category)){
        System.out.println(movie.toString());
      }
    }
  }

  public static void main(String[] args){

    Movie[] movies = MoviesArray.findAll();

    //printOptions();
    Input in = new Input();

    boolean exit = false;
    int option = -1;
    while(!exit){
      printOptions();
      option = in.getInt(0, 5);

      switch(option){
        case 0:
          exit = true;
          break;
        case 1:
          printAllMovies(movies);
          break;
        case 2:
          printByCategory(movies, "animated");
          break;
        case 3:
          printByCategory(movies, "drama");
          break;
        case 4:
          printByCategory(movies, "horror");
          break;
        case 5:
          printByCategory(movies, "scifi");
          break;
      }
    }
  }

}
