package by.epamtc.melnikov.elibrary.controller.command.impl;

import by.epamtc.melnikov.elibrary.bean.User;
import by.epamtc.melnikov.elibrary.constant.SplitConstants;
import by.epamtc.melnikov.elibrary.controller.CurrentUser;
import by.epamtc.melnikov.elibrary.controller.command.Command;
import by.epamtc.melnikov.elibrary.controller.presentation.UserActionViewer;
import by.epamtc.melnikov.elibrary.service.ServiceProvider;
import by.epamtc.melnikov.elibrary.service.UserService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class Authorization implements Command {

	@Override
	public String execute(String request) {
		
		String[] data = request.split(SplitConstants.SPLIT_BY);
		
		String login = data[1];
		String password = data[2];
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		User currentUser = null;
		
		try {
			currentUser = userService.authorization(login, password);
		} catch (ServiceException e) {
			//Обработать
		}
		
		CurrentUser.setCurrentUser(currentUser);
		
		String response = UserActionViewer.authorizationAnswer(currentUser);
		
		return response;
		
	}

}
