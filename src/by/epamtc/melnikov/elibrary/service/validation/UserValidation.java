package by.epamtc.melnikov.elibrary.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UserValidation {
	
	private UserValidation() {}
	
	public static boolean validatePassword(String password) {

		/*
		 *  ������ (�������� � ��������� ��������� �����, �����):
		 *	^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$
		 */
		Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$");
		Matcher matcher = pattern.matcher(password);
		
		if (matcher.matches()) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean validateLogin(String login) {
		
		/*
		 *  ��� ������������ (� ������������ 2-20 ��������, �������� ����� ���� ����� � �����, ������ ������ ����������� �����):
		 *	^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$
		 */
		Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
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
