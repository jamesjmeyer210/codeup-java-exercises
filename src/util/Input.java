package util;

import java.util.Scanner;

public class Input {

  private Scanner scan;
  private String ioString;
  private int ioInt;
  private double ioDouble;

  public Input(){
    this.scan = new Scanner(System.in).useDelimiter("\n");
    this.ioString = null;
    this.ioInt = 0;
    this.ioDouble = 0.0;
  }

  public String getString(){
    this.ioString = scan.next();
    return this.ioString;
  }

  public int getInt(){
    this.ioInt = Integer.parseInt(scan.next());
    return this.ioInt;
  }

  public double getDouble(){
    this.ioDouble = Double.parseDouble(scan.next());
    return this.ioDouble;
  }

  public boolean yesNo(){
    ioString = scan.next();
    if(ioString.equals("y") || ioString.equals("Y")){
      return true;
    }else{
      return false;
    }
  }

  public int getInt(int min, int max){

    boolean validInput = false;
    while(!validInput){
      try {
        this.ioInt = Integer.parseInt(scan.next());
        validInput = true;
      }catch(NumberFormatException e){
        System.out.format("Input is not a valid integer. Please try again.\n");
        continue;
      }

      if(this.ioInt < min || this.ioInt > max){
        System.out.format("Input is out of bounds. Please try again.\n");
      }
    }
    return this.ioInt;
  }

  public void getDouble(double min, double max){
    System.out.format("Please enter a number between %f and %f", min, max);
    ioDouble = scan.nextDouble();
  }

}
