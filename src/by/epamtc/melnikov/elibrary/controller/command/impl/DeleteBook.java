package by.epamtc.melnikov.elibrary.controller.command.impl;

import by.epamtc.melnikov.elibrary.constant.ResponseConstants;
import by.epamtc.melnikov.elibrary.constant.SplitConstants;
import by.epamtc.melnikov.elibrary.controller.command.Command;
import by.epamtc.melnikov.elibrary.service.ServiceProvider;
import by.epamtc.melnikov.elibrary.service.StorageService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class DeleteBook implements Command {

	@Override
	public String execute(String request) {
		
		String[] data = request.split(SplitConstants.SPLIT_BY);
		
		String title = data[1];
		String author = data[2];
		String sizeTypeString = data[3];
		
		ServiceProvider provider = ServiceProvider.getInstance();
		StorageService storageService = provider.getStorageService();
		
		String response;
		
		try {
			storageService.deleteBook(title, author, sizeTypeString);
			response = ResponseConstants.DELETE_BOOK_SUCCESS;
		} catch (ServiceException e) {
			response = ResponseConstants.DELETE_BOOK_FAIL;
		}
		
		return response;
		
	}

}
