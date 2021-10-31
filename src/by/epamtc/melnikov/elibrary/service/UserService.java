package by.epamtc.melnikov.elibrary.service;

import by.epamtc.melnikov.elibrary.bean.type.UserType;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public interface UserService {

	boolean logination(String login, String password) throws ServiceException;
	
	void registration(String login, String password, UserType userType) throws ServiceException;
	
}
