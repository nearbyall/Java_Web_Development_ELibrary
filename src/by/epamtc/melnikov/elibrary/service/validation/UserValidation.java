package by.epamtc.melnikov.elibrary.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UserValidation {
	
	private UserValidation() {}
	
	public static boolean validatePassword(String password) {

		/*
		 *  Пароль (Строчные и прописные латинские буквы, цифры):
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
		 *  Имя пользователя (с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква):
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
