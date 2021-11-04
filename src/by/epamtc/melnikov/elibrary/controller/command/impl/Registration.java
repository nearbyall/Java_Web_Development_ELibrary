package by.epamtc.melnikov.elibrary.controller.command.impl;

import by.epamtc.melnikov.elibrary.constant.SplitConstants;
import by.epamtc.melnikov.elibrary.controller.command.Command;
import by.epamtc.melnikov.elibrary.service.ServiceProvider;
import by.epamtc.melnikov.elibrary.service.UserService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public String execute(String request) {
		
		String[] data = request.split(SplitConstants.SPLIT_BY);
		
		String login = data[1];
		String password = data[2];
		String userTypeString = data[3];
		
		ServiceProvider provider = ServiceProvider.getInstance();
		UserService userService = provider.getUserService();
		
		try {
			userService.registration(login, password, userTypeString);
		} catch (ServiceException e) {
			//Обработать
		}
		
		return "User registered";
		
	}

}
