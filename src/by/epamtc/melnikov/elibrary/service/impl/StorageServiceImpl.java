package by.epamtc.melnikov.elibrary.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.bean.builder.BookBuilder;
import by.epamtc.melnikov.elibrary.bean.type.BookSizeType;
import by.epamtc.melnikov.elibrary.dao.DAOProvider;
import by.epamtc.melnikov.elibrary.dao.StorageDAO;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;
import by.epamtc.melnikov.elibrary.service.StorageService;
import by.epamtc.melnikov.elibrary.service.exception.ServiceException;
import by.epamtc.melnikov.elibrary.service.validation.StorageValidation;

public class StorageServiceImpl implements StorageService {

	@Override
	public List<Book> findBooks(String title) throws ServiceException {
		
		if (!StorageValidation.validateTitle(title)) {
			throw new ServiceException("");
		}
		
		DAOProvider provider = DAOProvider.getInstantce();
		StorageDAO storageDAO = provider.getStorageDAO();
		
		List<Book> result = new ArrayList<Book>();
		List<Book> storage;
		
		try {
			storage = storageDAO.readBooks();
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
		for (Book book : storage) {
			if (book.getTitle().equals(title)) {
				result.add(book);
			}
		}
		
		return result;
		
	}

	@Override
	public List<Book> findBooks(String title, String author) throws ServiceException {
		
		if (!StorageValidation.validateTitle(title)) {
			throw new ServiceException("");
		}
		
		DAOProvider provider = DAOProvider.getInstantce();
		StorageDAO storageDAO = provider.getStorageDAO();
		
		List<Book> result = new ArrayList<Book>();
		List<Book> storage;
		
		try {
			storage = storageDAO.readBooks();
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
		for (Book book : storage) {
			if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
				result.add(book);
			}
		}
		
		return result;
	}

	@Override
	public List<Book> storageList() throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstantce();
		StorageDAO storageDAO = provider.getStorageDAO();
		
		List<Book> books;
		
		try {
			books = storageDAO.readBooks();
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
		return books;
	}
	
	@Override
	public void addBook(String title, String author, String sizeTypeString) throws ServiceException {
		
		if (!StorageValidation.validateAuthor(author) || !StorageValidation.validateTitle(title)
				|| !StorageValidation.validateSizeTypeString(sizeTypeString)) {
			throw new ServiceException("");
		}
		
		DAOProvider provider = DAOProvider.getInstantce();
		StorageDAO storageDAO = provider.getStorageDAO();
		
		Book newBook = new BookBuilder()
				.withTitle(title)
				.withAuthor(author)
				.withBookSizeType(BookSizeType.valueOf(sizeTypeString))
				.build();
		
		try {
			storageDAO.addBook(newBook);
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
	}

	@Override
	public void deleteBook(String title, String author, String sizeTypeString) throws ServiceException {
		
		if (!StorageValidation.validateAuthor(author) || !StorageValidation.validateTitle(title)
				|| !StorageValidation.validateSizeTypeString(sizeTypeString)) {
			throw new ServiceException("");
		}
		
		DAOProvider provider = DAOProvider.getInstantce();
		StorageDAO storageDAO = provider.getStorageDAO();
		
		Book uselessBook = new BookBuilder()
				.withTitle(title)
				.withAuthor(author)
				.withBookSizeType(BookSizeType.valueOf(sizeTypeString))
				.build();
		
		try {
			storageDAO.deleteBook(uselessBook);
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
	}

	@Override
	public void correctBook(Book correctBook, Book uncorrectBook) throws ServiceException {
		
		DAOProvider provider = DAOProvider.getInstantce();
		StorageDAO storageDAO = provider.getStorageDAO();
		
		List<Book> storage;
		
		try {
			storage = storageDAO.readBooks();
		} catch (DAOException e) {
			throw new ServiceException("");
		}
		
		if (storage.contains(uncorrectBook)) {
			storage.set(storage.indexOf(uncorrectBook), correctBook);
		} else {
			throw new ServiceException("");
		}
		
	}


}
