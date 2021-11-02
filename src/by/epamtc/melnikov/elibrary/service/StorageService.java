package by.epamtc.melnikov.elibrary.service;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.bean.type.BookSizeType;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public interface StorageService {
	
	Book findBook(String title) throws ServiceException;
	
	Book findBook(String title, String author) throws ServiceException;
	
	String makeStorageList() throws ServiceException;
	
	boolean addBook(String title, String author, BookSizeType sizeType) throws ServiceException;
	
	boolean deleteBook(String title, String author, BookSizeType sizeType) throws ServiceException;
	
}
