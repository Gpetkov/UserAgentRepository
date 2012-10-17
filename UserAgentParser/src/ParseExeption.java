public class ParseExeption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParseExeption() {
		System.out.println("ParseExeption");
	}

	public ParseExeption(String mesage) {
		super(mesage);

	}

	public ParseExeption(Throwable couse) {
		super(couse);
	}

	public ParseExeption(String mesege, Throwable couse) {
		super(mesege, couse);

	}
}
