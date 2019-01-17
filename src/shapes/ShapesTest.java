package shapes;

public class ShapesTest {

  public static void assertEqual(double a, double b){
    if(a != b){
      System.err.format("Assert failed: %lf != %lf\n", a, b);
    }
  }

  public static void main(String[] args){

    Rectangle rec1 = new Rectangle(1, 3);
    assertEqual(rec1.getArea(), 1*3);
    assertEqual(rec1.getPerimeter(), (2*1) + (2*3));

  }

}
