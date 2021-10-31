package by.epamtc.melnikov.elibrary.service.impl;

import by.epamtc.melnikov.elibrary.bean.type.UserType;
import by.epamtc.melnikov.elibrary.service.UserService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public boolean logination(String login, String password) throws ServiceException {

		return false;
	}

	@Override
	public void registration(String login, String password, UserType userType) throws ServiceException {

		
	}

}
