package by.epamtc.melnikov.elibrary.service;

import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public interface UserService {

	boolean authorisation(String login, String password) throws ServiceException;
	
	void registration(String login, String password, String userTypeString) throws ServiceException;
	
	String roleCheck(String login) throws ServiceException;
	
}
