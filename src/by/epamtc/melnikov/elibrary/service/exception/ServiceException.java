package by.epamtc.melnikov.elibrary.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -7475596961838487274L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
