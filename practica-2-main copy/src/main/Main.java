package main;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int option = 0;
		do {
    		try {
    			option = menu();
    		} catch(Exception e) {};
    		switch(option) {
    			case 1:
    				MatrixTests.testMatrix();
    				break;
    			case 2:
    				ArrayTests.testArrays();
    				break;
    			case 3:
    				System.out.println("Bye!");
    				break;
    			default:
    				System.out.println("Option not valid.");
    				break;
    		}
    	} while (option != 3);

	}
	
	public static int menu() {
    	String menuStr = "\nOptions:\n"
    			+ "1. Matrix Tests\n"
    			+ "2. Array Tests\n"
    			+ "3. Exit\n"
    			+ "Select an option (1-3):";
    	int input = -1;
    	
    	System.out.print(menuStr);
    	try {
    		input = sc.nextInt();
    		sc.reset();
    	} catch (Exception e ) {
    		sc.reset();
    		return -1;
    	};
    	
    	
    	if (input >= 1 && input <= 3) {
    		return input;
    	} 
    	
    	return -1;
    }
	
	
}
