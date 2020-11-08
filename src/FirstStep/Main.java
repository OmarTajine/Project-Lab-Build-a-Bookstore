package FirstStep;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		
		boolean ValidationAttribute = true;
		Scanner sc = null;
		while(ValidationAttribute) {

			try  
			{
				sc = new Scanner( System.in );
				System.out.print( "Please enter the quantity : " );
				int quantity = sc.nextInt();

				System.out.print( "Please enter the price of the unit : " );
				double price = sc.nextDouble();

				System.out.println("the Total price is : "+Product.calculateTotalPrice(quantity,price));
				ValidationAttribute = false;
			}

			catch(InputMismatchException e) {

				System.out.println("Only numbers are allowed");
				
			}
		}
	}
}
