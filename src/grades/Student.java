package grades;

import java.util.ArrayList;

public class Student {

  private String name;
  private ArrayList<Integer> grades;

  public Student(String name){
    this.name = name;
    this.grades = new ArrayList<>(8);
  }

  public void addGrade(int grade){
    grades.add(new Integer(grade));
  }

  public double getGradeAverage(){

    int total = 0;
    for(Integer grade : this.grades){
      total += grade.intValue();
    }

    double ave = total / this.grades.size();
    return ave;
  }

  public String toString(){
    String str = "";
    str += "{\n";
    str += "\tname: " + this.name + ",\n";
    str += "\tgrades: [";
    for(Integer grade : this.grades){
      str += "" + grade.intValue() + ", ";
    }
    str += "]\n}";
    return str;
  }

}
