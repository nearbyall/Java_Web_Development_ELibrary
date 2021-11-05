package by.epamtc.melnikov.elibrary.controller.command.impl;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.controller.command.Command;
import by.epamtc.melnikov.elibrary.controller.presentation.UserActionViewer;
import by.epamtc.melnikov.elibrary.service.ServiceProvider;
import by.epamtc.melnikov.elibrary.service.StorageService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class ShowBooks implements Command {

	@Override
	public String execute(String request) {
		
		ServiceProvider provider = ServiceProvider.getInstance();
		StorageService storageService = provider.getStorageService();
		
		List<Book> result = null;
		
		try {
			result = storageService.storageList();
		} catch (ServiceException e) {
			//<a>
		}
		
		String response = UserActionViewer.findBooksAnswer(result);
		
		return response;

	}

}
