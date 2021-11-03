package by.epamtc.melnikov.elibrary.controller.command;

public enum CommandName {
	AUTHORIZATION("Авторизация"),
	REGISTRATION("Регистрация"),
	ADD_BOOK("Добавить книгу"),
	DELETE_BOOK("Удалить книгу"),
	CORRECT_NOTE("Редактировать запись"),
	SHOW_BOOKS("Вывести каталог книг"),
	FIND_BOOKS_BY_SIZE_TYPE("Найти книги по размеру"),
	FIND_BOOKS_BY_TITLE("Найти книги по названию"),
	FIND_BOOKS_BY_TITLE_AND_AUTHOR("Найти книги по названию и автору"),
	WRONG_REQUEST("Неверная команда");
	
	private final String value;
	
	private CommandName(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
