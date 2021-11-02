package by.epamtc.melnikov.elibrary.service.impl;

import by.epamtc.melnikov.elibrary.bean.User;
import by.epamtc.melnikov.elibrary.bean.builder.UserBuilder;
import by.epamtc.melnikov.elibrary.bean.type.UserType;
import by.epamtc.melnikov.elibrary.dao.DAOProvider;
import by.epamtc.melnikov.elibrary.dao.UserDAO;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;
import by.epamtc.melnikov.elibrary.service.UserService;
import by.epamtc.melnikov.elibrary.service.encryption.MD5PasswordEncryption;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;
import by.epamtc.melnikov.elibrary.service.validation.UserValidation;

public class UserServiceImpl implements UserService {

	@Override
	public boolean authorisation(String login, String password) throws ServiceException {
	
		if (!UserValidation.validateLogin(login) || !UserValidation.validatePassword(password)) {
			return false;
		}
		
		DAOProvider provider = DAOProvider.getInstantce();
		UserDAO userDAO = provider.getUserDAO();
		
		boolean result; 
		
		try {
			result = userDAO.authorisation(login, MD5PasswordEncryption.encryptPasswordWithMD5(password));
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		
		return result;
		
	}

	@Override
	public void registration(String login, String password, String userTypeString) throws ServiceException {

		if (!UserValidation.validateLogin(login) || !UserValidation.validatePassword(password)
				|| !UserValidation.validateUserTypeString(userTypeString)) {
			throw new ServiceException();
		}
		
		DAOProvider provider = DAOProvider.getInstantce();
		UserDAO userDAO = provider.getUserDAO();
		
		User newUser = new UserBuilder()
				.withLogin(login)
				.withPassword(MD5PasswordEncryption.encryptPasswordWithMD5(password))
				.withUserType(UserType.valueOf(userTypeString))
				.build();
		
		try {
			userDAO.registration(newUser);
		} catch (DAOException e) {
			throw new ServiceException();
		}
		
	}

	@Override
	public String roleCheck(String login) throws ServiceException {

		return null;
	}

}
