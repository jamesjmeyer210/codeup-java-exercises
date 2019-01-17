package shapes;

public abstract class Quadrilateral extends Shape {

  protected double length;
  protected double width;

  public Quadrilateral(double l, double w){
    this.length = l;
    this.width = w;
  }

  public double getArea(){
    return this.length * this.width;
  }

  public double getPerimeter(){
    return (2 * this.length) + (2 * this.width);
  }

}
