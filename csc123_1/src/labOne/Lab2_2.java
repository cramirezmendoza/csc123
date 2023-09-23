package labOne;
//Camila Ramirez Mendoza (cramirezmendoza1@toromail.csudh.edu)
import java.util.Scanner;
public class Lab2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int num1;
		int num2;
		
		System.out.print("Input the first number: ");
		num1 = input.nextInt();
		
		System.out.print("Input the second number: ");
		num2 = input.nextInt();
		
		System.out.print("The result is: "+ (num1+num2));

		
		input.close();
	}

}
