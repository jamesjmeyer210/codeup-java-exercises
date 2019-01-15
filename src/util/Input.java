package util;

import java.util.Scanner;

public class Input {

  private Scanner scan;
  private String ioString;
  private int ioInt;
  private double ioDouble;

  public Input(){
    this.scan = new Scanner(System.in);
    this.ioString = null;
    this.ioInt = 0;
    this.ioDouble = 0.0;
  }

  public String getString(){
    return this.ioString;
  }

  public int getInt(){
    return this.ioInt;
  }

  public double getDouble(){
    return this.ioDouble;
  }

  public boolean yesNo(){
    ioString = scan.nextLine();
    if(ioString.equals("y") || ioString.equals("Y")){
      return true;
    }else{
      return false;
    }
  }

  public void getInt(int min, int max){
    System.out.format("Please enter a number between %d and %d", min, max);
    ioInt = scan.nextInt();
  }

  public void getDouble(double min, double max){
    System.out.format("Please enter a number between %f and %f", min, max);
    ioDouble = scan.nextDouble();
  }

}
