package ec.com.servicioentidad.banco.exceptions;

public class ApplicationException extends Exception {

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	protected ApplicationException(String message, Throwable cause, Boolean enableSuppression,
			Boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	private static final long serialVersionUID = 1L;

}
