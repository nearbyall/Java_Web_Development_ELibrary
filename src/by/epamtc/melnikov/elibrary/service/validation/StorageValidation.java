package by.epamtc.melnikov.elibrary.service.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epamtc.melnikov.elibrary.constant.RegExConstants;

public final class StorageValidation {

	private StorageValidation() {};
	
	public static boolean validateTitle(String title) {
		
		if (title == null) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(RegExConstants.BOOK_TITLE);
		Matcher matcher = pattern.matcher(title);
		
		if (matcher.matches()) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean validateAuthor(String author) {
		
		if (author == null) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(RegExConstants.AUTHOR);
		Matcher matcher = pattern.matcher(author);
		
		if (matcher.matches()) {
			return true;
		}
		
		return false;
		
	}
	
	public static boolean validateSizeTypeString(String sizeTypeString) {
		
		if (sizeTypeString == null) {
			return false;
		}
		
		if (sizeTypeString.equals("LONG") || sizeTypeString.equals("SHORT")
				|| sizeTypeString.equals("MIDDLE")) {
			return true;
		}
		
		return false;
		
	}
	
}
