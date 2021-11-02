package by.epamtc.melnikov.elibrary.constant;

public final class RegExConstants {

	private RegExConstants() {}
	
	/*
	 *  ������ (�������� � ��������� ��������� �����, �����):
	 *	^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$
	 */
	public static String PASSWORD = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
	
	/*
	 *  ��� ������������ (� ������������ 2-20 ��������, �������� ����� ���� ����� � �����, ������ ������ ����������� �����):
	 *	^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$
	 */
	public static String LOGIN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
	
	/*
	 *  ��� ������ ������� ��� ������� (�������� � ���������)
	 */
	public static String AUTHOR = "^([�-�]{1}[�-��]{1,23}|[A-Z]{1}[a-z]{1,23})$";
	
	/*
	 *  �������� ����� (�������� � ��������� ��������� �����, �����):
	 *	^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$
	 */
	public static String BOOK_TITLE = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
	
}
