package labOne;
//Camila Ramirez Mendoza (cramirezmendoza1@toromail.csudh.edu)
import java.util.Scanner;
public class Lab2_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input the first number: ");
		int num1 = input.nextInt();
		
		
		System.out.print("Input the second number: ");
		int num2 = input.nextInt();
		
		System.out.print("Input the third number: ");
		int num3 = input.nextInt();
		
		boolean answer = (num2 > num1 && num3 > num2);
		
		System.out.print("The result is: "+answer);
		
		input.close();
	}

}
