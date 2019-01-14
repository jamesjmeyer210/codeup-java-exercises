import java.util.*;

class Tuple<T,U> {
  public T first;
  public U second;

  public Tuple(T f, U s){
    this.first = f;
    this.second = s;
  }
}

class Cell {

  protected int coordinates[];
  protected boolean collision; // read only, externally
  protected boolean hasHero;
  protected boolean hasEnemy;
  protected char view;
  protected Tuple<Hero,Enemy> within;

  public Cell(final int x, final int y, char v){
    collision = false;
    coordinates = new int[2];
    coordinates[0] = x;
    coordinates[1] = y;
    view = v;
  }

  public static int init(Cell self, final int x, final int y, char v){
    if(self == null){
      return 1;
    }
    self.collision = false;
    self.coordinates[0] = x;
    self.coordinates[1] = y;
    self.view = v;
    return 0;
  }

  // borrow makes for a nice function to overload
  public int borrow(final Tuple<Hero,Enemy> option){

    if(option.first == null && option.second == null){
      return 1;
    }
    else if(option.first != null){
      hasHero = true;
      this.within.first = option.first;
    }
    else if(option.second != null){
      hasEnemy = true;
      this.within.second = option.second;
    }
    else if(option.first != null && option.second != null){
      collision = true;
    }
    return 0;
  }

  public Tuple<Character,Integer> lendView(){
    return new Tuple<Character,Integer>(
      new Character(view),
      new Integer(0)
    );
  }

  public Tuple<Boolean,Integer> hasCollision(){
    return new Tuple<Boolean,Integer>(
      new Boolean(this.collision),
      new Integer(0));
  }

  public String toString(){
    return "";
  }
}

class Coordinate {
  int x, y;
  public Coordinate(int x, int y){
    this.x = x;
    this.y = y;
  }
}

class Room {

  private int xalloc;
  private int yalloc;
  private Coordinate[] entrances;
  private Coordinate[] exits;
  private Cell[][] cells;
  private ArrayList<Enemy> enemies;
  private Hero hero;

  public Room(Coordinate dim[], Coordinate entrances[], Coordinate exits[]){

    xalloc = dim[0];
    yalloc = dim[1];

    cells = new Cell[yalloc];
    for(int i = 0; i < yalloc; i++){

      cells[i] = new Cell[xalloc](x);
      for(int j = 0; j < x; j++){
        cells[i][j] = new Cell(i, j, ' ');
      }
    }

    xalloc = x;
    yalloc = y;
  }

  private int drawDefault(){

    int i = 0;
    int j = 0;
    for(ArrayList<ArrayList<Cell>> row : this.cells){

      for(Cell col : row){
        if(i == 0 || j == 0 || i == row.length() - 1 || j == row.length() - 1){
          col = new Cell(i, j, '#');
        }else{
          col = new Cell(i, j, ' ');
        }
        j++;
      }
      j = 0;
      i++;
    }
    return 0;
  }

} // END Room

class Hero {

    String name;
    int attack;
    int health;
    boolean alive;
    int x;
    int y;

    public Hero(String name, int attack) {
        this.health = 100;
        this.name = name;
        this.attack = attack;
        this.alive = true;
    }

    public void setPosition(int x, int y){
      this.x = x;
      this.y = y;
    }

    public void attack(Enemy enemy) {
        enemy.health--;

        if (enemy.health == 0) {
            enemy.alive = false;
            System.out.println("Enemy defeated!");
            System.exit(0);
        }

    }
}

class Enemy {

    boolean alive;
    String name;
    int attack;
    int health;
    int x;
    int y;

    public Enemy(String name, int attack) {
        this.health = 100;
        this.name = name;
        this.attack = attack;
        this.alive = true;
    }

    public void speak() {
        // TODO:
    }

    public void attack(Hero player) {
        player.health--;
        if (player.health == 0) {
            player.alive = false;
            System.out.println("You were defeated!");
            System.exit(0);
        }
    }

    public void setPosition(int x, int y){
      this.x = x;
      this.y = y;
    }

    public String toString() {
        return this.name + " " + this.attack;
    }
}

class DungeonCrawler {

  public static void main(String[] args){

    Enemy e1 = new Enemy("Bob", 2);
    System.out.println(e1.toString());

    Room r1 = new Room(128, 32);
    Hero hero = new Hero("", 1);
    r1.addHero(2,2, hero);
    r1.draw();

    boolean exit = false;
    Scanner scan = new Scanner(System.in);
    String userin = "";
    do{
      System.out.print("move (w/a/s/d): ");
      userin = scan.nextLine();
      if(userin.equals("exit")){
        System.out.println("Goodbye.");
        System.exit(0);
      }
      else if(userin.equals("w")){
        r1.moveHero(hero.x, hero.y - 1, hero);
      }
      else if(userin.equals("a")){
        r1.moveHero(hero.x - 1, hero.y, hero);
      }
      else if(userin.equals("s")){
        r1.moveHero(hero.x, hero.y + 1, hero);
      }
      else if(userin.equals("d")){
        r1.moveHero(hero.x + 1, hero.y, hero);
      }
      else {
        System.out.println("Invalid input: " + userin);
      }
      r1.draw();
    }while(!exit);
  }

}
