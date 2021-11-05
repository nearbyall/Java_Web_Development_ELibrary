package by.epamtc.melnikov.elibrary.controller.view;

import java.util.Scanner;
import java.util.regex.Pattern;

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
	
	public static int enterUserMenuChoise() {
		
		Integer value = null;
		
		do {
			value = enterInteger();
		} while (value < 0 || value > 3);
		
		return value;
		
	}
	
	public static int enterAdminMenuChoise() {
		
		Integer value = null;
		
		do {
			value = enterInteger();
		} while (value < 0 || value > 6);
		
		return value;
		
	}
	
	public static int enterAuthorizationMenuChoise() {
		
		Integer value = null;
		
		do {
			value = enterInteger();
		} while (value < 0 || value > 1);
		
		return value;
		
	}
	
}
