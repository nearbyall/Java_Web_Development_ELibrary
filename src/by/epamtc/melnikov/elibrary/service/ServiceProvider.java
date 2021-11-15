package by.epamtc.melnikov.elibrary.service;

import by.epamtc.melnikov.elibrary.service.impl.StorageServiceImpl;
import by.epamtc.melnikov.elibrary.service.impl.UserServiceImpl;

public class ServiceProvider {
	
	private final UserService userService = new UserServiceImpl();
	private final StorageService storageService = new StorageServiceImpl();
	
	private ServiceProvider() {}
	
	private static class ServiceProviderHolder {
		private final static ServiceProvider instance = new ServiceProvider();
	}
	
	public static ServiceProvider getInstance() {
		return ServiceProviderHolder.instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public StorageService getStorageService() {
		return storageService;
	}
	
}
