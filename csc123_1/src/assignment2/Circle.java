package assignment2;
//Camila Ramirez Mendoza cramirezmendoza1@toromail.csudh.edu
public class Circle {
    private String shape;
    private double radi;
    
    public Circle(String newShape, double newRadi)
    {
        shape = newShape;
        radi = newRadi;
    }
    
    // getters
    public double getArea()
    {
        return Math.PI * Math.pow(radi, 2);
    }
    
    public double getCircumference()
    {
        return 2 * Math.PI * radi;
    }
    
    public String newString()
    {
        return shape + "\nRadius : " + radi + "\nArea : " + String.format("%.2f", getArea()) + "\nCircumference : " + String.format("%.2f", getCircumference());
    }
    
    public static void main(String[] args) {
        Circle c = new Circle("My Circle", 20);
        System.out.println(c.newString()); 
    }
}
