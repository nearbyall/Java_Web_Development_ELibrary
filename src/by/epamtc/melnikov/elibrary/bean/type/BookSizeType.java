package by.epamtc.melnikov.elibrary.bean.type;

public enum BookSizeType {
	
	LONG("Long"),
	MIDDLE("Middle"),
	SHORT("Short");
	
	private final String value;
	
	private BookSizeType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
