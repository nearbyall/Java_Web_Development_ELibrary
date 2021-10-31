package by.epamtc.melnikov.elibrary.service;

import by.epamtc.melnikov.elibrary.service.impl.StorageServiceImpl;
import by.epamtc.melnikov.elibrary.service.impl.UserServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();
	
	private final UserService userService = new UserServiceImpl();
	private final StorageService storageService = new StorageServiceImpl();
	
	private ServiceProvider() {}
	
	public ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public StorageService getStorageService() {
		return storageService;
	}
	
}
