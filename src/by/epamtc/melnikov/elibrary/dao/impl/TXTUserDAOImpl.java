package by.epamtc.melnikov.elibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epamtc.melnikov.elibrary.bean.User;
import by.epamtc.melnikov.elibrary.bean.builder.UserBuilder;
import by.epamtc.melnikov.elibrary.bean.type.UserType;
import by.epamtc.melnikov.elibrary.constant.SplitConstants;
import by.epamtc.melnikov.elibrary.dao.UserDAO;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;

public class TXTUserDAOImpl implements UserDAO {

	private static final File USER_RESOURCES = new File("resources/users.txt");
	
	@Override
	public User authorization(String login, String password) throws DAOException {
		
		List<User> users = readUsers();
		
		for (User user : users) {
			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
		
	}

	@Override
	public void registration(User newUser) throws DAOException {
		
		List<User> users = readUsers();
		
		if (users.contains(newUser)) {
			throw new DAOException("User is already exist");
		}
		
		users.add(newUser);
		
		saveUsers(users);
		
	}

	@Override
	public void saveUsers(List<User> users) throws DAOException {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(USER_RESOURCES))) {
			for (User user : users) {
				StringBuilder sb = new StringBuilder();
				sb.append(user.getLogin());
				sb.append(",");
				sb.append(user.getPassword());
				sb.append(",");
				sb.append(user.getUserType());
				bw.write(sb.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			throw new DAOException(e.getMessage(), e);
		}

	}

	@Override
	public List<User> readUsers() throws DAOException {
		
		String line;
		List<User> users = new ArrayList<User>();
		try (BufferedReader br = new BufferedReader(new FileReader(USER_RESOURCES))) {
			while ((line = br.readLine()) != null) {
				String[] data = line.split(SplitConstants.SPLIT_BY);
				User user = new UserBuilder()
						.withLogin(data[0])
						.withPassword(data[1])
						.withUserType(UserType.valueOf(data[2]))
						.build();   
				users.add(user);
			}
		} catch (IOException e) {
			throw new DAOException(e.getMessage(), e);
		}
		return users;
		
	}

}
