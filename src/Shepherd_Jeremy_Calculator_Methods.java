

/*
 * CIS 2122
 * 02/02/2020
 * Jeremy L. Shepherd
 * Calculator with Methods
 * A menu driven console program that takes in user input to 
 * calculate basic math functions of 2 numbers and return a calculation.
 * Also generate a random number based on a range of numbers.
 * Using methods to present cleaner code.
 */

import java.util.Scanner;

public class Shepherd_Jeremy_Calculator_Methods  {
	
	static Scanner input = new Scanner(System.in);
	
	
	//Display menu
	public static void displayMenu() {
		System.out.println("Calculator Menu");
		System.out.println("1. Add");
		System.out.println("2. Subtract");
		System.out.println("3. Multiply");
		System.out.println("4. Divide");
		System.out.println("5. Generate Random Number");
		System.out.println("6. Quit");
		System.out.print("What would you like to do? ");
	}
	
	//Get menu method
	public static int getMenuOption() {
		int choice;
		
		displayMenu();
		choice = input.nextInt();
		while(choice < 1 || choice > 6)
		{
			System.out.println("I'm sorry, " + choice + " wasn't one of the options");
			System.out.print("Please select a valid option: ");
			choice = input.nextInt();
		}
		
		return choice;
	}
	
	//Get Operand method
	public static double getOperand(String message) {		
		double num;
		
		System.out.print(message);
		num = input.nextDouble();
		return num;
	}
	
	//Addition method
	public static double add(double operand1, double operand2) {
		return operand1 + operand2;
	}
	
	//Subtraction method
	public static double subtract(double operand1, double operand2) {
		return operand1  - operand2;
	}
	
	//Multiplication method
	public static double multiply(double operand1, double operand2) {
		return operand1 * operand2;
	}
	
	//Division method
	public static double divide(double operand1, double operand2) {
		if(operand2 == 0) {
			System.out.println("I'm sorry, you can't divide by zero.");
			return Double.NaN;
		}		
		return operand1 / operand2;
	}
	
	//Random number generation method
	public static double random(double lowerLimit, double upperLimit) {		
		//Warning to explain result
		if (lowerLimit > upperLimit)
			System.out.println("***Warning*** The lower limit is greater than the upper limit!*******");
		double randomVal = Math.random();
		return (randomVal * (upperLimit - lowerLimit) + lowerLimit);
	}	
		
	//Primary function
	public static void main(String[] args) {
		
		double num1 = 0, num2 = 0, result = 0;
		int menuChoice;
		
		menuChoice = getMenuOption();
		
		while(menuChoice != 6) {
			
			//Eliminated repeated calls to getNum by employing ternary for different input message
			String message1 = menuChoice == 5 ? "What is the lower limit? " : "What is the first number? ";
			String message2 = menuChoice == 5 ? "What is the upper limit? " : "What is the second number? ";
			
			//Only get input if needed
			if(menuChoice >= 1 && menuChoice <= 5) {
				num1 = getOperand(message1);
				num2 = getOperand(message2);
			}
			
			switch(menuChoice) {
				case 1:
					result = add(num1, num2);
					break;
				case 2:
					result = subtract(num1, num2);
					break;
				case 3:
					result = multiply(num1, num2);
					break;
				case 4:
					result = divide(num1, num2);
				case 5:
					result = random(num1, num2);					
			}
			
			//refactored answer output to single line
			System.out.println("Answer: " + result);
			System.out.println("");
			menuChoice = getMenuOption();
		}			
		
		input.close();
		System.out.println("Thank you for using Shepherd's Calculator!");
		System.out.println("Goodbye!");
	}
}

