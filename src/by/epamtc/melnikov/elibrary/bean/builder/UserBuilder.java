package by.epamtc.melnikov.elibrary.bean.builder;

import by.epamtc.melnikov.elibrary.bean.User;
import by.epamtc.melnikov.elibrary.bean.type.UserType;

public final class UserBuilder {

	private User user;
	
	public UserBuilder() {
		user = new User();
	}
	
	public UserBuilder withLogin(String login) {
		user.setLogin(login);
		return this;
	}
	
	public UserBuilder withPassword(String password) {
		user.setPassword(password);
		return this;
	}
	
	public UserBuilder withUserType(UserType type) {
		user.setUserType(type);
		return this;
	}
	
	public User build() {
		return user;
	}
	
}
