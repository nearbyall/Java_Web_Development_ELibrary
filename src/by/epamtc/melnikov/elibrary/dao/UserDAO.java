package by.epamtc.melnikov.elibrary.dao;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.User;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;

public interface UserDAO {

	User authorization(String login, String password) throws DAOException;
	
	void registration(User newUser) throws DAOException;
	
	void saveUsers(List<User> users) throws DAOException;
	
	List<User> readUsers() throws DAOException;
	
}
