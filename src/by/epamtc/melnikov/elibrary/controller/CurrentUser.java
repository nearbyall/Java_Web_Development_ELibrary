package by.epamtc.melnikov.elibrary.controller;

import by.epamtc.melnikov.elibrary.bean.User;

public final class CurrentUser {

	public static User currentUser = null;
	
	private CurrentUser() {};
	
	public static void setCurrentUser(User user) {
		currentUser = user;
	}
	
}
