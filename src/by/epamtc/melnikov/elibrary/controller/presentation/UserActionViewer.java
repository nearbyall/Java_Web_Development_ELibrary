package by.epamtc.melnikov.elibrary.controller.presentation;

import by.epamtc.melnikov.elibrary.bean.User;

public final class UserActionViewer {

	private UserActionViewer() {}
	
	public static String authorizationAnswer(User result) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Hello ");
		sb.append(result.getLogin());
		
		return sb.toString();
	
	}
	
}
