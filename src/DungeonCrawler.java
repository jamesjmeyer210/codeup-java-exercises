import java.util.*;

class Room {

  private int dimX;
  private int dimY;

  private ArrayList<String> rmap;
  private ArrayList<Enemy> enemies;
  private Hero hero;

  public Room(int x, int y){
    rmap = new ArrayList<String>(y);
    enemies = new ArrayList<Enemy>();
    drawBlank(x, y);
  }

  private String horizontalWall(int len){
    String wall = "";
    for(int i = 0; i < len; i++){
      wall += "#";
    }
    return wall;
  }

  private void drawBlank(int x, int y){
    String blank = "";
    for(int i = 0; i < x; i++){
      blank += " ";
    }

    rmap.add(horizontalWall(x + 2));
    for(int i = 0; i < y; i++){
      rmap.add("#" + blank + "#");
    }
    rmap.add(horizontalWall(x + 2));
  }

  public void draw(){
    for(String row : rmap){
      System.out.println(row);
    }
  }

  public void addEnemy(int x, int y, Enemy enemy){
    enemies.add(enemy);
    char[] row = rmap.get(y).toCharArray();
    row[x] = 'E';
    try{
      rmap.set(y, new String(row));
      enemy.setPosition(x, y);
    }catch(NullPointerException e){
      System.err.format("set failed. x: %d, y: %d", x, y);
    }
  }

  public void addHero(int x, int y, Hero hero){
    this.hero = hero;
    char[] row = rmap.get(y).toCharArray();
    row[x] = 'H';
    rmap.set(y, new String(row));
    hero.setPosition(x, y);
  }

  public void moveHero(int x, int y, Hero hero){
    int index;
    char[] crow = null;
    int i = 0;
    for(String row : rmap){
      index = row.indexOf('H');
      if(index > -1){
        crow = row.toCharArray();
        crow[index] = ' ';
        rmap.set(i, new String(crow));
        break;
      }
      i++;
    }

    this.addHero(x, y, hero);
  }
}

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
