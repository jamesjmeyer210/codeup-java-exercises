package movies;

public class Movie {

  private String name;
  private String genre;

  public Movie(String name, String genre){
    this.name = name;
    this.genre = genre;
  }

  public String getName(){
    return this.name;
  }

  public String getCategory(){
    return this.genre;
  }

  public String toString(){
    return this.name + "\t" + this.genre;
  }

}
