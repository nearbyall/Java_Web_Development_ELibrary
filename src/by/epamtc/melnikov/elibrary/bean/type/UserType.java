package by.epamtc.melnikov.elibrary.bean.type;

public enum UserType {
	
	ADMIN("Admin"),
	USER("User");
	
	private final String value;
	
	private UserType(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}