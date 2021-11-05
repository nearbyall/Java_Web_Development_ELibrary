package by.epamtc.melnikov.elibrary.controller.view;

import by.epamtc.melnikov.elibrary.bean.type.UserType;
import by.epamtc.melnikov.elibrary.constant.MenuConstants;
import by.epamtc.melnikov.elibrary.constant.ResponseConstants;
import by.epamtc.melnikov.elibrary.controller.Controller;
import by.epamtc.melnikov.elibrary.controller.CurrentUser;

public final class ClientAction {

	private static final Controller controller = new Controller();
	
	public static void start() {
		
		System.out.println(MenuConstants.WELCOME);
		
		while(!authorizationProcessing()) {
			System.out.println(ResponseConstants.AUTHORIZATION_FAIL);
		}
		
		while (true) {
			UserType userType = CurrentUser.currentUser.getUserType();
			System.out.println(getMainOptions(userType));
			
			int option = 0;
			
			if (userType == UserType.ADMIN) {
				option = ClientInput.enterAdminMenuChoise();
				adminOptionProcessing(option);
			} else {
				option = ClientInput.enterUserMenuChoise();
				userOptionProcessing(option);
			}
			
			if (option == 0) {
				break;
			}
		}	
		
	}
	
	private static String getMainOptions(UserType userType) {
		
		if (userType == UserType.ADMIN) {
			return MenuConstants.ADMIN_MENU;
		} else {
			return MenuConstants.USER_MENU;
		}
		
	}
	
	private static void userOptionProcessing(int option) {

		switch (option) {
			case 1:
				showBooksProcessing();
				break;
			case 2:
				findBooksByTitleProcessing();
				break;	
			case 3:
				findBooksByTitleAndAuthorProcessing();
				break;	
		}
		
	}
		
	private static void adminOptionProcessing(int option) {
		
		switch (option) {
		case 1:
			addBookProcessing();
			break;
		case 2:
			deleteBookProcessing();
			break;	
		case 3:
			correctNoteProcessing();
			break;	
		case 4:
			showBooksProcessing();
			break;
		case 5:
			findBooksByTitleProcessing();
			break;	
		case 6:
			findBooksByTitleAndAuthorProcessing();
			break;	
		case 7:
			registrationProcessing();
			break;
		}
		
	}

	private static boolean authorizationProcessing() {
		
		System.out.println(MenuConstants.ENTER_LOGIN);
		String login = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_PASSWORD);
		String password = ClientInput.enterString();
		
		String response = controller.executeTask("AUTHORIZATION," + login + "," + password);
		
		if (response.equals(ResponseConstants.AUTHORIZATION_FAIL)) {
			return false;
		}
		
		System.out.println(response);
		
		return true;
		
	}
	
	private static void registrationProcessing() {
		
		System.out.println(MenuConstants.ENTER_LOGIN);
		String login = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_PASSWORD);
		String password = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_USER_TYPE);
		String userTypeString = ClientInput.enterString();
		
		String response = controller.executeTask("REGISTRATION," + login + "," + password + "," + userTypeString);
		
		System.out.println(response);
		
	}

	private static void addBookProcessing() {
		
		System.out.println(MenuConstants.ENTER_BOOK_TITLE);
		String title = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_AUTHOR);
		String author = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_SIZE_TYPE);
		String sizeTypeString = ClientInput.enterString();
		
		String response = controller.executeTask("ADD_BOOK," + title + "," + author + "," + sizeTypeString);
		
		System.out.println(response);
		
		
	}
	
	private static void deleteBookProcessing() {
	
		System.out.println(MenuConstants.ENTER_BOOK_TITLE);
		String title = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_AUTHOR);
		String author = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_SIZE_TYPE);
		String sizeTypeString = ClientInput.enterString();
		
		String response = controller.executeTask("DELETE_BOOK," + title + "," + author + "," + sizeTypeString);
		
		System.out.println(response);
		
	}

	private static void showBooksProcessing() {
		
		String response = controller.executeTask("SHOW_BOOKS,");
		
		System.out.println(response);
		
	}
	
	private static void findBooksByTitleProcessing() {
		
		System.out.println(MenuConstants.ENTER_BOOK_TITLE);
		String title = ClientInput.enterString();
		
		String response = controller.executeTask("FIND_BOOKS_BY_TITLE," + title);
		
		System.out.println(response);
		
	}
	
	private static void findBooksByTitleAndAuthorProcessing() {
		
		System.out.println(MenuConstants.ENTER_BOOK_TITLE);
		String title = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_AUTHOR);
		String author = ClientInput.enterString();
		
		String response = controller.executeTask("FIND_BOOKS_BY_TITLE_AND_AUTHOR," + title + "," + author);
		
		System.out.println(response);
		
	}
	
	
	private static void correctNoteProcessing() {
		
		System.out.println(MenuConstants.ENTER_UNCORRECT_BOOK);
		System.out.println(MenuConstants.ENTER_BOOK_TITLE);
		String uncorrectTitle = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_AUTHOR);
		String uncorrectAuthor = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_SIZE_TYPE);
		String uncorrectSizeTypeString = ClientInput.enterString();
		
		System.out.println(MenuConstants.ENTER_CORRECT_BOOK);
		System.out.println(MenuConstants.ENTER_BOOK_TITLE);
		String correctTitle = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_AUTHOR);
		String correctAuthor = ClientInput.enterString();
		System.out.println(MenuConstants.ENTER_BOOK_SIZE_TYPE);
		String correctSizeTypeString = ClientInput.enterString();
		
		String response = controller.executeTask("CORRECT_NOTE," + uncorrectTitle + "," + uncorrectAuthor + ","
				+ uncorrectSizeTypeString + "," + correctTitle + "," + correctAuthor + "," + correctSizeTypeString);
		
		System.out.println(response);
		
	}
	
}
