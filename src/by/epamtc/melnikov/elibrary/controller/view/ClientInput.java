package by.epamtc.melnikov.elibrary.controller.view;

import java.util.Scanner;

public class ClientInput {

	private static Scanner scanner = new Scanner(System.in);
	
	public static int enterInteger() {
		
		Integer value = null;
		
		do {
			
			while (!scanner.hasNextInt()) {
				scanner.next();
			}
			
			value = scanner.nextInt();
			
		} while (value == null);
		
		return value;
		
	}
	
	public static String enterString() {
		
		String value = null;

		do {
        	
			while (!scanner.hasNext()) {

				scanner.next();
				
			}
			
			value = scanner.next();


		} while (value == null);
        
		return value;
		
	}
	
	public static int enterChoise(int left, int right) {
			
		Integer value = null;
		
		do {
			value = enterInteger();
		} while (value < left || value > right);
		
		return value;
		
	}
	
}
