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
	public User authorization(String login, String password) throws ServiceException {
	
		if (!UserValidation.validateLogin(login) || !UserValidation.validatePassword(password)) {
			throw new ServiceException();
		}
		
		DAOProvider provider = DAOProvider.getInstantce();
		UserDAO userDAO = provider.getUserDAO();
		
		User user = null; 
		
		try {
			user = userDAO.authorization(login, MD5PasswordEncryption.encryptPasswordWithMD5(password));
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
		return user;
		
	}

	@Override
	public void registration(String login, String password, String userTypeString) throws ServiceException {

		if (!UserValidation.validateLogin(login) || !UserValidation.validatePassword(password)
				|| !UserValidation.validateUserTypeString(userTypeString)) {
			throw new ServiceException("");
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
			throw new ServiceException("");
		}
		
	}

}
