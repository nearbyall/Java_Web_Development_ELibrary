package by.epamtc.melnikov.elibrary.service.impl;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.bean.type.BookSizeType;
import by.epamtc.melnikov.elibrary.service.StorageService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public class StorageServiceImpl implements StorageService {

	@Override
	public Book findBook(String title) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBook(String title, String author) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addBook(String title, String author, BookSizeType sizeType) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(String title, String author, BookSizeType sizeType) throws ServiceException {
		// TODO Auto-generated method stub
		return false;
	}

}
