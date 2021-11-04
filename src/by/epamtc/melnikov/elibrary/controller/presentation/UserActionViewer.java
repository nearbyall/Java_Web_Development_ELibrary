package by.epamtc.melnikov.elibrary.controller.presentation;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.bean.User;

public final class UserActionViewer {

	private UserActionViewer() {}
	
	public static String authorizationAnswer(User result) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Hello ");
		sb.append(result.getLogin());
		
		return sb.toString();
	
	}
	
	public static String findBooksAnswer(List<Book> result) {
		
		if (result.isEmpty()) {
			return "Storage is empty";
		}
		
		StringBuilder sb = new StringBuilder();
		
		int position = 0;
		for (Book book : result) {
			position++;
			sb.append("\n" + position + ". " + book.getTitle() + ", " + book.getAuthor() + ", " + book.getSizeType().getValue());
		}
		
		return sb.toString();
		
	}
	
}
