public class ParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParseException() {
		super("ParseException");
	}

	public ParseException(String mesage) {
		super(mesage);

	}

	public ParseException(Throwable couse) {
		super(couse);
	}

	public ParseException(String mesege, Throwable couse) {
		super(mesege, couse);

	}
}
