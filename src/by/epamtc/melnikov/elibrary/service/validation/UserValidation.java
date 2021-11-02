package by.epamtc.melnikov.elibrary.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.melnikov.elibrary.constant.RegExConstants;

public final class UserValidation {
	
	private UserValidation() {}
	
	public static boolean validatePassword(String password) {

		if (password == null) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(RegExConstants.PASSWORD);
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.matches()) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean validateLogin(String login) {
		
		if (login == null) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(RegExConstants.LOGIN);
		Matcher matcher = pattern.matcher(login);
		
		if (matcher.matches()) {
			return true;
		}
		
		
		return false;
		
	}
	
	public static boolean validateUserTypeString(String userTypeString) {
		
		if (userTypeString == null) {
			return false;
		}
		
		if (userTypeString.equals("ADMIN") || userTypeString.equals("USER")) {
			return true;
		}
		
		return false;
		
	}

}
