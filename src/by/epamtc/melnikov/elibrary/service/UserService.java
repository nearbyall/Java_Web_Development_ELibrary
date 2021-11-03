package by.epamtc.melnikov.elibrary.service;

import by.epamtc.melnikov.elibrary.bean.User;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public interface UserService {

	User authorization(String login, String password) throws ServiceException;
	
	void registration(String login, String password, String userTypeString) throws ServiceException;
	
}
