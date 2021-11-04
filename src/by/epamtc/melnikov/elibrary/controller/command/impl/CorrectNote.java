package by.epamtc.melnikov.elibrary.controller.command.impl;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.bean.builder.BookBuilder;
import by.epamtc.melnikov.elibrary.bean.type.BookSizeType;
import by.epamtc.melnikov.elibrary.constant.SplitConstants;
import by.epamtc.melnikov.elibrary.controller.command.Command;
import by.epamtc.melnikov.elibrary.service.ServiceProvider;
import by.epamtc.melnikov.elibrary.service.StorageService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class CorrectNote implements Command {

	@Override
	public String execute(String request) {
		
		String[] data = request.split(SplitConstants.SPLIT_BY);
		
		ServiceProvider provider = ServiceProvider.getInstance();
		StorageService storageService = provider.getStorageService();
		
		Book uncorrectBook = new BookBuilder()
				.withTitle(data[1])
				.withAuthor(data[2])
				.withBookSizeType(BookSizeType.valueOf(data[3]))
				.build();
		
		Book correctBook = new BookBuilder()
				.withTitle(data[4])
				.withAuthor(data[5])
				.withBookSizeType(BookSizeType.valueOf(data[6]))
				.build();
				
		try {
			storageService.correctBook(correctBook, uncorrectBook);
		} catch (ServiceException e) {
			//����������
		}
		
		return "Book was corrected";
		
	}

}
