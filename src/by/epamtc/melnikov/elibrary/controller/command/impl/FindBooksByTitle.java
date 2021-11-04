package by.epamtc.melnikov.elibrary.controller.command.impl;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.constant.SplitConstants;
import by.epamtc.melnikov.elibrary.controller.command.Command;
import by.epamtc.melnikov.elibrary.controller.presentation.UserActionViewer;
import by.epamtc.melnikov.elibrary.service.ServiceProvider;
import by.epamtc.melnikov.elibrary.service.StorageService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class FindBooksByTitle implements Command {

	@Override
	public String execute(String request) {
		
		String[] data = request.split(SplitConstants.SPLIT_BY);
		
		String title = data[1];
		
		ServiceProvider provider = ServiceProvider.getInstance();
		StorageService storageService = provider.getStorageService();
		
		List<Book> result = null;
		
		try {
			result = storageService.findBooks(title);
		} catch (ServiceException e) {
			//����������
		}
		
		String response = UserActionViewer.findBooksAnswer(result);
		
		return response;
	}

}
