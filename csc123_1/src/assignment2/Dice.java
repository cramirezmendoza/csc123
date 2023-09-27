package assignment2;
//Camila Ramirez Mendoza cramirezmendoza1@toromail.csudh.edu
import java.util.Random;

public class Dice {
    private int num;
    private Random rand;
    
    public Dice() {
        rand = new Random();
        cast();
    }
    
    public void cast() {
        num = rand.nextInt(7);
    }
     public String toString() {
        return "The value is: " + num;
    }
    
    public static void main(String[] args) {
        Dice d = new Dice();
        d.cast();
        System.out.println(d);
    }
}

