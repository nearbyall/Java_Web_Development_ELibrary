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
		
		while(!authorization()) {
			System.out.println(ResponseConstants.AUTHORIZATION_FAIL);
		}
		
		while (true) {
			UserType userType = CurrentUser.currentUser.getUserType();
			System.out.println(getMainOptions(userType));
			
			int option = 0;
			
			if (userType == UserType.ADMIN) {
				option = ClientInput.enterAdminMenuChoise();
				adminOptionProccesing(option);
			} else {
				option = ClientInput.enterUserMenuChoise();
				userOptionProccesing(option);
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
	
	private static boolean authorization() {
		
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
		
	private static void userOptionProccesing(int iption) {
		
	}
		
	private static void adminOptionProccesing(int iption) {
		
	}

}
