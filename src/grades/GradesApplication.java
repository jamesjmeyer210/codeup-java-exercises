package grades;
import java.util.HashMap;
import java.util.Scanner;

public class GradesApplication implements Runnable {

  private HashMap<String,Runnable> cli;
  private HashMap<String,Student> students;
  private Scanner scan;

  public GradesApplication(HashMap<String,Student> students, Scanner scan){
    // instantiate the cli hashmap and assign the references
    this.cli = new HashMap<>();
    this.students = students;
    this.scan = scan;
    // create the runnable objects for each command
    initArgExit();  // exit
    initArgView();  // view
    initArgUsernames(); // usernames
    initArgAddStudent();
    initArgEditStudent();
    initArgGetAverage();
  }

  private void initArgExit(){
    cli.put("exit", new Runnable(){
      public void run(){
        System.out.println("Goodbye.");
        System.exit(0);
      }
    });
  }

  private void initArgUsernames(){
    cli.put("usernames", new Runnable(){
      HashMap<String,Student> data = students;
      public void run(){
        for(String uname : data.keySet()){
          System.out.println(uname);
        }
      }
    });
  }

  private void initArgView(){
    cli.put("view", new Runnable(){

      Scanner fscan = scan;
      HashMap<String,Student> data = students;

      public void run(){
        System.out.println("What student would you like to view?");
        String query = fscan.next();
        if(students.containsKey(query)){
          System.out.println(data.get(query).toString());
        }else{
          System.out.println("Sorry, a student by the username doesn't exist.");
        }
      }
    });
  }

  private void initArgAddStudent(){
    cli.put("add student", new Runnable(){

      Scanner fscan = scan;
      HashMap<String,Student> data = students;

      public void run(){
        System.out.print("Please enter the student's github username: ");
        String uname = fscan.next();
        System.out.print("Please enter the student's name: ");
        String name = fscan.next();
        data.put(uname, new Student(name));
      }
    });
  }

  private void initArgEditStudent(){
    cli.put("add grade", new Runnable(){

      Scanner fscan = scan;
      HashMap<String, Student> data = students;

      public void run(){
        System.out.print("Which student would you like to modify? ");
        String query = fscan.next();
        if(students.containsKey(query)){
          Student stud = data.get(query);
          System.out.print("Add a grade: ");
          stud.addGrade(Integer.parseInt(fscan.next()));
        }else{
          System.out.println("Sorry, a student by the username doesn't exist.");
        }
      }
    });
  }

  private void initArgGetAverage(){
    cli.put("get average", new Runnable(){

      Scanner fscan = scan;
      HashMap<String, Student> data = students;

      public void run(){
        System.out.print("Which student would you like to view? ");
        String query = fscan.next();

        if(students.containsKey(query)){
          Student stud = data.get(query);
          System.out.println("" + stud.getGradeAverage());
        }else{
          System.out.println("Sorry, a student by the username doesn't exist.");
        }
      }
    });
  }

  public void run(){

    String userIn = "";
    while(true){
      System.out.format("\nCommands:\n");
      for(String command : this.cli.keySet()){
        System.out.println("\t" + command);
      }

      userIn = scan.next();
      if(cli.containsKey(userIn)){
        cli.get(userIn).run();
      }
      else {
        System.out.format("Command \"%s\" not found.\n", userIn);
      }
    }
  }

  public static void main(String[] args){

    HashMap<String,Student> students = new HashMap<>();
    Scanner scan = new Scanner(System.in).useDelimiter("\n");

    students.put("allice01", new Student("Allice"));
    students.put("bob02", new Student("Bob"));
    students.put("charlie03", new Student("Charlie"));
    students.put("donald04", new Student("Donald"));
    students.put("emily05", new Student("Emily"));

    GradesApplication app = new GradesApplication(students, scan);
    app.run();
  }
}
