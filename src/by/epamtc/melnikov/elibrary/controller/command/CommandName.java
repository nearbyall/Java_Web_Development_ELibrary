package by.epamtc.melnikov.elibrary.controller.command;

public enum CommandName {
	AUTHORIZATION("�����������"),
	REGISTRATION("�����������"),
	ADD_BOOK("�������� �����"),
	DELETE_BOOK("������� �����"),
	CORRECT_NOTE("������������� ������"),
	SHOW_BOOKS("������� ������� ����"),
	FIND_BOOKS_BY_SIZE_TYPE("����� ����� �� �������"),
	FIND_BOOKS_BY_TITLE("����� ����� �� ��������"),
	FIND_BOOKS_BY_TITLE_AND_AUTHOR("����� ����� �� �������� � ������"),
	WRONG_REQUEST("�������� �������");
	
	private final String value;
	
	private CommandName(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
