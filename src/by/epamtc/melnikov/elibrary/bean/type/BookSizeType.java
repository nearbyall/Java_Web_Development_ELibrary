package by.epamtc.melnikov.elibrary.bean.type;

public enum BookSizeType {
	
	LONG("�������"),
	MIDDLE("�������"),
	SHORT("��������");
	
	private final String value;
	
	private BookSizeType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
