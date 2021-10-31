package by.epamtc.melnikov.elibrary.dao;

import by.epamtc.melnikov.elibrary.dao.impl.TXTStorageDAOImpl;
import by.epamtc.melnikov.elibrary.dao.impl.TXTUserDAOImpl;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();
	
	private StorageDAO storageDAO = new TXTStorageDAOImpl();
	private UserDAO userDAO = new TXTUserDAOImpl();
	
	private DAOProvider() {}
	
	public static DAOProvider getInstantce() {
		return instance;
	}

	public StorageDAO getStorageDAO() {
		return storageDAO;
	}

	public void setStorageDAO(StorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
