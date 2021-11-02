package by.epamtc.melnikov.elibrary.constant;

public final class RegExConstants {

	private RegExConstants() {}
	
	/*
	 *  Пароль (Строчные и прописные латинские буквы, цифры):
	 *	^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$
	 */
	public static String PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
	
	/*
	 *  Имя пользователя (с ограничением 2-20 символов, которыми могут быть буквы и цифры, первый символ обязательно буква):
	 *	^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$
	 */
	public static String LOGIN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
	
	/*
	 *  Имя автора формата Имя Фамилия (Латиница и кириллица)
	 */
	public static String AUTHOR = "^([А-Я]{1}[а-яё]{1,23}|[A-Z]{1}[a-z]{1,23})$";
	
	/*
	 *  Название книги (Строчные и прописные латинские буквы, цифры):
	 *	^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$
	 */
	public static String BOOK_TITLE = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
	
}
