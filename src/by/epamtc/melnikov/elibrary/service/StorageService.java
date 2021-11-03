package by.epamtc.melnikov.elibrary.service;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;

public interface StorageService {
	
	List<Book> findBooks(String title) throws ServiceException;
	
	List<Book> findBooks(String title, String author) throws ServiceException;
	
	List<Book> storageList() throws ServiceException;
	
	void addBook(String title, String author, String sizeTypeString) throws ServiceException;
	
	void deleteBook(String title, String author, String sizeTypeString) throws ServiceException;
	
}
