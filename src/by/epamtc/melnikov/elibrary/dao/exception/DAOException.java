package by.epamtc.melnikov.elibrary.dao.exception;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = 8078637357694627007L;

	public DAOException() {
		super();
	}
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Exception e) {
		super(message, e);
	}
	
}
