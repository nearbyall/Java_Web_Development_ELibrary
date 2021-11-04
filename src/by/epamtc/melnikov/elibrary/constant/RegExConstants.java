package by.epamtc.melnikov.elibrary.constant;

public final class RegExConstants {

	private RegExConstants() {}
	
	/*
	 *  Password (Lowercase and uppercase Latin letters, numbers, special characters and different registers):
	 *	^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$
	 */
	public static String PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
	
	/*
	 *  Username (limited to 2-20 characters, which can be letters and numbers, the first character must be a letter):
	 *	^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$
	 */
	public static String LOGIN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
	
	/*
	 *  Name of the author of the format First name Surname (Latin and Cyrillic)
	 */
	public static String AUTHOR = "^([À-ß]{1}[à-ÿ¸]{1,23}|[A-Z]{1}[a-z]{1,23})$";
	
	/*
	 *  Book title (Lowercase and uppercase Latin letters, numbers):
	 *	^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$
	 */
	public static String BOOK_TITLE = "^[A-Za-z -]+$";
	
}
